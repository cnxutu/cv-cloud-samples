package com.cv.sample.utils.guava.single;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author: xutu
 * @since: 2024/7/15 10:39
 */
public class GuavaCacheUtil {

    private Cache<String, Object> cache;

    // 私有构造函数，确保工具类的单实例
    private GuavaCacheUtil() {
        // 创建一个Cache实例，设置过期时间为5秒
        cache = CacheBuilder.newBuilder()
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .build();
    }

    // 单实例持有者
    private static class SingletonHolder {
        private static final GuavaCacheUtil INSTANCE = new GuavaCacheUtil();
    }

    // 获取单实例
    public static GuavaCacheUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    // 放入一个值
    public void put(String key, Object value) {
        cache.put(key, value);
    }

    // 获取值
    public Object get(String key) {
        return cache.getIfPresent(key);
    }

    // 删除值
    public void remove(String key) {
        cache.invalidate(key);
    }

    // 清除所有缓存
    public void clear() {
        cache.invalidateAll();
    }

    // 示例用法
    public static void main(String[] args) {
        GuavaCacheUtil cacheUtil = GuavaCacheUtil.getInstance();

        // 放入一个值
        cacheUtil.put("key", "value");

        // 获取值
        String value = (String) cacheUtil.get("key");
        System.out.println("Initial value: " + value);

        // 等待6秒，超过过期时间
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 再次尝试获取值
        value = (String) cacheUtil.get("key");
        System.out.println("Value after expiration: " + (value != null ? value : "null"));
    }
}
