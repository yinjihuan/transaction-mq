# 分布式事务处理方案-使用消息队列达到最终一致性

本项目是基于dubbo构建的消息服务，和之前的dubbo构建微服务是一套代码 https://github.com/yinjihuan/micro-service-dubbo

- cxytiandi-transaction-mq-api-interface dubbo 接口定义，包含实体类
- cxytiandi-transaction-mq-manager 后台管理，可以管理消息的消费情况，有无死亡消息，手动重发消息等等（还未实现）
- cxytiandi-transaction-mq-service 消息处理服务
- cxytiandi-transaction-mq-task 消息发送任务

消息表结构请参考：

https://github.com/yinjihuan/transaction-mq/blob/master/cxytiandi-transaction-mq/cxytiandi-transaction-mq-api-interface/src/main/java/com/cxytiandi/transaction/mq/api/po/TransactionMessage.java

数据库用mysql,ORM框架自己封装的：https://github.com/yinjihuan/smjdbctemplate


