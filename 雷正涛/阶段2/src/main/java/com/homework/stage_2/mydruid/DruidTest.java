package com.homework.stage_2.mydruid;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DruidTest {
    private static DruidDataSource dds;
    //静态代码块
    static{
        dds = new DruidDataSource();
        //获取url
        dds.setUrl("jdbc:mysql://localhost:3306/fruit?useUnicode=true&characterEncoding=utf-8");
        //获取用户名
        dds.setUsername("root");
        //获取密码
        dds.setPassword("123456");
    }
    public static DataSource getDBDS(){
        //返回dds
        return dds;
    }
    public static Connection getConn(){
        try {
            return dds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
