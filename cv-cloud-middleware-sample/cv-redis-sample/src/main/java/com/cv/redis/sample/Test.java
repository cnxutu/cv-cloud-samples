package com.cv.redis.sample;

import cn.hutool.core.util.StrUtil;

/**
 * @author: xutu
 * @since: 2024/7/3 13:20
 */
public class Test {
    public static void main(String[] args) {
        String a = "63F71wwSS";
        String b = "63f71wwss";
        boolean b1 = StrUtil.equalsIgnoreCase(a, b);
        if (b1) {
            System.out.println("ok");
        } else {
            System.out.println("not ok");
        }

    }
}
