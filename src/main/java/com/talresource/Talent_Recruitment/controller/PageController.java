package com.talresource.Talent_Recruitment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/RedirLogin")
    public String login(){
        return "login";
    }

    @RequestMapping("/RedirRegister")
    public String register(){
        return "register";
    }
}
