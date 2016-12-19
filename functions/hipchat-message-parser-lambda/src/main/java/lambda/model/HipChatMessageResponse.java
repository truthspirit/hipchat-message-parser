package lambda.model;

import java.util.List;

/**
 */
public class HipChatMessageResponse {
    private List<String> mentions;
    private List<String> emoticons;
    private List<HipChatMessageLink> links;

    public List<String> getMentions() {
        return mentions;
    }

    public void setMentions(List<String> mentions) {
        this.mentions = mentions;
    }

    public List<String> getEmoticons() {
        return emoticons;
    }

    public void setEmoticons(List<String> emoticons) {
        this.emoticons = emoticons;
    }

    public List<HipChatMessageLink> getLinks() {
        return links;
    }

    public void setLinks(List<HipChatMessageLink> links) {
        this.links = links;
    }

    public HipChatMessageResponse mentions(List<String> mentions) {
        this.mentions = mentions;
        return this;
    }

    public HipChatMessageResponse emoticons(List<String> emoticons) {
        this.emoticons = emoticons;
        return this;
    }

    public HipChatMessageResponse links(List<HipChatMessageLink> links) {
        this.links = links;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HipChatMessageResponse that = (HipChatMessageResponse) o;

        if (mentions != null ? !mentions.equals(that.mentions) : that.mentions != null) return false;
        if (emoticons != null ? !emoticons.equals(that.emoticons) : that.emoticons != null) return false;
        return links != null ? links.equals(that.links) : that.links == null;
    }

    @Override
    public int hashCode() {
        int result = mentions != null ? mentions.hashCode() : 0;
        result = 31 * result + (emoticons != null ? emoticons.hashCode() : 0);
        result = 31 * result + (links != null ? links.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HipChatMessageResponse{" +
                "mentions=" + mentions +
                ", emoticons=" + emoticons +
                ", links=" + links +
                '}';
    }
}
