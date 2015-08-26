package model;

/**
 * Created by Marcela on 23/08/15.
 */
public class ContentProvider {

    private int contentId;
    private String id;
    private String userId;
    public int getContentId() {
        return contentId;
    }
    public void setContentId(int contentId) {
        this.contentId = contentId;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
