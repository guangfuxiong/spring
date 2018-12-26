package com.guangfuxiong.mybaits.pojo;

import java.util.List;

public interface UserMapper {
    public List<User> findAll();
    public User findUserByName(String name);
}
