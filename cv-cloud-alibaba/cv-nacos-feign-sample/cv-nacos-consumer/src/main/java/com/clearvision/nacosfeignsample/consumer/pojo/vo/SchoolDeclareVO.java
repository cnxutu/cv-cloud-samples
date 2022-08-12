package com.clearvision.nacosfeignsample.consumer.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author xutu
 * @since 2022-06-28
 */
@Data
public class SchoolDeclareVO {


    private Long id;

    /**
     * 机构名称
     */
    private String schoolName;

    /**
     * 所属地区
     */
    private String belongArea;

    /**
     * 包含学段：学段枚举记录用逗号分割
     */
    private String prefxInclude;

    /**
     * 机构类型  10-独立学校 20-集团学校  30-独立医院 40-集团医院 45-独立社会筛查机构，46-集团筛查社会机构 50-教育局 55-卫健委门
     */
    private Integer orgProperty;

    /**
     * 学校类型：10-常规，15-武校，20-体校，25-艺校，30-特殊学校，35-职高
     */
    private Integer schoolType;

    /**
     * 城乡属性：0-城市，1-乡镇
     */
    private Integer urbanRuralAttributes;

    /**
     * 学校级别：10-常规，15-市示范，16-市一级，17-市二级，20-省一级，25-省二级，30-省三级，35-省示范，40-国家级		
     */
    private Integer schoolLevel;

    /**
     * 省编号
     */
    private Integer provinceId;

    /**
     * 省名称
     */
    private String province;

    /**
     * 地市编号
     */
    private Integer cityId;

    /**
     * 地市名称
     */
    private String city;

    /**
     * 区/县编号
     */
    private Integer regionId;

    /**
     * 区县名称
     */
    private String region;

    /**
     * 学校编号
     */
    private String schoolCode;

    /**
     * 学校性质：1-集团学校，2-独立学校
     */
    private Integer schoolAttribute;

    /**
     * 学校地址
     */
    private String schoolAddress;

    /**
     * 拒绝原因
     */
    private String refuseReason;

    /**
     * 学校状态：0-待审批，1-已通过，2-已拒绝，3-已撤销
     */
    private Integer schoolDeclareState;

    /**
     * 机构经度
     */
    private String lng;

    /**
     * 机构纬度
     */
    private String lat;

    /**
     * 上报者
     */
    private Long reporter;

    /**
     * 上报时间
     */
    private LocalDateTime reportTime;

    /**
     * 上报人手机号
     */
    private String reporterPhone;

    /**
     * 备注
     */
    private String remark;

    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * 联系人手机号
     */
    private String contactPersonPhone;


    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 所属街道
     */
    private String street;

    /**
     * 所属社区
     */
    private String community;

    /**
     * 统一社会信用代码
     */
    private String socialCreditCode;

    /**
     * 是否主校区：0-否，1-是
     */
    private Integer isMainCampus;

    /**
     * 分校区社会信用代码
     */
    private String branchCampusScCode;

    /**
     * 办学类型：1-学期教育,2-初等教育,3-中等教育,4-高等教育,5-特殊教育,6-其他教育,7-幼儿园,8-小学,9-成人小学,10-普通初中,11-成人初中,12-普通高中,13-成人高中,14-中等职业学校,15-工读学校,16-普通高学校,17-成人高等学校,18-特殊教育学校,19-培养研究生的科研机构,20-民办的其他高等教育机构,21-中等职业培训机构
     */
    private Integer schoolHoldType;

    /**
     * 举办者类型：0-非民办，1-民办
     */
    private Integer organizersType;

    /**
     * 分校区所属主校区id
     */
    private Long parentId;



}
