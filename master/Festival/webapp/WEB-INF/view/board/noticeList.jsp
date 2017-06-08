<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
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
							<li><a href="notice_list.html" class="on">자유게시판</a></li>
                            <li><a href="qna_list.html" >Q&amp;A</a></li>
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
						<h2>자유게시판</h2>
					</div>

					<!-- 서브 내용 -->
					<div class="sub_content">
						<div class="btn_wrap">
							<button class="btn_write" onclick="location.href='noticeWrite.do' " >글쓰기</button>
							<div class="find">
								<input type="text" class="input" />
								<button class="btn_find">검색하기</button>
							</div>
						</div>
						<div class="notice_table">
							<table>
								<colgroup>
									<col width="10%">
									<col width="*">
									<col width="10%">
									<col width="15%">
									<col width="10%">
								</colgroup>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>이름</th>
									<th>날짜</th>
									<th>조회순</th>
								</tr>
								<c:forEach var="bean" items="${boardList}" varStatus="status">
								<tr>
									<td>${bean.boardNo}</td>
									<td><a href="/board/noticeView.do?boardNo=${bean.boardNo}">${bean.boardTitle}</a></td>
									<td></td>
									<td>${bean.boardDate}</td>
									<td>${bean.boardCount}</td>
								</tr>
								</c:forEach>
							</table>
						</div>
						<div class="page">
							<ul>
								<li><a href="#" class="on">1</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			
			
		</section>
		<!--메인끝 -->
	</body>
</body>
</html>