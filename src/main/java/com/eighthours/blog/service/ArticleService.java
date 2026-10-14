package com.eighthours.blog.service;

import com.eighthours.blog.entity.Article;
import com.eighthours.blog.mapper.ArticleMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Resource
    ArticleMapper articleMapper;

    public String insertArticle(String title, String content) {
        articleMapper.insertArticle(title, content);
        return "";
    }

    // 返回所有文章(按时间倒序)
    public List<Article> listArticles() {
        return articleMapper.selectAll();
    }
}
