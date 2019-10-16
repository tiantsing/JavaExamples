package com.tiantsing.frist.demoF.webservices;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

@WebService(name = "TestService", // 暴露服务名称
targetNamespace = "http://webservices.demoF.frist.tiantsing.com",// 命名空间,一般是接口的包名倒序
endpointInterface = "com.tiantsing.frist.demoF.webservices.MyService"// 接口地址
)
@Component
public class MyServiceImpl implements MyService {
	@Override
    public String sendMessage(String username) {
        
        return "hello "+username;
    }
}
