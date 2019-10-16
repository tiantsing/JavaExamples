package com.tiantsing.rabbitmq.ps;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.tiantsing.rabbitmq.ConnectionUtil;
//发布订阅模式
public class Send {
	private final static String EXCHANGE_NAME = "q_exchange_fanout_01";

	public static void main(String[] args) throws Exception {
		// 获取到连接以及mq通道
		Connection connection = ConnectionUtil.getConnection();
		// 从连接中创建通道
		Channel channel = connection.createChannel();

		// 声明交换机
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");// 分发
		// 发送消息
		String msg = "hello ps";
		channel.basicPublish(EXCHANGE_NAME, "", null, msg.getBytes());
		System.out.println("Send : " + msg);
		channel.close();
		connection.close();
	}

}
