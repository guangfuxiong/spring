package com.guangfuxiong.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloAnnoController {
    @RequestMapping(value = "helloAnno.do")
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","注解：获取信息成功");
        modelAndView.setViewName("page/hello");
        return modelAndView;
    }
}
