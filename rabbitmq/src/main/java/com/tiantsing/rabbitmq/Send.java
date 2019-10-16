package com.tiantsing.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {
	private final static String QUEUE_NAME = "q_test_01";

	public static void main(String[] argv) throws Exception {
		// 获取到连接以及mq通道
		Connection connection = ConnectionUtil.getConnection();
		// 从连接中创建通道
		Channel channel = connection.createChannel();

		// 声明（创建）队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		// 消息内容
		String message = "Hello World!";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");
		// 关闭通道和连接
		channel.close();
		connection.close();
	}
}
/*老版本
 * //定义队列的消费者 QueueingConsumer consumer = new QueueingConsumer(channel);
 * 
 * // 监听队列 channel.basicConsume(QUEUE_NAME, true, consumer);
 * 
 * // 获取消息 while (true) { QueueingConsumer.Delivery delivery =
 * consumer.nextDelivery(); String message = new String(delivery.getBody());
 * System.out.println(" [x] Received '" + message + "'"); }
 */
