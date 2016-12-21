package lambda;


import java.util.Map;

/**
 * LambdaProxyRequest represents an https request that has been proxied to AWS Lambda
 * through the APIGateway. This class is populated automatically by the lambda framework.
 */

public class LambdaProxyRequest {
    private String resource;
    private String path;
    private String httpMethod;
    private Map<String,String> headers;
    private Map<String,String> queryStringParameters;
    private Map<String,String> pathParameters;
    private Map<String,String> stageVariables;
    private RequestContext requestContext;
    private String body;
    private String isBase64Encoded;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getQueryStringParameters() {
        return queryStringParameters;
    }

    public void setQueryStringParameters(Map<String, String> queryStringParameters) {
        this.queryStringParameters = queryStringParameters;
    }

    public Map<String, String> getPathParameters() {
        return pathParameters;
    }

    public void setPathParameters(Map<String, String> pathParameters) {
        this.pathParameters = pathParameters;
    }

    public Map<String, String> getStageVariables() {
        return stageVariables;
    }

    public void setStageVariables(Map<String, String> stageVariables) {
        this.stageVariables = stageVariables;
    }

    public RequestContext getRequestContext() {
        return requestContext;
    }

    public void setRequestContext(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getIsBase64Encoded() {
        return isBase64Encoded;
    }

    public void setIsBase64Encoded(String isBase64Encoded) {
        this.isBase64Encoded = isBase64Encoded;
    }

    public LambdaProxyRequest resource(String resource) {
        this.resource = resource;
        return this;
    }

    public LambdaProxyRequest path(String path) {
        this.path = path;
        return this;
    }

    public LambdaProxyRequest httpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    public LambdaProxyRequest headers(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public LambdaProxyRequest queryStringParameters(Map<String, String> queryStringParameters) {
        this.queryStringParameters = queryStringParameters;
        return this;
    }

    public LambdaProxyRequest pathParameters(Map<String, String> pathParameters) {
        this.pathParameters = pathParameters;
        return this;
    }

    public LambdaProxyRequest stageVariables(Map<String, String> stageVariables) {
        this.stageVariables = stageVariables;
        return this;
    }

    public LambdaProxyRequest requestContext(RequestContext requestContext) {
        this.requestContext = requestContext;
        return this;
    }

    public LambdaProxyRequest body(String body) {
        this.body = body;
        return this;
    }

    public LambdaProxyRequest isBase64Encoded(String isBase64Encoded) {
        this.isBase64Encoded = isBase64Encoded;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LambdaProxyRequest that = (LambdaProxyRequest) o;

        if (resource != null ? !resource.equals(that.resource) : that.resource != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        if (httpMethod != null ? !httpMethod.equals(that.httpMethod) : that.httpMethod != null) return false;
        if (headers != null ? !headers.equals(that.headers) : that.headers != null) return false;
        if (queryStringParameters != null ? !queryStringParameters.equals(that.queryStringParameters) : that.queryStringParameters != null)
            return false;
        if (pathParameters != null ? !pathParameters.equals(that.pathParameters) : that.pathParameters != null)
            return false;
        if (stageVariables != null ? !stageVariables.equals(that.stageVariables) : that.stageVariables != null)
            return false;
        if (requestContext != null ? !requestContext.equals(that.requestContext) : that.requestContext != null)
            return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;
        return isBase64Encoded != null ? isBase64Encoded.equals(that.isBase64Encoded) : that.isBase64Encoded == null;
    }

    @Override
    public int hashCode() {
        int result = resource != null ? resource.hashCode() : 0;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (httpMethod != null ? httpMethod.hashCode() : 0);
        result = 31 * result + (headers != null ? headers.hashCode() : 0);
        result = 31 * result + (queryStringParameters != null ? queryStringParameters.hashCode() : 0);
        result = 31 * result + (pathParameters != null ? pathParameters.hashCode() : 0);
        result = 31 * result + (stageVariables != null ? stageVariables.hashCode() : 0);
        result = 31 * result + (requestContext != null ? requestContext.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (isBase64Encoded != null ? isBase64Encoded.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LambdaProxyRequest{" +
                "resource='" + resource + '\'' +
                ", path='" + path + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", headers=" + headers +
                ", queryStringParameters=" + queryStringParameters +
                ", pathParameters=" + pathParameters +
                ", stageVariables=" + stageVariables +
                ", requestContext=" + requestContext +
                ", body='" + body + '\'' +
                ", isBase64Encoded='" + isBase64Encoded + '\'' +
                '}';
    }
}