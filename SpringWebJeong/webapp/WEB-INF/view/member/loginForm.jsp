<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<script type="text/javascript" src="/js/common/jquery/jquery-3.2.1.js"> </script>
	<script type="text/javascript">
		$(function(){
			$("#btnLogin").click(function(){
				$.ajax({
					type : "post",
					url : "/member/loginProcAjax.do",
					data : {
						memberId : $("#memberId").val(),
						memberPw : $("#memberPw").val()
					},
					datatype : "json",
					success : function(data) {
						if (data.result == "ok") {
							location.replace("/index.do");
						} else {
							alert(data.result);
						}
					},
					error : function(xhr, status, error) {
						console.log(xhr);
						alert("error\nxhr : " + xhr + ", status : " + status + ", error : " + error);
					}
				}) // end of ajax()
			}) // end of click()
			$("#btnInsertMember").click(function(){
				location.href="/member/insertMemberForm.do";
			})
		})
		
	</script>
</head>
<body>
	<h3>로그인 화면</h3>
	<input type="text" id="memberId" placeholder="ID를 입력하세요" required />
	<br/>
	<input type="password" id="memberPw" placeholder="PW를 입력하세요" required />
	<br/>
	<button type="button" id="btnLogin">로그인</button>
	<button type="button" id="btnInsertMember">회원가입</button>
</body>
</html>