package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.OracleDBUtils;

@WebServlet({"/login.do"})
public class Login extends HttpServlet{
	// GET - /login.do - /WEB-INF/user/login.jsp 연결

	// POST - /login.do - 회원가입처리(username,password 받아 DBUtils를 이용한 DB INSERT)
	// 테이블 : tbl_user
	// 성공시 : /main.do 로 리다이렉트
	// 실패시 : /login.do로 포워딩
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);		
	}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			
			// 파라미터
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			try {
			    OracleDBUtils db = OracleDBUtils.getInstance();
			    boolean result = db.checklogin(username, password);

			    if (result) {
			        resp.sendRedirect(req.getContextPath() + "/main.do");
			        return ;
			    } else {
			        req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
			        return;
			    }
			} catch (Exception e) {
			    e.printStackTrace();
			    req.setAttribute("error", "서버 오류가 발생했습니다.");
			    req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
			}
			

		}
		
}
