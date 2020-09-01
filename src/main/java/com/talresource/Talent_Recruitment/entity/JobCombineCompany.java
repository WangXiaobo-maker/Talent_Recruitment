package com.talresource.Talent_Recruitment.entity;

public class JobCombineCompany {

    private Job job;
    private Company company;

    public JobCombineCompany(Job job, Company company) {
        this.job = job;
        this.company = company;
    }

    @Override
    public String toString() {
        return "JobCombineCompany{" +
                "job=" + job +
                ", company=" + company +
                '}';
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
