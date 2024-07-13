package com.cv.sample.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class CvUtilsSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CvUtilsSampleApplication.class, args);
    }

}
