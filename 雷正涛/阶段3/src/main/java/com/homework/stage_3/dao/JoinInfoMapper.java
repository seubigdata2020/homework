package com.homework.stage_3.dao;

import com.homework.stage_3.entity.JoinInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface JoinInfoMapper {
    List<JoinInfo> listJ() ;
}
