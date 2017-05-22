<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%for(int i = 0; i < 100 ; i++){ %>
helloooo  <br/>
<% }%>

<form action="/TestController?cmd=login"method="post">
ID : <input type="text" name = "id" value=""/><br/>
PW : <input type="text" name = "pass" value=""/><br/>
<input type="submit" value="LogIn">

</form>
</body>
</html>