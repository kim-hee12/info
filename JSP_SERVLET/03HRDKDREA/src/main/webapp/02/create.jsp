<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "Utils.*" %>
<!-- 파라미터 받기 -->    
<jsp:useBean id="classDto" class="Utils.ClassDto" scope="request" />
<jsp:setProperty name="classDto" property="*" />

<%
	System.out.println(classDto);
	int result = DBUtils.getInstance().insertClass(classDto);
	if(result>0){
		
		String code="<script>";
		code += "alert('수강신청이 정상적으로 완료되었습니다.')";
		code += "location.href='../index.jsp'";
		code += "</script>";
		
		out.println(code);
	}
	else{
		
		String code = "<script>";
		code += "alert('수강신청이 완료되지 않았습니다.')";
		code += "location href='./index.jsp'";
		code += "</script>";
		
		out.println(code);
	}
%>
