package myluntan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserExitServlet extends HttpServlet{
	private static final long serialVersionUID = 1599366365079846238L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		if(user!=null) {
			
			session.removeAttribute("user");
			request.setAttribute("info", user.getUsername()+"�ѳɹ��˳���");
		}
		request.getRequestDispatcher("/ArticleServlet").forward(request, response);
	}
	
}
