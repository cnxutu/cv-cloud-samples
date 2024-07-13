package com.cv.sample.utils.guava;

import com.google.common.cache.CacheStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author: xutu
 * @since: 2024/7/13 10:03
 */
@Component
public class GuavaCommandLineRunner implements CommandLineRunner {

    @Value("${data.key1}")
    private String key1;

    @Value("${data.key2}")
    private String key2;


    @Autowired
    private GuavaCacheUtil<String, String> cacheUtil;

    @Override
    public void run(String... strings) throws Exception {
        try {
            // 存储数据
            cacheUtil.put("key1", "value1"+key1);
            cacheUtil.put("key2", "value2"+key2);

            // 获取数据
            System.out.println("Key1: " + cacheUtil.get("key1"));
            System.out.println("Key2: " + cacheUtil.get("key2"));

            // 手动存储的数据
            cacheUtil.put("key3", "manualValue3");

            // 获取手动存储的数据
            System.out.println("Key3: " + cacheUtil.get("key3"));

            // 模拟等待以观察过期行为
            TimeUnit.SECONDS.sleep(5); // 等待5秒

            // 再次获取数据，检查是否过期
            System.out.println("After 5 seconds, Key1: " + cacheUtil.getIfPresent("key1"));
            System.out.println("After 5 seconds, Key2: " + cacheUtil.getIfPresent("key2"));

            // 打印缓存统计信息
            CacheStats stats = cacheUtil.getStats();
            System.out.println("Cache Stats: " + stats);

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
