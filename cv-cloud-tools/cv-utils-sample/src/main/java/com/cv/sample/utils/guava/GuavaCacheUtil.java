package com.cv.sample.utils.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author: xutu
 * @since: 2024/7/13 10:01
 */
@Component
public class GuavaCacheUtil<K, V> {

    private final LoadingCache<K, V> cache;

    @Autowired
    public GuavaCacheUtil(CacheLoader<K, V> cacheLoader) {
        this.cache = CacheBuilder.newBuilder()
//                .expireAfterWrite(100, TimeUnit.MINUTES) // 设置写入后100分钟过期
                .expireAfterWrite(4, TimeUnit.SECONDS) // 设置写入后100分钟过期
                .maximumSize(1000) // 设置缓存的最大条目数
                .recordStats() // 记录缓存统计信息
                .build(cacheLoader);
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public V get(K key) throws ExecutionException {
        return cache.get(key);
    }

    public V getIfPresent(K key) {
        return cache.getIfPresent(key);
    }

    public CacheStats getStats() {
        return cache.stats();
    }
}

