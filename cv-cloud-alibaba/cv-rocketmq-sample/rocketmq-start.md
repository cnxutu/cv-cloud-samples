

# Rocketmq Start

## Start Name Server
>nohup sh bin/mqnamesrv &


## Start Broker
>sh mqbroker -n localhost:9876  -c ../conf/broker.conf


## Start Dashboard
> java -jar rocketmq-dashboard-1.0.1-SNAPSHOT.jar —server.port=12581 —rocketmq.config.namesrvAddr=127.0.0.1:9876