package com.lane;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lane.entity.User;
import com.lane.mapper.UserMapper;
import com.lane.service.IUserService;
import com.lane.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;



@SpringBootTest
class Assignment3ApplicationTests {

    @Autowired
   private IUserService userService;

    @Resource
    private UserMapper userMapper;

    //增
    @Test
    public void addUser()
    {
        User user=new User(122,"keai","ssssdffs");
        userService.save(user);
    }


    //删
    @Test
    public void deleteUser() {
        System.out.println("删除一条数据：" + userService.removeById(1L));
    }

    //改
    @Test
    public void updateUser()
    {
        User user=new User(122,"羊","ssssdffs");
        userService.updateById(user);
    }

    //查
    @Test
    public void getUser()
    {
        User user=userService.getById(122);
        System.out.println(user);
    }

    //条件查询
    @Test
    public void queryUserCondition() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("id", 2).le("id",12);
        List<User> list= userMapper.selectList(queryWrapper);
        for(User user:list) {
            System.out.println(user);
        }
    }

    //分页查询
    @Test
    public void pageQuery()
    {
        Page<User> page=new Page<>(1,3);
        IPage<User> iPage=userMapper.selectPage(page,null);
        System.out.println(iPage.getRecords());
    }
}