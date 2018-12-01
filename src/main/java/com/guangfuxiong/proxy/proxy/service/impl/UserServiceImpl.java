package com.guangfuxiong.proxy.proxy.service.impl;

import com.guangfuxiong.proxy.proxy.dao.UserDao;
import com.guangfuxiong.proxy.proxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("target")
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    @Override
    public void addUser() {
        userDao.addUser();
    }

    @Override
    public void updateUser() {
        userDao.updateUser();
    }
}
