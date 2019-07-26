package myluntan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = -3009431503363456775L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse 
			response)throws ServletException, IOException {
					
			       String username=request.getParameter("username");  
			       String password=request.getParameter("password");
			       UserDao userDao=new UserDao();
			       User user=userDao.login(username, password);
			       if(user!=null) {	
			    	   request.getSession().setAttribute("user", user);
			    	   request.getSession().setAttribute("username", username);
			    	   request.getRequestDispatcher("/ArticleServlet").forward(request, response);
			       }else {
			    	   request.setAttribute("info", "错误");
			    	   request.getRequestDispatcher("/ArticleServlet").forward(request, response);

			       }
			   
}
}
