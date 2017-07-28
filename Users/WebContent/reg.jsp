<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/regServlet" method="post">
		用户名：<input type="text" name="username" value="${uf.username }"/>${uf.msg.username }${error }<br/>
		密码： <input	type="password" name="pwd" />${uf.msg.pwd }<br> 
		确认密码：<input type="password" name="pwdconfrim" />${uf.msg.pwdconfrim }<br> 
		邮箱： <input type="text" name="email" value="${uf.email }"/>${uf.msg.email }<br>
		出生日期：<input type="text" name="brithday" value="${uf.brithday }"/>${uf.msg.brithday }<br> 
		<input	type="submit" name="" value="注册" /> 
		<input type="reset" name=""	value="重置" />
	</form>
</body>
</html>