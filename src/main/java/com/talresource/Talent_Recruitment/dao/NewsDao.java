package com.talresource.Talent_Recruitment.dao;

import com.talresource.Talent_Recruitment.entity.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NewsDao {

    @Select("select * from news")
    List<News> selectAllNews();

    @Select("select * from news order by NewsPublishDate DESC limit 10")
    List<News> selectNewsByDate();

    @Select("select * from news where NewsID=#{NewsID}")
    News selectNewsByID(@Param("NewsID") int NewsID);

    @Select("select * from news order by NewsHeat DESC limit 5")
    List<News> selectNewsByHeat();

    @Insert("insert into news(NewsContent)" +
            "value(#{NewsContent})")
    void insertNewsTest(@Param("NewsContent") String NewsContent);

    @Insert("insert into news(NewsTitle ,NewsPublishDate, NewsContent) value(#{NewsTitle} ,#{NewsPublishDate}, #{NewsContent})")
    boolean insertNews(@Param("NewsTitle") String NewsTitle, @Param("NewsPublishDate") String NewsPublishDate,
                       @Param("NewsContent") String NewsContent);

    @Update("update news set NewsTitle=#{NewsTitle}, NewsPublishDate=#{NewsPublishDate}," +
            "NewsContent=#{NewsContent} where NewsID=#{NewsID}")
    boolean updateNewsById(@Param("NewsTitle") String NewsTitle, @Param("NewsPublishDate") String NewsPublishDate,
                   @Param("NewsContent") String NewsContent, @Param("NewsID") int NewsID);

}
