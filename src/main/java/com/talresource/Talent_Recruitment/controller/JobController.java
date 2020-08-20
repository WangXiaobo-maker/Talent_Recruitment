package com.talresource.Talent_Recruitment.controller;

import com.talresource.Talent_Recruitment.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping("/test1")
    public String test1(ModelMap map){

        map.addAttribute("JobListByHeat", jobService.selectJobByHeat());
        return "test1";
    }

}
