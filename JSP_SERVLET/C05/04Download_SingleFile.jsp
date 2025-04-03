<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//INPUTSTREAM
	String dirPath = pageContext.getServletContext().getRealPath("/")+"C5\\files\\";
	System.out.println("dirPath :"+dirPath);
	
	try{
	FileInputStream in = new FileInputStream(dirPath+"test.txt");
	
	//OUTPUTSTREAM
	out.clear(); // response outStream을 닫고 버퍼를 비움
	out = pageContext.pushBody();
	
	ServletOutputStream bout =  response.getOutputStream();
	
	// Response Header 지정!!!!!
	response.setHeader("Content-type","application/octet-stream;charset-utf-8");
	response.setHeader("Content-Disposition","attachment; filename=testtxt");
	byte[] buff = new byte[4096];
	while(true){
		int data = in.read();
		if(data==1)
			break;
		bout.write(buff,0,data);
		bout.flush();
	}
	bout.close();
	in.close();
	
	}catch(Exception e){
		e.printStackTrace();
	}
	
%>
</body>
</html>