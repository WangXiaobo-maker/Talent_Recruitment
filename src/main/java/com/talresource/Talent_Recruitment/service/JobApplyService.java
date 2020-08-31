package com.talresource.Talent_Recruitment.service;

import com.talresource.Talent_Recruitment.dao.JobApplyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JobApplyService {

    @Autowired
    private JobApplyDao jobApplyDao;

    @Transactional
    public boolean insertJobApply(int UserID, int JobID, int CompanyID, String JobApplyDate){
        return jobApplyDao.insertJobApply(UserID, JobID, CompanyID, JobApplyDate);
    }

}
