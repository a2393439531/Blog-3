package com.scau.dao;

import com.scau.entity.Tag;
import com.scau.entity.TagKey;

public interface TagMapper {
    int deleteByPrimaryKey(TagKey key);

    int insert(Tag record);

    int insertSelective(Tag record);
    int insertSelectiveDeId(Tag record);
    Tag selectByPrimaryKey(TagKey key);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}