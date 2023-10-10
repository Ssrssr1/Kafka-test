# Kafka Producer and Consumer
一个集合kafka生产者和消费者的功能
## 环境要求
CentOS-Stream9

## 参数设置

### 修改application.properties文件中的个人配置信息以达成互相通讯的功能
change the application.properties

## 启动本地zookeeper
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```

## 启动本地kafka-server 
```bash
bin/kafka-server-start.sh config/server.properties
```

## 在idea中运行consumer，再运行producer实现通讯目的，打印配置文件中的内容
```bash
...
15:04:51.875 [main] INFO org.apache.kafka.clients.producer.KafkaProducer -- [Producer clientId=producer-1] Instantiated an idempotent producer.
15:04:51.914 [main] INFO org.apache.kafka.clients.producer.ProducerConfig -- These configurations '[key.deserializer, value.deserializer, group.id, enable.auto.commit, auto.offset.reset]' were supplied but are not used yet.
15:04:51.917 [main] INFO org.apache.kafka.common.utils.AppInfoParser -- Kafka version: 3.5.0
15:04:51.917 [main] INFO org.apache.kafka.common.utils.AppInfoParser -- Kafka commitId: c97b88d5db4de28d
15:04:51.917 [main] INFO org.apache.kafka.common.utils.AppInfoParser -- Kafka startTimeMs: 1696748691916

Process finished with exit code 0
```