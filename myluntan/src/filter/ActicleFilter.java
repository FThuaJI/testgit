package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myluntan.User;

public class ActicleFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
			HttpServletRequest request=(HttpServletRequest) servletRequest;
			HttpServletResponse response=(HttpServletResponse) servletResponse;
			
			String url=request.getRequestURI();
			HttpSession session=request.getSession();
			User user=(User) session.getAttribute("user");
			if(user==null){
				System.out.println("请先登录！");
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			}else{
				filterChain.doFilter(request, response);
				
			}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
