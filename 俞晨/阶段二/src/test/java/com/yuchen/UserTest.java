package com.yuchen;

import com.yuchen.dao.UserDao;
import com.yuchen.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用jdbc进行增删改查的单元测试
 */
public class UserTest {
    @Test
    public void  testaddUser(){
        User user = new User();
        user.setId("4");
        user.setName("刘磊");
        user.setSex("男");
        user.setAge("24");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = (UserDao) ctx.getBean("userDao");
        dao.addUser(user);
    }

    @Test
    public void testdeleteUser(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = (UserDao) ctx.getBean("userDao");
        dao.deleteUser("4");
    };

    @Test
    public void testupdateUser(){
        User user = new User();
        user.setId("4");
        user.setName("刘磊");
        user.setSex("男");
        user.setAge("25");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = (UserDao) ctx.getBean("userDao");
        dao.updateUser(user);
    };
    @Test
    public void testsearchUserName(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = (UserDao) ctx.getBean("userDao");
        String  username = dao.searchUserName("2");
        System.out.println(username);
    };
    @Test
    public void testsearchUser(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = (UserDao) ctx.getBean("userDao");
        User  u = dao.searchUser("2");

        System.out.println(u.toString());

    };
    @Test
    public void testfindAll(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = (UserDao) ctx.getBean("userDao");
        List<User> u = dao.findAll();
        for (User user : u) {
            System.out.println(user.toString());
        }

    };

}
