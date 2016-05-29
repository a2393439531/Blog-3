package com.scau.entity;

import java.io.Serializable;

public class Photo implements Serializable {
    private Integer phoId;

    private Integer artId;

    private String imgUrl;

    private String imgDes;

    private static final long serialVersionUID = 1L;

    public Integer getPhoId() {
        return phoId;
    }

    public void setPhoId(Integer phoId) {
        this.phoId = phoId;
    }

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getImgDes() {
        return imgDes;
    }

    public void setImgDes(String imgDes) {
        this.imgDes = imgDes == null ? null : imgDes.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", phoId=").append(phoId);
        sb.append(", artId=").append(artId);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", imgDes=").append(imgDes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}