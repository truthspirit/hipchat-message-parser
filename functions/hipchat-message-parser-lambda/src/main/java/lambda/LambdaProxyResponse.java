package lambda;

import java.util.Map;

public class LambdaProxyResponse {
    private Integer statusCode;
    private Map<String, String> headers;
    private String body;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LambdaProxyResponse statusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public LambdaProxyResponse headers(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public LambdaProxyResponse body(String body) {
        this.body = body;
        return this;
    }

    @Override
    public String toString() {
        return "LambdaProxyResponse{" +
                "statusCode=" + statusCode +
                ", headers=" + headers +
                ", body='" + body + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LambdaProxyResponse that = (LambdaProxyResponse) o;

        if (statusCode != null ? !statusCode.equals(that.statusCode) : that.statusCode != null) return false;
        if (headers != null ? !headers.equals(that.headers) : that.headers != null) return false;
        return body != null ? body.equals(that.body) : that.body == null;
    }

    @Override
    public int hashCode() {
        int result = statusCode != null ? statusCode.hashCode() : 0;
        result = 31 * result + (headers != null ? headers.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }
}