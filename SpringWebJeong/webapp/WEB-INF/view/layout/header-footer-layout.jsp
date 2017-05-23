<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
	<title><decorator:title default="Spring 테스트웹"></decorator:title></title>

	<!-- 공통 CSS -->
	<link rel="stylesheet" type="text/css" href="/js/common/holdon/HoldOn.css" />
	
	<!-- 최종프로젝트에 쓰이는 CSSS -->
	<link rel="stylesheet" type="text/css" href="css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="css/main_style.css"/> <!--header,footer,전체셋팅-->
    <link rel="stylesheet" type="text/css" href="css/style(sub).css"/>   
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<!-- 공통 JS -->
	<script type="text/javascript" src="/js/common/jquery/jquery-3.2.1.js"> </script>
	<script type="text/javascript" src="/js/common/common.js"> </script>
	<script type="text/javascript" src="/js/common/holdon/HoldOn.js"> </script>
	
	<!-- 최종프로젝트에 쓰이는 JS -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js/jquery-1.12.4.min.js"></script>
	
	<decorator:head />
</head>
<body>

<!-- 	<div>공통 헤더</div> -->
	<header>
        <div class="head">
            <h1 class="logo">
                <a href="index.html">
                    <img src="images/title_subject.png" alt="로고">
                </a>
            </h1>
            
            <div class="menu_box">
                <ul class="menu_member">
                     <li>
                        <a href="login.html">로그인</a>
                    </li>
                     <li>
                        <a href="informationchange.html">마이페이지</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="head2">
            <div class="menu_box2">
                <ul class="menu_title">
                    <li>
                        <a href="about.html">소개</a>
                        <ul class="menu_list">
                            <li><a href="about.html">인사말</a></li>
                            <li><a href="guide.html">페이지 가이드</a></li>
                        </ul>
                    </li>
                     <li>
                        <a href="gallery.html">축제</a>
                    </li>
                     <li>
                        <a href="notice_list.html">커뮤니티</a>
                        <ul class="menu_list">
                            <li><a href="notice_list.html">자유게시판</a></li>
                            <li><a href="qna_list.html">QnA</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </header>
	

	<div>
		<decorator:body />
	</div>

	<footer>
		<div class="grid">
			<ul>
				<li>소재지 : 서울특별시 강남구 논현로79길 57 2층 / 대표자 : 홍길동 / 대표전화 : 0000-0000</li>
				<li>사업자등록번호 : 강남-가-000-0000  /  통신판매업신고 : 강남-허-00000  /  이메일 : abc@gmail.com</li>
				<li>Copyright 2017. All right reserved.</li>
			</ul>
		</div>
	</footer>
</body>
</html>



