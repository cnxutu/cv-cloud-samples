package com.clearvision.pojo.query;

import lombok.Data;

import java.util.List;



@Data
public class QrCodeBatchQuery {

    /**
     * 传参，多个
     */
    private List<Object> paramList;

    /**
     * 类型，各个业务模块自定义
     */
    private String type;

}
