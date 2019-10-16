package com.tiantsing.frist.demoF.webservices;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfig {
//创建webservice的Endpoint
	@Autowired
	private Bus bus;

	@Autowired
	private MyService testService;

	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, testService);
		endpoint.publish("/TestService");
		return endpoint;
	}

}
