package com.nowcoder.service;

import com.nowcoder.model.News;

import java.util.List;

/**
 * @Author: AnNing
 * @Description:
 * @Date: Create in 16:07 2019/2/25
 */
public interface NewsService {
    List<News> list();
    //根据Id查询新闻
    News findById(Integer id);
    //根据用户id查询新闻
    List<News> selectByUserIdAndOffset(int userId,int offset, int limit);

}
