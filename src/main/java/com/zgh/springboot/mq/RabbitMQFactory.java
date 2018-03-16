package com.zgh.springboot.mq;

public class RabbitMQFactory implements AbstractConnectionFactory {

	@Override
	public MQConnction CreateConnction() {
		return new RabbitMQConnection();
	}

}
