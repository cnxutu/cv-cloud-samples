package com.cv.excelsample.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author xutu
 * @since 2022-08-04
 */
@TableName("tb_student_base")
@Data
public class StudentBaseDO implements Serializable {


    private Long id;


    private static final long serialVersionUID = 1L;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 出生日期
     */
    private String birth;

    /**
     * 性别：1-男，2-女，0-未知
     */
    private Integer sex;

    /**
     * 所属区域：1-内地，2-非内地，0-未知
     */
    private Integer belongArea;

    /**
     * Idcard类型：1-居民身份证,6-香港特区护照,7-澳门特区护照,8-台湾居民来往大陆通行证,9-境外永久居住证
     */
    private Integer idcardType;

    /**
     * 身份证证件号
     */
    private String idcard;

    /**
     * 学籍号码
     */
    private Integer registerNumber;

    /**
     * 籍贯
     */
    private String nativePlace;

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
