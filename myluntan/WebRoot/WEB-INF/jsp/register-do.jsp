<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.sql.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register-do.jsp' starting page</title>
    
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
	<%
    	try{
    	request.setCharacterEncoding("utf-8");
    	String name=request.getParameter("username");
    	String psd=request.getParameter("password");
    	boolean isok=false;
    	if(name!=null&&psd!=null){
    		Class.forName("com.mysql.jdbc.Driver");
    		out.print("加载驱动成功<br>");
    		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "12345678");
    		out.print("链接数据库ok<br>");
    		Statement stm=conn.createStatement();
    		String sql1="insert into user(用户名,密码) value('"+name+"','"+psd+"')";
    		int flag=stm.executeUpdate(sql1); 
    		if(flag!=0){
    			out.print("注册成功！");
    			response.sendRedirect("main.jsp");
    		}
    		else{
    			out.print("注册失败！");
    		}
    		stm.close();
    		conn.close();
    	}
    	}catch(Exception e){
    		out.print(e.getMessage());
    	}
     %>
</body>
</html>
