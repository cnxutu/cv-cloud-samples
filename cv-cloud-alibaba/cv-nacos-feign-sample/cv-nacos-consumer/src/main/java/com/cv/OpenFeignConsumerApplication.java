package com.cv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author xutu
 * @since 2022-07-05
 */
@EnableDiscoveryClient
@SpringBootApplication
@ServletComponentScan("com.cv")
@EnableFeignClients(basePackages = {"com.cv"})
public class OpenFeignConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignConsumerApplication.class, args);
    }
}
