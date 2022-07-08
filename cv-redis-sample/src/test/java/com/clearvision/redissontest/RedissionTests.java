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
import java.util.concurrent.TimeUnit;


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

        //1.1  stirng 添加过期时间
        RBucket<String> s2 = redissonClient.getBucket("cellphone1");
        s2.set("17855554444",60,TimeUnit.SECONDS);
        String s3 = s2.get();
        System.out.println(s3);

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

        //3.1 list 过期设定
        RBucket<List<User>> userList1 = redissonClient.getBucket("userList1");
        List<User> initList1 = new ArrayList<>();
        User user3 = new User();
        user3.setSchoolName("杭州三中");
        user3.setId(3L);
        user3.setName("小灰");
        initList1.add(user3);
        userList1.set(initList1,60,TimeUnit.SECONDS);


        //4. 自增计数器
        RAtomicLong atomicLong = redissonClient.getAtomicLong("18555509632");
        long l = atomicLong.incrementAndGet();
        System.out.println("输出类型：");
        System.out.println(l);

    }


}
