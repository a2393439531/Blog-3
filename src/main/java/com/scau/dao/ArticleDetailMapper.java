package com.scau.dao;

import com.scau.entity.ArticleDetail;

public interface ArticleDetailMapper {
    int deleteByPrimaryKey(Integer artDeId);

    int insert(ArticleDetail record);

    int insertSelective(ArticleDetail record);
    int insertSelectiveDeId(ArticleDetail record);
    ArticleDetail selectByPrimaryKey(Integer artDeId);

    int updateByPrimaryKeySelective(ArticleDetail record);

    int updateByPrimaryKeyWithBLOBs(ArticleDetail record);

    int updateByPrimaryKey(ArticleDetail record);
}