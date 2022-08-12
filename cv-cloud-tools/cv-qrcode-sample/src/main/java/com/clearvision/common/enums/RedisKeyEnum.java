package com.clearvision.common.enums;

import cn.hutool.core.date.DateUtil;

import java.util.Date;


public interface RedisKeyEnum {


    /*****************************************二维码开始**************************************************/


    /**
     * 二维码存储的命名空间
     */
    String QR_CODE_NAMESPACE="qr_code";

    /**
     * 二维码存储的命名空间
     */
    String QR_CODE_LIST_NAMESPACE = "qr_code_list";

    /**
     * 二维码redis key，yyyyMM_type
     */
    String QR_CODE_KEY= DateUtil.format(new Date(),"yyyyMM");

    /**
     * 二维码里的url redis key
     */
    String QR_CODE_ENCODE_URL_KEY="health_qr_code_encode_url";

    /**
     * 二维码失效时间
     */
    String QR_CODE_EXPIRE_TIME_KEY="qr_code_expire_time";

    /**
     * 二维码token
     */
    String QR_CODE_TOKEN_KEY="qr_code_token";

    /*****************************************二维码结束**************************************************/

}
