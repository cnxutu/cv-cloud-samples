package com.cv.pojo.vo;

import lombok.Data;


@Data
public class QrCodeVO {

    /**
     * 二维码base64
     */
    private String imgBase64;

    /**
     * 访问地址
     */
    private String url;

}
