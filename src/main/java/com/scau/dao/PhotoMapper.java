package com.scau.dao;

import com.scau.entity.Photo;

public interface PhotoMapper {
    int deleteByPrimaryKey(Integer phoId);

    int insert(Photo record);

    int insertSelective(Photo record);

    Photo selectByPrimaryKey(Integer phoId);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKeyWithBLOBs(Photo record);

    int updateByPrimaryKey(Photo record);
}