package com.zgh.springboot.mq;

public class ActiveMQFactory implements AbstractConnectionFactory {

	@Override
	public MQConnction CreateConnction() {

		return new ActiveMQConnections();
	}

}
