package com.yuchen.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuchen.generator.entity.User;
import com.yuchen.generator.mapper.UserMapper;
import com.yuchen.generator.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YuChen
 * @since 2020-01-22
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    public UserMapper userMapper;
    /**
     * 根据 entity 条件，查询全部记录
     * @return
     */
    public List<User> selectList(QueryWrapper<User> queryWrapper) {
        return userMapper.selectList(queryWrapper);
    }

    public IPage<User> findByPage(Page<User> page) {
        return userMapper.selectPage(page,null);
    }

    public List<User> selectByName(String name){
        return userMapper.selectByName(name);
    }
}
