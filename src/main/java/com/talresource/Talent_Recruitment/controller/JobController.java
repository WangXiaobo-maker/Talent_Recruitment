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
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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
        }
        else{
            map.addAttribute("message", "null");
        }
        return "jobSearch";
    }



    @RequestMapping("deleteJob")
    @ResponseBody
    public boolean deleteJob(String JobID) {
        int jobid = Integer.parseInt(JobID);
        int delete = jobService.deleteJob(jobid);
        if(delete <= 0){
            return false;
        }
        return true;
    }

    @RequestMapping("updateJob")
    @ResponseBody
    public boolean updateJob(String JobName, String JobSalary, String JobCity, String JobEduDegree, String JobExperience,
                             String JobFamily, String JobHr, String JobPersonNum, String JobWelfare1,
                             String JobWelfare2, String JobWelfare3, String JobInfo, String JobID) {
        int jobid = Integer.parseInt(JobID);
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String JobPublishDate = sdf.format(today);
        int update = jobService.updateJob(JobName, JobSalary, JobCity, JobEduDegree, JobExperience, JobPublishDate,
                JobFamily, JobHr, JobPersonNum, JobWelfare1, JobWelfare2, JobWelfare3, JobInfo, jobid);
        if(update <= 0){
            return false;
        }
        return true;
    }

    @RequestMapping("addJob")
    @ResponseBody
    public boolean addJob(HttpSession session, String JobName, String JobSalary, String JobCity, String JobEduDegree,
                          String JobExperience, String JobFamily, String JobHr, String JobPersonNum, String JobWelfare1,
                          String JobWelfare2, String JobWelfare3, String JobInfo) {
        Company company = (Company)session.getAttribute("company");
        int CompanyID = company.getCompanyID();
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String JobPublishDate = sdf.format(today);
        int insert = jobService.addJob(CompanyID, JobName, JobSalary, JobCity, JobEduDegree, JobExperience, JobPublishDate,
                JobFamily, JobHr, JobPersonNum, JobWelfare1, JobWelfare2, JobWelfare3, JobInfo);
        if(insert <= 0){
            return false;
        }
        return true;
    }

    @RequestMapping("jobApply")
    @ResponseBody
    public Result jobApply(HttpSession session, String JobID, String CompanyID) throws IOException {

        int JobID2 = Integer.parseInt(JobID);
        int CompanyID2 = Integer.parseInt(CompanyID);

        Result result = null;
        User user = (User)session.getAttribute("user");
        int UserID = user.getUserID();
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String JobApplyDate = sdf.format(today);
        File project = new File("");
        String projectPath = project.getCanonicalPath();
        String filepath = projectPath + "\\src\\main\\resources\\static\\img\\CVImg\\" + UserID + ".png";
        File file = new File(filepath);
        if(!file.exists()){
            result = new Result(Config.STATUS_ERROR,"没有简历");
            return result;
        }
        if (jobApplyService.insertJobApply(UserID, JobID2, CompanyID2, JobApplyDate)){
            result = new Result(Config.STATUS_SUCCESS,"申请成功");
        }
        else{
            result = new Result(Config.STATUS_FAILURE,"申请失败");
        }
        return result;
    }
}


