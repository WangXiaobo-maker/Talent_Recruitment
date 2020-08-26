package com.talresource.Talent_Recruitment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoController {

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

}
