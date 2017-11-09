package com.cxytiandi.transaction.mq.service;

import java.util.concurrent.CountDownLatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.cxytiandi.transaction.mq.service.listener.ApplicationListenerStarted;

/**
 * 可靠事务消息服务启动入口
 * @author yinjihuan
 *
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
public class TransactionMqApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionMqApplication.class);
	
	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(TransactionMqApplication.class).web(false).listeners(new ApplicationListenerStarted()).run(args);
        try {
        	 new CountDownLatch(1).await();
		} catch (InterruptedException e) {
			LOGGER.error("项目启动异常", e);
		}
	}
	
}
