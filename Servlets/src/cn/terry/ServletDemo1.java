package cn.terry;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo1 implements Servlet{
	//ʵ����
	public ServletDemo1() {
		System.out.println("ServletDemo1ʵ����");
	}
    //����
	@Override
	public void destroy() {
		System.out.println("ServletDemo1����");
		
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
    //��ʼ��
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("ServletDemo1��ʼ��");
		
	}
    //�����û����󣬲�������Ӧ
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ServletDemo1�����У�");
	}

}
