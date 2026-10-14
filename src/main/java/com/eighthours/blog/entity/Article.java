package com.eighthours.blog.entity;

import java.time.LocalDateTime;

public class Article {
    //主键，时间，标题，内容，是否删除
    private Integer id;
    private LocalDateTime articleTime;
    private String title;
    private String content;
    private Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(LocalDateTime articleTime) {
        this.articleTime = articleTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
