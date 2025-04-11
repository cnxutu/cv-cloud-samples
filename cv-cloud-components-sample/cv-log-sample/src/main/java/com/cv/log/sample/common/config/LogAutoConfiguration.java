//package com.cv.log.sample.common.config;
//
//import com.cv.log.sample.common.aspect.OperationLogAspect;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author: xutu
// * @since: 2025/4/11 10:45
// */
//@Configuration
//@ConditionalOnClass(OperationLogAspect.class)
//public class LogAutoConfiguration {
//
//    @Bean
//    @ConditionalOnMissingBean
//    public OperationLogAspect operationLogAspect() {
//        return new OperationLogAspect();
//    }
//
//    // 也可以在这里注入默认实现 LogPersistService
//}
