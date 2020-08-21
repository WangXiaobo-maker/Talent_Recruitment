package com.talresource.Talent_Recruitment.controller;

import com.talresource.Talent_Recruitment.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping("/jobTest1")
    public String jobTest1(ModelMap map){

        map.addAttribute("JobListByHeat", jobService.selectJobByHeat());

        map.addAttribute("TestJobListSearch", jobService.selectAllJob());
        return "test1";
    }

    @RequestMapping("/jobTest2")
    public String jobTest2(ModelMap map, @RequestParam(defaultValue = "null") String JobName, @RequestParam(defaultValue = "null") String JobFamily){
        map.addAttribute("JobListByHeat", jobService.selectJobByHeat());
        map.addAttribute("TestJobListSearch", jobService.TestJobList(JobName, JobFamily));
        return "test1";
    }

}
