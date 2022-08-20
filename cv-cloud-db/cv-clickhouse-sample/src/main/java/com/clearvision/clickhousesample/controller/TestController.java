package com.clearvision.clickhousesample.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clearvision.clickhousesample.entity.Order;
import com.clearvision.clickhousesample.service.IOrderService;
import com.clearvision.common.enums.ErrorCodeEnum;
import com.clearvision.common.exception.CustomBusinessException;
import com.clearvision.common.pojo.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/order")
public class TestController {


    private List<Long> longList;

    @Resource
    private IOrderService orderService;


    @Resource
    private DataSource dataSource;

    //************************************************修改clickhouse表结构操作************************************************


    @GetMapping("/addColumn")
    public Result addColumn(@RequestParam("applicationName") String applicationName, @RequestParam("columnName") String columnName,@RequestParam("columnType") String columnType) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("ALTER TABLE helloworld.tb_order  ADD COLUMN  ？ ？; ");
            preparedStatement.setString(1,columnName);
            preparedStatement.setString(2,"UInt32");
            int i = preparedStatement.executeUpdate();
            if (i <= 0){
                throw new CustomBusinessException(ErrorCodeEnum.OPERATION_FAIL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Result.succeed();

//        return orderService.addColumn(applicationName, columnName);
    }


    //************************************************单条记录的clickhouse数据操作************************************************
    @GetMapping("/detail")
    public Result detail() {
        QueryWrapper<Order> customerId = new QueryWrapper<Order>().eq("customer_id", 123);
        Order byId = orderService.getOne(customerId);
        return Result.succeed(byId);
    }


    //************************************************批量记录的clickhouse数据操作************************************************


}
