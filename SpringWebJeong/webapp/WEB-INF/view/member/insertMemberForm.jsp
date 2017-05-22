<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<script type="text/javascript">
		function insertMember() {
			// 핸드폰번호를 문자열 결합한다
			var hp = $("#memberHp0").val() + "-" + $("#memberHp1").val() + "-" + $("#memberHp2").val();
			// 결합한 문자열을 추가한다.
			$("#memberHp").val(hp);
			
			console.log( $("#memberForm").serialize());
			
			$.ajax({
				type : "post",
				url : "/member/insertMemberProcAjax.do",
				data : $("#memberForm").serialize(), // 아래 Form 태그의 id 명을 가져옴
				dataType : "json",
				
				success : function(data){ // 여기서 data 는 컨트롤러에서 Map.push 했을 때, 넣어준 값을 의미한다.
					console.log(data);
					if (data.result == "ok") {
						alert(data.resultMsg); 
						location.replace("/member/loginFormAjax.do");
						return;
					} else {
						alert(data.resultMsg);
					}
				},
				error : function(xhr, status, error) {
					console.log(xhr);
					alert("error\nxhr : " + xhr + ", status : " + status + ", error : " + error);
				}
			}); // end of $.ajax()
		}
	</script>
	
</head>
<body>
	<h3>회원가입 화면</h3>
	
	<form id="memberForm">
		id : <input type="text" name="memberId" maxlength="13" required /> <br/> <!-- maxlength="13" required : 중요함  -->
		pw : <input type="password" name="memberPw" maxlength="20" required /> <br/>
		이름 : <input type="text" name="memberName" maxlength="20" /> <br/>
		나이 : 
		<select name="memberAge">
			<c:forEach var="i" begin="1" end="100" varStatus="status">
				<option value="${i}" ${i==20?'selected=selected' : '' }>${i}</option>
			</c:forEach>
		</select> 
		<br/>
		
		지역 : <select name="memberArea">
			<option value="서울시">서울시</option>
			<option value="천안시">천안시</option>
			<option value="순천시">순천시</option>
		</select> 
		<br/>
		
		핸드폰 : <select name="memberHp0" id="memberHp0">
			<option value="010">010</option>
			<option value="011">011</option>
		</select>
		- <input id="memberHp1" type="text" maxlength="4" />
		- <input id="memberHp2" type="text" maxlength="4" />  
		<input type="hidden" id="memberHp" name="memberHp" />
		<br/>
		
		<input type="radio" name="memberSex" value="F" >여자 
		<input type="radio" name="memberSex" value="M" >남자
		<br/>
		
		<button type="button" onclick="insertMember(); return false;">회원가입하기</button> &nbsp;&nbsp; 
		<button type="button" onclick="javascript:history.back();">취소</button>
	</form>
	
</body>
</html>