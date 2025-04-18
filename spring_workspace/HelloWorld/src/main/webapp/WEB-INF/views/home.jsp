<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Hello world!  
	</h1>
	<P>  The time on the server is ${serverTime}. </P>
	<a href="/sample/basic">basic</a>
	<a href="/sample/basicOnlyGet">basicGet</a>
	<a href="/sample/ex01?name=홍길동&age=25">ex01</a>
	<a href="/sample/ex02?name=박문스&age=35">ex02</a>
	<a href="/sample/ex04?name=심사임당&age=45&page=10">ex04</a>
	<a href="/sample/ex05">ex05</a>
	<a href="/sample/ex06">ex06</a>
	<a href="/sample/ex07">ex07</a>
	<a href="/sample/exUpload">exUpload</a>
	<a href="/sample/ex04?name=심사임당&age=aaa&page=10">에러</a>
</body>
</html>
