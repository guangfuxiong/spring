package com.guangfuxiong.springjdbc.service.impl;

import com.guangfuxiong.springjdbc.dao.UserDao;
import com.guangfuxiong.springjdbc.pojo.User;
import com.guangfuxiong.springjdbc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
        userDao.delUserById(id);
    }

    @Override
    public void updateUser(User user) {
       userDao.updateUser(user);
    }

    @Override
    public List<User> findAll() {
        List<User> list = userDao.findAll();
        int a = 1/0;
        return list;
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }
}
