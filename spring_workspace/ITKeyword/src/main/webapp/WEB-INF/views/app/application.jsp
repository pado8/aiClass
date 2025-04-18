<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/app/keypost"  method="post">

 <div>
    <label for="keyword">단어</label>
    <input type='text' id="keyword" name='keyword'>
 </div>
 <div>
    <label for="description">단어 뜻</label>
   <input type='text'id="description"  name='description'>
 </div>
 <div>
   <input type='date' name='regdate'>
 </div>
 <div>
   <input type='submit'>
 </div>   
</form>
</body>
</html>
