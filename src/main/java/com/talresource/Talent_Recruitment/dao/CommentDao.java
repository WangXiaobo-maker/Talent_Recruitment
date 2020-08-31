package com.talresource.Talent_Recruitment.dao;

import com.talresource.Talent_Recruitment.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentDao {

    @Select("select * from comment where PostID=#{PostID} order by CommentPublishDate DESC")
    List<Comment> selectCommentByPost(@Param("PostID") int PostID);

    @Insert("insert into comment(PostID, UserID, CommentPublishDate, CommentContent) " +
            "values(#{PostID}, #{UserID}, #{CommentPublishDate}, #{CommentContent})")
    boolean insertComment(@Param("PostID") int PostID, @Param("UserID") int UserID,
                         @Param("CommentPublishDate") String CommentPublishDate,
                         @Param("CommentContent") String CommentContent);

    @Delete("delete from comment where PostID=#{PostID}")
    boolean deleteCommentByPost(@Param("PostID") int PostID);
}
