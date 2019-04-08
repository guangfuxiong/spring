package com.redis.util;


import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RedisCatch implements Cache{

    private static JedisConnectionFactory  jedisConnectionFactory;
    private final String id;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public RedisCatch(final String id) {
        if(id==null){
            throw new IllegalArgumentException("缓存初始化需要一个ID");
        }
        this.id = id;
    }

    public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory){
        RedisCatch.jedisConnectionFactory = jedisConnectionFactory;
    }
    @Override
    public String getId() {
        return null;
    }

    @Override
    public void putObject(Object o, Object o1) {

    }

    @Override
    public Object getObject(Object o) {
        return null;
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
