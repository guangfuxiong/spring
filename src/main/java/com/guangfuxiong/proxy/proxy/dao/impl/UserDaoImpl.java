package com.guangfuxiong.proxy.proxy.dao.impl;

import com.guangfuxiong.proxy.proxy.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("添加用户");
    }

    @Override
    public void updateUser() {
        System.out.println("更新用户");
    }
}
