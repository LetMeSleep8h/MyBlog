package com.eighthours.blog.controller;

import com.eighthours.blog.entity.Article;
import com.eighthours.blog.service.ArticleService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {
    @Resource
    ArticleService articleService;

    // 管理口令,来自配置里的 admin.password
    @Value("${admin.password}")
    private String adminPassword;

    @PostMapping("/insert")
    public String insertArticle(String title, String content) {
        articleService.insertArticle(title, content);
        return "成功";
    }

    // 前端每次进入"个人博客"页面时调用,返回数据库里所有文章
    @GetMapping("/list")
    public List<Article> listArticles() {
        return articleService.listArticles();
    }

    // 管理端:添加一篇文章。前端不会直接展示这个接口,
    // 只有带对了口令(password)才能发布。
    @PostMapping("/admin/add")
    public ResponseEntity<String> adminAddArticle(String title, String content, String password) {
        if (!adminPassword.equals(password)) {
            return ResponseEntity.status(401).body("密码错误");
        }
        articleService.insertArticle(title, content);
        return ResponseEntity.ok("成功");
    }
}
