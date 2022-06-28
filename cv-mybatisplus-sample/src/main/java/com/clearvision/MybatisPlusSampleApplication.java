package com.clearvision;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.clearvision")
@MapperScan("com.clearvision.mybatissample.mapper")
public class MybatisPlusSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusSampleApplication.class, args);
    }

}
