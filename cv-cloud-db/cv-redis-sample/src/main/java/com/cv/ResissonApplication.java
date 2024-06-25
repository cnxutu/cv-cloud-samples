package com.cv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.cv")
public class ResissonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResissonApplication.class, args);
    }

}
