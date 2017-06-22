<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
function chkMemberId() {
	$.ajax({
		url : "/member/chkMemberId.do",
		type : "post",
		data : {
			memberId : $("#memberId").val()
		},
		dataType : "json",
		success : function(data) {

			$("<div style='text-align:center;'>" + data.resultMsg + "</div>").dialog({
				modal : true,
				resizable : false,
				buttons : [ {
					text : "확인",
					click : function() {
						$(this).dialog("close");
					}
				} ]
			});
			$(".ui-dialog-titlebar").hide();
			if (data.result == "success") {
			} else {
			}
		}
	});
}
</script>
</head>
<body>
	<form method="post" action="/member/insertMember.do">
		회원가입<br /> <br />
		<div>
			<label for="memberId" style="display: inline-block; width: 100px;">회원아이디</label>
			<input type="text" name="memberId" id="memberId" /> <input
				type="button" value="중복 체크" onclick="chkMemberId();">
		</div>
		<div>
			<label for="memberName" style="display: inline-block; width: 100px;">회원명</label>
			<span><input type="text" name="memberName" id="memberName" /></span>
		</div>
		<div>
			<label for="memberPw" style="display: inline-block; width: 100px;">회원패스워드</label>
			<span><input type="text" name="memberPw" id="memberPw" /></span>
		</div>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>

