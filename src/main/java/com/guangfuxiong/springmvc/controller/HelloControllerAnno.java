package com.guangfuxiong.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloControllerAnno {
    //针对用户输入的url-----匹配对应的方法
    @RequestMapping(value = "helloAnno.do")
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","注解-调用成功");
        modelAndView.setViewName("page/hello");
        return modelAndView;
    }
    @RequestMapping(value = "helloSpringMvc.do")
    public String helloSpringMvc(Model model){
        //用model对象来储存数据传给页面
        model.addAttribute("msg","model对象页面传值");
        return "page/hello";
    }
    //从页面中取值（get请求,若为post方法，接收参数要和html标签的name属性值一直）
    @RequestMapping(value = "args.do")
    public String args(Model model,String name,int age){//注意中文url路径乱码问题
        model.addAttribute("msg","页面传来的参数为："+name+age);
        return "page/hello";
    }
}
