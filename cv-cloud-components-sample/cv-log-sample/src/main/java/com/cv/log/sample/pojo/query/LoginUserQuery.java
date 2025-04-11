package com.cv.log.sample.pojo.query;

import lombok.Data;

/**
 * @author: xutu
 * @since: 2025/4/11 11:16
 */
@Data
public class LoginUserQuery {
    private Long userId;
    private String username;

    public LoginUserQuery(Long userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
}
