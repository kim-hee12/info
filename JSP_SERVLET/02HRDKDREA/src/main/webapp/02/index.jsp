<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	:root{}
	html{}
	*{	 box-sizing:border-box;}
	body{padding:0;margin : 0;}
	ul{list-style:none;margin:0;padding:0;}
	a{text-decoration:none; color:black;}
	.wrapper{}
	.wrapper>form{height:80px;}
	.wrapper>nav{height:50px;}
	.wrapper>main{ height :calc(100vh - 80px - 50px - 80px);}
	.wrapper>main h2{
		text-align:center;
		font-size:1.8rem;
		font-weight:400;
		
	}
	.wrapper>footer{height:80px;}
	
</style>


</head>
<body>
	
	<!--  
		select M.M_NO,M.M_NAME,P.P_NAME,M.P_SCHOOL,M.M_JUMIN,M.M_CITY,P.P_TEL1,P.P_TEL2,P.P_TEL3
		from TBL_MEMBER_202005 M
		join TBL_PARTY_202005 P
		on M.P_CODE=P.P_CODE;
	-->
	<%@page import="Utils.*,java.util.*" %>
	<%
		List<MemberDto> list = DBUtils.getInstance().selectAllMember();
	%>
	<div class="wrapper">
		<!--  -->
		<%@include file="/layouts/Header.jsp" %>
		
		<!--  -->
		<%@include file="/layouts/Nav.jsp" %>
		
		<main>
			
			<h2>투표하기</h2>
				
			<form name="vote_form" action="./create.jsp" method="post" onsubmit="return false">
				<div>
					<label>주민번호</label name="v_jumin"><input/>
				</div>	
				<div>
					<label>성명</label name="v_name"><input/>
				</div>	
				<div>
					<label>투표번호</label name="m_no"><input/>
				</div>	
				<div>
					<label>투표시간</label name="v_time"><input/>
				</div>	
				<div>
					<label>투표장소</label name="v_area"><input/>
				</div>	
				<div>
					<label>유권자확인</label>
					<input type="radio" name="v_confirm" value="Y"/>
					<input type="rodio" name="v_confirm" value="N"/>
				</div>	
				<div>
					<button type="submit">투표하기</button>
					<button type="reset">다시하기</button>
				</div>
				
				<script>
					function isValid(){

						// form 요소 찾기
						var form=document.vote_form;
						
						// 유효성 검사
						if(form.v_jumin.value==""){
							alert("주민번호가 입력되지 않았습니다!");
							return ;
						}
						// ...
						if(form.v_confirm.value==""){
							alert("유권자 확인이 선택되지 않았습니다!");
							return ;
						}
						// submit 처리
						form.submit();
					}
				</script>
			</form>	
			
		</main>
		
		<!--  -->
		<%@include file="/layouts/Footer.jsp" %>
	
	</div>

</body>
</html>