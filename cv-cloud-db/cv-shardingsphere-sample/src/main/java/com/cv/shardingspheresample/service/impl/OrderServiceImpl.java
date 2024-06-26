package com.cv.shardingspheresample.service.impl;

import com.cv.shardingspheresample.pojo.entity.Order;
import com.cv.shardingspheresample.mapper.OrderMapper;
import com.cv.shardingspheresample.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xutu
 * @since 2022-07-22
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
