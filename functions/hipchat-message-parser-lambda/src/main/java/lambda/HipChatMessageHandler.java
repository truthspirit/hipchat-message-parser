package lambda;

import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;
import com.amazonaws.services.cloudwatch.model.MetricDatum;
import com.amazonaws.services.cloudwatch.model.PutMetricDataRequest;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import lambda.model.HipChatMessageLink;
import lambda.model.HipChatMessageResponse;
import lambda.model.ParsedUrl;
import lambda.regex.Patterns;
import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.testng.util.Strings;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * HipChatMessageHandler is designed to be packaged and uploaded for use as an AWS Lambda function using API gateway
 * and Lambda Proxy Integration.
 *
 * It should answer REST POSTs with application/json content in the message body.
 *
 * The response body will contain a json representation of the features found in the input message.
 *
 * Sample Input: "hey @bob123, have you and @Chuck seen the new training video? https://www.youtube.com/watch?v=dQw4w9WgXcQ it's pretty helpful (awesome)(awesome)"
 *
 * Sample Output:
 * "{
 *     "mentions" : [
 *          "bob123",
 *          "Chuck"
 *     ],
 *
 *     "emoticons" : [
 *          "awesome",
 *          "awesome"
 *     ],
 *
 *     "links" : [
 *          {
 *              "url" : "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
 *              "title" : "Rick Astley - Never Gonna Give You Up - YouTube"
 *          }
 *     ]
 * }"
 */

public class HipChatMessageHandler implements RequestHandler<LambdaProxyRequest, LambdaProxyResponse> {

    private static final Logger LOG = Logger.getLogger(HipChatMessageHandler.class);

    private static final int OK = 200;
    private static final int METHOD_NOT_ALLOWED = 405;
    private static final int UNSUPPORTED_MEDIA_TYPE = 415;

    private String linkCacheTableName = "linkCache";
    private DynamoDBMapperConfig tableNameOverride;

