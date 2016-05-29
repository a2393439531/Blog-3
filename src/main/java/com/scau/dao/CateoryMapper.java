package com.scau.dao;

import com.scau.entity.Cateory;

public interface CateoryMapper {
    int deleteByPrimaryKey(Integer catId);

    int insert(Cateory record);

    int insertSelective(Cateory record);

    Cateory selectByPrimaryKey(Integer catId);

    int updateByPrimaryKeySelective(Cateory record);

    int updateByPrimaryKey(Cateory record);
}