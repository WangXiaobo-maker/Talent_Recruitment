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
}
