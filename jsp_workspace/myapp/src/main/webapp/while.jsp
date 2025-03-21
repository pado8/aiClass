<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>While Example</title>
</head>
<body>
	<%
	 	 request.setCharacterEncoding("UTF-8");
		 String msg = request.getParameter("msg"); //String으로 받음
	 	 int number = Integer.parseInt(request.getParameter("number"));
	 	 int count = 0;
	 	 while(number>count){
	%>
	<b><%=msg%></b><br/>
	<%
	    	count++;
	   }
	%>
</body>
</html>