<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 결과</title>
</head>
<body>
    <h2>입력하신 정보</h2>
    <p>아이디: <%= request.getParameter("username") %></p>
    <p>비밀번호: <%= request.getParameter("password") %></p>
</body>
</html>
