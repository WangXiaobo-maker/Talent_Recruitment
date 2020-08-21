package com.talresource.Talent_Recruitment.entity;

/**
 * 资讯实体
 */

public class News {
    private int NewsID;
    private String NewsTitle;
    private String NewsPublishDate;
    private String NewsContent;
    private String NewsImg;


    public String getNewsImg() {
        return NewsImg;
    }

    public void setNewsImg(String newsImg) {
        NewsImg = newsImg;
    }

    public int getNewsID() {
        return NewsID;
    }

    public void setNewsID(int newsID) {
        NewsID = newsID;
    }

    public String getNewsTitle() {
        return NewsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        NewsTitle = newsTitle;
    }

    public String getNewsPublishDate() {
        return NewsPublishDate;
    }

    public void setNewsPublishDate(String newsPublishDate) {
        NewsPublishDate = newsPublishDate;
    }

    public String getNewsContent() {
        return NewsContent;
    }

    public void setNewsContent(String newsContent) {
        NewsContent = newsContent;
    }
}
