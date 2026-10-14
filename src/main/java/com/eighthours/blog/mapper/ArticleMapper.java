package com.eighthours.blog.mapper;

import com.eighthours.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    void insertArticle(String title, String content);

    // 查询所有未删除的文章,按时间倒序(最新在前)
    List<Article> selectAll();
}
