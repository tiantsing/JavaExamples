package com.tiantsing.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtil {
	public static Connection getConnection() throws Exception {
		// 定义连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		//factory.setUri("amqp://admin:123456@192.168.131.128:5672/tiantsing");
		// 设置服务地址
		factory.setHost("192.168.131.128");
		// 端口
		factory.setPort(5672);
		// 设置账号信息，用户名、密码、vhost
		factory.setVirtualHost("tiantsing");
		factory.setUsername("admin");
		factory.setPassword("admin");
		// 通过工程获取连接
		Connection connection = factory.newConnection();
		return connection;
	}

}
