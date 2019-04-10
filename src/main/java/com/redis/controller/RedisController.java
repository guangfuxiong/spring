package com.redis.controller;

import com.redis.Emp;
import com.redis.RetResult;
import com.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping(value = "listEmp.do")
    @ResponseBody
    public RetResult listEmp(){
        List<Emp> list = redisService.listEmp();
        RetResult retResult = new RetResult();
        retResult.setMsg("查询成功");
        retResult.setSuccess("1");
        retResult.setObject(list);
        System.out.println(retResult);
        return retResult;
    }

    @RequestMapping(value = "delEmpById.do")
    @ResponseBody
    public String delEmpById(String id){
        redisService.delEmpById(id);
        return "成功";
    }

    @RequestMapping(value = "updateEmpById.do")
    @ResponseBody
    public String updateEmpById(String id,String name,String age,String adress){
        Emp emp = new Emp();
        emp.setId(6);
        emp.setAddress(adress);
        emp.setAge(Integer.parseInt(age));
        emp.setName(name);
        redisService.updateEmpById(id,emp);
        return "成功";
    }
}

