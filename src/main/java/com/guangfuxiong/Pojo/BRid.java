package com.guangfuxiong.Pojo;

import org.springframework.stereotype.Component;

@Component(value = "bird")
public class BRid {
    public void flying(){
        System.out.println("鸟儿飞翔");
    }
}
