package cn.terry;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo1 implements Servlet{
	//实例化
	public ServletDemo1() {
		System.out.println("ServletDemo1实例化");
	}
    //销毁
	@Override
	public void destroy() {
		System.out.println("ServletDemo1销毁");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
    //初始化
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("ServletDemo1初始化");
		
	}
    //接受用户请求，并作出响应
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ServletDemo1服务中！");
	}

}
