<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="myluntan.User" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'header.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<div class="header">
		<div class="box1">
			<%	
				User user = (User)session.getAttribute("user");   
				if(user==null){
			%>
				<a href="login.jsp" id="login" class="to-login">登录</a>
			<%
				}
			%>
			<%				  
            	if(user != null){
			%>
				当前用户：<%=user.getUsername() %>
			<%
			}
			%>
			<a href="UserExitServlet">退出</a>
			<a href="register.jsp">注册</a>

		</div>
	</div>
</body>
</html>
