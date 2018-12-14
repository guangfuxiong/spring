package com.guangfuxiong.springmvc.controller;

import com.guangfuxiong.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    //跳转页面
    @RequestMapping(value = "toUser.do")
    public String toUser(){
        return "page/user";
    }
    //测试spring对象获取参数
    @RequestMapping(value = "addUser.do")
    public String addUser(Model model,String name,String password,String gender){
        model.addAttribute("msg","用户信息为："+name+password+gender);
        return "page/hello";
    }
    //测试SpringMVC自动实现对象注入
    @RequestMapping(value = "addUserToObj.do")
    public String addUserToObj(User user, Model model, String[] hobbys){
        String msg = user.toString()+hobbys.toString();
        model.addAttribute("msg",msg);
        //转发
        return "forward:page/hello";
    }
}
