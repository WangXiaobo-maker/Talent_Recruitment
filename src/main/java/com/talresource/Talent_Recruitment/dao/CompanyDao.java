package com.talresource.Talent_Recruitment.dao;

import com.talresource.Talent_Recruitment.entity.Company;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyDao {

    @Select("select * from company where CompanyID=#{CompanyID}")
    Company queryById(@Param("CompanyID") int CompanyID);

    @Select("select * from company where CompanyName=#{CompanyName}")
    Company queryByName(@Param("CompanyName") String CompanyName);

    @Select("select * from company where CompanyEmail=#{CompanyEmail}")
    Company queryByEmail(@Param("CompanyEmail") String CompanyEmail);

    @Select("select * from company where CompanyEmail=#{CompanyEmail} and CPassword=#{CPassword}")
    Company queryByEmailAndPasswd(@Param("CompanyEmail") String CompanyEmail, @Param("CPassword") String CPassword);

    @Select("select * from company where CompanyEmail=#{CompanyEmail} and CompanyPhone=#{CompanyPhone} and CompanyName=#{CompanyName}")
    Company queryByEmPhNa(@Param("CompanyEmail") String CompanyEmail, @Param("CompanyPhone") String CompanyPhone,
                          @Param("CompanyName") String CompanyName);

    @Insert("insert into company(CompanyEmail,CPassword) values(#{CompanyEmail},#{CPassword})")
    int insertOneCompany(@Param("CompanyEmail") String CompanyEmail, @Param("CPassword") String CPassword);

    @Update("update company set CompanyName=#{CompanyName},CompanyPhone=#{CompanyPhone}," +
            "CompanyLegalPerson=#{CompanyLegalPerson},CompanyAddress=#{CompanyAddress} where CompanyID=#{CompanyID}")
    int updateById(@Param("CompanyName") String CompanyName,@Param("CompanyPhone") String CompanyPhone,
                   @Param("CompanyLegalPerson") String CompanyLegalPerson,@Param("CompanyAddress") String CompanyAddress,
                   @Param("CompanyID") int CompanyID);

    @Update("update company set CompanyNature=#{CompanyNature},CompanyType=#{CompanyType}," +
            "CompanyCulture=#{CompanyCulture},CompanyInfo=#{CompanyInfo} where CompanyID=#{CompanyID}")
    int updateById2(@Param("CompanyNature") String CompanyNature,@Param("CompanyType") String CompanyType,
                    @Param("CompanyCulture") String CompanyCulture,@Param("CompanyInfo") String CompanyInfo,
                    @Param("CompanyID") int CompanyID);

    @Update("update company set CompanyName=#{CompanyName},CompanyPhone=#{CompanyPhone},CompanyEmail=#{CompanyEmail}," +
            "CompanyLegalPerson=#{CompanyLegalPerson},CompanyNature=#{CompanyNature},CompanyType=#{CompanyType}," +
            "CompanyAddress=#{CompanyAddress},CompanyCulture=#{CompanyCulture},CompanyInfo=#{CompanyInfo}" +
            " where CompanyID=#{CompanyID}")
    int updateCompany(@Param("CompanyName") String CompanyName, @Param("CompanyPhone") String CompanyPhone,
                      @Param("CompanyEmail") String CompanyEmail, @Param("CompanyLegalPerson") String CompanyLegalPerson,
                      @Param("CompanyNature") String CompanyNature, @Param("CompanyType") String CompanyType,
                      @Param("CompanyAddress") String CompanyAddress, @Param("CompanyCulture") String CompanyCulture,
                      @Param("CompanyInfo") String CompanyInfo, @Param("CompanyID") int CompanyID);

    @Update("update company set CPassword=#{CPassword} where CompanyID=#{CompanyID}")
    int updatePasswd(@Param("CPassword") String CPassword, @Param("CompanyID") int CompanyID);

    @Select("select * from company order by CompanyHeat DESC limit 9")
    List<Company> selectCompanyByHeat();

    @Select("select * from company order by CompanyHeat DESC limit 4")
    List<Company> selectCompanyByHeatlim4();


    @Select("select * from company where (CompanyName like CONCAT('%',#{CompanyName},'%')) " +
            "order by CompanyHeat")
    List<Company> selectCompanyByName(@Param("CompanyName") String CompanyName );

    @Update("update company set CompanyHeat=CompanyHeat+6 where CompanyID=#{CompanyID}")
    boolean updateCompanyHeat(@Param("CompanyID") int CompanyID);
}
