package com.clearvision.clickhousesample.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clearvision.clickhousesample.entity.Order;
import com.clearvision.clickhousesample.mapper.OrderMapper;
import com.clearvision.clickhousesample.service.IOrderService;
import org.springframework.stereotype.Service;


@Service
public class OrderDaoImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
}
