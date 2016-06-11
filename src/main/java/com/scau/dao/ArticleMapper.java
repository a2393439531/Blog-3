package com.scau.dao;

import com.scau.entity.Article;

import java.util.List;
import java.util.Map;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer artId);

    int insert(Article record);

    int insertSelective(Article record);
    int insertSelectiveDeId(Article record);

    Article selectByPrimaryKey(Integer artId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
    List<Article> selectBylimit(Map map);
    List<Article> selectMatchTitle(Map map);
    List<Article> selectByCatId(Map map);
}