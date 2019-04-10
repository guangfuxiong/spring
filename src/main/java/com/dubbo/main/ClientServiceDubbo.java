package com.dubbo.main;

import com.dubbo.service.IHelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientServiceDubbo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo/spring-client.xml");
        IHelloService hs = (IHelloService)context.getBean("helloService");
        String str = hs.say("祝子");
        System.out.println("#######################################################");
        System.out.println(str);
        System.out.println("#######################################################");
    }
}
