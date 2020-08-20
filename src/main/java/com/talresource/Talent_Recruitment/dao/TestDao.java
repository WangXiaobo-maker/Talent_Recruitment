package com.talresource.Talent_Recruitment.dao;

import com.talresource.Talent_Recruitment.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestDao {

    @Select("select * from user")
    User selectAllUser();


}
