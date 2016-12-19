package lambda;

import java.util.Map;

public class LambdaProxyRequest {
    private String message;
    private Input input;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public LambdaProxyRequest message(String message) {
        this.message = message;
        return this;
    }

    public LambdaProxyRequest input(Input input) {
        this.input = input;
        return this;
    }

    @Override
    public String toString() {
        return "LambdaProxyRequest{" +
                "message='" + message + '\'' +
                ", input=" + input +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LambdaProxyRequest that = (LambdaProxyRequest) o;

        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        return input != null ? input.equals(that.input) : that.input == null;
    }

    @Override
    public int hashCode() {
        int result = message != null ? message.hashCode() : 0;
        result = 31 * result + (input != null ? input.hashCode() : 0);
        return result;
    }
}

class Input {
    private String resource;
    private String path;
    private String httpMethod;
    private Headers headers;
    private Map<String, String> queryStringParameters;
    private Map<String, String> pathParameters;
    private Map<String, String> stageVariables;
    private RequestContext requestContext;
    private String body;

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

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
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

    public Input resource(String resource) {
        this.resource = resource;
        return this;
    }

    public Input path(String path) {
        this.path = path;
        return this;
    }

    public Input httpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    public Input headers(Headers headers) {
        this.headers = headers;
        return this;
    }

    public Input queryStringParameters(Map<String, String> queryStringParameters) {
        this.queryStringParameters = queryStringParameters;
        return this;
    }

    public Input pathParameters(Map<String, String> pathParameters) {
        this.pathParameters = pathParameters;
        return this;
    }

    public Input stageVariables(Map<String, String> stageVariables) {
        this.stageVariables = stageVariables;
        return this;
    }

    public Input requestContext(RequestContext requestContext) {
        this.requestContext = requestContext;
        return this;
    }

    public Input body(String body) {
        this.body = body;
        return this;
    }

    @Override
    public String toString() {
        return "Input{" +
                "resource='" + resource + '\'' +
                ", path='" + path + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", headers=" + headers +
                ", queryStringParameters=" + queryStringParameters +
                ", pathParameters=" + pathParameters +
                ", stageVariables=" + stageVariables +
                ", requestContext=" + requestContext +
                ", body='" + body + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Input input = (Input) o;

        if (resource != null ? !resource.equals(input.resource) : input.resource != null) return false;
        if (path != null ? !path.equals(input.path) : input.path != null) return false;
        if (httpMethod != null ? !httpMethod.equals(input.httpMethod) : input.httpMethod != null) return false;
        if (headers != null ? !headers.equals(input.headers) : input.headers != null) return false;
        if (queryStringParameters != null ? !queryStringParameters.equals(input.queryStringParameters) : input.queryStringParameters != null)
            return false;
        if (pathParameters != null ? !pathParameters.equals(input.pathParameters) : input.pathParameters != null)
            return false;
        if (stageVariables != null ? !stageVariables.equals(input.stageVariables) : input.stageVariables != null)
            return false;
        if (requestContext != null ? !requestContext.equals(input.requestContext) : input.requestContext != null)
            return false;
        return body != null ? body.equals(input.body) : input.body == null;
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
        return result;
    }
}

class RequestContext {
    private String accountId;
    private String resourceId;
    private String stage;
    private String requestId;
    private Identity identity;
    private String resourcePath;
    private String httpMethod;
    private String apiId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public RequestContext accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public RequestContext resourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    public RequestContext stage(String stage) {
        this.stage = stage;
        return this;
    }

    public RequestContext requestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public RequestContext identity(Identity identity) {
        this.identity = identity;
        return this;
    }

