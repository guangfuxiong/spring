package com.guangfuxiong.springmvc.controller;

import com.guangfuxiong.springmvc.pojo.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


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
    //测试SpringMVC自动实现对象注入(表单提交)
    @RequestMapping(value = "addUserToObj.do")
    public String addUserToObj(Model model, String[] hobbys, User user){
        String msg = Arrays.toString(hobbys)+user.toString();
        model.addAttribute("msg",msg);
        //转发
        return "forward:toHello.do";
    }
    //转发至首页
    @RequestMapping(value = "toHello.do")
    public String toHello(){
        return "page/hello";
    }
    //初始化绑定，mvc可以自动的将指定日期格式封装为:2017/5/16这样的日期（只有这样的格式Date类才能默认解析）.
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyyMMdd"),true));
    }
}
