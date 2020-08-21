package com.talresource.Talent_Recruitment.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CompanyDao {

    @Insert("insert into company(CompanyEmail, CPassword) value(#{CompanyEmail},#{CPassword})")
    boolean InsertCompany(@Param("CompanyEmail") String CompanyEmail, @Param("CPassword") String CPassword);

}
