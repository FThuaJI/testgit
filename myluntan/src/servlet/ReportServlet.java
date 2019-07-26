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

import content.ArticleDao;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet{
	private static final long serialVersionUID = -3009431503363456775L;
		
	public void doGet(HttpServletRequest request, HttpServletResponse 
			response)throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String title= request.getParameter("title");
		String content=request.getParameter("content");
		HttpSession session=request.getSession();
		String senderName=(String) session.getAttribute("username");
		Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sendTime=dateFormat.format(now);
		
		ArticleDao articleDao=new ArticleDao();
		boolean addArticle=articleDao.addArticle(title,content,sendTime,senderName);
		if(addArticle){
			System.out.println("发表成功！");
			request.getRequestDispatcher("/ArticleServlet").forward(request, response);
		}else{
			System.out.println("失败");
		}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse 
			response)throws ServletException, IOException {
		
	}
}
