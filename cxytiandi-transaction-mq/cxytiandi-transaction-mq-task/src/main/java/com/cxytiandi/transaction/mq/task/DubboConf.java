package com.cxytiandi.transaction.mq.task;

import org.cxytiandi.conf.client.annotation.ConfField;
import org.cxytiandi.conf.client.annotation.CxytianDiConf;

/**
 * dubbo配置信息
 * @author yinjihuan
 *
 */
@CxytianDiConf(system = "cxytiandi-transaction-mq-task", env = true, prefix = "spring.dubbo")
public class DubboConf {
	
	@ConfField("zookeeper地址")
	private String registryAddress = "zookeeper://192.168.10.47:2181";
	
	@ConfField("dubbo服务名称")
	private String applicationName = "cxytiandi-transaction-mq-task";

	public String getRegistryAddress() {
		return registryAddress;
	}

	public void setRegistryAddress(String registryAddress) {
		this.registryAddress = registryAddress;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	
}
