<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	int one = 5;
	int two = 1;
	public int plusMethod(){
		return one + two;
	}
	String msg = "jsp";
	int three;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	one과 two의 합? <%=plusMethod() %>
	<p>
		JSP<br>
		<%=msg %>
	</p>
</body>
</html>