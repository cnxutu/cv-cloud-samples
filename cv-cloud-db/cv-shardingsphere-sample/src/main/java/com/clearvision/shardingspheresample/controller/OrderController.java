package com.clearvision.shardingspheresample.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.clearvision.shardingspheresample.pojo.entity.Order;
import com.clearvision.shardingspheresample.service.IOrderService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xutu
 * @since 2022-07-22
 */
@RestController
@RequestMapping("/order")
public class OrderController {


    @Resource
    private IOrderService orderService;

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public List<Order> getOrder(@RequestParam("orderId") Long orderId) {
        List<Order> list = orderService.list(Wrappers.<Order>lambdaQuery()
                .eq(Order::getOrderId, orderId)
        );
        return list;
    }


}
