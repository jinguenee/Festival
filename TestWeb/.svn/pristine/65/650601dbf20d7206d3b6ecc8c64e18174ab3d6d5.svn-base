<%@page import="test.web.model.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	// Controller 로부터 데이터를 취득한다
	MemberBean memberBean = (MemberBean) request.getAttribute("memberBean");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<span>귀하의 멤버정보를 출력합니다.</span>
	<br/>
	
	<!--     = : 출력할때 사용한다  -->
	아이디 : <%=memberBean.getId() %> <br/>
	비밀번호 : <%=memberBean.getPass() %> <br/>
	이름 : <%=memberBean.getName() %> <br/>
	나이 : <%=memberBean.getAge() %> <br/>
	
</body>
</html>