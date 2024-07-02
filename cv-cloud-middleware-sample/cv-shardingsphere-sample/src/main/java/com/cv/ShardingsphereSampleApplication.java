package com.cv;

//import org.apache.shardingsphere.shardingjdbc.orchestration.spring.boot.common.SpringBootPropertiesConfigurationProperties;
//import org.apache.shardingsphere.shardingjdbc.orchestration.spring.boot.encrypt.SpringBootEncryptRuleConfigurationProperties;
//import org.apache.shardingsphere.shardingjdbc.orchestration.spring.boot.masterslave.SpringBootMasterSlaveRuleConfigurationProperties;
//import org.apache.shardingsphere.shardingjdbc.orchestration.spring.boot.sharding.SpringBootShardingRuleConfigurationProperties;
//import org.apache.shardingsphere.spring.boot.prop.SpringBootPropertiesConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.cv")
@MapperScan("com.cv.*.mapper")
//@EnableConfigurationProperties({
////        SpringBootShardingRuleConfigurationProperties.class,
////        SpringBootMasterSlaveRuleConfigurationProperties.class,
////        SpringBootPropertiesConfigurationProperties.class,
////        SpringBootEncryptRuleConfigurationProperties.class,
////        SpringBootShadowRuleConfigurationProperties.class
//
//})
//@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class ShardingsphereSampleApplication {

//    private final SpringBootShardingRuleConfigurationProperties shardingRules;



    public static void main(String[] args) {
        SpringApplication.run(ShardingsphereSampleApplication.class, args);
    }

}
