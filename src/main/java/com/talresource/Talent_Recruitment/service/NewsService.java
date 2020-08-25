package com.talresource.Talent_Recruitment.service;

import com.talresource.Talent_Recruitment.dao.NewsDao;
import com.talresource.Talent_Recruitment.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsDao newsDao;

    @Transactional
    public List<News> selectAllNews(){
        return newsDao.selectAllNews();
    }

    public List<News> selectNewsByDate(){
        return newsDao.selectNewsByDate();
    }

    public News selectNewsByID(int NewsID){
        return newsDao.selectNewsByID(NewsID);
    }

    public List<News> selectNewsByHeat(){
        return newsDao.selectNewsByHeat();
    }

    public void insertNewsTest(String NewsContent){
        newsDao.insertNewsTest(NewsContent);
    }

    public boolean insertNews(String NewsTitle, String NewsPublishDate, String NewsContent){
        return newsDao.insertNews(NewsTitle, NewsPublishDate, NewsContent);
    }

    public boolean updateNewsById(String NewsTitle, String NewsPublishDate, String NewsContent, int NewsID){
        return newsDao.updateNewsById(NewsTitle, NewsPublishDate, NewsContent, NewsID);
    }

}
