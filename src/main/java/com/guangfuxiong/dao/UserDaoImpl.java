package com.guangfuxiong.dao;

import com.guangfuxiong.Pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao{
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addUser(){
        //dataSource.getConn();
        System.out.println("成功添加用户");
        //dataSource.closeConn();
    }
}
