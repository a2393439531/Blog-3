package com.scau.entity;

import java.io.Serializable;

/**
 * @Author: beyondboy
 * @Gmail: xuguoli.scau@gamil.com
 * @Data: 2016/5/29
 * @Time: 22:48
 */
public class ArticleResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Article article;
    private Cateory cateory;
    private Tag tag;

    public ArticleResponse(Article article, Cateory cateory, Tag tag) {
        this.article = article;
        this.cateory = cateory;
        this.tag = tag;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Cateory getCateory() {
        return cateory;
    }

    public void setCateory(Cateory cateory) {
        this.cateory = cateory;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "ArticleResponse{" +
                "article=" + article +
                ", cateory=" + cateory +
                ", tag=" + tag +
                '}';
    }
}
