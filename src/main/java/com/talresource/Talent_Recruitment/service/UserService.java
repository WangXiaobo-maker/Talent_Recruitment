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

    public User queryByEmPhNa(String UserEmail, String UserPhone, String UserName){
        return userDao.queryByEmPhNa(UserEmail, UserPhone, UserName);
    }

    public int insertOneUser(String UserEmail, String UPassword){
        return userDao.insertOneUser(UserEmail, UPassword);
    }

    public int updateById(String UserName, String Sex, String NickName, String Birth, String UserPhone, int UserID){
        return userDao.updateById(UserName, Sex, NickName, Birth, UserPhone, UserID);
    }

    public int updateUser(String UserName, String Sex, String NickName, String Birth, String UserPhone, String UserEmail, int UserID){
        return userDao.updateUser(UserName, Sex, NickName, Birth, UserPhone, UserEmail, UserID);
    }

    public int updatePasswd(String UPassword, int UserID){
        return userDao.updatePasswd(UPassword, UserID);
    }
}
