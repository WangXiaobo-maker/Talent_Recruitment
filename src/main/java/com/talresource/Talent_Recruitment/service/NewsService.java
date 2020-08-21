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

}
