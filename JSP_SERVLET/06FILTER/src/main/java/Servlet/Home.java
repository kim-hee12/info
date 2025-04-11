package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet({"/main.do","/index.do"})
public class Home extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		
		if(uri.endsWith("/main.do")) {
		req.getRequestDispatcher("/WEB-INF/main.jsp").forward(req, resp);
		return ;
		}
		else if(uri.endsWith("/index.do")) {
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		return ;
		}
	
	}
}
