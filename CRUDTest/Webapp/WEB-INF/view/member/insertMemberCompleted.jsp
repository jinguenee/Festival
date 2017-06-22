<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	회원가입
	<br />
	<br /> 회원 가입 성공 실패 : ${result}

	<div>
		<label for="memberId" style="display: inline-block; width: 100px;">회원아이디</label>
		<span>${memberBean.memberId}</span>
	</div>
	<div>
		<label for="memberName" style="display: inline-block; width: 100px;">회원명</label>
		<span>${memberBean.memberName}</span>
	</div>
	<div>
		<label for="memberPw" style="display: inline-block; width: 100px;">회원패스워드</label>
		<span>${memberBean.memberPw}</span>
	</div>
</body>
</html>
