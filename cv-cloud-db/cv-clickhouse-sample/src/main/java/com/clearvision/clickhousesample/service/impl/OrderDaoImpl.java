package com.clearvision.clickhousesample.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clearvision.clickhousesample.entity.Order;
import com.clearvision.clickhousesample.mapper.OrderMapper;
import com.clearvision.clickhousesample.service.IOrderService;
import com.clearvision.common.enums.ErrorCodeEnum;
import com.clearvision.common.exception.CustomBusinessException;
import com.clearvision.common.pojo.vo.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
