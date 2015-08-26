package model;

/**
 * Created by Marcela on 23/08/15.
 */
public class Card {

    private String title;
    private String summary;
    private boolean autoApprove;
    private String[] metaTags;
    private ContentProvider contentProvider;
    private String[] categories;
    private JsonExtendedData jsonExtendedData;
    private String content;
    private String[] attachments;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public boolean isAutoApprove() {
        return autoApprove;
    }
    public void setAutoApprove(boolean autoApprove) {
        this.autoApprove = autoApprove;
    }
    public String[] getMetaTags() {
        return metaTags;
    }
    public void setMetaTags(String[] metaTags) {
        this.metaTags = metaTags;
    }
    public ContentProvider getContentProvider() {
        return contentProvider;
    }
    public void setContentProvider(ContentProvider contentProvider) {
        this.contentProvider = contentProvider;
    }
    public String[] getCategories() {
        return categories;
    }
    public void setCategories(String[] categories) {
        this.categories = categories;
    }
    public JsonExtendedData getJsonExtendedData() {
        return jsonExtendedData;
    }
    public void setJsonExtendedData(JsonExtendedData jsonExtendedData) {
        this.jsonExtendedData = jsonExtendedData;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String[] getAttachments() {
        return attachments;
    }
    public void setAttachments(String[] attachments) {
        this.attachments = attachments;
    }
}
