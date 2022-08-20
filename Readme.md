
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
    1. 支持 mybatis plus 对 clickhouse 的数据增删改查操作
    2. 支持 jdbc 对 clickhosue进行表结构的修改(增/删)操作
  
* spring cloud + nacos + openfeign + mybatis plus
    1. nacos服务注册发现，生成者，消费者
    2. openfeign rpc调用
    3. rpc接口模块聚合（统一路径，接口统一聚合，减少代码冗余）
    
* spring boot + redissson 
    1. 进行redisson的技术集成，包括对redis常见数据类型的操作测试，即常见的 String,Hash,List等的数据类型的操作测试
    2. 添加各类型操作下的过期时间设定及 redisson的分布式自增实现类的计数操作
    3. redisson 分布式锁的实现（基于读写锁中的write锁完成的 业务互斥锁 操作）
    4. 添加namespace工具类，即可生成redis desktop的文件夹，方便键值的归类

* spring boot + spring cloud stream rocketmq 
    1. 生产者/消费者 代码实现，topic/group 配置

* shardingsphere 集成
    1. shardingsphere-jdbc的分库分表的功能集成

* 常用 工具类
    1. easy excel 基础导入/导出 demo

## 待完成集成案例
* spring cloud gateway 模块完善
* spring cloud + sentinel
* spring cloud + seata
* spring boot + elasticsearch

* mango db 集成


* Uitls - qrcode 使用模板
* Uitls -word 使用模板


## 浅记
### nacos + feign
1. 今日组员问我，为什么你要抽出这个api的服务呢？我直接引入项目本身的依赖，不是很多rpc的方法也可以直接用了吗？ 如果单独再写下rpc的方法，如果原先已经有了是否造成代码冗余了？
> 我整理了下思路，总结一下
> 1). 微服务的模块划分本身，就是对于功能等的模块划分，即为了低耦合，写api模块，只是为了提供需要的rpc接口，这是内聚的体现，只聚合需要的rpc接口提供；
> 2). 服务启动和打包的影响，如果一个服务A依赖了其他几个服务的本体，打包后，jar包会膨胀很大，如果大家有开发经验的话，会发现一些内容较多的服务启动的时间很长，试想如果这个服务依赖了其他剩余的所有服务，这个服务的启动时间可想而知；
> 3). rpc提供的接口与服务本身的接口本不应该相互耦合，对于简单的查询，可以直接再api的实现中，通过框架进行查询返回，对于复杂的查询，需要在业务里写相应的逻辑，跟原先的服务提供接口的逻辑肯定就不尽相同，而rpc的本身的逻辑，也不应与服务自身的接口复用接口，形成耦合。
总结：最简单的学习，应该就是多问为什么？体会设计者的初衷，从而更好的在未来的场景中更好的运用既得的知识技术。




