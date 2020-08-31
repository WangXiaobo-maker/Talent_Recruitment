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
import java.text.SimpleDateFormat;
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

        postService.updatePostHeat(PostID);

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

    @RequestMapping("/searchForum")
    public String searchForum(ModelMap map, String postInfo){

        List<Post> postList = postService.searchPostByTitleOrContent(postInfo);
        Map<User, Post> userPostMap = new LinkedHashMap<>();

        for (int i=0;i<postList.size();i++){
            Post post = postList.get(i);
            userPostMap.put(userService.queryById(post.getUserID()), post);
        }

        if (userPostMap.size() == 0)
            map.addAttribute("message", "null");
        else
            map.addAttribute("message", "notnull");


        map.addAttribute("UserPostMap", userPostMap);
        return "forumSearch";
    }

    @RequestMapping("/userDeletePost")
    public String userDeletePost(ModelMap map, String PostID){

        int id = Integer.parseInt(PostID);
        if (postService.deletePostByID(id) && commentService.deleteCommentByPost(id)){
            return "redirect:myPost";
        }
        return "redirect:myPost";
    }


    @RequestMapping("/publishPost")
    @ResponseBody
    public Result publishPost(HttpSession session, String PostTitle, String PostContent){
//        System.out.println(PostID + "-" + CommentContent);
        Result result = null;
        User user = (User)session.getAttribute("user");
        int UserID = user.getUserID();
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String PostPublishDate = sdf.format(today);
//        System.out.println(CommentPublishDate);

        if (postService.insertPost(PostTitle, PostContent, PostPublishDate, UserID)){
            result = new Result(Config.STATUS_SUCCESS,"发表成功");
        }
        else{
            result = new Result(Config.STATUS_FAILURE,"发表失败");
        }
        return result;
    }





}
