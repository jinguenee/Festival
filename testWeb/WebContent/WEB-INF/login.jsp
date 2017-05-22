<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    MemberBean memberBean = (MemberBean)request.getAttribute("MemberBean");
    
    %>
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<span>귀하의 맴버정보 출력</span>
<br/>

ID : <%=memberBean.getId() %> <br/>
passover : <%=memberBean.getPass() %> <br/>
name : <%=memberBean.getName() %> <br/>
age : <%=memberBean.getAge() %> 


</body>
</html>