<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<script type="text/javascript">
		$(function(){
			$("#btnSelectMember").click(function(){
				$.ajax({
					type : "post",
					url : "/member/selectMemberProcAjax.do",
					datatype : "json",
					success : function(data) {
						if (data.result == "ok") {
							location.href="/member/selectMemberForm.do";
						} else {
							alert(data.result);
						}
					},
					error : function(xhr, status, error) {
						console.log(xhr);
						alert("error\nxhr : " + xhr + ", status : " + status + ", error : " + error);
					}
				}) // end of ajax
			}) // end of click btnSelectMember
			
			$("#btnSelectMemberList").click(function() {
				location.href="/member/selectMemberListProcAjax.do";
			}) // end of click btnSelectMemberList
		})
	
	</script>
</head>
<body>
	<h3>WelCome!!</h3>
	${sessionScope.memberBean.memberId} 님! 환영합니다!아닙니다.
	
	<br/><br/>
	<button type="button" id="btnSelectMember">내 정보 보기</button>
	<button type="button" id="btnSelectMemberList">전체 회원 보기</button>
	<button type="button" id="btnBoardList">게시판</button>
	<button type="button" id="btnBoard">내가 쓴 게시물만 보기</button>
	
</body>
</html>