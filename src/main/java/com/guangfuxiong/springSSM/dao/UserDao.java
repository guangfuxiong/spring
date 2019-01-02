package com.guangfuxiong.springSSM.dao;

import com.guangfuxiong.springSSM.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
    List<User> findAll();
}
