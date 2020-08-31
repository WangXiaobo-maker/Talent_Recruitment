package com.talresource.Talent_Recruitment.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JobApplyDao {
    @Insert("insert into jobapply(UserID, JobID, CompanyID, JobApplyDate) " +
            "values(#{UserID}, #{JobID}, #{CompanyID}, #{JobApplyDate})")
    boolean insertJobApply(@Param("UserID") int UserID, @Param("JobID") int JobID,
                         @Param("CompanyID") int CompanyID, @Param("JobApplyDate") String JobApplyDate);
}
