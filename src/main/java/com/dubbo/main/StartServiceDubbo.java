package com.dubbo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class StartServiceDubbo {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo/spring-registry.xml");
        context.start();
        System.out.println("服务者提供者启动（按任意键退出或者在console窗口中停止）");
        System.in.read();
        System.out.println("已退出：");
    }
}
