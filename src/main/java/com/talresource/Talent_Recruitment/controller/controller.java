package com.talresource.Talent_Recruitment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {

    @RequestMapping("/reInfo")
    public String test1() {
        return "companyRegisterInfo";
    }

    @RequestMapping("/index2")
    public String test2(){
        return "login";
    }

}
