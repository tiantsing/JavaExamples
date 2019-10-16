package com.tiantsing.frist.demoF;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.tiantsing.frist.demoF.rabbitMQ.Send;

//@SpringBootApplication
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class DemoFApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoFApplication.class, args);
		Send.send_01();
	}

}
