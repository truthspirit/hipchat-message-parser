package lambda;

import java.util.Map;

public class RequestContext {
    private String accountId;
    private String resourceId;
    private String stage;
    private String requestId;
    private Map<String, String> identity;
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

    public Map<String, String> getIdentity() {
        return identity;
    }

    public void setIdentity(Map<String, String> identity) {
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

    public RequestContext identity(Map<String, String> identity) {
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
}
