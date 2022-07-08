
hi, there! welcome to this area.
喜欢新技术的整合与应用，没有最好的，只有最合适的～
探索新的技术，寻求最佳实践，don't wait!   :)

# 常见技术的spring-boot集成

## 目前已完成集成案例
* spring boot + mybatis plus
    1. 支持 mybatis plus 的增删改查
    2. 支持 mybatis的分页的统一处理
    3. 支持 统一返回的 VO 实现
    4. 支持 自定义异常枚举类，及异常的全局统一处理
* spring boot + clickhouse +  druid + mybatis plus
    1. 支持 mybatis plus 对 clickhouse 的增删改查操作
  
* spring cloud + nacos + openfeign + mybatis plus
    1. nacos服务注册发现，生成者，消费者
    2. openfeign rpc调用
    3. rpc接口模块聚合（统一路径，接口统一聚合，减少代码冗余）
    
* spring boot + redissson 
    1. 进行redisson的技术集成，包括对redis常见数据类型的操作测试，即常见的 String,Hash,List等的数据类型的操作测试
    2. 添加各类型操作下的过期时间设定及 redisson的分布式自增实现类的计数操作


## 待完成集成案例
* spring cloud gateway 模块完善
* spring boot + rocketmq
* spring cloud + sentinel
* spring cloud + seata
* spring boot + redis
  * redisson 分布式锁的实现【待完善】
* spring boot + elasticsearch




