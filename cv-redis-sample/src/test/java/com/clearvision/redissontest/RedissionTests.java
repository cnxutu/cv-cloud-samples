package com.clearvision.redissontest;


import org.junit.jupiter.api.Test;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.interceptor.SimpleKey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


@SpringBootTest
class RedissionTests {



    @Autowired
    private RedissonClient redissonClient;

    @Test
    void contextLoads() {

        //1. stirng
        RBucket<String> s1 = redissonClient.getBucket("cellphone");
        s1.set("17855554444");
        String s = s1.get();
        System.out.println(s);

        //2. hash
        RMap<String, String> school = redissonClient.getMap("school_id");
        school.put("class_id","王炸班");
        String className = school.get("class_id");
        System.out.println("输出班级名称：");
        System.out.println(className);

        //3. list
        RBucket<List<User>> userList = redissonClient.getBucket("userList");
        List<User> initList = new ArrayList<>();
        User user1 = new User();
        user1.setSchoolName("杭州二中");
        user1.setId(1L);
        user1.setName("小王");
        User user2 = new User();
        user2.setSchoolName("杭州二中");
        user2.setId(1L);
        user2.setName("小王");
        initList.add(user1);
        initList.add(user2);
        userList.set(initList);
        System.out.println("输出用户列表信息：");

        List<User> users = userList.get();
        users.forEach(System.out::println);



    }



}
