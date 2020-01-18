package com.homework.stage_2.mydruid;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 使用连接池的方式访问数据库
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyDruid {
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
        System.out.println("dataSource: " + dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println("connection: " + connection);
        connection.close();
    }

}
