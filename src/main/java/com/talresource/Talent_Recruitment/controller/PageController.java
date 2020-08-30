package com.talresource.Talent_Recruitment.controller;

import com.talresource.Talent_Recruitment.entity.Company;
import com.talresource.Talent_Recruitment.entity.Job;
import com.talresource.Talent_Recruitment.entity.Post;
import com.talresource.Talent_Recruitment.entity.User;
import com.talresource.Talent_Recruitment.service.*;
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

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

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

            map.put("JobCity",null);
            map.put("JobSalary",null);
            map.put("JobExperience",null);
            map.put("JobEduDegree",null);
            map.put("JobFamily",null);

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

            map.put("JobCity",JobCity);
            map.put("JobSalary",JobSalary);
            map.put("JobExperience",JobExperience);
            map.put("JobEduDegree",JobEduDegree);
            map.put("JobFamily",JobFamily);

            if (map1.size() == 0)
                map.addAttribute("message", "null");
            else
                map.addAttribute("message", "notnull");

            return "jobSearch";
        }



    }

    @RequestMapping("/forum")
    public String forum(ModelMap map){

        List<Post> PostListByHeat = postService.selectPostsByHeat();
        Map<User, Post> userPostMapByHeat = new HashMap<>();
        for (int i=0;i<PostListByHeat.size();i++){
            Post post = PostListByHeat.get(i);
            User user = userService.queryById(post.getUserID());
            userPostMapByHeat.put(user, post);
        }

        List<Post> PostListByDate = postService.selectPostsByDate();
        Map<User, Post> userPostMapByDate = new HashMap<>();
        for (int i=0;i<PostListByDate.size();i++){
            Post post = PostListByDate.get(i);
            User user = userService.queryById(post.getUserID());
            userPostMapByDate.put(user, post);
        }

        map.addAttribute("PostMapByHeat", userPostMapByHeat);
        map.addAttribute("PostMapByDate", userPostMapByDate);

        System.out.println();

        return "forum";
    }

    @RequestMapping("/forumSearch")
    public String forumSearch(){
        return "forumSearch";
    }

    @RequestMapping("/jobInfo")
    public String jobInfo(ModelMap map, int JobID){

        Job job = jobService.selectJobByID(JobID);
        Company company = companyService.queryById(job.getCompanyID());
        map.addAttribute("Job", job);
        map.addAttribute("Company", company);


        List<Job> jobList = jobService.selectJobByHeatlim10();

        Map<Company, Job> companyJobMap = new LinkedHashMap<>();
        for (int i=0;i<jobList.size();i++){
            Job job1 = jobList.get(i);
            companyJobMap.put(companyService.queryById(job1.getCompanyID()), job1);
        }
        map.addAttribute("CompanyJobMap", companyJobMap);

        map.addAttribute("similarJobList", jobService.selectJobByHeatlim4());

        return "jobInfo";
    }

    @RequestMapping("/companyIntro")
    public String companyIntro(ModelMap map, int CompanyID){

        map.addAttribute("companyInfo", companyService.queryById(CompanyID));
        map.addAttribute("companyJobListlim3", jobService.selectJobByCompanylim3(CompanyID));
        map.addAttribute("similarCompanyList", companyService.selectCompanyByHeatlim4());

        List<Job> jobList = jobService.selectJobByHeatlim10();

        Map<Company, Job> companyJobMap = new LinkedHashMap<>();
        for (int i=0;i<jobList.size();i++){
            Job job1 = jobList.get(i);
            companyJobMap.put(companyService.queryById(job1.getCompanyID()), job1);
        }
        map.addAttribute("CompanyJobMap", companyJobMap);


        return "companyIntro";
    }

    @RequestMapping("/test3")
    public String test3(){
        return "companyIntro";
    }

    @RequestMapping("/test4")
    public String test4(ModelMap map){
        map.addAttribute("testMessage", newsService.selectNewsByID(7));
        return "jobInfo";
    }


}
