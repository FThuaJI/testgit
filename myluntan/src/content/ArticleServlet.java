package content;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ArticleServlet extends HttpServlet{
	private static final long serialVersionUID = -3009431503363456775L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse 
			response)throws ServletException, IOException {
			
			ArticleDao articleDao=new ArticleDao();
			List<Article> article=(List<Article>) articleDao.getArticle();
			
			int toArticleTODAY = articleDao.ArticleToDay();
			
			request.setAttribute("toArticleTODAY", toArticleTODAY);
			if(article!=null) {
				request.setAttribute("article",article);
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
			}else {
				request.setAttribute("info","错误");
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
			}
	}
	


}
	
