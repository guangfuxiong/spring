package com.guangfuxiong.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用,表属性状态转移来定位资源
 */
@Controller
public class RestFulController {
    @RequestMapping(value = "rest/{name}/{age}.do")
    public String rest(@PathVariable String name, @PathVariable Integer age, Model model){
        model.addAttribute("msg",name+","+age);
        return "page/hello";
    }
}
