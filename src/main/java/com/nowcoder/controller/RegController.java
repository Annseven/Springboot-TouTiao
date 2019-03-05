package com.nowcoder.controller;

import com.nowcoder.Util.TouTiaoUtil;
import com.nowcoder.model.User;
import com.nowcoder.service.Impl.UserServiceImpl;
import com.nowcoder.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: AnNing
 * @Description:
 * @Date: Create in 18:02 2019/2/26
 */
@Controller
public class RegController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @Autowired
    User user;

    @RequestMapping("/reg")
    public String reg(){
        return  "reg";
    }

    //注册信息
    @RequestMapping("/regAction")
    public String home(Model model, @RequestParam("name") String name,
                       @RequestParam("password") String password,
                       @RequestParam(value="remeber",defaultValue = "0")int remeber,
                       HttpServletResponse response) {

        try{
            Map<String, Object> map = userService.register(name, password);
            if (map.containsKey("ticket")) {
                Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                cookie.setPath("/");
                if (remeber > 0) {
                    cookie.setMaxAge(3600*24*5);
                }
                response.addCookie(cookie);
                return TouTiaoUtil.getJSONString(0, "注册成功");
            } else {
                return TouTiaoUtil.getJSONString(1, map);
            }
        }
        catch (Exception e){
            logger.error("注册异常"+e.getMessage());
            return TouTiaoUtil.getJSONString(1,"注册异常");
        }
    }
}
