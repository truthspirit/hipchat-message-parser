package lambda;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import lambda.model.HipChatMessageLink;
import lambda.model.HipChatMessageResponse;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Unit Tests for HipChatMessageHandler
 */
public class HipChatMessageHandlerTest {

    @BeforeClass
    void resetCache() throws InterruptedException {
        if(System.getProperty("clearCache") == null) {
            return;
        }

        DynamoDB dynamo = new DynamoDB(new AmazonDynamoDBClient());
        Table linkCache = dynamo.getTable("testLinkCache");
        try {
            System.out.println("Deleting testLinkCache");
            linkCache.delete();
            System.out.println("Waiting for delete");
            linkCache.waitForDelete();
            System.out.println("Done");
        } catch (ResourceNotFoundException e) {
            // no-op
            System.out.println("Table not found to delete, moving on");
        }

        CreateTableRequest request = new CreateTableRequest("testLinkCache", ImmutableList.of(new KeySchemaElement("url", KeyType.HASH)))
                .withAttributeDefinitions(new AttributeDefinition("url", ScalarAttributeType.S))
                .withProvisionedThroughput(new ProvisionedThroughput(5l,5l));
        System.out.println("Creating testLinkCache");
        linkCache = dynamo.createTable(request);
        System.out.println("Waiting for testLinkCache to become active");
        linkCache.waitForActive();
        System.out.println("Done creating testLinkCache, starting tests");
    }

    @DataProvider
    public static Object[][] createMalformedFeatureData() {
        return new Object[][] {
                { "@ alice", new HipChatMessageResponse()},
                { "buried@mention.com", new HipChatMessageResponse()},
                { "(!a)", new HipChatMessageResponse()},
                { "buried(emoticon)", new HipChatMessageResponse()},
                { "htps://www.google.com", new HipChatMessageResponse()},
                { "https://www.google.notvaliddomain", new HipChatMessageResponse()},
                { "www.alsnotta.validdomain", new HipChatMessageResponse()}
        };
    }

    @DataProvider
    public static Object[][] createWellFormedFeatureData() {
        return new Object[][]{
                { "Hi @alice!", new HipChatMessageResponse().mentions(ImmutableList.of("alice"))},
                { "Wow! (smile)", new HipChatMessageResponse().emoticons(ImmutableList.of("smile"))},
                { "@bob123 meet @Chuck and @DebB", new HipChatMessageResponse().mentions(ImmutableList.of("bob123", "Chuck", "DebB"))},
                { "Whoa! (parrot)(parrot)(parrot)(parrot)", new HipChatMessageResponse().emoticons(ImmutableList.of("parrot","parrot","parrot","parrot"))},
                { "https://www.google.com", new HipChatMessageResponse().links(ImmutableList.of(new HipChatMessageLink().title("Google").url("https://www.google.com")))},
                { "www.google.com", new HipChatMessageResponse().links(ImmutableList.of(new HipChatMessageLink().title("Google").url("www.google.com")))},
                { "Check out: http://testng.org and http://junit.org", new HipChatMessageResponse()
                    .links(ImmutableList.of(
                        new HipChatMessageLink().title("TestNG - Welcome").url("http://testng.org"),
                        new HipChatMessageLink().title("JUnit").url("http://junit.org"))
                    )
                },
                { "hey @bob123, have you and @Chuck seen the new training video? https://www.youtube.com/watch?v=dQw4w9WgXcQ it's pretty helpful (awesome)(awesome)",
                    new HipChatMessageResponse().mentions(ImmutableList.of("bob123","Chuck"))
                        .emoticons(ImmutableList.of("awesome","awesome"))
                        .links(ImmutableList.of(new HipChatMessageLink().url("https://www.youtube.com/watch?v=dQw4w9WgXcQ").title("Rick Astley - Never Gonna Give You Up - YouTube")))
                }
        };
    }

    @Test(dataProvider = "createWellFormedFeatureData")
    void testWellFormedFeatures(String message, HipChatMessageResponse expected) throws JSONException {
        testFeature(message, expected);
    }

    @Test(dataProvider = "createMalformedFeatureData")
    void testMalformedFeatures(String message, HipChatMessageResponse expected) throws JSONException {
        testFeature(message, expected);
    }

    private void testFeature(String message, HipChatMessageResponse expected) throws JSONException {
        HipChatMessageHandler handler = new HipChatMessageHandler("testLinkCache");

        LambdaProxyRequest request = new LambdaProxyRequest().body(message).httpMethod("POST").headers(ImmutableMap.of("Content-Type", "text/plain"));
        LambdaProxyResponse response = handler.handleRequest(request, null);

        Gson gson = new Gson();

        String expectedStr = gson.toJson(expected);
        JSONAssert.assertEquals(expectedStr, response.getBody(), false);
    }

}
