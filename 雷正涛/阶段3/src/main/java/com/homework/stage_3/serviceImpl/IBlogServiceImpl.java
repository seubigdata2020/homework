package com.homework.stage_3.serviceImpl;

import com.homework.stage_3.dao.JoinInfoMapper;
import com.homework.stage_3.entity.JoinInfo;
import com.homework.stage_3.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IBlogServiceImpl implements BlogService {

    @Autowired
    private JoinInfoMapper joinInfoMapper;

    @Override
    public List<JoinInfo> listJoin() {
        return joinInfoMapper.listJ();
    }
}
