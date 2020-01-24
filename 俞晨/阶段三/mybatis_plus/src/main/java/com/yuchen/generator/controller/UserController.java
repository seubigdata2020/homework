package com.yuchen.generator.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuchen.generator.entity.User;
import com.yuchen.generator.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author YuChen
 * @since 2020-01-22
 */
@RestController
@EnableAutoConfiguration
public class UserController {

    @Autowired
    public UserServiceImpl userService;

    //条件查询 查询性别为女的用户信息
    @RequestMapping("/findGirl")
    public List<User> findAll(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
        queryWrapper.eq("sex","女");
        return userService.selectList(queryWrapper);
    }

    //条件自定义查询
    @RequestMapping("/selectByName/{name}")
    public List<User> selectByName(@PathVariable String name){
        List<User> users = userService.selectByName(name);
        return  users;
    }
    //分页查询
    @RequestMapping("/findPage/{pageNo}/{pageSize}")
    public IPage<User> findByPage(@PathVariable Integer pageNo , @PathVariable Integer pageSize) {
        Page<User> page = new Page<>(pageNo,pageSize);
        return userService.findByPage(page);
    }

}
