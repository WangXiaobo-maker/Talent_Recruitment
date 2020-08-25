package com.talresource.Talent_Recruitment.entity;

/**
 * 评论实体
 */

public class Comment {
    private int CommentID;
    private int PostID;
    private int UserID;
    private String CommentPublishDate;
    private String CommentContent;

    public Comment() {
    }

    public Comment(int postID, int userID, String commentPublishDate, String commentContent) {
        PostID = postID;
        UserID = userID;
        CommentPublishDate = commentPublishDate;
        CommentContent = commentContent;
    }

    public Comment(int commentID, int postID, int userID, String commentPublishDate, String commentContent) {
        CommentID = commentID;
        PostID = postID;
        UserID = userID;
        CommentPublishDate = commentPublishDate;
        CommentContent = commentContent;
    }

    public int getCommentID() {
        return CommentID;
    }

    public void setCommentID(int commentID) {
        CommentID = commentID;
    }

    public int getPostID() {
        return PostID;
    }

    public void setPostID(int postID) {
        PostID = postID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getCommentPublishDate() {
        return CommentPublishDate;
    }

    public void setCommentPublishDate(String commentPublishDate) {
        CommentPublishDate = commentPublishDate;
    }

    public String getCommentContent() {
        return CommentContent;
    }

    public void setCommentContent(String commentContent) {
        CommentContent = commentContent;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "CommentID=" + CommentID +
                ", PostID=" + PostID +
                ", UserID=" + UserID +
                ", CommentPublishDate='" + CommentPublishDate + '\'' +
                ", CommentContent='" + CommentContent + '\'' +
                '}';
    }
}
