package com.talresource.Talent_Recruitment.dao;

import com.talresource.Talent_Recruitment.entity.Job;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

}
//"ORDER BY   REPLACE(JobName,'${JobName}=','')  "