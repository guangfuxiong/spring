package com.redis.controller;

import com.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedisController {
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "hello.do",method = RequestMethod.GET,produces = "application/json;utf-8")
    @ResponseBody
    public String hello(){
        return "hello，spring整合redis";
    }

    @RequestMapping(value = "addString.do")
    @ResponseBody
    public String addString(String key,String value){
        redisService.addString(key,value);
        return "成功";
    }

    @RequestMapping(value = "addEmp.do")
    @ResponseBody
    public String addString(){
        redisService.addEmp();
        return "成功";
    }
}

