package com.cv.common.enums;



public enum BusinessErrorCodeEnum implements ExceptionEnum {

    /**
     * 二维码已失效
     */
    QR_CODE_NOT_EXISTS("678","二维码已失效"),

    /**
     * 操作失败
     */
    OPERATION_FAIL("700","操作失败，请重试"),


    ;

    /**
     * 异常编码
     */
    private String code;
    /**
     * 异常消息
     */
    private String message;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    BusinessErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
