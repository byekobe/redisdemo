package com.arthur.redisproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import javax.annotation.Resource;

/**
 * @author wangyd7
 * @date 2019/11/3
 * @title redis的基础api使用
 * */
@Component
@Slf4j
public class RedisClientAPI {
    @Resource(name = "jedisPool")
    private JedisPool jedisPool;
    private String password = "123456";

    public void set(String k,String v){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.auth(password);
            log.info("进入redisAPI的set===>:{}",jedis);
            jedis.set(k,v);
        } finally {
            if(jedis != null){
                jedis.close();
            }
        }
    }

    public String get(String k){
        Jedis jedis = null;
        String val;
        try {
            jedis = jedisPool.getResource();
            jedis.auth(password);
            val = jedis.get(k);
            log.info("进入redisAPI的get===>:{}",jedis);
        } finally {
            if(jedis != null){
                jedis.close();
            }
        }
        return val;
    }
}
