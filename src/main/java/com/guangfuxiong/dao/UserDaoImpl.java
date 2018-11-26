package com.guangfuxiong.dao;

import com.guangfuxiong.Pojo.User;

public class UserDaoImpl implements UserDao{
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addUser(){
        System.out.println("成功添加用户");
    }
}
