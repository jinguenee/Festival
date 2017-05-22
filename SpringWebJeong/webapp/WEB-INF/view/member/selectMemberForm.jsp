<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<style type="text/css">
		tr{
			text-align: center;
		}
		td{
			width: 150px;
		}
	</style>
	
</head>
<body>
	<h2>회원정보 보기</h2>
	<table border="1">	
		<tr>
			<th>ID</th>
			<td>${memberBean.memberId}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${memberBean.memberName}</td>
		</tr>
		<tr>
			<th>나이</th>
			<td>${memberBean.memberAge}</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${memberBean.memberArea}</td>
		</tr>
		<tr>
			<th>핸드폰</th>
			<td>${memberBean.memberHp}</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>${memberBean.memberSex}</td>
		</tr>
	
	</table>
	<br/>
	<form action="/member/updateMemberForm.do" method="post">
		<input type="submit" value="회원정보 수정하기">
	</form>
</body>
</html>