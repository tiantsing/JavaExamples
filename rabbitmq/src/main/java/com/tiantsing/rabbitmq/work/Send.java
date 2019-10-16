package com.tiantsing.rabbitmq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.tiantsing.rabbitmq.ConnectionUtil;
//工作队列
public class Send {

	private final static String QUEUE_NAME = "q_test_02";

	public static void main(String[] argv) throws Exception {
		// 获取到连接以及mq通道
		Connection connection = ConnectionUtil.getConnection();
		// 从连接中创建通道
		Channel channel = connection.createChannel();

		// 声明（创建）队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		int prefetchCount = 1;
		channel.basicQos(prefetchCount);
		for(int i=0;i<50;i++) {
			// 消息内容
			String message = "Hello World!"+i;
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println(" [x] Sent '" + message + "'");
			Thread.sleep(i*20);
		}
		// 关闭通道和连接
		channel.close();
		connection.close();
	}

}
