package com.cv.clickhousesample.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cv.clickhousesample.entity.Order;
import com.cv.common.pojo.vo.Result;


public interface IOrderService extends IService<Order> {


    Result addColumn(String applicationName, String columnName);
}
