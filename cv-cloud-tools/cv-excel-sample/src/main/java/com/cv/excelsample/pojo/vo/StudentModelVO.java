package com.cv.excelsample.pojo.vo;

import lombok.Data;

@Data
public class StudentModelVO {

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 出生日期
     */
    private String birth;


    /**
     * 身份证证件号
     */
    private String idcard;


    /**
     * 民族
     */
    private String nationality;

    /**
     * 家庭住址
     */
    private String familyAddress;

    /**
     * 家长姓名
     */
    private String parentName;

    /**
     * 家长手机
     */
    private String parentPhone;


}
