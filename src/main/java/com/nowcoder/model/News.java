package com.nowcoder.model;

import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: AnNing
 * @Description:
 * @Date: Create in 18:06 2019/2/18
 */
@Repository
public class News {
    private Integer id;

    private String title;

    private String link;

    private String image;

    private Integer likeCount;

    private Integer commentCount;

    private  Date createdDate;

    private Integer userId;



    public News() {
    }

    public News(Integer id, String title, String link, String image, Integer likeCount, Integer commentCount, Date createdDate, Integer userId) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.image = image;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.createdDate = createdDate;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
