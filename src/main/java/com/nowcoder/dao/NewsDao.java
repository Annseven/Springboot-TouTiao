package com.nowcoder.dao;

import com.nowcoder.model.News;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: AnNing
 * @Description:
 * @Date: Create in 10:27 2019/2/20
 */
@Repository
@Mapper
public interface NewsDao {

    String TABLE_NAME="News";
    String INSERT_FIELDS="title,link,image,likeCount,commentCount,createdDate,userId";
    String SELECT_FIELDS="id,"+ INSERT_FIELDS;

    /**
     * 全部
     */
    @Select("select * from News")
    List<News> list();
    /**
     * 根据id查询
     */
    News findById(Integer id);

//    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,") values (#{title},#{link},#{image},#{linkCount},#{commentCount}," +
//            "#{createdDate},#{userId})"})
//    int addNews(News news);
//
//
    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME,"where userId = #{userId} ORDER BY id DESC LIMIT #{offset},#{limit}"})
//    @ResultMap("NewsResultMap")
    public List<News> selectByUserIdAndOffset(@Param(value = "userId")int userId, @Param(value = "offset")int offset,@Param(value = "limit")int limit);


    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,") values(#{title},#{link},#{image},#{likeCount},#{commentCount},#{createdDate},#{userId})"})
    int addNews(News news);

    @Delete({"delete from ",TABLE_NAME,"where id=#{id}"})
    void deleteById(int id);

}
