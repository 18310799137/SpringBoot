package com.zgh.springboot.mq;

public class RedisFactory implements AbstractConnectionFactory {

	@Override
	public AbstractConnection CreateConnction() {
		return new RedisConnection();
	}

}
