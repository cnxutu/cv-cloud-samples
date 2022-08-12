package com.clearvision.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.clearvision.common.pojo.po.BaseDO;
import lombok.Data;

import java.beans.Transient;
import java.util.Date;


@TableName("sys_qr_code_data")
@Data
public class SysQrCodeDataPO extends BaseDO {

	private static final long serialVersionUID = 1L;
	/**
	 *二维码生成年月yyyy-MM
	 */
	private String generateDate;
	/**
	 *二维码id
	 */
	private Long qrId;
	/**
	 *二维码类型
	 */
	private String type;
	/**
	 *二维码内容
	 */
	private String content;

	/**
	 * 过期时间
	 */
	private Date expireTime;
	/**
	 * 标志:type_content
	 */
//	@Transient
	private String mark;

}
