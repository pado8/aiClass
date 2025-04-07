<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>일기 등록</title>
</head>
<body>
    <h1>일기 등록</h1>
    <form action="${pageContext.request.contextPath}/register.do" method="post">
        <div>
            <label for="weather">날씨:</label>
            <input type="text" id="weather" name="weather" required>
        </div>
        <div>
            <label for="title">제목:</label>
            <input type="text" id="title" name="title" required>
        </div>
        <div>
            <label for="content">내용:</label>
            <textarea id="content" name="content" rows="10" cols="50" required></textarea>
        </div>
        <div>
            <input type="submit" value="등록">
        </div>
    </form>
</body>
</html>
