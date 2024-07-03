package com.cv.redis.sample.controller;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author: xutu
 * @since: 2024/7/3 17:07
 */
@RequestMapping("/sample/redis")
public class RedisController {


//    @Autowired
//    private CacheTemplate redisService;
//
//
//    @GetMapping("/detail")
//    public String detail(@RequestParam("key1") String key1, @RequestParam(value = "key2",required = false) String key2) {
//        if (StrUtil.isNotEmpty(key2)) {
//            Object o = (String)redisTemplate.boundHashOps(key1).get(key2);
//        }
//
//
//    }


}
