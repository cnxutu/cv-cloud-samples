package com.cv.sample.utils.guava.single;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.UncheckedExecutionException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


/**
 * @author: xutu
 * @since: 2024/7/15 10:40
 */
public class GuavaLoadingCacheUtil {

    private LoadingCache<String, Object> cache;

    // 私有构造函数，确保工具类的单实例
    private GuavaLoadingCacheUtil() {
        // 创建一个LoadingCache实例，设置过期时间为5秒，并指定CacheLoader
        cache = CacheBuilder.newBuilder()
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .build(new CacheLoader<String, Object>() {
                    @Override
                    public Object load(String key) {
                        return loadData(key);
                    }
                });
    }

    // 单实例持有者
    private static class SingletonHolder {
        private static final GuavaLoadingCacheUtil INSTANCE = new GuavaLoadingCacheUtil();
    }

    // 获取单实例
    public static GuavaLoadingCacheUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    // 放入一个值
    public void put(String key, Object value) {
        cache.put(key, value);
    }

    // 获取值，缓存未命中时自动加载
    public Object get(String key) {
        try {
            return cache.get(key);
        } catch (ExecutionException | UncheckedExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 获取值，如果不存在则返回null，不触发加载
    public Object getIfPresent(String key) {
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

    // 加载数据的方法（根据实际需求实现）
    private Object loadData(String key) {
        // 模拟加载数据的过程，可以从数据库或其他数据源加载数据
        return "LoadedDataFor_" + key;
    }

    // 示例用法
    public static void main(String[] args) {
        GuavaLoadingCacheUtil cacheUtil = GuavaLoadingCacheUtil.getInstance();

        // 尝试获取值（缓存未命中时会自动加载）
        String value = (String) cacheUtil.get("key1");
        System.out.println("Value for key1: " + value);

        // 放入一个值
        cacheUtil.put("key2", "value2");

        // 获取值（缓存命中）
        value = (String) cacheUtil.get("key2");
        System.out.println("Value for key2: " + value);

        // 等待6秒，超过过期时间
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 再次尝试获取值（缓存未命中时会自动加载）
        value = (String) cacheUtil.get("key1");
        System.out.println("Value for key1 after expiration: " + value);
    }
}


