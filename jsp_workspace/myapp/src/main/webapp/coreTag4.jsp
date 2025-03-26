<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Core Tag - import, url, param</h2>
	<hr>
	<c:import url="coreTags2.jsp">
		<c:param name="id" value="JSPStudy"></c:param>
		<c:param name="color" value="orange"></c:param>
	</c:import>
	<hr>
	<c:url var="url1" value="https://www.google.co.kr/search">
		<c:param name="q" value="JSPStudy"/>
		<c:param name="safe" value="off"/>
	</c:url>
	<a href="${url1}" target="_black">구글에서 JSPStudy 검색</a>
</body>
</html>