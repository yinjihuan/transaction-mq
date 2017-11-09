package com.cxytiandi.transaction.mq.service.test;

import org.cxytiandi.conf.client.init.SmconfInit;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.cxytiandi.transaction.mq.service.TransactionMqApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TransactionMqApplication.class)
public class TestBase {
	
	@BeforeClass
	public static void before() {
		SmconfInit.init("com.cxytiandi.transaction.mq.service.config");
	}
	
}
