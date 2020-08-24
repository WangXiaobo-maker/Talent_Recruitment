package com.talresource.Talent_Recruitment.service;

import com.talresource.Talent_Recruitment.dao.UserDao;
import com.talresource.Talent_Recruitment.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public User queryById(int UserID){
        return userDao.queryById(UserID);
    }

    public User queryByEmail(String UserEmail){
        return userDao.queryByEmail(UserEmail);
    }

    public User queryByEmailAndPasswd(String UserEmail, String UPassword){
        return userDao.queryByEmailAndPasswd(UserEmail, UPassword);
    }

    public int insertOneUser(String UserEmail, String UPassword){
        return userDao.insertOneUser(UserEmail, UPassword);
    }

    public int updateById(String UserName, String Sex, String NickName, String Birth, String UserPhone, int UserID){
        return userDao.updateById(UserName, Sex, NickName, Birth, UserPhone, UserID);
    }
}
