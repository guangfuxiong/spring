package com.guangfuxiong.service;

import com.guangfuxiong.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
    UserDaoImpl userDao;

    public UserDaoImpl getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser() {
        userDao.addUser();
    }
}
