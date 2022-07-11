package com.clearvision.redissontest;


import org.junit.jupiter.api.Test;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.interceptor.SimpleKey;

import java.util.*;
import java.util.concurrent.*;


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

        //5. 基于redisson 的互斥锁的分布式锁实现

        ExecutorService executorService = Executors.newCachedThreadPool();
        //多线程测试
        for (int i = 0; i < 6; i++) {
            executorService.submit(new ThreadTest());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("=============================");

        // 互斥锁测试
        for (int i = 0; i < 5; i++) {
            executorService.submit(new MultipleThreadsRunTest());
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(20000);
            System.out.println("主程序结束...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    class ThreadTest implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"多线程开始....");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"多线程结束....");
        }
    }



    class MultipleThreadsRunTest implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+ " 线程开始... ");
            RReadWriteLock readWriteLock = redissonClient.getReadWriteLock("rw-lock");
            try {
                boolean b1 = readWriteLock.writeLock().tryLock(1, 5, TimeUnit.SECONDS);
                if (b1){
                    System.out.println(Thread.currentThread().getName()+ " 读取锁成功... ");
                    Thread.sleep(4000);
                }else {
                    System.out.println(Thread.currentThread().getName()+ " 读取锁失败... ");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName() + " 线程结束，准备释放锁... ");
                readWriteLock.writeLock().unlock();
            }

        }
    }

}
