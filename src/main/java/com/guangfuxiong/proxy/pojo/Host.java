package com.guangfuxiong.proxy.pojo;

//房东
public class Host implements Rent{
    @Override
    public void rent(){
        System.out.println("房屋出租");
    }
    public void unlock(){

    }
}
