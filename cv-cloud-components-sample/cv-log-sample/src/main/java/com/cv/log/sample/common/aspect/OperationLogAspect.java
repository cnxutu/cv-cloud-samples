package com.cv.log.sample.common.aspect;

import cn.hutool.extra.cglib.CglibUtil;
import com.alibaba.fastjson2.JSON;
import com.cv.log.sample.common.annotation.OperationLog;
import com.cv.log.sample.common.config.UserContextHolder;
import com.cv.log.sample.dao.OperationLogMapper;
import com.cv.log.sample.pojo.dto.OperationLogDTO;
import com.cv.log.sample.pojo.po.OperationLogPO;
import com.cv.log.sample.pojo.query.LoginUserQuery;
import com.cv.log.sample.service.LogPersistService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author: xutu
 * @since: 2025/4/11 10:40
 */
@Aspect
@Component
@RequiredArgsConstructor
public class OperationLogAspect {

    private final OperationLogMapper operationLogMapper;

    @Pointcut("@annotation(operationLog)")
    public void logPointcut(OperationLog operationLog) {
    }

    @Around(value = "logPointcut(operationLog)", argNames = "joinPoint,operationLog")
    public Object around(ProceedingJoinPoint joinPoint, OperationLog operationLog) throws Throwable {
        long start = System.currentTimeMillis();

        // 初始化
        Object result = null;
        boolean success = true;
        String errorMsg = null;

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        LoginUserQuery currentUser = UserContextHolder.get();
        String ip = request.getRemoteAddr();
        String traceId = MDC.get("traceId");
        String userAgent = request.getHeader("User-Agent");
        try {
            result = joinPoint.proceed();
            return result;
        } catch (Throwable ex) {
            success = false;
            errorMsg = ex.getMessage();
            throw ex;
        } finally {
            long duration = System.currentTimeMillis() - start;

            OperationLogDTO log = OperationLogDTO.builder()
                    .userId(currentUser != null ? currentUser.getUserId() : null)
                    .username(currentUser != null ? currentUser.getUsername() : "anonymous")
                    .operation(operationLog.value())
                    .method(joinPoint.getSignature().toLongString())
                    .uri(request.getRequestURI())
                    .httpMethod(request.getMethod())
                    .ip(ip)
                    .requestParams(getParams(joinPoint))
                    .responseResult(JSON.toJSONString(result))
                    .success(success)
                    .operateTime(LocalDateTime.now())
                    .executionTime(duration)
                    .userAgent(userAgent)
                    .traceId(traceId)
                    .build();
            OperationLogPO copy = CglibUtil.copy(log, OperationLogPO.class);
            operationLogMapper.insert(copy); // 你可以改为异步写入
        }
    }

    private String getParams(ProceedingJoinPoint joinPoint) {
        try {
            return new ObjectMapper().writeValueAsString(joinPoint.getArgs());
        } catch (JsonProcessingException e) {
            return Arrays.toString(joinPoint.getArgs());
        }
    }
}
