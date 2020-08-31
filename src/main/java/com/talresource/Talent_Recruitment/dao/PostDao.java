package com.talresource.Talent_Recruitment.dao;

import com.talresource.Talent_Recruitment.entity.Job;
import com.talresource.Talent_Recruitment.entity.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostDao {

    @Select("select * from post ")
    List<Post> selectAllPost();

    @Select("select * from post where PostID=#{PostID}")
    Post selectPostByID(@Param("PostID") int PostID);

    @Select("select * from post order by PostHeat DESC limit 12")
    List<Post> selectPostsByHeat();

    @Select("select * from post order by PostPublishDate DESC limit 12")
    List<Post> selectPostsByDate();

    @Select("select * from post where (PostTitle like CONCAT('%',#{PostInfo},'%')) " +
            "or (PostContent like CONCAT('%',#{PostInfo},'%')) " +
            "order by PostTitle")
    List<Post> searchPostByTitleOrContent(@Param("PostInfo") String PostInfo);

    @Insert("insert into post(PostTitle, PostContent, PostPublishDate, UserID)" +
            "value(#{PostTitle}, #{PostContent}, #{PostPublishDate}, #{UserID})")
    boolean insertPost(@Param("PostTitle") String PostTitle, @Param("PostContent") String PostContent,
                       @Param("PostPublishDate") String PostPublishDate, @Param("UserID") int UserID);

    @Update("update post set PostHeat=PostHeat+6 where PostID=#{PostID}")
    boolean updatePostHeat(@Param("PostID") int PostID);

    @Delete("delete from post where PostID=#{PostID}")
    boolean deletePostByID(@Param("PostID") int PostID);

    @Select("select * from post where UserID=#{UserID} order by PostPublishDate DESC")
    List<Post> selectPostByUserID(@Param("UserID") int UserID);

}
