package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.CommentDao;

@WebServlet("/ReCommentServlet")
public class ReCommentServlet extends HttpServlet{
	private static final long serialVersionUID = -3009431503363456775L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse 
			response)throws ServletException, IOException {
		
		String comcontent=request.getParameter("comContent");
		String articleId=(String) request.getSession().getAttribute("articleId");
		HttpSession session=request.getSession();
		String comName=(String) session.getAttribute("username");
		Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String comTime=dateFormat.format(now);
		
		CommentDao commentDao=new CommentDao();
		boolean addComment=commentDao.addComment(comcontent,comTime,comName,articleId);
		if(addComment){
			System.out.println("发表成功！");
			request.getRequestDispatcher("/CommentServlet?articleId="+articleId).forward(request, response);
		}else{
			System.out.println("失败");
			request.getRequestDispatcher("/CommentServlet?articleId="+articleId).forward(request, response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse 
			response)throws ServletException, IOException {
		
	}
}
