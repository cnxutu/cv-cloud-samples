package com.cv.redis.sample.controller;

import cn.hutool.core.util.StrUtil;
import com.cv.redis.service.IRedisService;
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


    @Autowired
    private IRedisService redisService;


    /**
     * 通过key获取缓存详情，支持hkey普通key
     *
     * @param key1
     * @param key2
     * @return
     */
    @GetMapping("/detail")
    public String detail(@RequestParam("key1") String key1, @RequestParam(value = "key2", required = false) String key2) {
        if (StrUtil.isNotEmpty(key2)) {
            return (String) redisService.hget(key1, key2);
        }
        return (String) redisService.get(key1);
    }

    /**
     * 通过key删除缓存详情，支持del删除普通key
     *
     * @param key1
     * @param key2
     * @return
     */
    @GetMapping("/delete")
    public String delete(@RequestParam("key1") String key1, @RequestParam(value = "key2", required = false) String key2) {
        if (StrUtil.isNotEmpty(key2)) {
            Long hdel = redisService.hdel(key1, key2);
            if (hdel > 0) {
                return "hdel cache success!";
            } else {
                return "hdel cache fail!";
            }
        }
        Boolean del = redisService.del(key1);
        if (del) {
            return "del cache success!";
        } else {
            return "del cache fail!";
        }
    }


}
