<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		function updateBoard() {
			$.ajax({
                type: 'POST',
                url: "/board/noticeUpdateAjax.do",
                data: {
                	boardNo : "${boardList.boardNo}",
                	boardTitle : $("#boardTitle").val(),
                	boardContent : $("#boardContent").val()
                },
                dataType: "json",
                success: function(data){
                	
                	alert(data.resultMsg);
                	
                	if(data.result == "ok") {
                		//화면이동 처리
                		location.href="/board/noticeList.do";
                	}
                }
            }); // end of ajax
		}
	</script>
</head>
<body>
		<!--메인 -->
		<section>
			<div class="sub_wrap">
				<div class="sub_bg">
					<h1>커뮤니티 Community</h1>
					<img src="/images/community.jpg" alt="서브배경" />	
				</div>
				<!-- 서브 네비 -->
				<div class="sub_nav">
					<div class="sub_menu">
						<h3>커뮤니티</h3>
						<ul>
							<li><a href="noticeList.do" class="on">자유게시판</a></li>
							<li><a href="qna_list.html"> Q&amp;A </a></li>
						</ul>
					</div>
					<div class="sub_title">
						<div class="rout">
							<ul>
								<li>홈</li> > 
								<li>커뮤니티</li> > 
								<li>자유게시판</li>
							</ul>
						</div>
						<h2>자유게시판 글수정</h2>
					</div>

					<!-- 서브 내용 -->
					<div class="sub_content">
						<div class="write_table">
							<table>
								<tr>
									<th>제목</th>
									<td><input type="text" class="input" id="boardTitle" value="${boardList.boardTitle}"></td>
								</tr>
								<tr>
									<th>첨부파일</th>
									<td><input type="file"></td>
								</tr>
								<tr>
									<th>내용</th>
									<td><textarea id="boardContent">${boardList.boardContent}</textarea></td>
								</tr>
							</table>
							<button type="submit" class="btn_submit" onclick="updateBoard()">수정하기</button>
						</div>
					</div>
				</div>
			</div>
			
			
		</section>
		<!--메인끝 -->
</body>
</html>