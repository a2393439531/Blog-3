package com.scau.dao;

import com.scau.entity.Cateory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CateoryMapper {
    int deleteByPrimaryKey(Integer catId);

    int insert(Cateory record);

    int insertSelective(Cateory record);
    int insertSelectiveDeId(Cateory record);
    Cateory selectByPrimaryKey(Integer catId);
    int getCount();
    List<Cateory> queryByName(@Param("catName") String catName);
    int updateByPrimaryKeySelective(Cateory record);

    int updateByPrimaryKey(Cateory record);
    List<Cateory> getAll();
}