package com.talresource.Talent_Recruitment.dao;

import com.talresource.Talent_Recruitment.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostDao {

    @Select("select * from post where PostID=#{PostID}")
    Post selectPostByID(@Param("PostID") int PostID);

    @Select("select * from post order by PostHeat DESC limit 12")
    List<Post> selectPostsByHeat();

    @Select("select * from post order by PostPublishDate DESC limit 12")
    List<Post> selectPostsByDate();

}
