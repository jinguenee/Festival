<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>FESTIVAL</title>

<script type="text/javascript">
	$(function() {
		$("#btnSelectMember").click(function() {
			$.ajax({
				type : "post",
				url : "/member/selectMemberProcAjax.do",
				datatype : "json",
				success : function(data) {
					if (data.result == "ok") {
						location.href = "/member/selectMemberForm.do";
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
			location.href = "/member/selectMemberListProcAjax.do";
		}) // end of click btnSelectMemberList
	})
</script>
</head>
<body>
	<!-- 	<h3>WelCome!!</h3> -->
	<%-- 	${sessionScope.memberBean.memberId} 님! 환영합니다!아닙니다. --%>

	<!-- 	<br/><br/> -->
	<!-- 	<button type="button" id="btnSelectMember">내 정보 보기</button> -->
	<!-- 	<button type="button" id="btnSelectMemberList">전체 회원 보기</button> -->
	<!-- 	<button type="button" id="btnBoardList">게시판</button> -->
	<!-- 	<button type="button" id="btnBoard">내가 쓴 게시물만 보기</button> -->

	<!--메인 -->
	<section class="index_section">

		<div class="section_search">
			<div class="text_guide">놀러가고 싶으신 곳이 있으신가요? 축제에 관련된 내용을 아래에서
				검색해보세요!</div>
			<input class="text_search" type="text" size="30" maxlength="30"
				placeholder="검색할 내용을 입력하세요." /> <a class="btn_search" href="#"><img
				src="images/search_image.jpg" /></a>
		</div>

		<div id="myCarousel" class="carousel slide main_visual"
			data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<a href="#"><span class="first-slide visual01">메인01</span></a>
				</div>

				<div class="item">
					<a href="#"><span class="second-slide visual02">메인02</span></a>
				</div>

				<div class="item">
					<a href="#"><span class="third-slide visual03">메인03</span></a>
				</div>
				<div class="item">
					<a href="#"><span class="third-slide visual04">메인04</span></a>
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>

	</section>
	<!--메인끝 -->

</body>
</html>