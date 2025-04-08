<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="C09.DBUtils, C04.UserDto,java.util.*" %>
<%
	DBUtils dbUtils = DBUtils.getInstance();

	List<UserDto> list = dbUtils.selectAllUser();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--
		1. selectAllUser를 이용해서 table의 해당 user정보 표시
		2. 만들어진 테이블에 컬럼을 추가해서 해당 수정버튼 만들기
		3. 만들어진 테이블애 컬럼을 추가해서 해당 삭제버튼 만들기
		4. 수정버튼을 클릭하면 수정페이지로 이동(update.jsp + 해당 사용자 파리미터 전달)
		5. 삭제버튼을 클릭하면 삭제페이지로 이동(delete.jsp + 해당 사용자 파리미터 전달)
	  -->
	  총인원 : <%=list.size() %><br/>
	  
	  <table>
	  	<tr>
	  		<th>계정</th>
	  		<th>패스워드</th>
	  		<th>역할</th>
	  		<th>수정</th>
	  		<th>삭제</th>
	  	</tr>
	  	<%
	  		for(UserDto dto : list){
	  			%>
	  			<tr>
	  				<td><%=dto.getUserid() %></td>
	  				<td><%=dto.getPassword() %></td>
	  				<td><%=dto.getRole() %></td>
	  				<td>
						<a href="./update_form.jsp?userid=<%=dto.getUserid()%>">수정하기</a>
					</td>
					<td>
						<a href="./delete.jsp?userid=<%=dto.getUserid()%>">삭제하기</a>
						<button onClick="deleteFunc=<%=dto.getUserid()%>">삭제버튼</button>
					</td>
				</tr>
	  			<%
	  		}
	  	%>
	  	<tr>
	  		<td></td>
	  		<td></td>
	  		<td></td>
	  	</tr>
	  </table>
	  
	  <script>
	  function deleteFunc(userid){
			const isDelete = confirm("정말 삭제하시겠습니까?");
			console.log('userid :' ,userid , "isDelete",isDelete);
			if(isDelete)
				location.href=`./delete.jsp?userid=` + userid;
		}
	  </script>
	  
</body>
</html>