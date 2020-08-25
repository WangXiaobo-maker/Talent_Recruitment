package com.talresource.Talent_Recruitment.service;

import com.talresource.Talent_Recruitment.dao.CompanyDao;
import com.talresource.Talent_Recruitment.entity.Company;
import com.talresource.Talent_Recruitment.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Transactional
    public Company queryById(int CompanyID){
        return companyDao.queryById(CompanyID);
    }

    public Company queryByName(String CompanyName){
        return companyDao.queryByName(CompanyName);
    }

    public Company queryByEmail(String CompanyEmail){
        return companyDao.queryByEmail(CompanyEmail);
    }

    public Company queryByEmailAndPasswd(String CompanyEmail, String CPassword){
        return companyDao.queryByEmailAndPasswd(CompanyEmail, CPassword);
    }

    public int insertOneCompany(String CompanyEmail, String CPassword){
        return companyDao.insertOneCompany(CompanyEmail, CPassword);
    }

    public int updateById(String CompanyName, String CompanyPhone, String CompanyLegalPerson,
                          String CompanyAddress, int CompanyID){
        return companyDao.updateById(CompanyName, CompanyPhone, CompanyLegalPerson, CompanyAddress, CompanyID);
    }

    public int updateById2(String CompanyNature, String CompanyType, String CompanyCulture,
                          String CompanyInfo, int CompanyID){
        return companyDao.updateById2(CompanyNature, CompanyType, CompanyCulture, CompanyInfo, CompanyID);
    }
}