    public RequestContext resourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
        return this;
    }

    public RequestContext httpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    public RequestContext apiId(String apiId) {
        this.apiId = apiId;
        return this;
    }

    @Override
    public String toString() {
        return "RequestContext{" +
                "accountId='" + accountId + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", stage='" + stage + '\'' +
                ", requestId='" + requestId + '\'' +
                ", identity=" + identity +
                ", resourcePath='" + resourcePath + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", apiId='" + apiId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestContext that = (RequestContext) o;

        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) return false;
        if (resourceId != null ? !resourceId.equals(that.resourceId) : that.resourceId != null) return false;
        if (stage != null ? !stage.equals(that.stage) : that.stage != null) return false;
        if (requestId != null ? !requestId.equals(that.requestId) : that.requestId != null) return false;
        if (identity != null ? !identity.equals(that.identity) : that.identity != null) return false;
        if (resourcePath != null ? !resourcePath.equals(that.resourcePath) : that.resourcePath != null) return false;
        if (httpMethod != null ? !httpMethod.equals(that.httpMethod) : that.httpMethod != null) return false;
        return apiId != null ? apiId.equals(that.apiId) : that.apiId == null;
    }

    @Override
    public int hashCode() {
        int result = accountId != null ? accountId.hashCode() : 0;
        result = 31 * result + (resourceId != null ? resourceId.hashCode() : 0);
        result = 31 * result + (stage != null ? stage.hashCode() : 0);
        result = 31 * result + (requestId != null ? requestId.hashCode() : 0);
        result = 31 * result + (identity != null ? identity.hashCode() : 0);
        result = 31 * result + (resourcePath != null ? resourcePath.hashCode() : 0);
        result = 31 * result + (httpMethod != null ? httpMethod.hashCode() : 0);
        result = 31 * result + (apiId != null ? apiId.hashCode() : 0);
        return result;
    }
}

class Identity {
    private String cognitoIdentityPoolId;
    private String accountId;
    private String cognitoIdentityId;
    private String caller;
    private String apiKey;
    private String sourceIp;
    private String cognitoAuthenticationType;
    private String cognitoAuthenticationProvider;
    private String userArn;
    private String userAgent;
    private String user;

    public String getCognitoIdentityPoolId() {
        return cognitoIdentityPoolId;
    }

