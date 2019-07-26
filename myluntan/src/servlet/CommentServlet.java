package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.Comment;
import comment.CommentDao;
import reply.Reply;
import reply.ReplyDao;

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse 
			response)throws ServletException, IOException {
		
		String articleId=request.getParameter("articleId");
		String commentId=(String) request.getSession().getAttribute("commentId");
		CommentDao commentDao=new CommentDao();
		List<Comment> comment=commentDao.getComment(articleId);
		
		if(comment!=null){
			request.getSession().setAttribute("articleId", articleId);
			request.setAttribute("comment", comment);
			request.getRequestDispatcher("/WEB-INF/jsp/article.jsp").forward(request, response);
		}else{
			request.setAttribute("info","错误");
			request.getRequestDispatcher("/WEB-INF/jsp/article.jsp").forward(request, response);
		}
	}
}
