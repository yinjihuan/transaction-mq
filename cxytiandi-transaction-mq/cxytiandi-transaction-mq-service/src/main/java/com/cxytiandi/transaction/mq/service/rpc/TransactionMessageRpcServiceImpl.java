package com.cxytiandi.transaction.mq.service.rpc;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.dubbo.config.annotation.Service;
import com.cxytiandi.jdbc.PageQueryParam;
import com.cxytiandi.transaction.mq.api.enums.TransactionMessageStatusEnum;
import com.cxytiandi.transaction.mq.api.po.TransactionMessage;
import com.cxytiandi.transaction.mq.api.rpc.TransactionMessageRpcService;
import com.cxytiandi.transaction.mq.service.service.TransactionMessageService;

@Component("TransactionMessageRpcService")
@Service(interfaceClass = TransactionMessageRpcService.class, version = "1.0.0", timeout = 5000)
public class TransactionMessageRpcServiceImpl implements TransactionMessageRpcService {
	
	@Autowired
	private TransactionMessageService transactionMessageService;
	
	@Override
	public boolean sendMessage(TransactionMessage message) {
		return transactionMessageService.sendMessage(message);
	}

	@Override
	public boolean sendMessage(List<TransactionMessage> messages) {
		return transactionMessageService.sendMessage(messages);
	}

	@Override
	public boolean confirmCustomerMessage(String customerSystem, Long messageId) {
		return transactionMessageService.confirmCustomerMessage(customerSystem, messageId);
	}

	@Override
	public List<TransactionMessage> findByWatingMessage(int limit) {
		return transactionMessageService.findByWatingMessage(limit);
	}

	@Override
	public boolean confirmDieMessage(Long messageId) {
		return transactionMessageService.confirmDieMessage(messageId);
	}

	@Override
	public boolean incrSendCount(Long messageId, Date sendDate) {
		return transactionMessageService.incrSendCount(messageId, sendDate);
	}

	@Override
	public boolean retrySendDieMessage() {
		return transactionMessageService.retrySendDieMessage();
	}

	@Override
	public List<TransactionMessage> findMessageByPage(PageQueryParam query, TransactionMessageStatusEnum status) {
		return transactionMessageService.findMessageByPage(query, status);
	}

}
