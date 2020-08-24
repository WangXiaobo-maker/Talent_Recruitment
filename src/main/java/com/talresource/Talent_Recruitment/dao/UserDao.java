package com.talresource.Talent_Recruitment.dao;

import com.talresource.Talent_Recruitment.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {

    @Select("select * from user where UserID=#{UserID}")
    User queryById(@Param("UserID") int UserID);

    @Select("select * from user where UserEmail=#{UserEmail}")
    User queryByEmail(@Param("UserEmail") String UserEmail);

    @Select("select * from user where UserEmail=#{UserEmail} and UPassword=#{UPassword}")
    User queryByEmailAndPasswd(@Param("UserEmail") String UserEmail, @Param("UPassword") String UPassword);

    @Insert("insert into user(UserEmail,UPassword) values(#{UserEmail},#{UPassword})")
    int insertOneUser(@Param("UserEmail") String UserEmail, @Param("UPassword") String UPassword);

    @Update("update user set UserName=#{UserName},Sex=#{Sex},NickName=#{NickName}," +
            "Birth=#{Birth},UserPhone=#{UserPhone} where UserID=#{UserID}")
    int updateById(@Param("UserName") String UserName, @Param("Sex") String Sex,
                   @Param("NickName") String NickName, @Param("Birth") String Birth,
                   @Param("UserPhone") String UserPhone, @Param("UserID") int UserID);
}
