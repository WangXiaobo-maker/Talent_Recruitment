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

    public List<Job> JobSearchByInfo(String JobCity, String JobSalary, String JobExperience, String JobEduDegree, String JobFamily){
        return jobDao.JobSearchByInfo(JobCity, JobSalary, JobExperience, JobEduDegree, JobFamily);
    }

    public List<Job> JobSearchByNameOrFamily(String JobName, String JobFamily){
        return jobDao.JobSearchByNameOrFamily(JobName, JobFamily);
    }

    public List<Job> selectJobByCompany(int CompanyID){
        return jobDao.selectJobByCompany(CompanyID);
    }

    public Job selectJobByID(int JobID){
        return jobDao.selectJobByID(JobID);
    }

    public List<Job> selectJobByHeatlim10(){
        return jobDao.selectJobByHeatlim10();
    }

    public List<Job> selectJobByHeatlim4(){
        return jobDao.selectJobByHeatlim4();
    }

    public List<Job> selectJobByCompanylim3(int CompanyID){
        return jobDao.selectJobByCompanylim3(CompanyID);
    }

    public boolean updateJobHeat(int JobID){
        return jobDao.updateJobHeat(JobID);
    }
}
