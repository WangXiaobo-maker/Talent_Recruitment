package com.talresource.Talent_Recruitment.controller;

import com.talresource.Talent_Recruitment.entity.Comment;
import com.talresource.Talent_Recruitment.entity.Company;
import com.talresource.Talent_Recruitment.entity.Result;
import com.talresource.Talent_Recruitment.entity.User;
import com.talresource.Talent_Recruitment.service.CommentService;
import com.talresource.Talent_Recruitment.util.Config;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("publishComment")
    @ResponseBody
    public Result publishComment(HttpSession session, String PostID, String CommentContent){
        Result result = null;
        int PostID1 = Integer.parseInt(PostID);
        User user = (User)session.getAttribute("user");
        int UserID = user.getUserID();
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String CommentPublishDate = sdf.format(today);
        if (commentService.insertComment(PostID1, UserID, CommentPublishDate,CommentContent)){
            result = new Result(Config.STATUS_SUCCESS,"发表成功");
        }
        else{
            result = new Result(Config.STATUS_FAILURE,"发表失败");
        }
        return result;
    }
}
