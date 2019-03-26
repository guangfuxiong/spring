package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;

public class RedisDemo {
    //Redis服务ip
    private static String ADDR = "127.0.0.1";
    //端口
    private static int PORT = 6379;
    //访问密码
    private static String AUTH = "admin";
    //可连接实例最大数，默认值为8
    //如果赋值为-1，则表示为不限制；如果pool已分配maxActive个jedis实例，则此时pool的状态为exhausted
    private static int MAX_ACTIVE = 1024;
    //控制一个pool最多有多少个状态为idle（空闲）的jedis实例，默认值也是8
    private static int MAX_IDLE = 200;
    //等待可连接的最大时间，单位为毫秒，默认值为-1表示永不超时。如果超出等待时间，则抛出JedisConnectionException异常
    private static int MAX_WAIT = 10000;
    private static int TIMEOUT = 10000;
    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的
    private static boolean TEST_ON_BORROW = true;

    //Jedis连接池
    private static JedisPool jedisPool = null;

    //初始化Jedis连接池
    static {
        try{
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxActive(MAX_ACTIVE);
            jedisPoolConfig.setMaxIdle(MAX_IDLE);
            jedisPoolConfig.setMaxWait(MAX_WAIT);
            jedisPoolConfig.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(jedisPoolConfig,ADDR,PORT,TIMEOUT,AUTH);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //获取jedis实例，jedis对象来操作redis数据库用
    public synchronized static Jedis getJedis(){
        try{
            if(null!=jedisPool){
                Jedis jedis = jedisPool.getResource();
                return  jedis;
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    public static void main(String[] args) {
        Jedis jedis = getJedis();
        jedis.set("myJedisName","hello，Redis");
        jedis.set("first","大家好，我是第一次认识Redis");
        jedis.del("myJedisName");
        jedis.lpush("list","1","2","3","4","后进先出");
        jedis.sadd("set","张三","老二","王五","李四","无序");
        Map<Double,String> map = new HashMap<>();
        map.put(5.0,"张三");
        map.put(4.0,"老二");
        map.put(3.0,"王五");
        map.put(2.0,"李四");
        map.put(1.0,"有序");
        jedis.zadd("zset",map);
        jedis.hset("hset","name","孙悟空");

        System.out.println("字符串操作："+jedis.get("first"));
        System.out.println("列表操作list："+jedis.lrange("list",0,5));
        System.out.println("无序集合set操作："+jedis.smembers("set"));
        System.out.println("有序集合zset操作："+jedis.zrange("zset",0,5));
        System.out.println("哈希表操作："+jedis.hgetAll("hset"));
    }

}
