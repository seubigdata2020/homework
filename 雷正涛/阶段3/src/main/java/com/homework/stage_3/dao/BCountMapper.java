package com.homework.stage_3.dao;

import com.homework.stage_3.entity.BCount;

public interface BCountMapper {
    int insert(BCount record);

    int insertSelective(BCount record);
}