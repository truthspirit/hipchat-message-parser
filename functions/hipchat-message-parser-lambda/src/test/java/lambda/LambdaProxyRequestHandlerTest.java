package lambda;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import lambda.model.HipChatMessageLink;
import lambda.model.HipChatMessageResponse;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Unit Tests for LambdaProxyRequestHandler
 */
public class LambdaProxyRequestHandlerTest {

    @DataProvider
    public static Object[][] createMalformedFeatureData() {
        return new Object[][] {
                { "@ alice", new HipChatMessageResponse()},
                { "(!a)", new HipChatMessageResponse()},
                { "htps://www.google.com", new HipChatMessageResponse()},
                { "https://www.google.notvaliddomain", new HipChatMessageResponse()},
                { "www.alsnotta.validdomain", new HipChatMessageResponse()}
        };
    }

    @DataProvider
    Object[][] createWellFormedFeatureData() {
        return new Object[][]{
                { "Hi @alice!", new HipChatMessageResponse().mentions(ImmutableList.<String>of("alice"))},
                { "Wow! (smile)", new HipChatMessageResponse().emoticons(ImmutableList.<String>of("smile"))},
                { "@bob123 meet @Chuck and @DebB", new HipChatMessageResponse().mentions(ImmutableList.of("bob123", "Chuck", "DebB"))},
                { "Whoa! (parrot)(parrot)(parrot)(parrot)", new HipChatMessageResponse().emoticons(ImmutableList.<String>of("parrot","parrot","parrot","parrot"))},
                { "https://www.google.com", new HipChatMessageResponse().links(ImmutableList.<HipChatMessageLink>of(new HipChatMessageLink().title("Google").url("https://www.google.com")))},
                { "www.google.com", new HipChatMessageResponse().links(ImmutableList.<HipChatMessageLink>of(new HipChatMessageLink().title("Google").url("www.google.com")))},
                { "Check out: http://testng.org and http://junit.org", new HipChatMessageResponse()
                        .links(ImmutableList.<HipChatMessageLink>of(
                                new HipChatMessageLink().title("TestNG").url("http://testng.org"),
                                new HipChatMessageLink().title("JUnit - \n    About").url("http://junit.org"))
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
        LambdaProxyRequestHandler handler = new LambdaProxyRequestHandler();

        LambdaProxyRequest request = new LambdaProxyRequest().message(message);
        LambdaProxyResponse response = handler.handleRequest(request, null);

        Gson gson = new Gson();

        String expectedStr = gson.toJson(expected);
        JSONAssert.assertEquals(expectedStr, response.getBody(), false);
    }

}
