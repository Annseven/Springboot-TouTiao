package com.nowcoder.controller;

import com.nowcoder.Util.TouTiaoUtil;
import com.nowcoder.model.User;
import com.nowcoder.service.Impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: AnNing
 * @Description:
 * @Date: Create in 14:24 2019/2/21
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserServiceImpl userService;
    @Autowired
    User user;



    //登录页面跳转
    @RequestMapping("/login")
    public String  login(){
        return "login";
    }
    //登录结果

    @RequestMapping("/loginResult")
    public String login(Model model, @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam(value="rember", defaultValue = "0") int rememberme,
                        HttpServletResponse response){

        try{
            Map<String, Object> map = userService.login(username, password);
            if (map.containsKey("ticket")) {
                Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                cookie.setPath("/");

                if (rememberme > 0) {
                    cookie.setMaxAge(3600*24*5);
                }
                response.addCookie(cookie);
                return "index";
            }else{
                return TouTiaoUtil.getJSONString(1,map);
            }
        }
        catch (Exception e){
            logger.error("登录异常"+e.getMessage());
            return TouTiaoUtil.getJSONString(1,"登录异常");
        }
    }


    @RequestMapping(path = {"/logout"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String logout(@CookieValue("ticket") String ticket){
          userService.logout(ticket);
        System.out.println("用户登出");
        return "index";
    }





}
