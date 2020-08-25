package com.talresource.Talent_Recruitment.dao;

import com.talresource.Talent_Recruitment.entity.Job;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JobDao {

    @Select("select * from job")
    List<Job> selectAllJob();

    @Select("select * from job order by JobHeat DESC limit 9")
    List<Job> selectJobByHeat();

    @Select("select * from job where (JobName like CONCAT('%',#{JobName},'%')) " +
            "or (JobFamily like CONCAT('%',#{JobFamily},'%')) " +
            "order by JobFamily")
    List<Job> TestJobList(@Param("JobName") String JobName, @Param("JobFamily") String JobFamily);

}
//"ORDER BY   REPLACE(JobName,'${JobName}=','')  "