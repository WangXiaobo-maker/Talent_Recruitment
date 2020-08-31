package com.talresource.Talent_Recruitment.controller;

import com.talresource.Talent_Recruitment.entity.Company;
import com.talresource.Talent_Recruitment.entity.Job;
import com.talresource.Talent_Recruitment.entity.Result;
import com.talresource.Talent_Recruitment.entity.User;
import com.talresource.Talent_Recruitment.service.CompanyService;
import com.talresource.Talent_Recruitment.service.JobApplyService;
import com.talresource.Talent_Recruitment.service.JobService;
import com.talresource.Talent_Recruitment.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private JobApplyService jobApplyService;

    @RequestMapping("/searchJob")
    public String searchJob(ModelMap map, String jobInfo, String searchType){

        if (searchType.equals("职位")){
            List<Job> JobList = new ArrayList<Job>();
            JobList = jobService.JobSearchByNameOrFamily(jobInfo, jobInfo);
            List<Company> CompanyList = new ArrayList<Company>();
            for (int i=0; i<JobList.size();i++){
                Job job = JobList.get(i);
                CompanyList.add(companyService.queryById(job.getCompanyID()));
            }

            Map<Job, Company> map1 = new LinkedHashMap<>();
            for (int i=0;i<JobList.size();i++){
                map1.put(JobList.get(i), CompanyList.get(i));
            }

            map.addAttribute("JobMap", map1);
            if (map1.size() == 0)
                map.addAttribute("message", "null");
            else
                map.addAttribute("message", "notnull");
            System.out.println("Search1: " + JobList.size());
        }

        else if (searchType.equals("公司")){
            List<Company> CompanyList = companyService.selectCompanyByName(jobInfo);
            List<Job> JobList = new ArrayList<Job>();
            Map<Job, Company> map1 = new LinkedHashMap<>();
            for (int i=0;i<CompanyList.size();i++){
                Company company = CompanyList.get(i);
                List<Job> companyJobList = jobService.selectJobByCompany(company.getCompanyID());
                for (int j=0;j<companyJobList.size();j++){
                    JobList.add(companyJobList.get(j));
                    map1.put(companyJobList.get(j), company);
                }
            }

            map.addAttribute("JobMap", map1);
            if (map1.size() == 0)
                map.addAttribute("message", "null");
            else
                map.addAttribute("message", "notnull");

            System.out.println("Search1.1: " + JobList.size());

        }

        else{
            map.addAttribute("message", "null");
        }

        return "jobSearch";

    }


    @RequestMapping("jobApply")
    @ResponseBody
    public Result jobApply(HttpSession session, String JobID, String CompanyID){

        int JobID2 = Integer.parseInt(JobID);
        int CompanyID2 = Integer.parseInt(CompanyID);

        Result result = null;
        User user = (User)session.getAttribute("user");
        int UserID = user.getUserID();
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String JobApplyDate = sdf.format(today);

        if (jobApplyService.insertJobApply(UserID, JobID2, CompanyID2, JobApplyDate)){
            result = new Result(Config.STATUS_SUCCESS,"发表成功");
        }
        else{
            result = new Result(Config.STATUS_FAILURE,"发表失败");
        }
        return result;
    }
}


