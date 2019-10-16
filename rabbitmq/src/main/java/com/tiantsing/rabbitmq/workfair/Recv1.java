package com.tiantsing.rabbitmq.workfair;

import java.io.IOException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.tiantsing.rabbitmq.ConnectionUtil;

public class Recv1 {
	private final static String QUEUE_NAME = "q_test_02";
	public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
     // 定义队列的消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {

			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				String msg = new String(body,"utf-8");
				System.out.println(" [1] Received '" + msg + "'");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				//super.handleDelivery(consumerTag, envelope, properties, body);
			}
        	
        };

        // 监听队列
        channel.basicConsume(QUEUE_NAME, true, consumer);

    }

}
