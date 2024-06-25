package com.cv.common.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.extra.qrcode.QrCodeUtil;

public class QRUtil {

    /**
     * 获取转为base64的二维码
     * @param content 需要放入二维码的内容
     * @return base64
     */
    public static String getBase64QrCode(String content){
        byte[] bytes = QrCodeUtil.generatePng(content, 300, 300);
        return toBase64(bytes);
    }

    private static String toBase64(byte[] bytes) {
        String encode = Base64.encode(bytes);
        return "data:image/png;base64,"+encode;
    }

}
