package cn.terry;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件下载
 */
@WebServlet("/servletdemo8")
public class ServletDemo8 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDemo8() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
        response.setCharacterEncoding("text/html;charset=UTF-8");
		//通过路径得到一个输入流
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/test.png");
		FileInputStream fis = new FileInputStream(path);
		//创建字节输出流
		ServletOutputStream sos = response.getOutputStream();
		//得到文件名
		String filename = path.substring(path.lastIndexOf("\\")+1);
		//文件名转码
		filename = URLEncoder.encode(filename, "UTF-8");
		//告知客户端下载文件
		response.setHeader("content-disposition", "attachment;filename="+filename);
		response.setHeader("content-type", "image/jpeg");
		//执行输出操作
		int len =1;
		byte[] b = new byte[1024];
		while((len = fis.read(b))!=-1) {
			sos.write(b, 0, len);
		}
		sos.close();
		fis.close();
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
