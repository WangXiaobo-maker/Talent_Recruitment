package com.talresource.Talent_Recruitment.service;

import com.talresource.Talent_Recruitment.dao.CommentDao;
import com.talresource.Talent_Recruitment.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    public List<Comment> selectCommentByPost(int PostID){
        return commentDao.selectCommentByPost(PostID);
    }

    public boolean insertComment(int PostID, int UserID, String CommentPublishDate, String CommentContent){
        return commentDao.insertComment(PostID, UserID, CommentPublishDate, CommentContent);
    }

    public boolean deleteCommentByPost(int PostID){
        return commentDao.deleteCommentByPost(PostID);
    }
}
