<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<%
    // 1. DB 연결 정보 설정
    String url = "jdbc:oracle:thin:@localhost:1521:xe";  // Oracle DB 주소
    String id = "system";  // 오라클 계정
    String pw = "1234";  // 오라클 비밀번호

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        // 2. Oracle JDBC 드라이버 로드
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // 3. 데이터베이스 연결
        conn = DriverManager.getConnection(url, id, pw);

        // 4. SQL 실행
        stmt = conn.createStatement();
        String sql = "SELECT * FROM tbl_user";
        rs = stmt.executeQuery(sql);

        // 5. 결과 출력
        while (rs.next()) {
            out.println("ID: " + rs.getInt("ID") + ", Name: " + rs.getString("NAME") + "<br>");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // 6. 연결 종료
        if (rs != null) try { rs.close(); } catch (SQLException e) {}
        if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
        if (conn != null) try { conn.close(); } catch (SQLException e) {}
    }
%>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	// 파라미터 유효성 체크
	if(username.isEmpty()){
//		out.println("<script>alert('username을 입력하세여');location.href='./Login_form.jsp'</script>");
		request.setAttribute("username_msg","username을 입력하세요");	
				
	}
	if(password.isEmpty()){
//		out.println("<script>alert('password을 입력하세여');location.href='./Login_form.jsp'</script>");
		request.setAttribute("password_msg","password을 입력하세요");
	}
	if(username.isEmpty()||password.isEmpty()){
		request.getRequestDispatcher("./Login_form.jsp").forward(request, response);
		return ;
	}
	
	// 01 ID 확인(DB 조회)
	if(!username.equals("admin")){
		request.setAttribute("username_msg","해당 ID는 이미 존재합니다");
//		request.setAttribute("password_msg","");
		request.getRequestDispatcher("./join_form.jsp").forward(request, response);
		return ;
	}
	
	// 02 PW 확인(일치여부 확인) 
	if(!password.equals("1234")){
		request.setAttribute("password_msg","패스워드가 일치하지 않습니다");
		request.getRequestDispatcher("./join_form.jsp").forward(request, response);
		return ;
	}	
	
	// 03 사용자 상태정보(인증됨)를 Session 저장
	session.setAttribute("isAuth", true);
	session.setAttribute("role", "ROLE_ADMIN");
	session.setMaxInactiveInterval(30); 
	
	// 04 회원가입 처리 후 MAIN PAGE REDIRECT
	out.println("<script> alert('회원가입 성공! Login page로 이동합니다.');location.href='login.jsp'</script>");
%>