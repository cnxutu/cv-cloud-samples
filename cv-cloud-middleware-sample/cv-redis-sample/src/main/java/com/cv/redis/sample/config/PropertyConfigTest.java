package com.cv.redis.sample.config;

import com.cv.redis.config.RedisProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: xutu
 * @since: 2024/7/4 10:04
 */
@Component
@Slf4j
@Order(1)
public class PropertyConfigTest implements CommandLineRunner {

    @Autowired
    private RedisProperties redisConfig;

    @Override
    public void run(String... args) throws Exception {
        log.info("Cluster Nodes: {}, maxRedirects: {} ,Timeout: {} ", redisConfig.getCluster().getNodes(), redisConfig.getCluster().getMaxRedirects(), redisConfig.getTimeout());
    }
}
