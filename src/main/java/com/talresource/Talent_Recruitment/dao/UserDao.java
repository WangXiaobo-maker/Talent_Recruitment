package com.talresource.Talent_Recruitment.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    @Insert("insert into user(UserEmail, UPassword) value(#{UserEmail},#{UPassword})")
    boolean InsertUser(@Param("UserEmail") String UserEmail, @Param("UPassword") String UPassword);

}
