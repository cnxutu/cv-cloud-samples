package com.clearvision.shardingspheresample.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    public List<Order> getOrder(@RequestParam("status") Integer status, @RequestParam("userId") Long userId) {
        QueryWrapper<Order> eq = Wrappers.<Order>query()
                .eq("status", status)
                .eq("user_id", userId);
        List<Order> list = orderService.list(eq);
        return list;
    }


}
