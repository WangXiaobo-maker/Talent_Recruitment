package com.talresource.Talent_Recruitment.service;

import com.talresource.Talent_Recruitment.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Transactional
    public boolean InsertCompany(String CompanyEmail, String CPassword){
        return companyDao.InsertCompany(CompanyEmail, CPassword);
    }
}
