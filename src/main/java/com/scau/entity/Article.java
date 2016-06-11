package com.scau.entity;

import java.io.Serializable;
import java.sql.Date;

public class Article implements Serializable {
    private Integer artId;

    private Integer userId;

    private String title;

    private Date publishDate;

    private Integer catId;

    private String summary;

    private static final long serialVersionUID = 1L;

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", artId=").append(artId);
        sb.append(", userId=").append(userId);
        sb.append(", title=").append(title);
        sb.append(", publishDate=").append(publishDate);
        sb.append(", catId=").append(catId);
        sb.append(", summary=").append(summary);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}