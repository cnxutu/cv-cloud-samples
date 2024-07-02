package com.cv.clickhouse.sample.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cv.clickhouse.sample.entity.Order;
import com.cv.clickhouse.sample.mapper.OrderMapper;
import com.cv.clickhouse.sample.service.IOrderService;
import com.cv.common.enums.ErrorCodeEnum;
import com.cv.common.exception.CustomBusinessException;
import com.cv.common.pojo.vo.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class OrderDaoImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {


    @Resource
    private OrderMapper orderMapper;

    @Override
//    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public Result addColumn(String applicationName, String columnName) {
        Integer i = orderMapper.addColumn(applicationName, columnName);
        if (i <= 0 ){
            throw new CustomBusinessException(ErrorCodeEnum.OPERATION_FAIL);
        }
        return Result.succeed(i);
    }
}
