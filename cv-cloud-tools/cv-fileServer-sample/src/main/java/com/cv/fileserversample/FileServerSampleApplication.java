package com.cv.fileserversample;

/**
 * @author: xutu
 * @since: 2023/2/8 14:13
 */

@SpringBootApplication
@ServletComponentScan("com.cv")
//@MapperScan("com.cv.*.mapper")
public class FileServerSampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileServerSampleApplication.class, args);
    }
}
