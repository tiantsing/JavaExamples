package cn.terry.web.servlet;

import java.io.IOException;
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
import cn.terry.domain.UserForm;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 获取表单数据
		// 注册验证
		// 验证操作
		UserForm uf = new UserForm();
		try {
			BeanUtils.populate(uf, request.getParameterMap());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (!uf.validate()) {// 如果map中不为空，说明有错误信息
			request.setAttribute("uf", uf);
			request.getRequestDispatcher("/reg.jsp").forward(request, response);
			return;
		}

		User user = new User();
		try {
			// 日期转换
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.populate(user, request.getParameterMap());
			// 调用业务逻辑
			UserService us = new UserServiceImpl();

			// 查看用户名是否已被注册
			Boolean iBoolean = us.findUserByName(user.getUsername());

			if (iBoolean) {
				request.setAttribute("error", "用户名已存在");
				request.getRequestDispatcher("/reg.jsp").forward(request, response);
			} else {
				us.register(user);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		// 分发转向
		response.getWriter().write("注册成功！1秒后返回主页。。。");
		response.setHeader("refresh", "1;url=" + request.getContextPath() + "/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
