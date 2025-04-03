<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		System.out.println("pageContext : " + pageContext);
		System.out.println("pageContext's get request : " + pageContext.getRequest());
		System.out.println("pageContext's get sesion : " + pageContext.getSession());
		System.out.println("pageContext's get application : " + pageContext.getServletContext());
		
		// 현재 위치 경로 찾기
		System.out.println("project path : "+pageContext.getServletContext().getContextPath());
	%>
	
	<!-- 표현식 -->
	PROJECTPATH : <%=pageContext.getServletContext().getContextPath() %>
	<!-- EL -->
	PROJECTPATH : ${ pageContext.request.contextPath }
</body>
</html>