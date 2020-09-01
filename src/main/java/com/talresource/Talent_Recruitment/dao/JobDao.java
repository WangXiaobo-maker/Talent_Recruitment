package com.talresource.Talent_Recruitment.dao;

import com.talresource.Talent_Recruitment.entity.Job;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface JobDao {

    @Select("select * from job order by JobHeat")
    List<Job> selectAllJob();

    @Select("select * from job where JobID=#{JobID}")
    Job selectJobByID(@Param("JobID") int JobID);

    @Select("select * from job order by JobHeat DESC limit 9")
    List<Job> selectJobByHeat();

    @Select("select * from job order by JobHeat DESC limit 10")
    List<Job> selectJobByHeatlim10();

    @Select("select * from job order by JobHeat DESC limit 4")
    List<Job> selectJobByHeatlim4();

    @Select("select * from job where (JobCity like CONCAT('%',#{JobCity},'%')) " +
            "and (JobSalary like CONCAT('%',#{JobSalary},'%')) " +
            "and (JobExperience like CONCAT('%',#{JobExperience},'%')) " +
            "and (JobEduDegree like CONCAT('%',#{JobEduDegree},'%')) " +
            "and (JobFamily like CONCAT('%',#{JobFamily},'%')) " +
            "order by JobHeat")
    List<Job> JobSearchByInfo(@Param("JobCity") String JobCity, @Param("JobSalary") String JobSalary,
                              @Param("JobExperience") String JobExperience, @Param("JobEduDegree") String JobEduDegree,
                              @Param("JobFamily") String JobFamily);

    @Select("select * from job where (JobName like CONCAT('%',#{JobName},'%')) " +
            "or (JobFamily like CONCAT('%',#{JobFamily},'%')) " +
            "order by JobFamily")
    List<Job> JobSearchByNameOrFamily(@Param("JobName") String JobName, @Param("JobFamily") String JobFamily);

    @Select("select * from job where CompanyID=#{CompanyID}")
    List<Job> selectJobByCompany(@Param("CompanyID") int CompanyID);

    @Select("select * from job where CompanyID=#{CompanyID} order by JobHeat DESC limit 3" )
    List<Job> selectJobByCompanylim3(@Param("CompanyID") int CompanyID);

    @Update("update job set JobHeat=JobHeat+6 where JobID=#{JobID}")
    boolean updateJobHeat(@Param("JobID") int JobID);

    @Delete("delete from job where JobID=#{JobID}")
    int deleteJob(@Param("JobID") int JobID);

    @Update("update job set JobName=#{JobName},JobSalary=#{JobSalary},JobCity=#{JobCity},JobEduDegree=#{JobEduDegree}," +
            "JobExperience=#{JobExperience},JobPublishDate=#{JobPublishDate},JobFamily=#{JobFamily},JobHr=#{JobHr}," +
            "JobPersonNum=#{JobPersonNum},JobWelfare1=#{JobWelfare1},JobWelfare2=#{JobWelfare2}," +
            "JobWelfare3=#{JobWelfare3},JobInfo=#{JobInfo} where JobID=#{JobID}")
    int updateJob(@Param("JobName") String JobName,@Param("JobSalary") String JobSalary,@Param("JobCity") String JobCity,
                  @Param("JobEduDegree") String JobEduDegree,@Param("JobExperience") String JobExperience,
                  @Param("JobPublishDate") String JobPublishDate, @Param("JobFamily") String JobFamily,
                  @Param("JobHr") String JobHr,@Param("JobPersonNum") String JobPersonNum,
                  @Param("JobWelfare1") String JobWelfare1, @Param("JobWelfare2") String JobWelfare2,
                  @Param("JobWelfare3") String JobWelfare3, @Param("JobInfo") String JobInfo,@Param("JobID") int JobID);

    @Insert("insert into job(CompanyID,JobName,JobSalary,JobCity,JobEduDegree,JobExperience,JobPublishDate,JobFamily," +
            "JobHr,JobPersonNum,JobWelfare1,JobWelfare2,JobWelfare3,JobInfo) values(#{CompanyID},#{JobName}," +
            "#{JobSalary},#{JobCity},#{JobEduDegree},#{JobExperience},#{JobPublishDate},#{JobFamily},#{JobHr}," +
            "#{JobPersonNum},#{JobWelfare1},#{JobWelfare2},#{JobWelfare3},#{JobInfo})")
    int addJob(@Param("CompanyID") int CompanyID,@Param("JobName") String JobName,@Param("JobSalary") String JobSalary,
               @Param("JobCity") String JobCity, @Param("JobEduDegree") String JobEduDegree,
               @Param("JobExperience") String JobExperience, @Param("JobPublishDate") String JobPublishDate,
               @Param("JobFamily") String JobFamily, @Param("JobHr") String JobHr,
               @Param("JobPersonNum") String JobPersonNum, @Param("JobWelfare1") String JobWelfare1,
               @Param("JobWelfare2") String JobWelfare2, @Param("JobWelfare3") String JobWelfare3,
               @Param("JobInfo") String JobInfo);

}
//"ORDER BY   REPLACE(JobName,'${JobName}=','')  "