package com.talresource.Talent_Recruitment.service;

import com.talresource.Talent_Recruitment.dao.PostDao;
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

}
