package com.guangfuxiong.Pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class Food {
    @Value("${food2}")
    private String name;
    @Value("#{list}")
    private List<String> list;
    @Value("#{list}")
    private String[] array;
    @Value("#{map}")
    private Map map;

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", list=" + list +
                ", array=" + Arrays.toString(array) +
                ", map=" + map +
                '}';
    }
}
