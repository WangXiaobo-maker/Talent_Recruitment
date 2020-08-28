package com.talresource.Talent_Recruitment.entity;

/**
 * 帖子实体
 */

public class Post {
    private int PostID;
    private String PostTitle;
    private int UserID;
    private String PostPublishDate;
    private String PostContent;
    private String PostHeat;

    public Post() {
    }

    public Post(String postTitle, int userID, String postPublishDate, String postContent) {
        PostTitle = postTitle;
        UserID = userID;
        PostPublishDate = postPublishDate;
        PostContent = postContent;
    }

    public Post(int postID, String postTitle, int userID, String postPublishDate, String postContent) {
        PostID = postID;
        PostTitle = postTitle;
        UserID = userID;
        PostPublishDate = postPublishDate;
        PostContent = postContent;
    }

    public String getPostHeat() {
        return PostHeat;
    }

    public void setPostHeat(String postHeat) {
        PostHeat = postHeat;
    }

    public int getPostID() {
        return PostID;
    }

    public void setPostID(int postID) {
        PostID = postID;
    }

    public String getPostTitle() {
        return PostTitle;
    }

    public void setPostTitle(String postTitle) {
        PostTitle = postTitle;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getPostPublishDate() {
        return PostPublishDate;
    }

    public void setPostPublishDate(String postPublishDate) {
        PostPublishDate = postPublishDate;
    }

    public String getPostContent() {
        return PostContent;
    }

    public void setPostContent(String postContent) {
        PostContent = postContent;
    }

    @Override
    public String toString() {
        return "Post{" +
                "PostID=" + PostID +
                ", PostTitle='" + PostTitle + '\'' +
                ", UserID=" + UserID +
                ", PostPublishDate='" + PostPublishDate + '\'' +
                ", PostContent='" + PostContent + '\'' +
                '}';
    }
}
