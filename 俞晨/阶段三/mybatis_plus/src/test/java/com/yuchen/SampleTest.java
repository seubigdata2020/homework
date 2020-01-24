package com.yuchen;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuchen.generator.entity.User;
import com.yuchen.generator.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect(){
        System.out.println(("----- selectAll method test ------"));

    }

    //增加一条用户记录
    @Test
    public void Insert() {
        User user = new User();
        user.setId("9");
        user.setUsername("小羊");
        user.setAge("29");
        user.setSex("男");
        assertThat(userMapper.insert(user)).isGreaterThan(0);
        // 成功直接拿会写的 ID
        assertThat(user.getId()).isNotNull();
    }

    //根据id删除用户记录
    @Test
    public void DeleteById(){
        userMapper.deleteById("9");
    }

    //修改用户记录
    @Test
    public void Update(){
        User user = new User();
        user.setId("9");
        user.setUsername("小羊");
        user.setAge("29");
        user.setSex("女");
        userMapper.updateById(user);
    }

    //查询所有
    @Test
    public void SelectAll(){
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(4, userList.size());
        userList.forEach(System.out::println);
    }

    //根据条件查询
    @Test
    public void SelectByCondiction(){
        QueryWrapper<UserMapper> queryWrapper = new QueryWrapper<>(userMapper) ;
        List<User> userList = userMapper.selectList(null);
    }
}
