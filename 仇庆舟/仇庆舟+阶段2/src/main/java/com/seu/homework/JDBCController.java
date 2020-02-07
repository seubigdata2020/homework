package com.seu.homework;

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

    //查看全体用户
    @GetMapping("/userList")
    public List<Map<String,Object>> userList(){
        String sql = "select * from person";
        List<Map<String,Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }

    //增加一个用户
    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into student.person(id,name,age) values (4,'小北','14')";
        jdbcTemplate.update(sql);
        return "update-ok";

    }

    //更新一个用户
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update student.person set name=?,age=? where id="+id;

        Object[] objects = new Object[2];
        objects[0] = "小花";
        objects[1] = "15";
        jdbcTemplate.update(sql,objects);
        return "updateUser-ok";

    }

    //删除一个用户
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from student.person where id =?";
        jdbcTemplate.update(sql,id);
        return "deleteUser-ok";

    }
}
