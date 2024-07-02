package com.cv.clickhouse.sample.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cv.clickhouse.sample.entity.Order;
import com.cv.common.pojo.vo.Result;


public interface IOrderService extends IService<Order> {


    Result addColumn(String applicationName, String columnName);
}
