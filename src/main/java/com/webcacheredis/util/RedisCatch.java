package com.webcacheredis.util;


import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.exceptions.JedisConnectionException;

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

    /**
     * 获取缓存对象的唯一标识
     * @return
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * 保存key/value到缓存对象中
     * key可以是任何对象，但一般是CacheKey对象
     * value是查询结果，为List类型
     * @param key
     * @param value
     */
    @Override
    public void putObject(Object key, Object value) {
        JedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> redisSerializer = new JdkSerializationRedisSerializer();
            connection.set(redisSerializer.serialize(key),redisSerializer.serialize(value));
        }catch (JedisConnectionException e){
            e.printStackTrace();
        }finally {
            if(connection != null){
                connection.close();
            }
        }
    }

    /**
     * 从缓存对象中获取key对应的value
     * @param
     * @return
     */
    @Override
    public Object getObject(Object key) {
        Object result = null;
        JedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> redisSerializer = new JdkSerializationRedisSerializer();
            result = redisSerializer.deserialize(connection.get(redisSerializer.serialize(key)));
        }catch (JedisConnectionException e){
            e.printStackTrace();
        }finally {
            if(connection != null){
                connection.close();
            }
        }
        return result;
    }

    /**
     * 可选的方法，没有被核心框架调用，移除key对应的value
     * @param
     * @return
     */
    @Override
    public Object removeObject(Object key) {
        Object result = null;
        JedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> redisSerializer = new JdkSerializationRedisSerializer();
            result = connection.expire(redisSerializer.serialize(key),0);//设置缓存的生存事件，0则表示立即删除
        }catch (JedisConnectionException e){
            e.printStackTrace();
        }finally {
            if(connection != null){
                connection.close();
            }
        }
        return result;
    }

    /**
     * 清空缓存
     */
    @Override
    public void clear() {
        JedisConnection connection = null;
        try
        {
            connection = jedisConnectionFactory.getConnection();
            connection.flushDb();
        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * 获取缓存对象中存储的键/值对的数量
     * 可选的方法，没有被框架核心调用
     * @return
     */
    @Override
    public int getSize() {
        int result = 0;
        JedisConnection connection = null;
        try
        {
            connection = jedisConnectionFactory.getConnection();
            result = Integer.valueOf(connection.dbSize().toString());
        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

    /**
     * 获取读写锁
     * 可选的方法，从3.2.6起这个方法不再被框架核心调用
     * 任何需要的锁，都必须由缓存供应商提供
     * @return
     */
    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }
}
