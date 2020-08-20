package com.talresource.Talent_Recruitment.entity;

public class Manager {
    private int ManagerID;
    private String ManagerName;
    private String MPassword;

    public Manager() {
    }

    public Manager(String managerName, String MPassword) {
        ManagerName = managerName;
        this.MPassword = MPassword;
    }

    public Manager(int managerID, String managerName, String MPassword) {
        ManagerID = managerID;
        ManagerName = managerName;
        this.MPassword = MPassword;
    }

    public int getManagerID() {
        return ManagerID;
    }

    public void setManagerID(int managerID) {
        ManagerID = managerID;
    }

    public String getManagerName() {
        return ManagerName;
    }

    public void setManagerName(String managerName) {
        ManagerName = managerName;
    }

    public String getMPassword() {
        return MPassword;
    }

    public void setMPassword(String MPassword) {
        this.MPassword = MPassword;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "ManagerID=" + ManagerID +
                ", ManagerName='" + ManagerName + '\'' +
                ", MPassword='" + MPassword + '\'' +
                '}';
    }
}
