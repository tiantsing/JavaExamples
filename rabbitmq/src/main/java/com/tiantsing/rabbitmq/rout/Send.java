package com.tiantsing.rabbitmq.rout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.tiantsing.rabbitmq.ConnectionUtil;

//路由模式
public class Send {

	private final static String QUEUE_NAME = "q_test_rout_01";
	private final static String EXCHANGE_NAME = "e_test_rout_direct";

	public static void main(String[] argv) throws Exception {
		// 获取到连接以及mq通道
		Connection connection = ConnectionUtil.getConnection();
		// 从连接中创建通道
		Channel channel = connection.createChannel();
		// 声明交换机
		channel.exchangeDeclare(EXCHANGE_NAME, "direct");//
		// 消息内容
		String message = "Hello direct!";
		String routingKey = "error";
		channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
		System.out.println("Send : " + message);
		// 关闭通道和连接
		channel.close();
		connection.close();
	}

}
