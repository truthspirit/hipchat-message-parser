package lambda.model;

import java.net.URL;

/**
 * ParsedUrl allows us to keep a representation of the original string that was passed in the request
 * and also the valid URL that was parsed from it.
 */

public class ParsedUrl {
    private String originalToken;
    private URL url;

    public String getOriginalToken() {
        return originalToken;
    }

    public void setOriginalToken(String originalToken) {
        this.originalToken = originalToken;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public ParsedUrl originalToken(String originalToken) {
        this.originalToken = originalToken;
        return this;
    }

    public ParsedUrl url(URL url) {
        this.url = url;
        return this;
    }
}