    public HipChatMessageHandler() {
        this.tableNameOverride = DynamoDBMapperConfig.builder().withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement(linkCacheTableName)).build();
    }

    public HipChatMessageHandler(String linkCacheTableName) {
        this.linkCacheTableName = linkCacheTableName;
        this.tableNameOverride = DynamoDBMapperConfig.builder().withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement(linkCacheTableName)).build();
    }

    public LambdaProxyResponse handleRequest(LambdaProxyRequest lambdaProxyRequest, Context context) {
        //ensure method type is POST
        if(!lambdaProxyRequest.getInput().getHttpMethod().equalsIgnoreCase("post")) {
            return new LambdaProxyResponse().statusCode(METHOD_NOT_ALLOWED);
        }
        //ensure content type is application/json
        if(!lambdaProxyRequest.getInput().getHeaders().getContentType().equalsIgnoreCase("application/json")) {
            return new LambdaProxyResponse().statusCode(UNSUPPORTED_MEDIA_TYPE);
        }

        String message = lambdaProxyRequest.getMessage();
        if(Strings.isNullOrEmpty(message)) {
            return new LambdaProxyResponse().statusCode(OK);
        }

        //parse the message for special features
        List<String> mentions = parseMentions(message);
        List<String> emoticons = parseEmoticons(message);
        List<HipChatMessageLink> links = parseLinks(message);

        //build a response for the message containing the parsed features
        HipChatMessageResponse response = new HipChatMessageResponse();
        if(!mentions.isEmpty()) {
            response.mentions(mentions);
        }
        if(!emoticons.isEmpty()) {
            response.emoticons(emoticons);
        }
        if(!links.isEmpty()) {
            response.links(links);
        }

        //map the response to json and return 200 - OK
        return new LambdaProxyResponse().statusCode(OK).body(new Gson().toJson(response));
    }

    private List<String> parseMentions(String message) {
        List<String> mentions = new ArrayList<String>();
        Matcher m = Pattern.compile("@[a-zA-Z0-9]+").matcher(message);
        while(m.find()) {
            mentions.add(m.group().replace("@", ""));
        }
        return mentions;
    }

    private List<String> parseEmoticons(String message) {
        List<String> emoticons = new ArrayList<String>();
        Matcher m = Pattern.compile("\\([a-zA-Z0-9]+\\)").matcher(message);
        while(m.find()) {
            emoticons.add(m.group().replace("(","").replace(")",""));
        }
        return emoticons;
    }

    private List<HipChatMessageLink> parseLinks(String message) {
        return Arrays.stream(message.split("\\s+"))
                .map(this::parseUrl)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(this::scrapeTitleWithCaching)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private Optional<ParsedUrl> parseUrl(String token) {
        //sanity check regex, this saves a lot of time
        if(!Patterns.AUTOLINK_WEB_URL.matcher(token).matches()) {
            return Optional.empty();
        }

        //use java.net.URL to validate the token as a url
        URL url;
        try {
            url = new URL(token);
        } catch (MalformedURLException e1) {
            //This isn't a url, maybe it needs a protocol to be valid
            try {
                //use https because it's 2016 and nobody should use http anymore.
                url = new URL("https://" + token);
            } catch (MalformedURLException e2) {
                //Even if we add a protocol, this isn't a url
                return Optional.empty();
            }
        }

        return Optional.of(new ParsedUrl().originalToken(token).url(url));
    }

    private String getRefreshUrl(Element metaRefreshElement) {
        String content = metaRefreshElement.attr("content");
        Pattern refreshUrlPattern = Pattern.compile("(?i)(\\d+;.+URL=)(.+)");
        Matcher matcher = refreshUrlPattern.matcher(content);
        if(matcher.matches()) {
            return matcher.group(2);
        } else {
            return null;
        }
    }

    private Optional<HipChatMessageLink> scrapeTitleWithCaching(ParsedUrl parsedUrl) {
        //check cache
        AmazonDynamoDBClient client = new AmazonDynamoDBClient();
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        //if successful this will add to the AWS Cloudwatch DynamoDB metric ReturnedItemCount
        //this is equivalent to raw cache hits
        HipChatMessageLink cachedLink = mapper.load(HipChatMessageLink.class, parsedUrl.getOriginalToken(), tableNameOverride);
        LOG.debug(String.format("retrieved a link from the cache: %s", cachedLink));

        //do we have any record of this url in the cache?
        //is the cache record unexpired?
        if(cachedLink != null &&
                cachedLink.getCreated().plus(cachedLink.getTtl(), ChronoUnit.MINUTES).isAfter(LocalDateTime.now())) {

                cacheHit();
                LOG.debug(String.format("unexpired cache hit: %s", cachedLink));
                return Optional.of(cachedLink);
        } else {
            //try to connect to the url and scrape the title
            LOG.debug(String.format("cache miss for url: %s", parsedUrl.getOriginalToken()));
            Connection connection = Jsoup.connect(parsedUrl.getUrl().toString());
            Document document = null;
            try {
                document = connection.get();
            } catch (IOException e) {
                LOG.warn("error retrieving document", e);
                return Optional.empty();
            }

            //special case for meta refresh redirects
            Element metaRefreshElement = document.head().select("meta[http-equiv=Refresh]").first();
            while(metaRefreshElement != null) {
                String refreshUrl = getRefreshUrl(metaRefreshElement);
                LOG.debug(String.format("following meta refresh redirect to: %s", refreshUrl));
                try {
                    document = Jsoup.connect(refreshUrl).get();
                } catch (IOException e) {
                    LOG.warn("error retrieving document", e);
                    return Optional.empty();
                }
                metaRefreshElement = document.head().select("meta[http-equiv=Refresh]").first();
            }

            //if we get an empty title, set it to null for the cache
            String title = Strings.isNullOrEmpty(document.title()) ? null : document.title();

            //cache the result with 30 minute time to live
            HipChatMessageLink link = new HipChatMessageLink()
                    //use the original token from the message
                    .url(parsedUrl.getOriginalToken())
                    .title(title)
                    .created(LocalDateTime.now())
                    .ttl(30);
            LOG.debug(String.format("link saved: %s", link));
            mapper.save(link, tableNameOverride);

            return Optional.ofNullable(link);
        }
    }

    private void cacheHit() {
        new AmazonCloudWatchClient().putMetricData(new PutMetricDataRequest()
                .withNamespace("HipChatMessageParser")
                .withMetricData(new MetricDatum()
                        .withMetricName("CacheHits")
                        .withValue(1d)));
    }
}
