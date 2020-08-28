package com.talresource.Talent_Recruitment.controller;

import com.talresource.Talent_Recruitment.entity.Post;
import com.talresource.Talent_Recruitment.entity.User;
import com.talresource.Talent_Recruitment.service.PostService;
import com.talresource.Talent_Recruitment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping("/forumContent")
    public String forumContent( ModelMap map, int PostID, int UserID){
        Post post = postService.selectPostByID(PostID);
        User user = userService.queryById(UserID);

        map.addAttribute("postInfo", post);
        map.addAttribute("userInfo", user);

        return "forumContent";
    }

}
