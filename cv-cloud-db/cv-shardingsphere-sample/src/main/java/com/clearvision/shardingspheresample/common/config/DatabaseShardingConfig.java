package com.clearvision.shardingspheresample.common.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class DatabaseShardingConfig implements PreciseShardingAlgorithm<Long>  {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> preciseShardingValue) {

        Long value = preciseShardingValue.getValue();
        String shardingValue = String.valueOf(value);
        for (String targetName : availableTargetNames) {
            if(targetName.endsWith(shardingValue)) {
                return targetName;
            }
        }
        return null;
    }
}
