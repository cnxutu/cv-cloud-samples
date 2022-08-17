//package com.clearvision.shardingspheresample.common.config;
//
//import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
//import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
//import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
//import org.apache.shardingsphere.sharding.api.config.strategy.keygen.KeyGenerateStrategyConfiguration;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//
//public final class ShardingDatabasesAndTablesConfigurationPrecise implements ExampleConfiguration {
//
//    @Override
//    public DataSource getDataSource() throws SQLException {
//        return ShardingSphereDataSourceFactory.createDataSource(createDataSourceMap(), Collections.singleton(createShardingRuleConfiguration()), new Properties());
//    }
//
//    private ShardingRuleConfiguration createShardingRuleConfiguration() {
//        ShardingRuleConfiguration result = new ShardingRuleConfiguration();
//        result.getTables().add(getOrderTableRuleConfiguration());
//        result.getTables().add(getOrderItemTableRuleConfiguration());
//        result.getBindingTableGroups().add("t_order, t_order_item");
//        result.getBroadcastTables().add("t_address");
//        result.setDefaultDatabaseShardingStrategy(new StandardShardingStrategyConfiguration("user_id", "inline"));
//        result.setDefaultTableShardingStrategy(new StandardShardingStrategyConfiguration("order_id", "standard_test_tbl"));
//        Properties props = new Properties();
//        props.setProperty("algorithm-expression", "demo_ds_${user_id % 2}");
//        result.getShardingAlgorithms().put("inline", new AlgorithmConfiguration("INLINE", props));
//        result.getShardingAlgorithms().put("standard_test_tbl", new AlgorithmConfiguration("STANDARD_TEST_TBL", new Properties()));
//        result.getKeyGenerators().put("snowflake", new AlgorithmConfiguration("SNOWFLAKE", new Properties()));
//        return result;
//    }
//
//    private ShardingTableRuleConfiguration getOrderTableRuleConfiguration() {
//        ShardingTableRuleConfiguration result = new ShardingTableRuleConfiguration("t_order", "demo_ds_${0..1}.t_order_${[0, 1]}");
//        result.setKeyGenerateStrategy(new KeyGenerateStrategyConfiguration("order_id", "snowflake"));
//        return result;
//    }
//
//    private ShardingTableRuleConfiguration getOrderItemTableRuleConfiguration() {
//        ShardingTableRuleConfiguration result = new ShardingTableRuleConfiguration("t_order_item", "demo_ds_${0..1}.t_order_item_${[0, 1]}");
//        result.setKeyGenerateStrategy(new KeyGenerateStrategyConfiguration("order_item_id", "snowflake"));
//        return result;
//    }
//
//    private Map<String, DataSource> createDataSourceMap() {
//        Map<String, DataSource> result = new HashMap<>();
//        result.put("demo_ds_0", DataSourceUtil.createDataSource("demo_ds_0"));
//        result.put("demo_ds_1", DataSourceUtil.createDataSource("demo_ds_1"));
//        return result;
//    }
//}