package com.arthur.redisproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * @author wangyd7
 * @date 2019/11/3
 * @title Jedis连接池的配置
 * */
@Slf4j
@Configuration
public class RedisConfigure {

    @Bean(name = "jedisPool")
    public JedisPool getConnect(@Value("${redis.host}") String host, @Value("${redis.port}") int port){
        JedisPool jedisPool = new JedisPool(host,port);
        log.info("获取连接===>:{}",jedisPool);
        return jedisPool;
    }

}
