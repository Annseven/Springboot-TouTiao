package com.nowcoder.model;

import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @Author: AnNing
 * @Description:
 * @Date: Create in 14:20 2019/3/1
 */
@Repository
public class LoginTicket {

    private Integer Id;

    private Integer UserId;

    private String Ticket;

    private Date Expired;

    private Integer Status;


    public LoginTicket(Integer id, Integer userId, String ticket, Date expired, Integer status) {
        Id = id;
        UserId = userId;
        Ticket = ticket;
        Expired = expired;
        Status = status;
    }

    public LoginTicket() {

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public Date getExpired() {
        return Expired;
    }

    public void setExpired(Date expired) {
        Expired = expired;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }
}
