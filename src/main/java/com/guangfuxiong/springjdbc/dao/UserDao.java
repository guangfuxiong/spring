package com.guangfuxiong.springjdbc.dao;

import com.guangfuxiong.springjdbc.pojo.User;

public interface UserDao {
    void addUser(User user);
    void delUserById(int id);
    void updateUser(User user);
    void findAll();
    void findUserById();
}
