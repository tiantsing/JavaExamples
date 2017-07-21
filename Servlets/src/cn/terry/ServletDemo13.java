package cn.terry;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.terry.entity.User;


/**
 * request获取头以及转发
 */
@WebServlet("/servletdemo13")
public class ServletDemo13 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo13() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        request.setAttribute("s", "aaa");
        request.getRequestDispatcher("/servletdemo6").forward(request, response);
	}

	private void getValues3(HttpServletRequest request) {
		try {
			User u = new User();
			System.out.println("封装数据前："+u);
			//调用第三方工具类
			BeanUtils.populate(u, request.getParameterMap());
			
			System.out.println("封装数据后："+u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getValues2(HttpServletRequest request) {
		Enumeration names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String[] values = request.getParameterValues(name);
			for(int i=0 ; values!=null&& i<values.length;i++) {
				System.out.println(name+"\t"+values[i]);
			}
		}
	}

	private void getValues1(HttpServletRequest request) {
		String userName = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		
		String[] hobbys = request.getParameterValues("hobby");
		
		String city = request.getParameter("city");
		
		System.out.println(userName);
		System.out.println(pwd);
		System.out.println(sex);
		for(int i=0;i<hobbys.length;i++) {
			System.out.println(hobbys[i]);
		}
		System.out.println(city);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
