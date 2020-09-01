package com.talresource.Talent_Recruitment.dao;

import com.talresource.Talent_Recruitment.entity.JobApply;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper
public interface JobApplyDao {

    @Insert("insert into jobapply(UserID, JobID, CompanyID, JobApplyDate) " +
            "values(#{UserID}, #{JobID}, #{CompanyID}, #{JobApplyDate})")
    boolean insertJobApply(@Param("UserID") int UserID, @Param("JobID") int JobID,
                         @Param("CompanyID") int CompanyID, @Param("JobApplyDate") String JobApplyDate);

    @Select("select * from jobapply where UserID = #{UserID}")
    List<JobApply> selectJobApplyInfo(@Param("UserID") int UserID);

    @Select("select * from jobapply where CompanyID = #{CompanyID}")
    List<JobApply> selectJobApplyInfo2(@Param("CompanyID") int CompanyID);

    @Update("update jobapply set JobReplyState=#{JobReplyState} where JobApplyID=#{JobApplyID}")
    boolean updateApplyState(@Param("JobReplyState") String JobReplyState, @Param("JobApplyID") int JobApplyID);


    @Select("select * from jobapply where UserID = #{UserID} order by JobApplyDate DESC limit 5")
    List<JobApply> selectJobApplyInfolim5(@Param("UserID") int UserID);

    @Select("select * from jobapply where CompanyID = #{CompanyID} order by JobApplyDate DESC limit 5")
    List<JobApply> selectJobApplyInfo2lim5(@Param("CompanyID") int CompanyID);


}
