package com.guangfuxiong.proxy.aop.tx;

import org.springframework.stereotype.Component;

@Component("tx")
public class TransactionManage {
    public void begin(){
        System.out.println("事物开启");
    }
    public void commit(){
        System.out.println("事物提交");
    }
    public void rollback(){
        System.out.println("事物回滚");
    }
}
