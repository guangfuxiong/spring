package com.guangfuxiong.springjdbc.service.impl;

import com.guangfuxiong.springjdbc.dao.UserDao;
import com.guangfuxiong.springjdbc.pojo.User;
import com.guangfuxiong.springjdbc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void delUserById(int id) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void findAll() {

    }

    @Override
    public void findUserById() {

    }
}
