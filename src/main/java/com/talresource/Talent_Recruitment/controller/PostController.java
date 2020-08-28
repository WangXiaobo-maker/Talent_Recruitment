package com.talresource.Talent_Recruitment.controller;

import com.talresource.Talent_Recruitment.entity.*;
import com.talresource.Talent_Recruitment.service.CommentService;
import com.talresource.Talent_Recruitment.service.PostService;
import com.talresource.Talent_Recruitment.service.UserService;
import com.talresource.Talent_Recruitment.util.Config;
import org.apache.xerces.xs.StringList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/forumContent")
    public String forumContent( ModelMap map, int PostID, int UserID){
        Post post = postService.selectPostByID(PostID);
        User user = userService.queryById(UserID);

        List<Comment> CommentList = commentService.selectCommentByPost(PostID);


        Map<User, Comment> userCommentMap = new LinkedHashMap<>();
        for (int i=0;i<CommentList.size();i++){
            Comment comment = CommentList.get(i);
            userCommentMap.put(userService.queryById(comment.getUserID()), comment);
        }

        map.addAttribute("postInfo", post);
        map.addAttribute("userInfo", user);
        map.addAttribute("UserCommentMap", userCommentMap);

        List<Post> HeatPosts = postService.selectPostsByHeat();

        Map<String, PostCombineUser> stringPostCombineUserMap1 = new HashMap<>();
        Map<String, PostCombineUser> stringPostCombineUserMap2 = new HashMap<>();


        for (int i=0;i<10;i++){
            if (i<3){
                Post post1 = HeatPosts.get(i);
                User user1 = userService.queryById(post1.getUserID());
                PostCombineUser postCombineUser = new PostCombineUser(post1, user1);
                stringPostCombineUserMap1.put(String.valueOf(i+1), postCombineUser);
            }
            else{
                Post post1 = HeatPosts.get(i);
                User user1 = userService.queryById(post1.getUserID());
                PostCombineUser postCombineUser = new PostCombineUser(post1, user1);
                stringPostCombineUserMap2.put(String.valueOf(i+1), postCombineUser);

            }

        }

        map.addAttribute("userPostMap1", stringPostCombineUserMap1);
        map.addAttribute("userPostMap2", stringPostCombineUserMap2);

        return "forumContent";
    }


}
