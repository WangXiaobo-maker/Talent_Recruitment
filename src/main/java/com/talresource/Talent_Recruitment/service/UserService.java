package com.talresource.Talent_Recruitment.service;

import com.talresource.Talent_Recruitment.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public boolean InsertUser(String UserEmail, String UPassword){
        return userDao.InsertUser(UserEmail, UPassword);
    }
}
