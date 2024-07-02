package com.cv.clickhouse.sample.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cv.clickhouse.sample.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface OrderMapper extends BaseMapper<Order> {


    @Update(" ALTER TABLE helloworld.tb_order  ADD COLUMN  #{columnName} UInt32;    ")
    Integer addColumn(@Param("applicationName") String applicationName, @Param("columnName") String columnName);



    Integer addColumnTest(@Param("applicationName") String applicationName, @Param("columnName") String columnName);
}
