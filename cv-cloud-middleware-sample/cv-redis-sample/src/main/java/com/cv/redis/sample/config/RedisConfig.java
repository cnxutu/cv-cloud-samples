package com.cv.redis.sample.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xutu
 * @since: 2024/7/4 10:03
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {
    private String clusterNodes;
    private int timeout;

    public String getClusterNodes() {
        return clusterNodes;
    }

    public void setClusterNodes(String clusterNodes) {
        this.clusterNodes = clusterNodes;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
