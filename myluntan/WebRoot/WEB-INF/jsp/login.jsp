<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
    
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
<center>
<form action="LoginServlet" methon="post" name="form1">
		<table width="300">
		<h2>用户登录</h2>
		<p>用户名：<input type="text" name="username">
		<p>&nbsp;密码：<input type="password" name="password">
		<p><input type="submit" value="登录" name="submit">
		<input type="reset" value="重置" name="reset">
		<input type="button" value="返回" onclick="javascript:window.location.href='ArticleServlet'">
		</table>
	</form>
	</center>
</body>
</html>
