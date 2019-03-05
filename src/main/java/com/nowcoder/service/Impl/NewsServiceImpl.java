package com.nowcoder.service.Impl;

import com.nowcoder.dao.NewsDao;
import com.nowcoder.model.News;
import com.nowcoder.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: AnNing
 * @Description:
 * @Date: Create in 16:04 2019/2/25
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Override
    public List<News> list() {

        return newsDao.list();
    }

    @Override
    public  News findById(Integer id) {

        return newsDao.findById(id);
    }

    @Override
    public  List<News> selectByUserIdAndOffset(int userId,int offset, int limit){

        return  newsDao.selectByUserIdAndOffset( userId,offset, limit);

    }




}



