package com.cxytiandi.transaction.mq.api.rpc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cxytiandi.jdbc.PageQueryParam;
import com.cxytiandi.transaction.mq.api.enums.TransactionMessageStatusEnum;
import com.cxytiandi.transaction.mq.api.po.TransactionMessage;

public class TransactionMessageRpcServiceMock implements TransactionMessageRpcService {

	public boolean sendMessage(TransactionMessage message) {
		return false;
	}

	public boolean sendMessage(List<TransactionMessage> messages) {
		return false;
	}

	public boolean confirmCustomerMessage(String customerSystem, Long messageId) {
		return false;
	}

	public List<TransactionMessage> findByWatingMessage(int limit) {
		return new ArrayList<TransactionMessage>();
	}

	public boolean confirmDieMessage(Long messageId) {
		return false;
	}

	public boolean incrSendCount(Long messageId, Date sendDate) {
		return false;
	}

	public boolean retrySendDieMessage() {
		return false;
	}

	public List<TransactionMessage> findMessageByPage(PageQueryParam query, TransactionMessageStatusEnum status) {
		return new ArrayList<TransactionMessage>();
	}

}
