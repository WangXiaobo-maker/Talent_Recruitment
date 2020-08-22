package com.talresource.Talent_Recruitment.dao;

import com.talresource.Talent_Recruitment.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsDao {

    @Select("select * from news")
    List<News> selectAllNews();

    @Select("select * from news order by NewsPublishDate DESC limit 10")
    List<News> selectNewsByDate();

}
