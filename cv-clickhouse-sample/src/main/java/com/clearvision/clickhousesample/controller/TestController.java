package com.clearvision.clickhousesample.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clearvision.clickhousesample.entity.Order;
import com.clearvision.clickhousesample.service.IOrderService;
import com.clearvision.common.pojo.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class TestController {

    @Resource
    private IOrderService orderService;

    @GetMapping("/detail")
    public Result detail() {
        QueryWrapper<Order> customerId = new QueryWrapper<Order>().eq("customer_id", 123);
        Order byId = orderService.getOne(customerId);
        return Result.succeed(byId);
    }


}
