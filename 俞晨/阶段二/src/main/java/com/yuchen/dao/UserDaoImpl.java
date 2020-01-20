package com.yuchen.dao;

import com.yuchen.entity.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
    //增加用户
    @Override
    public void addUser(User user) {
        String sql = "insert into user values(?,?,?,?)";
        this.getJdbcTemplate().update(sql, user.getId(), user.getName(),  user.getSex(),user.getAge());
    }

    //根据id删除用户
    @Override
    public void deleteUser(String id) {
        String sql = "delete from user where id = ?";
        this.getJdbcTemplate().update(sql, id);
    }

    //更新用户信息
    @Override
    public void updateUser(User user) {
        String sql = "update user set username =?,age=?,sex=? where id = ?";
        this.getJdbcTemplate().update(sql, user.getName(),  user.getSex(),user.getAge(), user.getId());
    }

    //根据id查询用户姓名
    @Override
    public String searchUserName(String id) {
        String sql = "select username from user where id = ?";
        return this.getJdbcTemplate().queryForObject(sql, String.class, id);
    }

    //根据id查询用户所有信息
    @Override
    public User searchUser(String id) {
        String sql = "select * from user where id=?";
        return this.getJdbcTemplate().queryForObject(sql, new UserRowMapper(), id);

    }


    //查询所有
    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        String sql = "select * from user";
        return this.getJdbcTemplate().query(sql, new UserRowMapper());
    }


    class UserRowMapper implements RowMapper<User> {
        //rs为返回结果集，以每行为单位封装着
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            // TODO Auto-generated method stub
            User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("username"));
            user.setAge(rs.getString("age"));
            user.setSex(rs.getString("sex"));
            return user;
        }
    }
}
