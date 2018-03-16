package com.zgh.springboot.mq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQConnections implements MQConnction {
	private static final int SEND_NUMBER = 5;

	@Override
	public Object getConnection() {
		ConnectionFactory connectionFactory; // ConnectionFactory--连接工厂，JMS用它创建连接
		// Provider 的连接
		Connection connection = null; // Connection ：JMS 客户端到JMS
		// 构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar
		connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
		try { // 构造从工厂得到连接对象
			connection = connectionFactory.createConnection();

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return connection;
	}

	public static void sendMessage(Session session, MessageProducer producer, Object messages) throws Exception {
		for (int i = 1; i <= SEND_NUMBER; i++) {
			TextMessage message = session.createTextMessage(messages + " : " + i);
			// 发送消息到目的地方
			System.out.println("发送消息：" + message.getText());
			producer.send(message);
		}
	}

	@Override
	public Object recieveMessage(Object connections) {
		// Connection ：JMS 客户端到JMS Provider 的连接
		Connection connection = null;
		// Session： 一个发送或接收消息的线程
		Session session;
		// Destination ：消息的目的地;消息发送给谁.
		Destination destination;
		// 消费者，消息接收者
		MessageConsumer consumer;
		TextMessage message = null ;
		try {
			// 构造从工厂得到连接对象
			connection = (Connection) connections;
			// 启动
			connection.start();
			// 获取操作连接
			session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			// 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
			destination = session.createQueue("FirstQueue");
			consumer = session.createConsumer(destination);
				// 设置接收者接收消息的时间，为了便于测试，这里谁定为100s
			 message = (TextMessage) consumer.receive(500000);
				 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != connection)
					connection.close();
			} catch (Throwable ignore) {
			}
		}
		return message;
	}

	@Override
	public void close(Object... connect) {
		// TODO Auto-generated method stub
		for (int i = 0; connect != null && i < connect.length; i++) {
			if(connect[i] instanceof Connection) {
				try {
					((Connection)connect[i]).close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void sendMessage(Object connections, Object message) {
		Connection connection = (Connection) connections; // Connection ：JMS 客户端到JMS
		Session session; // Session： 一个发送或接收消息的线程
		Destination destination; // Destination ：消息的目的地;消息发送给谁.
		MessageProducer producer; // MessageProducer：消息发送者
		try {
			// 启动
			connection.start();
			// 获取操作连接
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			// 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
			destination = session.createQueue("FirstQueue");
			// 得到消息生成者【发送者】
			producer = session.createProducer(destination);
			// 设置不持久化，此处学习，实际根据项目决定
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			// 构造消息，此处写死，项目就是参数，或者方法获取
			sendMessage(session, producer, message);
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
