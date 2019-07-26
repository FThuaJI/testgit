<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'check.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    
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
    <jsp:include page="header.jsp"></jsp:include>
    <div class="pic">
		<img alt="" src="images/bg.jpg" width="100%">
	</div>
	<div class="banner">
		<div class="pic1">
			<img alt="" src="images/tou.jpg" width="150px" height="150px">
		</div>
		<div class="banner-header">
			<div class="h1"><h2>我的论坛</h2></div>
			<div class="h2">
				今日帖子：<span>${toArticleTODAY}</span>
				全部帖子：<span>${toArticleTODAY}</span>
			</div>
			<div class="h3">
				这是一个可以自由交流的论坛，欢迎大家在此各抒己见
			</div>
			<div class="h4">
				<form action="CheckServlet" method="get">
					<input type="text" placeholder="输入关键字" class="text1" name="text1">
					<input type="button" value="搜索" class="text2">
				</form>
			</div>
		</div>
		<hr>
		
		<div class="navi">
			<a href=""><button>看帖交流区</button></a>
			<button>新闻公告区</button>
			<button>图片</button>
			<button>精品</button>
		</div>
		<hr>
		
		<div class="content">
  			<c:forEach items="${checkArticle}" var="C">
      			<div class="con">
      				<div><a href="CommentServlet?articleId=${C.articleId}">${C.title}</a></div>
      				<div class="c1">${C.content}</div>
      				<span>${C.senderName}</span>
	       			<span>${fn:substring(C.sendTime,0,19)}</span>
	       		</div>
			</c:forEach>
		</div>
		
		</div>
  </body>
</html>
