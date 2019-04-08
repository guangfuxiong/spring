package com.redis.util;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * 实现Catch接口，创建mybatis
 */
public class RedisCatchTransfer {
    public void setJedisConnectionFactory(JedisConnectionFactory  jedisConnectionFactory){
        RedisCatch.setJedisConnectionFactory(jedisConnectionFactory);
    }
}
