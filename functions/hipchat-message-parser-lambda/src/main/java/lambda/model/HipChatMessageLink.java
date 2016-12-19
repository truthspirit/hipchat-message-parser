package lambda.model;

/**
 */
public class HipChatMessageLink {
    private String url;
    private String title;

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


    public HipChatMessageLink url(String url) {
        this.url = url;
        return this;
    }

    public HipChatMessageLink title(String title) {
        this.title = title;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HipChatMessageLink that = (HipChatMessageLink) o;

        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        return title != null ? title.equals(that.title) : that.title == null;
    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HipChatMessageLink{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
