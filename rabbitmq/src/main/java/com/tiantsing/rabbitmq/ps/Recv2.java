package com.tiantsing.rabbitmq.ps;

import java.io.IOException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.tiantsing.rabbitmq.ConnectionUtil;

public class Recv2 {
	private final static String EXCHANGE_NAME = "q_exchange_fanout_01";
	private final static String QUEUE_NAME = "q_exchange_02";

	public static void main(String[] argv) throws Exception {

		// 获取到连接以及mq通道
		Connection connection = ConnectionUtil.getConnection();
		// 从连接中创建通道
		final Channel channel = connection.createChannel();
		// 声明队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		// 绑定队列到交换机 转发器
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
		int prefetchCount = 1;
		channel.basicQos(prefetchCount);
		// 定义队列的消费者
		DefaultConsumer consumer = new DefaultConsumer(channel) {

			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				String msg = new String(body, "utf-8");
				System.out.println(" [2] Received '" + msg + "'");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					// 手动回执
					channel.basicAck(envelope.getDeliveryTag(), false);
				}

				// super.handleDelivery(consumerTag, envelope, properties, body);
			}

		};
		boolean autoAck = false;// 自动应答
		// 监听队列
		channel.basicConsume(QUEUE_NAME, autoAck, consumer);

	}

}
