package com.arthur.redisproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangyd7
 * @date 2019/11/3
 * @title 控制器Controller
 *
 * */

@Slf4j
@RequestMapping("/test")
@Component
public class TestController {
    @Autowired
    private RedisClientAPI redisClientAPI;

    /**
     * 测试springboot是否搭建成功
     * */
    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        log.info("进入test方法");
        return "hello test";
    }

    /**
     * 基础API中set的使用
     * */
    @ResponseBody
    @RequestMapping("/set")
    public String set(@RequestParam("k") String k, @RequestParam("v") String v){
        redisClientAPI.set(k,v);
        return "success";
    }

    /**基础API中get的使用
     * */
    @ResponseBody
    @RequestMapping("/get")
    public String get(@RequestParam("k") String k){
        return redisClientAPI.get(k);
    }

}
