package com.guangfuxiong.springSSM.service.impl;

import com.guangfuxiong.springSSM.dao.UserDao;
import com.guangfuxiong.springSSM.entity.User;
import com.guangfuxiong.springSSM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
