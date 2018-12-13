package com.guangfuxiong.springjdbc.dao.impl;

import com.guangfuxiong.springjdbc.dao.UserDao;
import com.guangfuxiong.springjdbc.mapper.UserMapper;
import com.guangfuxiong.springjdbc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

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
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql,1);
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set name = ?,age = ? where id = ?";
        jdbcTemplate.update(sql,user.getName(),user.getAge(),user.getId());
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        UserMapper userMapper = new UserMapper();
        List<User> list = jdbcTemplate.query(sql,userMapper);
        return list;
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id = ?";
        UserMapper userMapper = new UserMapper();
        User user = jdbcTemplate.queryForObject(sql,userMapper,id);
        return user;
    }
}
