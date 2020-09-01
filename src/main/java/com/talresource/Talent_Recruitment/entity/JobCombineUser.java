package com.talresource.Talent_Recruitment.entity;

public class JobCombineUser {

    private User user;
    private Job job;

    public JobCombineUser(User user, Job job) {
        this.user = user;
        this.job = job;
    }

    @Override
    public String toString() {
        return "JobCombineUser{" +
                "user=" + user +
                ", job=" + job +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
