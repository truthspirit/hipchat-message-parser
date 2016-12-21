package lambda.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.google.gson.annotations.Expose;

import java.time.LocalDateTime;

/**
 * HipChatMessageLink is both a DynamoDB mapped table and a gson annotated model object.
 */

@DynamoDBTable(tableName = "linkCache")
public class HipChatMessageLink {
    @Expose
    private String url;
    @Expose
    private String title;
    private LocalDateTime created;
    private Integer ttl;

    @DynamoDBHashKey
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    public HipChatMessageLink url(String url) {
        this.url = url;
        return this;
    }

    public HipChatMessageLink title(String title) {
        this.title = title;
        return this;
    }

    public HipChatMessageLink created(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public HipChatMessageLink ttl(Integer ttl) {
        this.ttl = ttl;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HipChatMessageLink that = (HipChatMessageLink) o;

        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        return ttl != null ? ttl.equals(that.ttl) : that.ttl == null;
    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (ttl != null ? ttl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HipChatMessageLink{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", created=" + created +
                ", ttl=" + ttl +
                '}';
    }

    public static class LocalDateTimeConverter implements DynamoDBTypeConverter<String, LocalDateTime> {
        @Override
        public String convert(LocalDateTime time) {
            return time.toString();
        }

        @Override
        public LocalDateTime unconvert(String stringVal) {
            return LocalDateTime.parse(stringVal);
        }
    }
}
