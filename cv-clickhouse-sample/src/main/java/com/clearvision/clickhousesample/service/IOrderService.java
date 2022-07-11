package com.clearvision.clickhousesample.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clearvision.clickhousesample.entity.Order;
import com.clearvision.common.pojo.vo.Result;


public interface IOrderService extends IService<Order> {


    Result addColumn(String applicationName, String columnName);
}
