package com.clearvision.clickhousesample.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : wh
 * @date : 2021/5/21 10:31
 * @description:
 */
@Data
@TableName("tb_order")
public class Order {


    private Integer customerId;

    private Integer buyDate;

    private String cardNo;

//    private BigDecimal payMoney;
//
//    private BigDecimal originMoney;
//
//    private String storeNo;
//
//    private String storeUserNo;
//
//    private String orderNo;
//
//    private Integer year;
//
//    private Integer month;
//
//    private Integer day;
//
//    private String payWay;
//
//    private Date createDate;
//
//    private Integer sign;
//
//    private Integer version;


}
