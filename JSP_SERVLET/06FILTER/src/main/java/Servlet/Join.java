package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.MysqlDbUtils;
import Utils.UserDto;

//@WebServlet("/join.do")
public class Join extends HttpServlet {

	private MysqlDbUtils dbutils;

	@Override
	public void init() throws ServletException {
		try {
			dbutils = MysqlDbUtils.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET /join.do");
		req.getRequestDispatcher("/WEB-INF/user/join.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 파라미터 받기
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("POST /join.do username : " + username);

		// 처리작업(DB저장)
		int result = 0;
		try {
			result = dbutils.insert(new UserDto(username, password, "ROLE_USER"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 뷰
		if (result > 0) {
			resp.sendRedirect(req.getContextPath() + "/login.do");
		} else {
			req.getRequestDispatcher("/WEB-INF/user/join.jsp").forward(req, resp);
		}
	}

}