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
    
    <title>主页面</title>
    <link rel="stylesheet" href="css/main.css" type="text/css"></link>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/myjs.js" ></script>
	
	<!-- 
	<script type="text/javascript">
            function a(){  
                $.ajax({    
                    url:"ArticleServlet",//servlet文件的名称  
                    type:"POST",  
                    success:function(e){  
                          alert("调用成功");
                          $('.content').html(e)
                    } ,
                
                });  
                  
            }  
        </script>
        -->
  </head>
  
  <body>
	<jsp:include page="header.jsp" />
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
  			<c:forEach items="${article }" var="A">
      			<div class="con">
      				<div><a href="CommentServlet?articleId=${A.articleId}">${A.title}</a></div>
      				<div class="c1">${A.content}</div>
      				<span>${A.senderName}</span>
	       			<span>${fn:substring(A.sendTime,0,19)}</span>
	       		</div>
			</c:forEach>
		</div>
		
		<div class="re" onclick="ShopConfirm('img3')" >回帖</div>
		
		<div class="im" id="img3" style="display: none;">
			<div class="out" onclick="CloseShopConfirm('img3')">关 闭</div>
			<div class="zhu">主题帖</div>
				<form id="layer" action="ReportServlet" method="get">
					<div class="put"><input type="text" placeholder="帖子标题" name="title"></div>
					<div class="te"><textarea placeholder="正文" name="content"></textarea></div>
					<div class="iput"><input type="submit" value="发布" class="btn"></div>
				</form>
			</div>
		
		
		<div class="bu" id="bu">
			<div class="back"></div>
		</div>
		
		<jsp:include page="foot.jsp"></jsp:include>
		
		<script type="text/javascript">
			var timer = null;
			bu.onclick = function(){
			cancelAnimationFrame(timer);
			timer = requestAnimationFrame(function fn(){
			var oTop = document.body.scrollTop || document.documentElement.scrollTop;
			if(oTop > 0){
			document.body.scrollTop = document.documentElement.scrollTop = oTop - 50;
			timer = requestAnimationFrame(fn);
				}else{
			cancelAnimationFrame(timer);
			} 
			});
			}
			$(function(){
				$('#bu').hide();
				$(function(){
					$(window).scroll(function(){
						if($(window).scrollTop()>300){
						$('#bu').fadeIn(300);
						}
						else{$('#bu').fadeOut(200);}
				});
				$('#bu').click(function(){
				$('body,html').animate({scrollTop:0},300);
				return false;
					})
				})
			})
			
		</script>
		
		
	</div>
	
</body>
</html>
