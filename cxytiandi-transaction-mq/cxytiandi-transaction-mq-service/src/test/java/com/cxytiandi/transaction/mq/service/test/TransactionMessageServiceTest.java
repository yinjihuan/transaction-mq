package com.cxytiandi.transaction.mq.service.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.cxytiandi.transaction.mq.api.po.TransactionMessage;
import com.cxytiandi.transaction.mq.service.service.TransactionMessageService;

public class TransactionMessageServiceTest extends TestBase {
	
	@Autowired
	TransactionMessageService transactionMessageService;
	
	@Test
	public void testSendMessage() {
		TransactionMessage message = new TransactionMessage();
		message.setQueue("sms_queue");
		message.setMessage("hello");
		message.setSendSystem("district-service");
		message.setCreateDate(new Date());
		boolean result = transactionMessageService.sendMessage(message);
		Assert.isTrue(result);
	}
	
	@Test
	public void testFindByWatingMessage() {
		List<TransactionMessage> list = transactionMessageService.findByWatingMessage(10);
		Assert.notEmpty(list);
	}
}
