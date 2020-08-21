package com.talresource.Talent_Recruitment.service;


import com.talresource.Talent_Recruitment.dao.JobDao;
import com.talresource.Talent_Recruitment.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobDao jobDao;

    @Transactional
    public List<Job> selectAllJob(){
        return jobDao.selectAllJob();
    }

    public List<Job> selectJobByHeat(){
        return jobDao.selectJobByHeat();
    }

    public List<Job> TestJobList(String JobName, String JobFamily){
        return jobDao.TestJobList(JobName, JobFamily);
    }

}
