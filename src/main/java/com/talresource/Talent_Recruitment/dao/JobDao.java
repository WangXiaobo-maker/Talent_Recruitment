package com.talresource.Talent_Recruitment.dao;

import com.talresource.Talent_Recruitment.entity.Job;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JobDao {

    @Select("select * from job")
    List<Job> selectAllJob();

    @Select("select * from job order by JobPublishDate DESC limit 5")
    List<Job> selectJobByHeat();

}
