package com.talresource.Talent_Recruitment.controller;

import com.talresource.Talent_Recruitment.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @Autowired
    private JobService jobService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/home")
    public String home(ModelMap map){
        map.addAttribute("JobListByHeat", jobService.selectJobByHeat());

        return "home";
    }

    @RequestMapping("/test3")
    public String test3(){
        return "test3";
    }


    @RequestMapping("/redirLogin")
    public String login(){
        return "login";
    }

    @RequestMapping("/redirRegister")
    public String register(){
        return "register";
    }
}
