package com.talresource.Talent_Recruitment.entity;

public class User {
    private int UserID;
    private String UserName;
    private String UPassword;
    private String NickName;
    private String Sex;
    private String Birth;
    private String UserPhone;
    private String UserEmail;

    public User() {
    }

    public User(String userName, String UPassword, String nickName, String sex,
                String birth, String userPhone, String userEmail) {
        UserName = userName;
        this.UPassword = UPassword;
        NickName = nickName;
        Sex = sex;
        Birth = birth;
        UserPhone = userPhone;
        UserEmail = userEmail;
    }

    public User(int userID, String userName, String UPassword, String nickName,
                String sex, String birth, String userPhone, String userEmail) {
        UserID = userID;
        UserName = userName;
        this.UPassword = UPassword;
        NickName = nickName;
        Sex = sex;
        Birth = birth;
        UserPhone = userPhone;
        UserEmail = userEmail;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUPassword() {
        return UPassword;
    }

    public void setUPassword(String UPassword) {
        this.UPassword = UPassword;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getBirth() {
        return Birth;
    }

    public void setBirth(String birth) {
        Birth = birth;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserID=" + UserID +
                ", UserName='" + UserName + '\'' +
                ", UPassword='" + UPassword + '\'' +
                ", NickName='" + NickName + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Birth='" + Birth + '\'' +
                ", UserPhone='" + UserPhone + '\'' +
                ", UserEmail='" + UserEmail + '\'' +
                '}';
    }
}
