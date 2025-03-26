<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="num" value="123456789.567"/>
	달러 : <fmt:formatNumber value="${num}" type="currency" currencySymbol="$"></fmt:formatNumber><br/>
	패턴 : <fmt:formatNumber value="${num}" pattern="#,###.00"></fmt:formatNumber><br/>
	
	<c:set var="dayTime" value="<%=new Date() %>"/>
	날짜 : <fmt:formatDate value="${dayTime}" pattern="yyyy-MM-dd"></fmt:formatDate><br/>
	날짜 : <fmt:formatDate value="${dayTime}" pattern="yyyy년 MM월 dd일"></fmt:formatDate>
</body>
</html>