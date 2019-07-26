package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reply.Reply;
import reply.ReplyDao;

@WebServlet("/ReplyServlet")
public class ReplyServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse 
			response)throws ServletException, IOException {
		
		String commentId=request.getParameter("commentId");
		String articleId=(String) request.getSession().getAttribute("articleId");
		ReplyDao replyDao=new ReplyDao();
		List<Reply> reply=replyDao.getReply(commentId);
		
		if(reply!=null){
			request.getSession().setAttribute("commentId", commentId);
			request.setAttribute("reply", reply);
			request.getRequestDispatcher("/CommentServlet?articleId="+articleId).forward(request, response);
		}else{
			request.setAttribute("info","错误");
			request.getRequestDispatcher("/WEB-INF/jsp/article.jsp").forward(request, response);
		}
	}
}
