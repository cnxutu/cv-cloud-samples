package com.cv.redisson.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xutu
 * @since: 2025/3/29 17:29
 */
@RestController
@RequestMapping("/redissonSample")
public class RedissonSampleController {


    @GetMapping("/")
    public String getStr() {
        return "";
    }


}
