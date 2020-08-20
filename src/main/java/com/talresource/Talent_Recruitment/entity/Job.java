package com.talresource.Talent_Recruitment.entity;

/**
 * 工作实体
 */

public class Job {
    private int JobID;
    private int CompanyID;
    private String JobName;
    private String JobSalary;
    private String JobCity;
    private String JobEduDegree;
    private String JobExperience;
    private String JobInfo;
    private String JobPublishDate;
    private String JobFamily;
    private String JobHr;



    public int getJobID() {
        return JobID;
    }

    public void setJobID(int jobID) {
        JobID = jobID;
    }

    public int getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(int companyID) {
        CompanyID = companyID;
    }

    public String getJobName() {
        return JobName;
    }

    public void setJobName(String jobName) {
        JobName = jobName;
    }

    public String getJobSalary() {
        return JobSalary;
    }

    public void setJobSalary(String jobSalary) {
        JobSalary = jobSalary;
    }

    public String getJobCity() {
        return JobCity;
    }

    public void setJobCity(String jobCity) {
        JobCity = jobCity;
    }

    public String getJobEduDegree() {
        return JobEduDegree;
    }

    public void setJobEduDegree(String jobEduDegree) {
        JobEduDegree = jobEduDegree;
    }

    public String getJobExperience() {
        return JobExperience;
    }

    public void setJobExperience(String jobExperience) {
        JobExperience = jobExperience;
    }

    public String getJobInfo() {
        return JobInfo;
    }

    public void setJobInfo(String jobInfo) {
        JobInfo = jobInfo;
    }

    public String getJobPublishDate() {
        return JobPublishDate;
    }

    public void setJobPublishDate(String jobPublishDate) {
        JobPublishDate = jobPublishDate;
    }

    public String getJobFamily() {
        return JobFamily;
    }

    public void setJobFamily(String jobFamily) {
        JobFamily = jobFamily;
    }

    public String getJobHr() {
        return JobHr;
    }

    public void setJobHr(String jobHr) {
        JobHr = jobHr;
    }
}
