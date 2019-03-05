package com.nowcoder.service;

import com.nowcoder.model.LoginTicket;
import com.nowcoder.model.User;

import java.util.Map;

/**
 * @Author: AnNing
 * @Description:
 * @Date: Create in 14:59 2019/2/21
 */
public interface UserService {
    //登陆
    public User loginResult(String name, String passwd);


    public String  addLoginticket(int userId);

    Map<String,Object> login(String name,String password);
    //注册
    public Map<String,Object> register(String name, String password);

    public User getUser(int id);

    public void logout(String ticket);
}
