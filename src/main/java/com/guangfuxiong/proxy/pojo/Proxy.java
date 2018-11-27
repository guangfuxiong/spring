package com.guangfuxiong.proxy.pojo;

public class Proxy implements Rent {
    Host host = new Host();
    @Override
    public void rent() {
        System.out.println("带客户看房子");
        host.rent();
        System.out.println("收取中介费");
    }
}
