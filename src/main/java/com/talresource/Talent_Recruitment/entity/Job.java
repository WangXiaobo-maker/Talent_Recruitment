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
    private int JobHeat;
    private String JobPersonNum;
    private String JobWelfare1;
    private String JobWelfare2;
    private String JobWelfare3;

    @Override
    public String toString() {
        return "Job{" +
                "JobID=" + JobID +
                ", CompanyID=" + CompanyID +
                ", JobName='" + JobName + '\'' +
                ", JobSalary='" + JobSalary + '\'' +
                ", JobCity='" + JobCity + '\'' +
                ", JobEduDegree='" + JobEduDegree + '\'' +
                ", JobExperience='" + JobExperience + '\'' +
                ", JobInfo='" + JobInfo + '\'' +
                ", JobPublishDate='" + JobPublishDate + '\'' +
                ", JobFamily='" + JobFamily + '\'' +
                ", JobHr='" + JobHr + '\'' +
                ", JobHeat=" + JobHeat +
                ", JobPersonNum='" + JobPersonNum + '\'' +
                ", JobWelfare1='" + JobWelfare1 + '\'' +
                ", JobWelfare2='" + JobWelfare2 + '\'' +
                ", JobWelfare3='" + JobWelfare3 + '\'' +
                '}';
    }

    public String getJobPersonNum() {
        return JobPersonNum;
    }

    public void setJobPersonNum(String jobPersonNum) {
        JobPersonNum = jobPersonNum;
    }

    public String getJobWelfare1() {
        return JobWelfare1;
    }

    public void setJobWelfare1(String jobWelfare1) {
        JobWelfare1 = jobWelfare1;
    }

    public String getJobWelfare2() {
        return JobWelfare2;
    }

    public void setJobWelfare2(String jobWelfare2) {
        JobWelfare2 = jobWelfare2;
    }

    public String getJobWelfare3() {
        return JobWelfare3;
    }

    public void setJobWelfare3(String jobWelfare3) {
        JobWelfare3 = jobWelfare3;
    }

    public int getJobHeat() {
        return JobHeat;
    }

    public void setJobHeat(int jobHeat) {
        JobHeat = jobHeat;
    }

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
