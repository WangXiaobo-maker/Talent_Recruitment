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
    private String CompanyAddress;
    private String CompanyCulture;
    private String CompanyInfo;

    public Company() {
    }

    public Company(String CPassword, String companyName, String companyPhone, String companyEmail,
                   String companyAddress, String companyCulture, String companyInfo) {
        this.CPassword = CPassword;
        CompanyName = companyName;
        CompanyPhone = companyPhone;
        CompanyEmail = companyEmail;
        CompanyAddress = companyAddress;
        CompanyCulture = companyCulture;
        CompanyInfo = companyInfo;
    }

    public Company(int companyID, String CPassword, String companyName, String companyPhone,
                   String companyEmail, String companyAddress, String companyCulture, String companyInfo) {
        CompanyID = companyID;
        this.CPassword = CPassword;
        CompanyName = companyName;
        CompanyPhone = companyPhone;
        CompanyEmail = companyEmail;
        CompanyAddress = companyAddress;
        CompanyCulture = companyCulture;
        CompanyInfo = companyInfo;
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

    @Override
    public String toString() {
        return "Company{" +
                "CompanyID=" + CompanyID +
                ", CPassword='" + CPassword + '\'' +
                ", CompanyName='" + CompanyName + '\'' +
                ", CompanyPhone='" + CompanyPhone + '\'' +
                ", CompanyEmail='" + CompanyEmail + '\'' +
                ", CompanyAddress='" + CompanyAddress + '\'' +
                ", CompanyCulture='" + CompanyCulture + '\'' +
                ", CompanyInfo='" + CompanyInfo + '\'' +
                '}';
    }
}
