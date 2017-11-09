# 分布式事务处理方案-使用消息队列达到最终一致性

本项目是基于dubbo构建的消息服务，和之前的dubbo构建微服务是一套代码 

https://github.com/yinjihuan/micro-service-dubbo

- cxytiandi-transaction-mq-api-interface dubbo 接口定义，包含实体类
- cxytiandi-transaction-mq-manager 后台管理，可以管理消息的消费情况，有无死亡消息，手动重发消息等等（还未实现）
- cxytiandi-transaction-mq-service 消息处理服务
- cxytiandi-transaction-mq-task 消息发送任务

消息表结构请参考：

https://github.com/yinjihuan/transaction-mq/blob/master/cxytiandi-transaction-mq/cxytiandi-transaction-mq-api-interface/src/main/java/com/cxytiandi/transaction/mq/api/po/TransactionMessage.java

数据库用mysql,ORM框架自己封装的：https://github.com/yinjihuan/smjdbctemplate


# 使用
注入消息队列的dubbo服务即可发送消息, 消息队列用的activemq

我们在A服务中修改信息，同时需要修改B服务中的数据，这个时候就产生分布式事务了
```
@Reference(interfaceClass = TransactionMessageRpcService.class, version = "1.0.0", check = false, mock = "true")

@Transactional(rollbackFor = Exception.class)
public void update(LouDong louDong) {
    LouDong old = super.getById("id", louDong.getId());
    super.update(louDong, "id");
		
    //发送消息，修改房号中的小区名称
    TransactionMessage message = new TransactionMessage();
    message.setQueue("fangjia.dis_name_queue");
    message.setCreateDate(new Date()); 
    message.setSendSystem(Constants.FJ_LD_SYS_NAME);
    message.setMessage(JsonUtils.toJson(
		    new UpdateHouseNameDto(louDong.getCity(), louDong.getRegion(), old.getName(), louDong.getName())
    ));
    boolean reuslt = transactionMessageRpcService.sendMessage(message);
    if (!reuslt) {
	    throw new RuntimeException("回滚事务");
    }
}

```
