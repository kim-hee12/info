package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Utils.OracleDBUtils;

@WebServlet({"/join.do"})
public class Join extends HttpServlet{
	// GET - /join.do - /WEB-INF/user/join.jsp 연결

	// POST - /join.do - 회원가입처리(username,password 받아 DBUtils를 이용한 DB INSERT)
	// 테이블 : tbl_user(요청 파라미터에 맞게 적절히 생성)
	// 성공시 - /login.do 로 리다이렉트
	// 실패시 - /join.do 로 포워딩

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 회원가입 폼 보여주기
		req.getRequestDispatcher("/WEB-INF/user/join.jsp").forward(req, resp);		
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		try {
		    OracleDBUtils db = OracleDBUtils.getInstance();
		    boolean result = db.insertUser(username, password);

		    if(result) {
		        resp.sendRedirect(req.getContextPath() + "/login.do");
		    } else {
		        req.getRequestDispatcher("/WEB-INF/user/join.jsp").forward(req, resp);
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		    req.getRequestDispatcher("/WEB-INF/user/join.jsp").forward(req, resp);
		}

	}
}
