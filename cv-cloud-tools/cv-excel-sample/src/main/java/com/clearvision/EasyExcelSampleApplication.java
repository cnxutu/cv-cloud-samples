package com.clearvision;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.clearvision")
//@MapperScan("com.clearvision.*.mapper")
public class EasyExcelSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyExcelSampleApplication.class, args);
    }

}
