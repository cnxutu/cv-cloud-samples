package com.cv.log.sample.common.config;

import com.cv.log.sample.pojo.query.LoginUserQuery;

/**
 * @author: xutu
 * @since: 2025/4/11 11:24
 */
public class UserContextHolder {

    private static final ThreadLocal<LoginUserQuery> context = new ThreadLocal<>();

    public static void set(LoginUserQuery user) {
        context.set(user);
    }

    public static LoginUserQuery get() {
        return context.get();
    }

    public static void clear() {
        context.remove();
    }
}
