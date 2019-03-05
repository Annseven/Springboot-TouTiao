package com.nowcoder.service.Impl;

import com.mysql.jdbc.StringUtils;
import com.nowcoder.Util.TouTiaoUtil;
import com.nowcoder.dao.LoginTicketDao;
import com.nowcoder.dao.UserDao;
import com.nowcoder.model.LoginTicket;
import com.nowcoder.model.User;
import com.nowcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @Author: AnNing
 * @Description:
 * @Date: Create in 10:29 2019/3/4
 */
@Repository
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    private LoginTicketDao loginTicketDao;
    //登录查询
    @Override
    public User loginResult(String name, String passwd){
        return userDao.findByUsernameAndPassword(name,passwd);
    }

    @Override
    public  String  addLoginticket(int userId){
        LoginTicket ticket =new LoginTicket();
        ticket.setUserId(userId);
        Date date=new Date();
        //24h有效期
        date.setTime(date.getTime()+1000*3600*24);
        ticket.setExpired(date);
        ticket.setStatus(0);
        ticket.setTicket(UUID.randomUUID().toString().replaceAll("-",""));
        //插入数据库
        loginTicketDao.addTicket(ticket);
        return  ticket.getTicket();
    }


    @Override
    public Map<String,Object> login(String name, String password){
        Map<String,Object> map=new HashMap<String,Object>();
        if(StringUtils.isEmptyOrWhitespaceOnly(name)){
            map.put("msg","用户名不能为空");
            return  map;
        }

        if(StringUtils.isNullOrEmpty(password)){
            map.put("msgped","密码不能为空");
        }

        User user=userDao.findByUsername(name);

        if(user==null){
            map.put("magname","用户名不存在");
            return map;
        }
        if (!TouTiaoUtil.MD5(password+user.getSalt()).equals(user.getPassword())){
            map.put("msgpwd","密码不正确");
            return  map;
        }

        String ticket=addLoginticket(user.getId());
        map.put("ticket",ticket);
        return map;

    }

    @Override
    public Map<String,Object> register(String name,String password){

        Map<String,Object> map=new HashMap<String,Object>();
        if (StringUtils.isEmptyOrWhitespaceOnly(name)){
            map.put("msgname","用户名不能为空");
            return  map;
        }
        if(StringUtils.isEmptyOrWhitespaceOnly(password)){
            map.put("magpwd","密码不能为空");
            return  map;
        }

        User user = userDao.findByUsername(name);

        if (user!=null){
            map.put("msgname","用户名已经被注册");
            return map;
        }
        //密码强度
        user=new User();
        user.setName(name);
        user.setSalt(UUID.randomUUID().toString().substring(0,5));
        String head=String.format("1", new Random().nextInt(1000));
        user.setHeadUrl(head);
        user.setPassword(TouTiaoUtil.MD5(password+user.getSalt()));
        userDao.addUser(user);
        String ticket=addLoginticket(user.getId());
        map.put("ticket",ticket);
        return map;

    }

    @Override
    public User getUser(int id) {
        return userDao.selectById(id);
    }

    @Override
    public void logout(String ticket) {
        loginTicketDao.updateStatus(ticket,1);
    }
}
