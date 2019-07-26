package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import content.Article;
import content.ArticleDao;

@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse 
			response)throws ServletException, IOException {
		
		String title=request.getParameter("text1");
		ArticleDao articleDao=new ArticleDao();
		List<Article> checkArticle=articleDao.checkArticle(title);
		
		if(checkArticle!=null){
			request.setAttribute("checkArticle", checkArticle);
			request.getRequestDispatcher("/WEB-INF/jsp/check.jsp").forward(request, response);
		}else{
			request.setAttribute("info","错误");
			request.getRequestDispatcher("/WEB-INF/jsp/article.jsp").forward(request, response);
		}
	}
	
}
