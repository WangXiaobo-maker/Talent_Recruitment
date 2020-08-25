package com.talresource.Talent_Recruitment.controller;

import com.talresource.Talent_Recruitment.service.CompanyService;
import com.talresource.Talent_Recruitment.service.JobService;
import com.talresource.Talent_Recruitment.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @Autowired
    private JobService jobService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/index")
    public String index(){
        return "jobSearch";
    }

    @RequestMapping("/home")
    public String home(ModelMap map){
        map.addAttribute("JobListByHeat", jobService.selectJobByHeat());
        map.addAttribute("CompanyListByHeat", companyService.selectCompanyByHeat());
        return "jobSearch";
    }

    @RequestMapping("/test3")
    public String test3(){
        return "test3";
    }

    @RequestMapping("/test4")
    public String test4(ModelMap map){
        map.addAttribute("testMessage", newsService.selectNewsByID(7));
        return "test4";
    }
}
