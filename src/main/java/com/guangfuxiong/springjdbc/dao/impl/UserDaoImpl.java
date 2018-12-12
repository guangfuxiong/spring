package com.guangfuxiong.springjdbc.dao.impl;

import com.guangfuxiong.springjdbc.dao.UserDao;
import com.guangfuxiong.springjdbc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserDaoImpl implements UserDao{
    @Resource(name = "jdbcTemplate_spring")
    private JdbcTemplate jdbcTemplate;
    @Override
    public void addUser(User user) {
        String sql = "insert into user values (null,?,?)";
        jdbcTemplate.update(sql,user.getName(),user.getAge());
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
