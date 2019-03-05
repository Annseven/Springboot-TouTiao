package com.nowcoder.model;

import org.springframework.stereotype.Component;

/**
 * @Author: AnNing
 * @Description:
 * @Date: Create in 13:31 2019/3/4
 */
@Component
public class HostHolder {
    //面试会考。每一条线程只存自己的变量
    private static  ThreadLocal<User> users = new ThreadLocal<User>();

    public User getUser() {
        return users.get();
    }

    public void setUser(User user) {
        users.set(user);
    }

    public void clear() {
        users.remove();;
    }
}
