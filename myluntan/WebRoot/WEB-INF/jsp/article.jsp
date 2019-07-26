<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    
    <title>我的帖子</title>
    <link rel="stylesheet" href="css/article.css" type="text/css"></link>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/myjs.js" ></script>
	
	
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
			<div class="title"></div>
			<div class="comment">
				<c:forEach items="${comment}" var="C">
					<div class="name">
						<img alt="" src="images/tou.jpg" width="100px" height="100px">
						<div class="na">${C.comName}</div>
					</div>
					
					<div class="cont">
						${C.comContent}
						<div class="ti">${fn:substring(C.comTime,0,19)} </div>
						<div class="rep">
							<a href="ReplyServlet?commentId=${C.commentId}">查看</a>
							<a id="" onclick="replyfirm('img3')">回复</a>
						</div>						
					</div>
					<div class="reply">
						<c:if test="${C.commentId==commentId}">
							<c:forEach items="${reply}" var="R">
								<div class="name_re">${R.repName}:</div>
								<div class="cont_re">${R.repContent}</div>
								<div class="time_re">${fn:substring(R.repTime,0,19)}</div>
							</c:forEach>
							</c:if>
						</div>
						
						<!-- 
					<div class="reply_textarea" id="reply_textarea">
							<form action="ReplyServlet" methon="get">
								<textarea name="repContent" cols="60" rows="3"></textarea><br/>
								<input type="submit" value="回复" />
								<input type="button" value="收起" id="yin">
							</form>
					</div>
					 -->
				</c:forEach>
			</div>
		</div>
		
		<div class="im" id="img3" style="display: none;">
			<div class="out" onclick="Closereplyfirm('img3')">关 闭</div>
			<div class="zhu">发表评论</div>
				<form id="layer" action="ReplyServlet" method="get">
					<div class="te"><textarea placeholder="正文" name="comContent"></textarea></div>
					<div class="iput"><input type="submit" value="回复" class="btn"></div>
				</form>
		</div>
		
		
		
		<div class="re" onclick="ShopConfirm('img3')" >评论</div>
		<div class="im" id="img3" style="display: none;">
			<div class="out" onclick="CloseShopConfirm('img3')">关 闭</div>
			<div class="zhu">发表评论</div>
				<form id="layer" action="ReCommentServlet" method="get">
					<div class="te"><textarea placeholder="正文" name="comContent"></textarea></div>
					<div class="iput"><input type="submit" value="发表" class="btn"></div>
				</form>
		</div>
		
		
		<div class="bu" id="bu">
			<div class="back"></div>
		</div>
		
		
		</div>
		
		<script type="text/javascript">
			
			
			$(document).ready(function(){
				$("#yin").click(function(){
					$("#reply_textarea").hide(1000);
				});
				$("#rep").click(function(){
					$("#reply_textarea").show(1000);
				});
			});
			
			 $(function(){
            //页面加载完毕后开始执行的事件
            $(".reply_btn").click(function(){
                $(".reply_textarea").remove();
                $(this).parent().append("<div class='reply_textarea'><form action='ReplyServlet' methon='get'><textarea name='repContent' cols='40' rows='5'></textarea><br/><input type='submit' value='发表' /></form></div>");
            });
        	});
		
			//回到顶部
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
			
  </body>
</html>
