package com.guangfuxiong.springjdbc.service;

import com.guangfuxiong.springjdbc.pojo.User;

public interface UserService {
    void addUser(User user);
    void delUserById(int id);
    void updateUser(User user);
    void findAll();
    void findUserById();
}
