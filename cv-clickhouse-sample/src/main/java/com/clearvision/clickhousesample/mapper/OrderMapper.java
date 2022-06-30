package com.clearvision.clickhousesample.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clearvision.clickhousesample.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
