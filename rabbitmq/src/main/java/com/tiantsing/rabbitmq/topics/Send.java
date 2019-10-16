package com.tiantsing.rabbitmq.topics;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.tiantsing.rabbitmq.ConnectionUtil;

//主题模式
public class Send {

	private final static String QUEUE_NAME = "q_test_topic_02";
	private final static String EXCHANGE_NAME = "e_test_topic";

	public static void main(String[] argv) throws Exception {
		// 获取到连接以及mq通道
		Connection connection = ConnectionUtil.getConnection();
		// 从连接中创建通道
		Channel channel = connection.createChannel();
		// 声明交换机
		channel.exchangeDeclare(EXCHANGE_NAME, "topic");//
		// 消息内容
		String message = "Hello direct!";
		channel.basicPublish(EXCHANGE_NAME, "routingKey.1", null, message.getBytes());
		System.out.println("Send : " + message);
		// 关闭通道和连接
		channel.close();
		connection.close();
	}

}
