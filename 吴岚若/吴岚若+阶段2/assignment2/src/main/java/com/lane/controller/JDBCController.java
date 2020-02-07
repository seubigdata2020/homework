package com.lane.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    protected static Logger logger= LoggerFactory.getLogger(JDBCController.class);

    //查询数据库的所有信息
    @GetMapping("/userList")
    public List<Map<String,Object>> userList() {
        String sql="select * from user";
        List<Map<String,Object>> list_maps=jdbcTemplate.queryForList(sql);
        logger.info("显示数据库表的内容");
        return list_maps;
    }

    //根据id查找一个用户
    @GetMapping("/queryUser/{id}")
    public List<Map<String,Object>> queryUser(@PathVariable("id") int id) {
        String sql="select * from user where id="+id;
        List<Map<String,Object>> list_maps=jdbcTemplate.queryForList(sql);
        logger.info("查找id为"+id+"的用户");
        return list_maps;
    }

    //增加一个用户
    @GetMapping("/addUser/{name}/{id}/{password}")
    public String addUser(@PathVariable("name") String name,
                          @PathVariable("id") int id,
                          @PathVariable("password") String password){
        String sql="insert into jdbc.user(name,id,password) values('"+name+"','"+id+"','"+password+"')";
        jdbcTemplate.update(sql);
        logger.info("增加id为"+id+"的用户成功");
        return "增加一个用户成功！";
    }

    //根据id来更新内容
    @GetMapping("/updateUser/{name}/{id}/{password}")
    public String updateUser(@PathVariable("name") String name,
                             @PathVariable("id") int id,
                             @PathVariable("password") String password){
        String sql="update jdbc.user set name='"+name+"', password='"+password+"' where id="+"'"+id+"'";
        jdbcTemplate.update(sql);
        logger.info("更新id为"+id+"的用户成功");
        return "更新成功！";
    }

    //根据id删除一个用户
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql="delete from jdbc.user where id=?";
        jdbcTemplate.update(sql,id);
        logger.info("刪除id为"+id+"的用户成功");
        return "删除一个用户成功！";
    }
}
