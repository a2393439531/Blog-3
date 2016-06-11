package com.scau.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: beyondboy
 * @Gmail: xuguoli.scau@gamil.com
 * @Data: 2016/6/11
 * @Time: 23:44
 */
public class ArticleLimit implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Article> articles;
    private int count;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ArticleLimit{" +
                "articles=" + articles +
                ", count=" + count +
                '}';
    }
}
