package com.clearvision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.clearvision")
public class ResissonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResissonApplication.class, args);
    }

}
