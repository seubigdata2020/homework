package com.yuchen.dao;

import com.yuchen.entity.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);
    public void deleteUser(String id);
    public void updateUser(User user);
    public String searchUserName(String id);
    public User searchUser(String id);
    public List<User> findAll();
}
