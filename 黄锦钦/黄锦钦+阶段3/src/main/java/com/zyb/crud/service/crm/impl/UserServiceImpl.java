package com.zyb.crud.service.crm.impl;

import com.zyb.crud.entity.crm.User;
import com.zyb.crud.mapper.crm.UserMapper;
import com.zyb.crud.service.crm.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
