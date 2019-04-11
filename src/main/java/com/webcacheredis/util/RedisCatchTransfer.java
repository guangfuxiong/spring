package com.webcacheredis.util;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * 实现Catch接口，创建mybatis二级缓存实现类
 * 本质上讲，就是是要利用第三方非关系型数据库（如：redis）实现缓存功能
 */
public class RedisCatchTransfer {

    public void setJedisConnectionFactory(JedisConnectionFactory  jedisConnectionFactory){
        RedisCatch.setJedisConnectionFactory(jedisConnectionFactory);
    }
}
