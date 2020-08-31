package com.talresource.Talent_Recruitment.dao;

import com.talresource.Talent_Recruitment.entity.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NewsDao {

    @Select("select * from news where NewsID<>0")
    List<News> selectAllNews();

    @Select("select * from news where NewsID<>0 order by NewsPublishDate DESC ")
    List<News> selectNewsByDate();

    @Select("select * from news where NewsID=#{NewsID}")
    News selectNewsByID(@Param("NewsID") int NewsID);

    @Select("select * from news order by NewsHeat DESC limit 5")
    List<News> selectNewsByHeat();

    @Insert("insert into news(NewsContent)" +
            "value(#{NewsContent})")
    void insertNewsTest(@Param("NewsContent") String NewsContent);

    @Insert("insert into news(NewsTitle ,NewsPublishDate, NewsBriefInfo, NewsContent) " +
            "value(#{NewsTitle} ,#{NewsPublishDate}, #{NewsBriefInfo}, #{NewsContent})")
    boolean insertNews(@Param("NewsTitle") String NewsTitle, @Param("NewsPublishDate") String NewsPublishDate,
                       @Param("NewsBriefInfo") String NewsBriefInfo, @Param("NewsContent") String NewsContent);

    @Update("update news set NewsTitle=#{NewsTitle}, NewsPublishDate=#{NewsPublishDate}," +
            "NewsContent=#{NewsContent} where NewsID=#{NewsID}")
    boolean updateNewsById(@Param("NewsTitle") String NewsTitle, @Param("NewsPublishDate") String NewsPublishDate,
                   @Param("NewsContent") String NewsContent, @Param("NewsID") int NewsID);

    @Update("update news set NewsHeat=NewsHeat+6 where NewsID=#{NewsID}")
    boolean updateNewsHeat(@Param("NewsID") int NewsID);

    @Delete("delete from news where NewsID=#{NewsID}")
    boolean deleteNewsByID(@Param("NewsID") int NewsID);


}
