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
    private String NewsBriefInfo;

    public News() {
    }

    public News(String newsTitle, String newsPublishDate, String newsContent, String newsImg, String newsBriefInfo) {
        NewsTitle = newsTitle;
        NewsPublishDate = newsPublishDate;
        NewsContent = newsContent;
        NewsImg = newsImg;
        NewsBriefInfo = newsBriefInfo;
    }

    public News(int newsID, String newsTitle, String newsPublishDate, String newsContent, String newsImg, String newsBriefInfo) {
        NewsID = newsID;
        NewsTitle = newsTitle;
        NewsPublishDate = newsPublishDate;
        NewsContent = newsContent;
        NewsImg = newsImg;
        NewsBriefInfo = newsBriefInfo;
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

    public String getNewsImg() {
        return NewsImg;
    }

    public void setNewsImg(String newsImg) {
        NewsImg = newsImg;
    }

    public String getNewsBriefInfo() {
        return NewsBriefInfo;
    }

    public void setNewsBriefInfo(String newsBriefInfo) {
        NewsBriefInfo = newsBriefInfo;
    }

    @Override
    public String toString() {
        return "News{" +
                "NewsID=" + NewsID +
                ", NewsTitle='" + NewsTitle + '\'' +
                ", NewsPublishDate='" + NewsPublishDate + '\'' +
                ", NewsContent='" + NewsContent + '\'' +
                ", NewsImg='" + NewsImg + '\'' +
                ", NewsBriefInfo='" + NewsBriefInfo + '\'' +
                '}';
    }
}
