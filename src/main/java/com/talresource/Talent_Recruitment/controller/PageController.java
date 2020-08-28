package com.talresource.Talent_Recruitment.controller;

import com.talresource.Talent_Recruitment.entity.Company;
import com.talresource.Talent_Recruitment.entity.Job;
import com.talresource.Talent_Recruitment.service.CompanyService;
import com.talresource.Talent_Recruitment.service.JobService;
import com.talresource.Talent_Recruitment.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

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
        return "index";
    }

    @RequestMapping("/home")
    public String home(ModelMap map){
        map.addAttribute("JobListByHeat", jobService.selectJobByHeat());
        map.addAttribute("CompanyListByHeat", companyService.selectCompanyByHeat());
        return "home";
    }

    @RequestMapping("/jobSearch")
    public String jobSearch(ModelMap map, @RequestParam(defaultValue = "") String JobCity,
                            @RequestParam(defaultValue = "") String JobSalary,
                            @RequestParam(defaultValue = "")String JobExperience,
                            @RequestParam(defaultValue = "")String JobEduDegree,
                            @RequestParam(defaultValue = "")String JobFamily){

        if (JobCity.equals("全国")){
            JobCity = "";
        }
        if (JobSalary.equals("所有")){
            JobSalary = "";
        }
        if (JobExperience.equals("所有")){
            JobExperience = "";
        }
        if (JobEduDegree.equals("所有")){
            JobEduDegree = "";
        }
        if (JobFamily.equals("所有")){
            JobFamily = "";
        }

        List<Job> JobList = new ArrayList<Job>();
        if (JobCity.equals("") && JobSalary.equals("") && JobExperience.equals("") && JobEduDegree.equals("")
            && JobFamily.equals("")){
            JobList = jobService.selectAllJob();
            List<Company> CompanyList = new ArrayList<Company>();
            for (int i=0; i<JobList.size();i++){
                Job job = JobList.get(i);
                CompanyList.add(companyService.queryById(job.getCompanyID()));
            }

            Map<Job, Company> map1 = new HashMap<>();
            for (int i=0;i<JobList.size();i++){
                map1.put(JobList.get(i), CompanyList.get(i));
            }

            map.addAttribute("JobMap", map1);

            if (map1.size() == 0)
                map.addAttribute("message", "null");
            else
                map.addAttribute("message", "notnull");

            System.out.println("Search1: " + JobList.size());
            return "jobSearch";
        }else {
            JobList = jobService.JobSearchByInfo(JobCity, JobSalary, JobExperience, JobEduDegree, JobFamily);
            List<Company> CompanyList = new ArrayList<Company>();
            for (int i=0; i<JobList.size();i++){
                Job job = JobList.get(i);
                CompanyList.add(companyService.queryById(job.getCompanyID()));
            }

            Map<Job, Company> map1 = new HashMap<>();
            for (int i=0;i<JobList.size();i++){
                map1.put(JobList.get(i), CompanyList.get(i));
            }

            map.addAttribute("JobMap", map1);
            if (map1.size() == 0)
                map.addAttribute("message", "null");
            else
                map.addAttribute("message", "notnull");
            System.out.println("Search1: " + JobList.size());

            if (map1.size() == 0)
                map.addAttribute("message", "null");
            else
                map.addAttribute("message", "notnull");

            return "jobSearch::list";
        }



    }

    @RequestMapping("/toJobSearch")
    public String toJobSearch(ModelMap map, String JobCity, String JobSalary, String JobExperience,
                              String JobEduDegree, String JobFamily){

        if (JobCity.equals("全国")){
            JobCity = "";
        }
        if (JobSalary.equals("所有")){
            JobSalary = "";
        }
        if (JobExperience.equals("所有")){
            JobExperience = "";
        }
        if (JobEduDegree.equals("所有")){
            JobEduDegree = "";
        }
        if (JobFamily.equals("所有")){
            JobFamily = "";
        }

        System.out.println("flag");

        System.out.println(JobCity+"-"+JobSalary+"-"+JobExperience+"-"+JobEduDegree+"-"+JobFamily);

        List<Job> JobList = jobService.JobSearchByInfo(JobCity, JobSalary, JobExperience, JobEduDegree, JobFamily);
        List<Company> CompanyList = new ArrayList<Company>();
        for (int i=0; i<JobList.size();i++){
            Job job = JobList.get(i);
            CompanyList.add(companyService.queryById(job.getCompanyID()));
        }

        System.out.println("Search2: " + JobList.size());

        Map<Job, Company> map1 = new HashMap<>();
        for (int i=0;i<JobList.size();i++){
            map1.put(JobList.get(i), CompanyList.get(i));
        }

        map.addAttribute("JobMap", map1);
        map.addAttribute("size", JobList.size());
        if (map1.size() == 0)
            map.addAttribute("message", "null");
        else
            map.addAttribute("message", "notnull");

        return "jobSearch";
    }

    @RequestMapping("/pagediv")
    public String pagediv(){
        return "jobSearch::test";
    }

    @RequestMapping("/test3")
    public String test3(){
        return "test5";
    }

    @RequestMapping("/test4")
    public String test4(ModelMap map){
        map.addAttribute("testMessage", newsService.selectNewsByID(7));
        return "test4";
    }


}
