package com.talresource.Talent_Recruitment.controller;

import com.talresource.Talent_Recruitment.entity.User;
import com.talresource.Talent_Recruitment.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class InfoController {

    @Autowired
    private PostService postService;

    @RequestMapping("/forgotPwd")
    public String forgotPwd() {
        return "forgotPwd";
    }

    @RequestMapping("/userInfoPage")
    public String userInfoPage() {
        return "userInfoPage";
    }

    @RequestMapping("/userInfoPageNoLogin")
    public String userInfoPageNoLogin() {
        return "userInfoPageNoLogin";
    }

    @RequestMapping("/myInfo")
    public String myInfo() {
        return "html/myInfo";
    }

    @RequestMapping("/myUpdateInfo")
    public String myUpdateInfo() {
        return "html/myUpdateInfo";
    }

    @RequestMapping("/myNotice")
    public String myNotice() {
        return "html/myNotice";
    }

    @RequestMapping("/myCV")
    public String myCV() {
        return "html/myCV";
    }

    @RequestMapping("/companyInfoPage")
    public String companyInfoPage() {
        return "companyInfoPage";
    }

    @RequestMapping("/companyInfo")
    public String companyInfo() {
        return "html/companyInfo";
    }

    @RequestMapping("/companyUpdateInfo")
    public String companyUpdateInfo() {
        return "html/companyUpdateInfo";
    }

    @RequestMapping("/companyNotice")
    public String companyNotice() {
        return "html/companyNotice";
    }

    @RequestMapping("/myPost")
    public String myPost(HttpSession session, ModelMap map){
        User user = (User)session.getAttribute("user");
        map.addAttribute("PostList", postService.selectPostByUserID(user.getUserID()));
        return "html/myPost";
    }

}

