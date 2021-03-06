package com.talresource.Talent_Recruitment.controller;

import com.talresource.Talent_Recruitment.entity.*;
import com.talresource.Talent_Recruitment.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class InfoController {

    @Autowired
    private PostService postService;

    @Autowired
    private JobService jobService;

    @Autowired
    private JobApplyService jobApplyService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

    @RequestMapping("/userInfoPage")
    public String userInfoPage(HttpSession session, ModelMap map) {
        User user = (User)session.getAttribute("user");
        Company company = (Company)session.getAttribute("company");
        if(user == null && company == null)
            return "redirect:userInfoPageNoLogin";
        if(user != null){
            List<JobApply> jobApplyList = jobApplyService.selectJobApplyInfolim5(user.getUserID());

            Map<JobCombineCompany, JobApply> jobMap = new LinkedHashMap<>();

            for (int i=0;i<jobApplyList.size();i++){
                JobApply jobApply = jobApplyList.get(i);
                JobCombineCompany jobCombineCompany = new JobCombineCompany(jobService.selectJobByID(jobApply.getJobID()),
                        companyService.queryById(jobApply.getCompanyID()));
                jobMap.put(jobCombineCompany, jobApply);
            }
            map.addAttribute("JobMap", jobMap);
            return "userInfoPage";
        }
        if(company != null)
            return "redirect:companyInfoPage";
        return "redirect:redirLogin";
    }

    @RequestMapping("/userInfoPageNoLogin")
    public String userInfoPageNoLogin() {
        return "userInfoPageNoLogin";
    }

    @RequestMapping("/myInfo")
    public String myInfo() {
        return "html/myInfo";
    }

    @RequestMapping("/myUpdateInfo")
    public String myUpdateInfo() {
        return "html/myUpdateInfo";
    }

    @RequestMapping("/updatePasswd")
    public String updatePasswd() {
        return "html/updatePasswd";
    }

    @RequestMapping("/myPost")
    public String myPost(HttpSession session, ModelMap map){
        User user = (User)session.getAttribute("user");
        map.addAttribute("PostList", postService.selectPostByUserID(user.getUserID()));
        return "html/myPost";
    }

    @RequestMapping("/myJobApply")
    public String myJobApply(HttpSession session, ModelMap map){
        User user = (User)session.getAttribute("user");

        List<JobApply> jobApplyList = jobApplyService.selectJobApplyInfo(user.getUserID());

        Map<JobCombineCompany, JobApply> jobMap = new LinkedHashMap<>();

        for (int i=0;i<jobApplyList.size();i++){
            JobApply jobApply = jobApplyList.get(i);
            JobCombineCompany jobCombineCompany = new JobCombineCompany(jobService.selectJobByID(jobApply.getJobID()),
                    companyService.queryById(jobApply.getCompanyID()));
            jobMap.put(jobCombineCompany, jobApply);
        }

        map.addAttribute("JobMap", jobMap);

        return "html/myJobApply";
    }


    @RequestMapping("/companyCV")
    public String companyCV(HttpSession session, ModelMap map){
        session.setAttribute("user",null);
        Company company = (Company)session.getAttribute("company");
        if(company == null)
            return "redirect:userInfoPageNoLogin";

        List<JobApply> jobApplyList = jobApplyService.selectJobApplyInfo2(company.getCompanyID());

        Map<JobCombineUser, JobApply> jobMap = new LinkedHashMap<>();

        for (int i=0;i<jobApplyList.size();i++){
            JobApply jobApply = jobApplyList.get(i);
            JobCombineUser jobCombineUser = new JobCombineUser(userService.queryById(jobApply.getUserID()),
                    jobService.selectJobByID(jobApply.getJobID()));
            jobMap.put(jobCombineUser, jobApply);
        }

        map.addAttribute("JobMap", jobMap);

        return "html/companyCV";
    }

    @RequestMapping("/dealApply")
    public String dealApply(HttpSession session, String state, int JobApplyID){
        session.setAttribute("user",null);
        Company company = (Company)session.getAttribute("company");
        if(company == null)
            return "redirect:userInfoPageNoLogin";
        if (state.equals("同意")){
            if (jobApplyService.updateApplyState("已通过", JobApplyID)){
                return "redirect:companyCV";
            }
        }
        if (state.equals("拒绝")){
            if (jobApplyService.updateApplyState("已拒绝", JobApplyID)){
                return "redirect:companyCV";
            }
        }

        return "html/companyCV";
    }


    @RequestMapping("/myCV")
    public String myCV() {
        return "html/myCV";
    }

    @RequestMapping("/companyInfoPage")
    public String companyInfoPage(HttpSession session, ModelMap map) {
        session.setAttribute("user",null);
        Company company = (Company)session.getAttribute("company");
        if(company == null)
            return "redirect:userInfoPageNoLogin";

        List<JobApply> jobApplyList = jobApplyService.selectJobApplyInfo2lim5(company.getCompanyID());

        Map<JobCombineUser, JobApply> jobMap = new LinkedHashMap<>();

        for (int i=0;i<jobApplyList.size();i++){
            JobApply jobApply = jobApplyList.get(i);
            JobCombineUser jobCombineUser = new JobCombineUser(userService.queryById(jobApply.getUserID()),
                    jobService.selectJobByID(jobApply.getJobID()));
            jobMap.put(jobCombineUser, jobApply);
        }

        map.addAttribute("JobMap", jobMap);
        return "companyInfoPage";
    }

    @RequestMapping("/companyInfo")
    public String companyInfo(HttpSession session) {
        session.setAttribute("user",null);
        Company company = (Company)session.getAttribute("company");
        if(company == null)
            return "redirect:userInfoPageNoLogin";
        return "html/companyInfo";
    }

    @RequestMapping("/companyUpdateInfo")
    public String companyUpdateInfo(HttpSession session) {
        session.setAttribute("user",null);
        Company company = (Company)session.getAttribute("company");
        if(company == null)
            return "redirect:userInfoPageNoLogin";
        return "html/companyUpdateInfo";
    }

    @RequestMapping("/companyJob")
    public String companyNotice(HttpSession session, Model model) {
        session.setAttribute("user",null);
        Company company = (Company)session.getAttribute("company");
        if(company == null)
            return "redirect:userInfoPageNoLogin";
        int CompanyID = company.getCompanyID();
        List<Job> jobs = jobService.selectJobByCompany(CompanyID);
        model.addAttribute("jobs", jobs);
        return "html/companyJob";
    }

    @RequestMapping("/companyJobInfo")
    public String companyJobInfo(HttpSession session, Model model, int JobID) {
        session.setAttribute("user",null);
        Company company = (Company)session.getAttribute("company");
        if(company == null)
            return "redirect:userInfoPageNoLogin";
        Job job = jobService.selectJobByID(JobID);
        model.addAttribute("job", job);
        return "html/companyJobInfo";
    }

    @RequestMapping("/companyAddJob")
    public String companyAddJob(HttpSession session) {
        session.setAttribute("user",null);
        Company company = (Company)session.getAttribute("company");
        if(company == null)
            return "redirect:userInfoPageNoLogin";
        return "html/companyAddJob";
    }

    @RequestMapping("/companyUpdatePasswd")
    public String companyUpdatePasswd(HttpSession session) {
        session.setAttribute("user",null);
        Company company = (Company)session.getAttribute("company");
        if(company == null)
            return "redirect:userInfoPageNoLogin";
        return "html/companyUpdatePasswd";
    }

    @RequestMapping("getSex")
    @ResponseBody
    public String getSex(HttpSession session) {
        User user = (User)session.getAttribute("user");
        return user.getSex();
    }

    @RequestMapping("getNature")
    @ResponseBody
    public String getNature(HttpSession session) {
        Company company = (Company)session.getAttribute("company");
        return company.getCompanyNature();
    }

    @RequestMapping("getJobCity")
    @ResponseBody
    public String getJobCity(String JobID) {
        int jobid = Integer.parseInt(JobID);
        Job job = jobService.selectJobByID(jobid);
        return job.getJobCity();
    }

    @RequestMapping("getJobEduDegree")
    @ResponseBody
    public String getJobEduDegree(String JobID) {
        int jobid = Integer.parseInt(JobID);
        Job job = jobService.selectJobByID(jobid);
        return job.getJobEduDegree();
    }
}

