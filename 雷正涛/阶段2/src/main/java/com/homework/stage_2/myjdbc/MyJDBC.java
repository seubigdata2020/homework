package com.homework.stage_2.myjdbc;
import com.homework.stage_2.jpa.Fruit;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 传统的JDBC 访问数据库
 */
public class MyJDBC {

    private String jdbc;
    private Connection conn;
    private Statement state;


    /**
     * 关闭连接
     * @throws Exception
     */

    public void CloseConnect() throws SQLException {
        conn.close();
    }

    public MyJDBC() throws Exception {
            Class.forName("com.mysql.cj.jdbc.Driver");
        jdbc="jdbc:mysql://localhost:3306/fruit?serverTimezone=UTC";
        conn = DriverManager.getConnection(jdbc,"root","123456");
        state = conn.createStatement();
    }

    /**
     * 增加一条信息
     */
    public Fruit addOne(String name,double price,String address) throws SQLException {
       String sql_tmp = "insert into fruit(fruit_name,price,address) values(";
       String sql = sql_tmp+"'"+name+"'"+","+"'"+price+"'"+","+"'"+address+"'"+")";
       state.executeUpdate(sql);
       return findByName(name);
    }

    /**
     * 删除一条信息
     */
    public boolean deleteOne(String name) throws SQLException {
        String sql_tmp = "delete from fruit where fruit_name=";
        String sql =sql_tmp+"'"+name+"';";
        try{
            state.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * 查找一条信息
     */
    public Fruit findByName(String name) throws SQLException{
        String sql_tmp = "select * from fruit where fruit_name=";
        String sql = sql_tmp+"'"+name+"'";
        ResultSet rs = state.executeQuery(sql);
        Fruit fruit = new Fruit();
        while (rs.next()){
            fruit.setId(Integer.parseInt(rs.getString(1)));
            fruit.setFruit_name(rs.getString(2));
            fruit.setPrice(Double.parseDouble(rs.getString(3)));
            fruit.setAddress(rs.getString(4));
        }

        return fruit;
    }

    /**
     *修改一条信息
     */
    public boolean updateFruit(Integer id, String name,double price,String address) throws SQLException {
        String sql_tmp = "UPDATE fruit set ";
        String sql =sql_tmp+"fruit_name='"+name+"',"+"price='"+price+"',"+"address= '"+address+"'where id="+"'"+id+"'";
        try {
            state.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();

            return false;
        }
        return true;
    }


    /**
     * 列出所有信息
     */

    public List<Fruit> listFruit() throws SQLException {
        String sql = "select * from fruit";
        ResultSet rs = state.executeQuery(sql);
        List<Fruit> list = new ArrayList<Fruit>();
        while (rs.next()){
            Fruit fruit = new Fruit();
            String s1 = rs.getString(1);
            String s2 = rs.getString(2);
            String s3 = rs.getString(3);
            String s4 = rs.getString(4);

            fruit.setId(Integer.parseInt(s1));
            fruit.setFruit_name(s2);
            fruit.setPrice(Double.parseDouble(s3));
            fruit.setAddress(s4);
            list.add(fruit);
        }
        return list;
    }


}
