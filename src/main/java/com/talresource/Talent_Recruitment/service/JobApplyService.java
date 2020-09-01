package com.talresource.Talent_Recruitment.service;

import com.talresource.Talent_Recruitment.dao.JobApplyDao;
import com.talresource.Talent_Recruitment.entity.JobApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobApplyService {

    @Autowired
    private JobApplyDao jobApplyDao;

    @Transactional
    public boolean insertJobApply(int UserID, int JobID, int CompanyID, String JobApplyDate){
        return jobApplyDao.insertJobApply(UserID, JobID, CompanyID, JobApplyDate);
    }

    public List<JobApply> selectJobApplyInfo(int UserID){
        return jobApplyDao.selectJobApplyInfo(UserID);
    }

    public List<JobApply> selectJobApplyInfo2(int CompanyID){
        return jobApplyDao.selectJobApplyInfo2(CompanyID);
    }

    public boolean updateApplyState(String JobReplyState, int JobApplyID){
        return jobApplyDao.updateApplyState(JobReplyState, JobApplyID);
    }

    public List<JobApply> selectJobApplyInfolim5(int UserID){
        return jobApplyDao.selectJobApplyInfolim5(UserID);
    }

    public List<JobApply> selectJobApplyInfo2lim5(int CompanyID){
        return jobApplyDao.selectJobApplyInfo2lim5(CompanyID);
    }

}
