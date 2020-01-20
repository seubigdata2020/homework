package com.homework.stage_3.dao;

import com.homework.stage_3.entity.BlogInfo;

public interface BlogInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogInfo record);

    int insertSelective(BlogInfo record);

    BlogInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogInfo record);

    int updateByPrimaryKey(BlogInfo record);
}