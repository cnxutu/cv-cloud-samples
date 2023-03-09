package com.cv.fileserversample;

/**
 * @author: xutu
 * @since: 2023/2/8 14:13
 */

@SpringBootApplication
@ServletComponentScan("com.clearvision")
//@MapperScan("com.clearvision.*.mapper")
public class FileServerSampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileServerSampleApplication.class, args);
    }
}
