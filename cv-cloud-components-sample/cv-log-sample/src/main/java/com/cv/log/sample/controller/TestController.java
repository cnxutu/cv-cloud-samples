package com.cv.log.sample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xutu
 * @since: 2025/4/17 14:32
 */
@RestController
@Slf4j
public class TestController {


    @GetMapping("/ok")
    public String test() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            log.error("some err msg:", e);
        }

        return "ok";
    }

}
