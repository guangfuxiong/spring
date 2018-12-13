package com.guangfuxiong.springjdbc.dao;

import com.guangfuxiong.springjdbc.pojo.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void delUserById(int id);
    void updateUser(User user);
    List<User> findAll();
    User findUserById(int id);
}
