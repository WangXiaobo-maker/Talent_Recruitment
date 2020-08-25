package com.talresource.Talent_Recruitment.entity;

/**
 * 公司实体
 */

public class Company {
    private int CompanyID;
    private String CPassword;
    private String CompanyName;
    private String CompanyPhone;
    private String CompanyEmail;
    private String CompanyLegalPerson;
    private String CompanyAddress;
    private String CompanyCulture;
    private String CompanyInfo;
    private String CompanyNature;
    private String CompanyType;
    private int CompanyHeat;
    private int CompanyJobNum;

    public Company() {
    }

    public Company(String CPassword, String companyName, String companyPhone, String companyEmail,
                   String companyLegalPerson, String companyAddress, String companyCulture,
                   String companyInfo, String companyNature, String companyType, int companyHeat) {
        this.CPassword = CPassword;
        CompanyName = companyName;
        CompanyPhone = companyPhone;
        CompanyEmail = companyEmail;
        CompanyLegalPerson = companyLegalPerson;
        CompanyAddress = companyAddress;
        CompanyCulture = companyCulture;
        CompanyInfo = companyInfo;
        CompanyNature = companyNature;
        CompanyType = companyType;
        CompanyHeat = companyHeat;
    }

    public Company(int companyID, String CPassword, String companyName, String companyPhone, String companyEmail,
                   String companyLegalPerson, String companyAddress, String companyCulture, String companyInfo,
                   String companyNature, String companyType, int companyHeat) {
        CompanyID = companyID;
        this.CPassword = CPassword;
        CompanyName = companyName;
        CompanyPhone = companyPhone;
        CompanyEmail = companyEmail;
        CompanyLegalPerson = companyLegalPerson;
        CompanyAddress = companyAddress;
        CompanyCulture = companyCulture;
        CompanyInfo = companyInfo;
        CompanyNature = companyNature;
        CompanyType = companyType;
        CompanyHeat = companyHeat;
    }

    public int getCompanyJobNum() {
        return CompanyJobNum;
    }

    public void setCompanyJobNum(int companyJobNum) {
        CompanyJobNum = companyJobNum;
    }

    public int getCompanyHeat() {
        return CompanyHeat;
    }

    public void setCompanyHeat(int companyHeat) {
        CompanyHeat = companyHeat;
    }

    public int getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(int companyID) {
        CompanyID = companyID;
    }

    public String getCPassword() {
        return CPassword;
    }

    public void setCPassword(String CPassword) {
        this.CPassword = CPassword;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getCompanyPhone() {
        return CompanyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        CompanyPhone = companyPhone;
    }

    public String getCompanyEmail() {
        return CompanyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        CompanyEmail = companyEmail;
    }

    public String getCompanyAddress() {
        return CompanyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        CompanyAddress = companyAddress;
    }

    public String getCompanyCulture() {
        return CompanyCulture;
    }

    public void setCompanyCulture(String companyCulture) {
        CompanyCulture = companyCulture;
    }

    public String getCompanyInfo() {
        return CompanyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        CompanyInfo = companyInfo;
    }

    public String getCompanyLegalPerson() {
        return CompanyLegalPerson;
    }

    public void setCompanyLegalPerson(String companyLegalPerson) {
        CompanyLegalPerson = companyLegalPerson;
    }

    public String getCompanyNature() {
        return CompanyNature;
    }

    public void setCompanyNature(String companyNature) {
        CompanyNature = companyNature;
    }

    public String getCompanyType() {
        return CompanyType;
    }

    public void setCompanyType(String companyType) {
        CompanyType = companyType;
    }

    @Override
    public String toString() {
        return "Company{" +
                "CompanyID=" + CompanyID +
                ", CPassword='" + CPassword + '\'' +
                ", CompanyName='" + CompanyName + '\'' +
                ", CompanyPhone='" + CompanyPhone + '\'' +
                ", CompanyEmail='" + CompanyEmail + '\'' +
                ", CompanyLegalPerson='" + CompanyLegalPerson + '\'' +
                ", CompanyAddress='" + CompanyAddress + '\'' +
                ", CompanyCulture='" + CompanyCulture + '\'' +
                ", CompanyInfo='" + CompanyInfo + '\'' +
                ", CompanyNature='" + CompanyNature + '\'' +
                ", CompanyType='" + CompanyType + '\'' +
                ", CompanyHeat=" + CompanyHeat +
                '}';
    }
}
