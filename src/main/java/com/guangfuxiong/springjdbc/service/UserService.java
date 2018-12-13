package com.guangfuxiong.springjdbc.service;

import com.guangfuxiong.springjdbc.pojo.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void delUserById(int id);
    void updateUser(User user);
    List<User> findAll();
    User findUserById(int id);
}