    public void setCognitoIdentityPoolId(String cognitoIdentityPoolId) {
        this.cognitoIdentityPoolId = cognitoIdentityPoolId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCognitoIdentityId() {
        return cognitoIdentityId;
    }

    public void setCognitoIdentityId(String cognitoIdentityId) {
        this.cognitoIdentityId = cognitoIdentityId;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    public String getCognitoAuthenticationType() {
        return cognitoAuthenticationType;
    }

    public void setCognitoAuthenticationType(String cognitoAuthenticationType) {
        this.cognitoAuthenticationType = cognitoAuthenticationType;
    }

    public String getCognitoAuthenticationProvider() {
        return cognitoAuthenticationProvider;
    }

    public void setCognitoAuthenticationProvider(String cognitoAuthenticationProvider) {
        this.cognitoAuthenticationProvider = cognitoAuthenticationProvider;
    }

    public String getUserArn() {
        return userArn;
    }

    public void setUserArn(String userArn) {
        this.userArn = userArn;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Identity cognitoIdentityPoolId(String cognitoIdentityPoolId) {
        this.cognitoIdentityPoolId = cognitoIdentityPoolId;
        return this;
    }

    public Identity accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public Identity cognitoIdentityId(String cognitoIdentityId) {
        this.cognitoIdentityId = cognitoIdentityId;
        return this;
    }

    public Identity caller(String caller) {
        this.caller = caller;
        return this;
    }

    public Identity apiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public Identity sourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
        return this;
    }

    public Identity cognitoAuthenticationType(String cognitoAuthenticationType) {
        this.cognitoAuthenticationType = cognitoAuthenticationType;
        return this;
    }

    public Identity cognitoAuthenticationProvider(String cognitoAuthenticationProvider) {
        this.cognitoAuthenticationProvider = cognitoAuthenticationProvider;
        return this;
    }

    public Identity userArn(String userArn) {
        this.userArn = userArn;
        return this;
    }

    public Identity userAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public Identity user(String user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return "Identity{" +
                "cognitoIdentityPoolId='" + cognitoIdentityPoolId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", cognitoIdentityId='" + cognitoIdentityId + '\'' +
                ", caller='" + caller + '\'' +
                ", apiKey='" + apiKey + '\'' +
                ", sourceIp='" + sourceIp + '\'' +
                ", cognitoAuthenticationType='" + cognitoAuthenticationType + '\'' +
                ", cognitoAuthenticationProvider='" + cognitoAuthenticationProvider + '\'' +
                ", userArn='" + userArn + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", user='" + user + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Identity identity = (Identity) o;

        if (cognitoIdentityPoolId != null ? !cognitoIdentityPoolId.equals(identity.cognitoIdentityPoolId) : identity.cognitoIdentityPoolId != null)
            return false;
        if (accountId != null ? !accountId.equals(identity.accountId) : identity.accountId != null) return false;
        if (cognitoIdentityId != null ? !cognitoIdentityId.equals(identity.cognitoIdentityId) : identity.cognitoIdentityId != null)
            return false;
        if (caller != null ? !caller.equals(identity.caller) : identity.caller != null) return false;
        if (apiKey != null ? !apiKey.equals(identity.apiKey) : identity.apiKey != null) return false;
        if (sourceIp != null ? !sourceIp.equals(identity.sourceIp) : identity.sourceIp != null) return false;
        if (cognitoAuthenticationType != null ? !cognitoAuthenticationType.equals(identity.cognitoAuthenticationType) : identity.cognitoAuthenticationType != null)
            return false;
        if (cognitoAuthenticationProvider != null ? !cognitoAuthenticationProvider.equals(identity.cognitoAuthenticationProvider) : identity.cognitoAuthenticationProvider != null)
            return false;
        if (userArn != null ? !userArn.equals(identity.userArn) : identity.userArn != null) return false;
        if (userAgent != null ? !userAgent.equals(identity.userAgent) : identity.userAgent != null) return false;
        return user != null ? user.equals(identity.user) : identity.user == null;
    }

    @Override
    public int hashCode() {
        int result = cognitoIdentityPoolId != null ? cognitoIdentityPoolId.hashCode() : 0;
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (cognitoIdentityId != null ? cognitoIdentityId.hashCode() : 0);
        result = 31 * result + (caller != null ? caller.hashCode() : 0);
        result = 31 * result + (apiKey != null ? apiKey.hashCode() : 0);
        result = 31 * result + (sourceIp != null ? sourceIp.hashCode() : 0);
        result = 31 * result + (cognitoAuthenticationType != null ? cognitoAuthenticationType.hashCode() : 0);
        result = 31 * result + (cognitoAuthenticationProvider != null ? cognitoAuthenticationProvider.hashCode() : 0);
        result = 31 * result + (userArn != null ? userArn.hashCode() : 0);
        result = 31 * result + (userAgent != null ? userAgent.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}

class Headers {
    private String accept;
    private String acceptEncoding;
    private String cacheControl;
    private String cloudFrontForwardedProto;
    private String cloudFrontIsDesktopViewer;
    private String cloudFrontIsMobileViewer;
    private String cloudFrontIsSmartTVViewer;
    private String cloudFrontIsTabletViewer;
    private String cloudFrontViewerCountry;
    private String contentType;
    private String headerName;
    private String host;
    private String postmanToken;
    private String userAgent;
    private String via;
    private String xAmzCfId;
    private String xForwardedFor;
    private String xForwardedPort;
    private String xForwardedProto;

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    public String getCacheControl() {
        return cacheControl;
    }

    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }

    public String getCloudFrontForwardedProto() {
        return cloudFrontForwardedProto;
    }

    public void setCloudFrontForwardedProto(String cloudFrontForwardedProto) {
        this.cloudFrontForwardedProto = cloudFrontForwardedProto;
    }

    public String getCloudFrontIsDesktopViewer() {
        return cloudFrontIsDesktopViewer;
    }

    public void setCloudFrontIsDesktopViewer(String cloudFrontIsDesktopViewer) {
        this.cloudFrontIsDesktopViewer = cloudFrontIsDesktopViewer;
    }

    public String getCloudFrontIsMobileViewer() {
        return cloudFrontIsMobileViewer;
    }

    public void setCloudFrontIsMobileViewer(String cloudFrontIsMobileViewer) {
        this.cloudFrontIsMobileViewer = cloudFrontIsMobileViewer;
    }

    public String getCloudFrontIsSmartTVViewer() {
        return cloudFrontIsSmartTVViewer;
    }

    public void setCloudFrontIsSmartTVViewer(String cloudFrontIsSmartTVViewer) {
        this.cloudFrontIsSmartTVViewer = cloudFrontIsSmartTVViewer;
    }

    public String getCloudFrontIsTabletViewer() {
        return cloudFrontIsTabletViewer;
    }

    public void setCloudFrontIsTabletViewer(String cloudFrontIsTabletViewer) {
        this.cloudFrontIsTabletViewer = cloudFrontIsTabletViewer;
    }

    public String getCloudFrontViewerCountry() {
        return cloudFrontViewerCountry;
    }

    public void setCloudFrontViewerCountry(String cloudFrontViewerCountry) {
        this.cloudFrontViewerCountry = cloudFrontViewerCountry;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPostmanToken() {
        return postmanToken;
    }

    public void setPostmanToken(String postmanToken) {
        this.postmanToken = postmanToken;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getxAmzCfId() {
        return xAmzCfId;
    }

    public void setxAmzCfId(String xAmzCfId) {
        this.xAmzCfId = xAmzCfId;
    }

    public String getxForwardedFor() {
        return xForwardedFor;
    }

    public void setxForwardedFor(String xForwardedFor) {
        this.xForwardedFor = xForwardedFor;
    }

    public String getxForwardedPort() {
        return xForwardedPort;
    }

    public void setxForwardedPort(String xForwardedPort) {
        this.xForwardedPort = xForwardedPort;
    }

    public String getxForwardedProto() {
        return xForwardedProto;
    }

    public void setxForwardedProto(String xForwardedProto) {
        this.xForwardedProto = xForwardedProto;
    }

    public Headers accept(String accept) {
        this.accept = accept;
        return this;
    }

    public Headers acceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
        return this;
    }

    public Headers cacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
        return this;
    }

    public Headers cloudFrontForwardedProto(String cloudFrontForwardedProto) {
        this.cloudFrontForwardedProto = cloudFrontForwardedProto;
        return this;
    }

    public Headers cloudFrontIsDesktopViewer(String cloudFrontIsDesktopViewer) {
        this.cloudFrontIsDesktopViewer = cloudFrontIsDesktopViewer;
        return this;
    }

    public Headers cloudFrontIsMobileViewer(String cloudFrontIsMobileViewer) {
        this.cloudFrontIsMobileViewer = cloudFrontIsMobileViewer;
        return this;
    }

    public Headers cloudFrontIsSmartTVViewer(String cloudFrontIsSmartTVViewer) {
        this.cloudFrontIsSmartTVViewer = cloudFrontIsSmartTVViewer;
        return this;
    }

    public Headers cloudFrontIsTabletViewer(String cloudFrontIsTabletViewer) {
        this.cloudFrontIsTabletViewer = cloudFrontIsTabletViewer;
        return this;
    }

    public Headers cloudFrontViewerCountry(String cloudFrontViewerCountry) {
        this.cloudFrontViewerCountry = cloudFrontViewerCountry;
        return this;
    }

    public Headers contentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public Headers headerName(String headerName) {
        this.headerName = headerName;
        return this;
    }

    public Headers host(String host) {
        this.host = host;
        return this;
    }

    public Headers postmanToken(String postmanToken) {
        this.postmanToken = postmanToken;
        return this;
    }

    public Headers userAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public Headers via(String via) {
        this.via = via;
        return this;
    }

    public Headers xAmzCfId(String xAmzCfId) {
        this.xAmzCfId = xAmzCfId;
        return this;
    }

    public Headers xForwardedFor(String xForwardedFor) {
        this.xForwardedFor = xForwardedFor;
        return this;
    }

    public Headers xForwardedPort(String xForwardedPort) {
        this.xForwardedPort = xForwardedPort;
        return this;
    }

    public Headers xForwardedProto(String xForwardedProto) {
        this.xForwardedProto = xForwardedProto;
        return this;
    }

    @Override
    public String toString() {
        return "Headers{" +
                "accept='" + accept + '\'' +
                ", acceptEncoding='" + acceptEncoding + '\'' +
                ", cacheControl='" + cacheControl + '\'' +
                ", cloudFrontForwardedProto='" + cloudFrontForwardedProto + '\'' +
                ", cloudFrontIsDesktopViewer='" + cloudFrontIsDesktopViewer + '\'' +
                ", cloudFrontIsMobileViewer='" + cloudFrontIsMobileViewer + '\'' +
                ", cloudFrontIsSmartTVViewer='" + cloudFrontIsSmartTVViewer + '\'' +
                ", cloudFrontIsTabletViewer='" + cloudFrontIsTabletViewer + '\'' +
                ", cloudFrontViewerCountry='" + cloudFrontViewerCountry + '\'' +
                ", contentType='" + contentType + '\'' +
                ", headerName='" + headerName + '\'' +
                ", host='" + host + '\'' +
                ", postmanToken='" + postmanToken + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", via='" + via + '\'' +
                ", xAmzCfId='" + xAmzCfId + '\'' +
                ", xForwardedFor='" + xForwardedFor + '\'' +
                ", xForwardedPort='" + xForwardedPort + '\'' +
                ", xForwardedProto='" + xForwardedProto + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Headers headers = (Headers) o;

        if (accept != null ? !accept.equals(headers.accept) : headers.accept != null) return false;
        if (acceptEncoding != null ? !acceptEncoding.equals(headers.acceptEncoding) : headers.acceptEncoding != null)
            return false;
        if (cacheControl != null ? !cacheControl.equals(headers.cacheControl) : headers.cacheControl != null)
            return false;
        if (cloudFrontForwardedProto != null ? !cloudFrontForwardedProto.equals(headers.cloudFrontForwardedProto) : headers.cloudFrontForwardedProto != null)
            return false;
        if (cloudFrontIsDesktopViewer != null ? !cloudFrontIsDesktopViewer.equals(headers.cloudFrontIsDesktopViewer) : headers.cloudFrontIsDesktopViewer != null)
            return false;
        if (cloudFrontIsMobileViewer != null ? !cloudFrontIsMobileViewer.equals(headers.cloudFrontIsMobileViewer) : headers.cloudFrontIsMobileViewer != null)
            return false;
        if (cloudFrontIsSmartTVViewer != null ? !cloudFrontIsSmartTVViewer.equals(headers.cloudFrontIsSmartTVViewer) : headers.cloudFrontIsSmartTVViewer != null)
            return false;
        if (cloudFrontIsTabletViewer != null ? !cloudFrontIsTabletViewer.equals(headers.cloudFrontIsTabletViewer) : headers.cloudFrontIsTabletViewer != null)
            return false;
        if (cloudFrontViewerCountry != null ? !cloudFrontViewerCountry.equals(headers.cloudFrontViewerCountry) : headers.cloudFrontViewerCountry != null)
            return false;
        if (contentType != null ? !contentType.equals(headers.contentType) : headers.contentType != null) return false;
        if (headerName != null ? !headerName.equals(headers.headerName) : headers.headerName != null) return false;
        if (host != null ? !host.equals(headers.host) : headers.host != null) return false;
        if (postmanToken != null ? !postmanToken.equals(headers.postmanToken) : headers.postmanToken != null)
            return false;
        if (userAgent != null ? !userAgent.equals(headers.userAgent) : headers.userAgent != null) return false;
        if (via != null ? !via.equals(headers.via) : headers.via != null) return false;
        if (xAmzCfId != null ? !xAmzCfId.equals(headers.xAmzCfId) : headers.xAmzCfId != null) return false;
        if (xForwardedFor != null ? !xForwardedFor.equals(headers.xForwardedFor) : headers.xForwardedFor != null)
            return false;
        if (xForwardedPort != null ? !xForwardedPort.equals(headers.xForwardedPort) : headers.xForwardedPort != null)
            return false;
        return xForwardedProto != null ? xForwardedProto.equals(headers.xForwardedProto) : headers.xForwardedProto == null;
    }

    @Override
    public int hashCode() {
        int result = accept != null ? accept.hashCode() : 0;
        result = 31 * result + (acceptEncoding != null ? acceptEncoding.hashCode() : 0);
        result = 31 * result + (cacheControl != null ? cacheControl.hashCode() : 0);
        result = 31 * result + (cloudFrontForwardedProto != null ? cloudFrontForwardedProto.hashCode() : 0);
        result = 31 * result + (cloudFrontIsDesktopViewer != null ? cloudFrontIsDesktopViewer.hashCode() : 0);
        result = 31 * result + (cloudFrontIsMobileViewer != null ? cloudFrontIsMobileViewer.hashCode() : 0);
        result = 31 * result + (cloudFrontIsSmartTVViewer != null ? cloudFrontIsSmartTVViewer.hashCode() : 0);
        result = 31 * result + (cloudFrontIsTabletViewer != null ? cloudFrontIsTabletViewer.hashCode() : 0);
        result = 31 * result + (cloudFrontViewerCountry != null ? cloudFrontViewerCountry.hashCode() : 0);
        result = 31 * result + (contentType != null ? contentType.hashCode() : 0);
        result = 31 * result + (headerName != null ? headerName.hashCode() : 0);
        result = 31 * result + (host != null ? host.hashCode() : 0);
        result = 31 * result + (postmanToken != null ? postmanToken.hashCode() : 0);
        result = 31 * result + (userAgent != null ? userAgent.hashCode() : 0);
        result = 31 * result + (via != null ? via.hashCode() : 0);
        result = 31 * result + (xAmzCfId != null ? xAmzCfId.hashCode() : 0);
        result = 31 * result + (xForwardedFor != null ? xForwardedFor.hashCode() : 0);
        result = 31 * result + (xForwardedPort != null ? xForwardedPort.hashCode() : 0);
        result = 31 * result + (xForwardedProto != null ? xForwardedProto.hashCode() : 0);
        return result;
    }
}