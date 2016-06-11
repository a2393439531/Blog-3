package com.scau.dao;

import com.scau.entity.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer artId);

    int insert(Article record);

    int insertSelective(Article record);
    int insertSelectiveDeId(Article record);

    Article selectByPrimaryKey(Integer artId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
}