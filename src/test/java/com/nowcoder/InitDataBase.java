package com.nowcoder;

import com.nowcoder.dao.NewsDao;
import com.nowcoder.dao.UserDao;
import com.nowcoder.model.News;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InitDataBase {

    @Autowired
    UserDao userDao;

    @Autowired
    NewsDao newsDao;

    @Test
    public void contextLoads() {

        News news = new News();
        List<News> newsList = newsDao.list();
        for (int i = 0; i < newsList.size(); i++) {
            System.out.println(newsList.get(i).getCommentCount());
            System.out.println(newsList.get(i).getLikeCount());
            System.out.println(newsList.get(i).getCreatedDate());
            System.out.println(newsList.get(i).getImage());
            System.out.println(newsList.get(i).getLink());
            System.out.println(newsList.get(i).getTitle());
            System.out.println(newsList.get(i).getUserId());
            System.out.println("===========");
        }
    }

}

