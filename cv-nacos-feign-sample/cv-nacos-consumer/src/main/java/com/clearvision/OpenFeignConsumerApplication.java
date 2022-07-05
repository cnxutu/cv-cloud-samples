package com.clearvision;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 描述：入口类
 *
 * @author ay
 * @since 2020-07-24
 */
@EnableDiscoveryClient
@SpringBootApplication
@ServletComponentScan("com.clearvision")
@EnableFeignClients(basePackages = {"com.clearvision"})
public class OpenFeignConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignConsumerApplication.class, args);
    }
}
