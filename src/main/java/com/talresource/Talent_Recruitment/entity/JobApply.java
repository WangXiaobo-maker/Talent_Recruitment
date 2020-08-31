package com.talresource.Talent_Recruitment.entity;

public class JobApply {

    private int JobApplyID;
    private int UserID;
    private int JobID;
    private int CompanyID;
    private String JobApplyDate;
    private String JobReplyState;

    public int getJobApplyID() {
        return JobApplyID;
    }

    public void setJobApplyID(int jobApplyID) {
        JobApplyID = jobApplyID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
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

    public String getJobApplyDate() {
        return JobApplyDate;
    }

    public void setJobApplyDate(String jobApplyDate) {
        JobApplyDate = jobApplyDate;
    }

    public String getJobReplyState() {
        return JobReplyState;
    }

    public void setJobReplyState(String jobReplyState) {
        JobReplyState = jobReplyState;
    }
}
