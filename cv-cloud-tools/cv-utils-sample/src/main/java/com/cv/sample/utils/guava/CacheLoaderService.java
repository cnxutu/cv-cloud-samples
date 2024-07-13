package com.cv.sample.utils.guava;

import com.google.common.cache.CacheLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xutu
 * @since: 2024/7/13 10:02
 */
@Service
@Slf4j
public class CacheLoaderService extends CacheLoader<String, String> {

//    @Value("#{${data}}")
//    private Map<String, String> dataMap = new HashMap<>();


    @Value("${data.key1}")
    private String key1;

    @Value("${data.key2}")
    private String key2;


    @Override
    public String load(String key) {

        log.info("输出读取配置记录:{}", key1 + "==============" + key2);
        return "hello world!";

//        return dataMap.getOrDefault(key, "default value"); // 从配置文件加载数据
    }
}
