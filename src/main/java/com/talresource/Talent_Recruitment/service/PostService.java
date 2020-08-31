package com.talresource.Talent_Recruitment.service;

import com.talresource.Talent_Recruitment.dao.PostDao;
import com.talresource.Talent_Recruitment.entity.Job;
import com.talresource.Talent_Recruitment.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostDao postDao;

    public Post selectPostByID(int PostID){
        return postDao.selectPostByID(PostID);
    }

    public List<Post> selectPostsByHeat(){
        return postDao.selectPostsByHeat();
    }

    public List<Post> selectPostsByDate(){
        return postDao.selectPostsByDate();
    }

    public List<Post> selectAllPost(){
        return postDao.selectAllPost();
    }

    public List<Post> searchPostByTitleOrContent(String PostInfo){
        return postDao.searchPostByTitleOrContent(PostInfo);
    }

    public boolean insertPost(String PostTitle, String PostContent, String PostPublishDate, int UserID){
        return postDao.insertPost(PostTitle, PostContent, PostPublishDate, UserID);
    }

    public boolean updatePostHeat(int PostID){
        return postDao.updatePostHeat(PostID);
    }

    public boolean deletePostByID(int PostID){
        return postDao.deletePostByID(PostID);
    }

    public List<Post> selectPostByUserID(int UserID){
        return postDao.selectPostByUserID(UserID);
    }

}
