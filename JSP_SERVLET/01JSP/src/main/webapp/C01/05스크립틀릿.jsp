<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	java.util.Scanner sc = new java.util.Scanner(System.in);
	System.out.print("몇 단? ");
	int num = sc.nextInt();
	System.out.printf("%d단 \n",num);
	int sum;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
		<tbody>
			<%	
				for(int j=1;j<=9;j++){
					sum=j*num;
				%>
					<td><%=num+"*"+j+"="+sum %></td>
				<%
				}	
			%>
		</tbody>
	</table>
</body>
</html>