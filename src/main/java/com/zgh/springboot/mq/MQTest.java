package com.zgh.springboot.mq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.jms.JMSException;
import javax.jms.TextMessage;

public class MQTest {
	public static void activeMQSender()  throws IOException, TimeoutException{
		ActiveMQFactory activeMQFactory = new ActiveMQFactory();
		MQConnction  connction =  activeMQFactory.CreateConnction();
		connction.sendMessage(connction.getConnection(), "Hello ActiveMQ!");
		connction.close(connction);
	}
	public static void activeMQRecieve()  throws IOException, TimeoutException{
		ActiveMQFactory activeMQFactory = new ActiveMQFactory();
		MQConnction  connction =  activeMQFactory.CreateConnction();
		Object object = connction.recieveMessage(connction.getConnection());
		TextMessage message = null;
		if(object instanceof TextMessage) {
			  message =(TextMessage) object;
		}
		try {
			System.out.println(message.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		connction.close(connction);
	}
	
	
	public static void main(String[] args) throws IOException, TimeoutException {
		activeMQSender();
//		activeMQRecieve();
	}
}
