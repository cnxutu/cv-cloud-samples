package com.cv.nacosfeignsample.consumer.pojo.query;

import com.cv.common.pojo.query.PageQuery;

import javax.validation.constraints.NotNull;

public class TestQuery extends PageQuery {


    @NotNull(message = "参数1不能为空！")
    private Integer param1;
}
