package com.cv.pojo.vo;

import lombok.Data;

@Data
public class QrIdAndMarkByMarkSetVO {
    /**
     * 二维码id
     */
    private String qrId;
    /**
     * 标识：type_content
     */
    private String mark;
    /**
     *二维码生成年月yyyy-MM
     */
    private String generateDate;

}
