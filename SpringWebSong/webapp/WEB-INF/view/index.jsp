<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hello Spring 
	<br/>
	
	환영합니다. ${sessionScope.memberLoginBean.memberId} 님
	
	<br/><br/>
	<a href="/board/boardList.do">JSTL게시판 바로가기</a>
	<br/>
	<a href="/board/boardDetailViewForm.do?no=1">AJAX게시판 바로가기</a>
	
	
</body>
</html>