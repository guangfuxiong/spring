package com.redis.service;

import com.redis.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate redisTemplate;
    private static Integer id = 0;

    @Override
    public void addString(String key, String value) {
        redisTemplate.opsForValue().append(key,value);
    }

    @Override
    public void addEmp(){
        Emp emp = new Emp();
        emp.setId(++id);
        emp.setName("孙广才");
        emp.setAddress("南门");
        emp.setAge(54);
        redisTemplate.opsForHash().put("emp",id.toString(),emp);
    }

    @Override
    public List<Emp> listEmp() {
        System.out.println("#############################################################");
        //System.out.println(redisTemplate.opsForHash().get("emp","emp-map1"));
        List<Emp> list =  redisTemplate.opsForHash().values("emp");
        System.out.println(list);
        System.out.println("#############################################################");
        return  list;
    }




    @Override
    public void delEmpById(String id){
        redisTemplate.opsForHash().delete("emp",id);
    }

    @Override
    public void updateEmpById(Emp emp) {
        redisTemplate.opsForHash().put("emp",emp.getId().toString(),emp);
    }

    @Override
    public void updateEmpById(String id, Emp emp) {
        redisTemplate.opsForHash().put("emp",id,emp);
    }
}
