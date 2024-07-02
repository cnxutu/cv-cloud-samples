package com.cv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 描述：入口类
 *
 * @author xutu
 * @since 2022-07-05
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.cv"})
@ServletComponentScan("com.cv")
@MapperScan("com.cv.nacosfeignsample.consumer.mapper")
public class OpenFeignProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignProviderApplication.class, args);
    }
}
