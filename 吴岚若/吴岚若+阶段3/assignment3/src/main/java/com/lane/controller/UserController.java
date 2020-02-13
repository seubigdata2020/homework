package com.lane.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lane.entity.User;
import com.lane.mapper.UserMapper;
import com.lane.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lane
 * @since 2020-02-12
 */
@RestController
@RequestMapping("/lane")
public class UserController {
    @Resource
    private UserMapper userMapper;

    @Autowired
    private IUserService userService;


    //增
    @RequestMapping("/addUser/{id}/{name}/{pwd}")
    public String addUser(@PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("pwd") String pwd)
    {
        User user=new User(id,name,pwd);
        userService.save(user);
        return "添加成功";
    }


    //删
    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.removeById(id);
        return "删除成功";
    }

    //改
    @RequestMapping("/updateUser/{id}/{name}/{pwd}")
    public String updateUser(@PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("pwd") String pwd)
    {
        User user=new User(id,name,pwd);
        userService.updateById(user);
        return "更新成功";
    }

    //查
    @RequestMapping("/queryUserById/{id}")
    public User getUser(@PathVariable("id") int id)
    {
        User user=userService.getById(id);
        return user;
    }

    //条件查询
    @RequestMapping("/queryUserCondition/{low}/{high}")
    public List<User> queryUserCondition(@PathVariable("low") int low,@PathVariable("high") int high) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("id", low).le("id",high);
        List<User> list=userService.list(queryWrapper);
        return list;
    }



    //分页查询
    @RequestMapping("/page/{current}/{size}")
    public List<User> getPage(@PathVariable("current") int current,@PathVariable("size") int size)
    {

        Map<String,Object> map = new HashMap<>();
        QueryWrapper<User> queryWrapper =  new QueryWrapper<>();
        queryWrapper.orderByDesc("id");//按id降序
        Page<User> page = new Page<>(current,size);  // 查询第current页，每页大小为size
        IPage<User> iPage = userMapper.selectPage(page,queryWrapper);
        return iPage.getRecords();
    }
}

