package com.guangfuxiong.factory;

import java.util.Calendar;

public class StaticFactory {
    public StaticFactory() {

    }
    public static Calendar getCalendar(){
        System.out.println("静态工厂");
        return Calendar.getInstance();
    }
}
