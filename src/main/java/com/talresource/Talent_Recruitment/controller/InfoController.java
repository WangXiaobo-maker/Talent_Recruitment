package com.talresource.Talent_Recruitment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoController {

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

}

