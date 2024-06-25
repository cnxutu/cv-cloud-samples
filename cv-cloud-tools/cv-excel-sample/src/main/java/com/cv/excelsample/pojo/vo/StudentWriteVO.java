package com.cv.excelsample.pojo.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class StudentWriteVO {

    /**
     * 学生姓名
     */
    @ExcelProperty("学生姓名")
    private String studentName;

    /**
     * 出生日期
     */
    @ExcelProperty("出生日期")
    private String birth;


    /**
     * 身份证证件号
     */
    @ExcelProperty("身份证证件号")
    private String idcard;


    /**
     * 民族
     */
    @ExcelProperty("民族")
    private String nationality;

    /**
     * 家庭住址
     */
    @ExcelProperty("家庭住址")
    private String familyAddress;

    /**
     * 家长姓名
     */
    @ExcelProperty("家长姓名")
    private String parentName;

    /**
     * 家长手机
     */
    @ExcelProperty("家长手机")
    private String parentPhone;


}
