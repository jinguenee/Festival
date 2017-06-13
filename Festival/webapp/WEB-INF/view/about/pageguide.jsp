<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Script시작 -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>GUIDE</title>
<link rel="stylesheet" type="text/css" href="/Festival/css/reset.css">
<link href="/Festival/css/main_style.css" rel="stylesheet" type="text/css" />
<!--header,footer,전체셋팅-->
<link rel="stylesheet" type="text/css" href="/Festival/css/style(sub).css">
<script src="/Festival/js/jquery-1.12.4.min.js"></script>
<!-- 스크립트 끝 -->
<script>
     $(function(){
            //아코디언
            $("#accordian ul div[id=showAc]").hide();
            $("#accordian div[id=title]").click(function(){
                var showAc = $("#accordian ul div[id=showAc]");
                showAc.slideUp();
                if(!$(this).next().is(":visible"))
                {
                    $(this).next().slideDown();
                }
            });

        });
    </script>
    <style>
        *{margin: 0; padding: 0;}
        li{
           list-style: none; 
        }
        .acImg{
            max-width: 100%;
        }
        .ac_title{
            position: relative;
            display: block;
            padding: 20px 20px;
            font-size: 1.2em;
            cursor: pointer;
            background: rgba(246, 246, 246, 1);
            color: #5a9aa8;
            z-index: 2;
            box-shadow: 0 0 10px rgba(0,0,0,.1);
            border-radius: 3px;
            margin-bottom: 10px;
        }
        .ac_cont{
            padding: 10px 20px;
            -webkit-transform: translate3d(0, 0, 0) rotate(0deg);
            -webkit-filter: blur(0px);
            margin-bottom: 20px;
            color: white;
            background-color: #5a9aa8;
        }
    </style>
</head>
<body>
		<!--메인 -->
		<section>
			<div class="sub_wrap">
				<div class="sub_bg">
					<h1>소개페이지 ABOUT</h1>
					<img src="/Festival/images/about.jpg" alt="서브배경" />	
				</div>
				<!-- 서브 네비 -->
				<div class="sub_nav">
					<div class="sub_menu">
						<h3>소개</h3>
						<ul>
							<li><a href="about.do">인사말</a></li>
							<li><a href="guide.do"  class="on">페이지 가이드</a></li>
						</ul>
					</div>
					<div class="sub_title">
						<div class="rout">
							<ul>
								<li>홈</li> > 
								<li>소개</li> > 
								<li>페이지 가이드</li> 
							</ul>
						</div>
						<h2>페이지 가이드</h2>
					</div>
                    <div class="sub_content">
                        <div id="accordian" class="accordian">
                        <ul>
                        <li>
                        <div id="title" class="clear_after ac_title">메인</div>
                        <div id="showAc" class="ac_cont">
                        <img class="acImg" src="/Festival/images/guide1.png" /><br />
                        1. 로고 : 메인으로 이동 &nbsp;&nbsp;&nbsp;&nbsp;2. 로그인/마이페이지 : 로그인 / 로그인시 개인정보확인&nbsp;&nbsp;&nbsp;&nbsp;3. 소개 : 인사말 / 페이지 가이드 화면으로 이동<br/>4. 축제 : 축제 정보 리스트 화면으로 이동&nbsp;&nbsp;&nbsp;&nbsp;
                        5. 커뮤니티 : 자유게시판 / QnA 게시판 화면으로 이동&nbsp;&nbsp;&nbsp;&nbsp;6. 검색 : 축제정보를 검색하고싶은 내용을 통해 검색 
                        </div>
                        </li>
                        <li>
                        <div id="title" class="clear_after ac_title">소개</div>
                        <div id="showAc" class="ac_cont">
                        <img class="acImg" src="/Festival/images/guide1.png" /><br />
                        1. 로고 : 메인으로 이동 &nbsp;&nbsp;&nbsp;&nbsp;2. 로그인/마이페이지 : 로그인 / 로그인시 개인정보확인&nbsp;&nbsp;&nbsp;&nbsp;3. 소개 : 인사말 / 페이지 가이드 화면으로 이동<br/>4. 축제 : 축제 정보 리스트 화면으로 이동&nbsp;&nbsp;&nbsp;&nbsp;
                        5. 커뮤니티 : 자유게시판 / QnA 게시판 화면으로 이동&nbsp;&nbsp;&nbsp;&nbsp;6. 검색 : 축제정보를 검색하고싶은 내용을 통해 검색 
                        </div>
                        </li>
                        <li>
                        <div id="title" class="clear_after ac_title">축제</div>
                        <div id="showAc" class="ac_cont">
                         <img class="acImg" src="/Festival/images/guide1.png" /><br />
                        1. 로고 : 메인으로 이동 &nbsp;&nbsp;&nbsp;&nbsp;2. 로그인/마이페이지 : 로그인 / 로그인시 개인정보확인&nbsp;&nbsp;&nbsp;&nbsp;3. 소개 : 인사말 / 페이지 가이드 화면으로 이동<br/>4. 축제 : 축제 정보 리스트 화면으로 이동&nbsp;&nbsp;&nbsp;&nbsp;
                        5. 커뮤니티 : 자유게시판 / QnA 게시판 화면으로 이동&nbsp;&nbsp;&nbsp;&nbsp;6. 검색 : 축제정보를 검색하고싶은 내용을 통해 검색 
                        </div>
                        </li>
                        <li>
                        <div id="title" class="clear_after ac_title">커뮤니티</div>
                        <div id="showAc" class="ac_cont">
                         <img class="acImg" src="/Festival/images/guide1.png" /><br />
                        1. 로고 : 메인으로 이동 &nbsp;&nbsp;&nbsp;&nbsp;2. 로그인/마이페이지 : 로그인 / 로그인시 개인정보확인&nbsp;&nbsp;&nbsp;&nbsp;3. 소개 : 인사말 / 페이지 가이드 화면으로 이동<br/>4. 축제 : 축제 정보 리스트 화면으로 이동&nbsp;&nbsp;&nbsp;&nbsp;
                        5. 커뮤니티 : 자유게시판 / QnA 게시판 화면으로 이동&nbsp;&nbsp;&nbsp;&nbsp;6. 검색 : 축제정보를 검색하고싶은 내용을 통해 검색 
                        </div>

                        </li>
                        <li>
                        <div id="title" class="clear_after ac_title">로그인</div>
                        <div id="showAc" class="ac_cont">
                         <img class="acImg" src="/Festival/images/guide1.png" /><br />
                        1. 로고 : 메인으로 이동 &nbsp;&nbsp;&nbsp;&nbsp;2. 로그인/마이페이지 : 로그인 / 로그인시 개인정보확인&nbsp;&nbsp;&nbsp;&nbsp;3. 소개 : 인사말 / 페이지 가이드 화면으로 이동<br/>4. 축제 : 축제 정보 리스트 화면으로 이동&nbsp;&nbsp;&nbsp;&nbsp;
                        5. 커뮤니티 : 자유게시판 / QnA 게시판 화면으로 이동&nbsp;&nbsp;&nbsp;&nbsp;6. 검색 : 축제정보를 검색하고싶은 내용을 통해 검색 
                        </div>
                        </li>
                        </ul>
                        </div>	
            </div>
					<!-- 서브 내용 -->
				</div>
			
			
			</div>
		</section>
		<!--메인끝 -->
</body>
</html>