package com.zgh.springboot.mq;

public interface MQConnction extends AbstractConnection {

	void sendMessage(Object connection,Object message);
	
	Object recieveMessage(Object connection);
}
