package cn.terry;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

/**
 * 使用工具生成验证码
 */
@WebServlet("/servletdemo9")
public class ServletDemo9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo9() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 告知客户端不使用缓存
       response.setHeader("pragma", "no-cache");
       response.setHeader("cache-control", "no-cache");
       response.setIntHeader("expires", 0);

	    ValidateCode vCode = new ValidateCode(110, 25, 4, 9);
	    String vcode = vCode.getCode();//获取到生成的字符串
	    System.out.println(vcode);
	    vCode.write(response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
