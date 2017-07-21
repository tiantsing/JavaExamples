package cn.terry;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo12
 */
@WebServlet("/servletsemo12")
public class ServletDemo12 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDemo12() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
        System.out.println(request.getMethod());
        System.out.println(request.getRequestURL());
        System.out.println(request.getRequestURI());
        System.out.println(request.getQueryString());
        
        String header = request.getHeader("User-Agent");
        System.out.println(header);
        if (header.toLowerCase().contains("msie")) {
			System.out.println("U use is IE!");
		}else if(header.toLowerCase().contains("firefox")){
			System.out.println("U use is Firefox!");
		}else if(header.toLowerCase().contains("chrome")) {
			System.out.println("U use is Chrome!");
		}else {
			System.out.println("U use is other!");
		}
        
		PrintWriter out = response.getWriter();
		String title = "HTTP Header 请求实例 - 菜鸟教程实例";
		String docType = "<!DOCTYPE html> \n";
		out.println(docType + "<html>\n" + "<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n"
				+ "<table width=\"100%\" border=\"1\" align=\"center\">\n" + "<tr bgcolor=\"#949494\">\n"
				+ "<th>Header 名称</th><th>Header 值</th>\n" + "</tr>\n");

		Enumeration headerNames = request.getHeaderNames();

		while (headerNames.hasMoreElements()) {
			String paramName = (String) headerNames.nextElement();
			out.print("<tr><td>" + paramName + "</td>\n");
			String paramValue = request.getHeader(paramName);
			out.println("<td> " + paramValue + "</td></tr>\n");
		}
		out.println("</table>\n</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
