package com.cv.log.sample.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * @author: xutu
 * @since: 2025/4/11 11:29
 */

@Data
@TableName("operation_log")
public class OperationLogPO {

    @TableId(type = IdType.AUTO)
    private Long id;

    // 操作人信息
    private Long userId;

    private String username;

    // 操作内容（注解内容）
    private String operation;

    // 方法签名：com.xxx.UserService.updateUser
    private String method;

    // 请求路径 /api/user/update
    private String uri;

    // 请求方法 GET/POST
    private String httpMethod;

    // 请求方 IP
    private String ip;

    // 请求参数（JSON 格式字符串）
    private String requestParams;

    // 响应结果（JSON 格式）
    private String responseResult;

    // 是否成功
    private Boolean success;

    // 操作时间
    private LocalDateTime operateTime;

    // 执行耗时（ms）
    private Long executionTime;

    // User-Agent
    private String userAgent;

    // TraceId（MDC中获取）
    private String traceId;
}