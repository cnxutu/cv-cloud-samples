package com.clearvision.pojo.query;

import lombok.Data;



@Data
public class QrCodeQuery {

    /**
     * 传参
     */
    private Object param;

    /**
     * 类型，各个业务模块自定义
     */
    private String type;

    /**
     * 失效时间，单位：秒
     */
    private Long expireTime;

}
