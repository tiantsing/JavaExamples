<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
     //获取表单数据
     String username = request.getParameter("username");
     String pwd = request.getParameter("pwd");
    /*  String remember = request.getParameter("remember");
     Cookie ck = new Cookie("userName", username);
		ck.setPath("/"); */
		 //处理业务逻辑
	     //分发转向
		if("tom".equals(username)&&"123".equals(pwd)){
			request.getRequestDispatcher("/success.jsp").forward(request, response);
			/* 
			if(remember!=null){
				ck.setMaxAge(Integer.MAX_VALUE);
			}else{
				ck.setMaxAge(0);
			}
			response.addCookie(ck);
			out.write("登录成功！");
		}else{
			out.write("登录失败！"); 
			response.setHeader("refresh", "2;url="+request.getContextPath()+"/login.jsp");*/
		}else{
			response.sendRedirect("/JSP/login.jsp");
		}
    
   %>
</body>
</html>