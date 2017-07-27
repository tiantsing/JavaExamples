package cn.terry.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import cn.terry.domain.User;
import cn.terry.service.UserService;
import cn.terry.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/regServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
		//获取表单数据
	    User user = new User();
	    try {
	    	ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.populate(user, request.getParameterMap());
			//调用业务逻辑
			UserService us = new UserServiceImpl();
			us.register(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//分发转向
		response.getWriter().write("注册成功！1秒后返回主页。。。");
		response.setHeader("refresh", "1;url="+request.getContextPath()+"/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
