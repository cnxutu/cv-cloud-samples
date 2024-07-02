# sharding sphere 框架集成










# shardingsphere 的坑？
1. shardingsphere 做了表的策略路由配置，但是为何不生效？
> 这个问题困扰了我两天，我这边是取自官网shardingsphere master节点下的文档及相关demo进行的项目整合，但是在将近二天的时候，依然查找不出相关问题，
> 最后，无奈之下，将pom依赖降级到 version 4，最终路由策略得到解决，主要考虑的是 版本5的情况下，进行Java的配置或更新，无法复线网上的demo，从而无法进行相关的测试，
> 故，目前还是暂且选择 version 4的版本，而非新版。
> 当然，我也从中学到了很多，了解了spring boot的数据源的装配，及shardingsphere的策略加载机制。version 5的版本还需要后期的相关调试，查出原因后，再进行更新。

**推荐博客（shardingsphere 使用配置和内核剖析）**：https://www.jianshu.com/p/c64c1f41bf8b



