package com.scau.entity;

import java.io.Serializable;

public class ArticleDetail implements Serializable {
    private Integer artDeId;

    private Integer articleClick;

    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getArtDeId() {
        return artDeId;
    }

    public void setArtDeId(Integer artDeId) {
        this.artDeId = artDeId;
    }

    public Integer getArticleClick() {
        return articleClick;
    }

    public void setArticleClick(Integer articleClick) {
        this.articleClick = articleClick;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", artDeId=").append(artDeId);
        sb.append(", articleClick=").append(articleClick);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}