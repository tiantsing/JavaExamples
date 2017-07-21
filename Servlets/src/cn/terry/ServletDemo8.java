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
 * �ļ�����
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
		//ͨ��·���õ�һ��������
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/test.png");
		FileInputStream fis = new FileInputStream(path);
		//�����ֽ������
		ServletOutputStream sos = response.getOutputStream();
		//�õ��ļ���
		String filename = path.substring(path.lastIndexOf("\\")+1);
		//�ļ���ת��
		filename = URLEncoder.encode(filename, "UTF-8");
		//��֪�ͻ��������ļ�
		response.setHeader("content-disposition", "attachment;filename="+filename);
		response.setHeader("content-type", "image/jpeg");
		//ִ���������
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
