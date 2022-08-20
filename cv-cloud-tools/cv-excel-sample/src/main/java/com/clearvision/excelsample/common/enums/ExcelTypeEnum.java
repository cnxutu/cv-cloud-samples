package com.clearvision.excelsample.common.enums;


/**
 * @author xutu
 * @date 2022/08/04
 */
public enum ExcelTypeEnum {

    /**
     * 学生数据信息导入
     */
    STUDNET_INFO_IMPORT(0, "学生数据信息导入"),


    ;

    ExcelTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    /**
     * 获得枚举
     */
    public static ExcelTypeEnum getEnumByStatus(Integer value) {
        if (null != value) {
            for (ExcelTypeEnum activitie : ExcelTypeEnum.values()) {
                if (value.equals(activitie.getCode())) {
                    return activitie;
                }
            }
        }
        return null;
    }

    public static String getMsgByCode(Integer code) {
        if (null!=code) {
            for (ExcelTypeEnum activitie : ExcelTypeEnum.values()) {
                if (code.equals(activitie.code)) {
                    return activitie.getMessage();
                }
            }
        }
        return null;
    }

    /**
     * 异常编码
     */
    private Integer code;
    /**
     * 异常消息
     */
    private String message;

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
