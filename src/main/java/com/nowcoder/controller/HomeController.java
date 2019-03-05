package com.nowcoder.controller;

import com.nowcoder.model.HostHolder;
import com.nowcoder.model.News;
import com.nowcoder.model.ViewObject;
import com.nowcoder.service.NewsService;
import com.nowcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: AnNing
 * @Description:
 * @Date: Create in 17:28 2019/2/20
 */
@Controller
public class HomeController {

    @Autowired
    NewsService newsService;

    @Autowired
    UserService userService;

    @Autowired
    HostHolder hostHolder;


    private List<ViewObject> getNews(int userId, int offset, int limit) {
        List<News> newsList = newsService.selectByUserIdAndOffset(userId, offset, limit);

        List<ViewObject> vos = new ArrayList<>();
        for (News news : newsList) {
            ViewObject vo = new ViewObject();
            vo.set("news", news);
            vo.set("user", userService.getUser(news.getUserId()));
            vos.add(vo);
        }
        return vos;
    }


    //获取所有的新闻信息
    @RequestMapping(path = {"/list"})
    public String NewsList(Model model) {
        System.out.println("查询所有");
        List<News> newsList=newsService.list();
        model.addAttribute("newsList",newsList);
        return "index";
    }
    //根据ID查询新闻数
    @RequestMapping(path = {"/listById/{userId}/{groupId}"})
    public String NewsListById(@PathVariable("userId") int userId,
                               @PathVariable("groupId") int groupId,
                               Model model) {
        System.out.println("根据ID查询");
        List<News> newsList=newsService.selectByUserIdAndOffset(userId,groupId, 10);
        model.addAttribute("newsList",newsList);
        return "index";
    }


    @RequestMapping(path = {"/", "/index"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model,
                        @RequestParam(value = "pop", defaultValue = "0") int pop) {
        model.addAttribute("vos", getNews(0, 0, 10));
        model.addAttribute("pop", pop);
        return "index";
    }




}
