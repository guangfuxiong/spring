package com.redis.service;

import com.redis.Emp;

import java.util.List;

public interface RedisService {
    void addString(String key,String value);
    void addEmp();
    List<Emp> listEmp();
    void delEmpById(String id);
    void updateEmpById(String id,Emp emp);
}
