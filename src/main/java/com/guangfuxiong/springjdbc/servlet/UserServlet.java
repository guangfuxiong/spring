package com.guangfuxiong.springjdbc.servlet;

import com.guangfuxiong.springjdbc.pojo.User;
import com.guangfuxiong.springjdbc.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserServlet {
    @Resource
    private UserService userService;
    public void addUser(User user){
        userService.addUser(user);
    }
    public void delUserById(int id) {
        userService.delUserById(id);
    }
    public void updateUser(User user) {
        userService.updateUser(user);
    }
    public List<User> findUserAll(){
        return userService.findAll();
    }
    public User findUserById(int id){
        return userService.findUserById(id);
    }
}
