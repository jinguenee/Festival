<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<!-- Bootstrap -->
<link href="/css/bootstrap.css" rel="stylesheet" type="text/css" />
<style>
a:hover {
	text-decoration: none;
}

html, body {
	font-family: 'Noto Sans KR', sans-serif, dotum, '돋움', gulim, '굴림', Arial,
		AppleGothic, verdana, helvetica;
	font-size: 14px;
	letter-spacing: -0.05em;
	line-height: 1.6;
	font-weight: 400;
	color: #333;
	margin: 0;
	overflow-x: hidden;
	!
	important;
}

a {
	color: #333333;
	text-decoration: none;
}

a:link {
	color: #333333;
	text-decoration: none;
	transition: all .3s ease
}

a:visited {
	color: #333333;
	text-decoration: none
}

a:active {
	color: #333333;
	text-decoration: none
}

a:hover {
	color: #666666;
	text-decoration: none
}

.sub_title {
	padding-bottom: 0px;
}
-webkit-box-sizing
:
 
border-box
;

        
-moz-box-sizing
:
 
border-box
;

        
box-sizing
:
 
border-box
;
</style>
<script type="text/javascript">
    	function deleteBoard() {
    		$.ajax({
    			type: 'POST',
    			url: "/board/deleteBoardAjax.do",
                data: {
                	boardNo : "${boardList.boardNo}",
                },
                success: function(data){
                	alert(data.resultMsg);
                	if(data.result == "ok") {
                		//화면이동 처리
                		location.href="noticeList.do?pageNo=1";
                	}
                }
            }); // end of ajax
    	};
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
					<li><a href="noticeList.do?pageNo=1" class="on">자유게시판</a></li>
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
				<h2>자유게시판</h2>
			</div>

			<!-- 서브 내용 -->
			<div class="sub_content">
				<div class="write_table">
					<table>
						<tr>
							<th>제목</th>
							<td colspan="3" id="boardTitle">${boardList.boardTitle}</td>
						</tr>
						<tr>
							<th width="20%">이름</th>
							<td width="30%" id="memberName">${boardList.memberName }</td>
							<th width="20%">날짜</th>
							<td width="30%" id="regDate">${boardList.boardDate}</td>
						</tr>
						<tr>
							<th>번호</th>
							<td id="boardNo">${boardList.boardNo}</td>
							<th>조회수</th>
							<td>${boardList.boardCount+1}</td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td colspan="3"><c:forEach var="bean" items="${fileList}"
									varStatus="status">
									<c:if test="${fileList ne null}">
										<a target="_blank" href="${bean.fileImgPath}">${bean.fileOriginName}</a>
									</c:if>
								</c:forEach></td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="3" id="boardContent"><c:forEach var="bean"
									items="${fileList}" varStatus="status">
									<c:if test="${fileList ne null}">
										<img width="100%" src="${bean.fileImgPath}">
									</c:if>
								</c:forEach> ${boardList.boardContent}</td>
						</tr>
					</table>
				</div>
				<div class="container">

					<table id="commentTable"></table>

					<table class="table table-condensed">
						<tr>
							<td><span class="form-inline" role="form">

									<div class="form-group">
										<input type="text" id="commentParentName"
											name="commentParentName" class="form-control col-lg-2"
											data-rule-required="true" placeholder="이름" maxlength="10">
									</div>
									<div class="form-group">
										<input type="password" id="commentParentPassword"
											name="commentParentPassword" class="form-control col-lg-2"
											data-rule-required="true" placeholder="패스워드" maxlength="10">
									</div>
									<div class="form-group">
										<button type="button" id="commentParentSubmit"
											name="commentParentSubmit" class="btn btn-default">확인</button>
									</div> <textarea id="commentParentText"
										class="form-control col-lg-12" style="width: 100%" rows="4"></textarea>
							</span></td>
						</tr>

					</table>



					<table class="table table-condensed">
						<thead>
							<tr>
								<td><span style='float: right'>
										<button type="button" id="list" class="btn btn-default">목록</button>
										<button type="button" id="modify" class="btn btn-default">수정</button>
										<button type="button" id="delete" class="btn btn-default">삭제</button>
										<button type="button" id="write" class="btn btn-default">글쓰기</button>
								</span></td>
							</tr>
						</thead>
					</table>


					<script>
					
                        $(function(){
                              
                            //제일 하단에 있는 depth1의 댓글을 다는 이벤트
                            $("#commentParentSubmit").click(function( event ) {
                                //ajax로 저장하고 성공하면 저장한 데이터를 가져와 넣어야 하는데 여기서는 테스트라 그냥 입력값을 가져옴
                                  
		
//                                 var pName = $("#commentParentName");
//                                 var pPassword = $("#commentParentPassword");//패스워드를 노출 시켰는데 저장하고 나서 저장한 날짜를 보여줄 예정
//                                 var pText = $("#commentParentText");
//                                 if($.trim(pName.val())==""){
//                                     alert("이름을 입력하세요.");
//                                     pName.focus();
//                                     return;
//                                 }else if($.trim(pPassword.val())==""){
//                                     alert("패스워드를 입력하세요.");
//                                     pPassword.focus();
//                                     return;
//                                 } else if ($.trim(pText.val())==""){
//                                     alert("내용을 입력하세요.");
//                                     pText.focus();
//                                     return;
//                                 }

                                var commentParentText = '<tr id="r1" name="commentParentCode">'+
                                                            '<td colspan=2>'+'<strong>'+pName.val()+'</strong> '+ '<a style="cursor:pointer;" name="pDel">삭제</a><p>'+pText.val().replace(/\n/g, "<br>")+'</p>'+
                                                            '</td>'+
                                                        '</tr>';
                                  
                                //테이블의 tr자식이 있으면 tr 뒤에 붙인다. 없으면 테이블 안에 tr을 붙인다.
                                if($('#commentTable').contents().size()==0){
                                    $('#commentTable').append(commentParentText);
                                }else{
                                    $('#commentTable tr:last').after(commentParentText);
                                }
                                  
                                $("#commentParentName").val("");
                                $("#commentParentPassword").val("");
                                $("#commentParentText").val("");
                            });

                                var pText = $("#commentParentText");
                                if ($.trim(pText.val())==""){
                                    alert("내용을 입력하세요.");
                                    pText.focus();
                                    return;
                                }
							
                                  
                                var commentParentText = '<tr id="r1" name="commentParentCode">'+
                                                            '<td colspan=2>'+'<strong>'+pName.val()+'</strong> '+ '<a style="cursor:pointer;" name="pDel">삭제</a><p>'+pText.val().replace(/\n/g, "<br>")+'</p>'+
                                                            '</td>'+
                                                        '</tr>';
                                  
                                //테이블의 tr자식이 있으면 tr 뒤에 붙인다. 없으면 테이블 안에 tr을 붙인다.
                                if($('#commentTable').contents().size()==0){
                                    $('#commentTable').append(commentParentText);
                                }else{
                                    $('#commentTable tr:last').after(commentParentText);
                                }
                                  
                                $("#commentParentName").val("");
                                $("#commentParentPassword").val("");
                                $("#commentParentText").val("");
                            });
                              
                            //댓글의 댓글을 다는 이벤트
                            $(document).on("click","#commentChildSubmit", function(){
                                var cName = $("#commentChildName");
                                var cPassword = $("#commentChildPassword");
                                var cText = $("#commentChildText");
                                
                                if($.trim(cName.val())==""){
                                    alert("이름을 입력하세요.");
                                    cName.focus();
                                    return;
                                }else if($.trim(cPassword.val())==""){
                                    alert("패스워드를 입력하세요.");
                                    cPassword.focus();
                                    return;
                                } else if($.trim(cText.val())==""){
	                                alert("내용을 입력하세요.");
	                                cText.focus();
	                                return;
	                            } 
                                  
                                var commentChildText = '<tr name="commentChildCode">'+
                                                            '<td style="width:1%"><span class="glyphicon glyphicon-arrow-right"></span></td>'+
                                                            '<td style="width:99%">'+
                                                                '<strong>'+cName.val()+'</strong> '+cPassword.val()+' <a style="cursor:pointer;" name="cAdd">답글</a> | <a style="cursor:pointer;" name="cDel">삭제</a>'+
                                                                '<p>'+cText.val().replace(/\n/g, "<br>")+'</p>'+
                                                            '</td>'+
                                                        '</tr>';
                            });
                              
                            //답글링크를 눌렀을때 에디터 창을 뿌려주는 이벤트, 삭제링크를 눌렀을때 해당 댓글을 삭제하는 이벤트
                            $(document).on("click","table#commentTable a", function(){//동적으로 버튼이 생긴 경우 처리 방식
                                  
                                if($(this).attr("name")=="pDel"){
                                    if (confirm("해당 댓글을 삭제합니까?") == true){    //확인
                                          
                                        var delComment = $(this).parent().parent();
                                        var nextTr = delComment.next();
                                        var delTr;
                                        //댓글(depth1)의 댓글(depth2_1)이 있는지 검사하여 삭제
                                        while(nextTr.attr("name")=="commentCode"){
                                            nextTr = nextTr.next();
                                            delTr = nextTr.prev();//삭제하고 넘기면 삭제되서 없기 때문에 다음값을 가져오기 어려워 다시 앞으로 돌려서 찾은 다음 삭제
                                            delTr.remove();
                                        }
                                          
                                        delComment.remove();
                                          
                                    }else{   //취소
                                        return;
                                    }
                                }else if($(this).attr("name")=="cDel"){
                                    if (confirm("정말 삭제하시겠습니까??") == true){    //확인
                                        $(this).parent().parent().remove();
                                    }else{   //취소
                                        return;
                                    }
                                }else{
                                    //자기 부모의 tr을 알아낸다.
                                    var parentElement = $(this).parent().parent();
                                    //댓글달기 창을 없앤다.
                                    $("#commentEditor").remove();
                                    //부모의 하단에 댓글달기 창을 삽입
                                    var commentEditor = '<tr id="commentEditor">'+
                                                            '<td style="width:1%"> </td>'+
                                                            '<td>'+
                                                                '<span class="form-inline" role="form">'+
                                                                    '<p>'+
                                                                        '<div class="form-group">'+
                                                                            '<input type="text" id="commentChildName" name="commentChildName" class="form-control col-lg-2" data-rule-required="true" placeholder="이름" maxlength="10">'+
                                                                        '</div>'+
                                                                        '<div class="form-group">'+
                                                                            ' <input type="password" id="commentChildPassword" name="commentChildPassword" class="form-control col-lg-2" data-rule-required="true" placeholder="패스워드" maxlength="10">'+
                                                                        '</div>'+
                                                                        '<div class="form-group">'+
                                                                            '<button type="button" id="commentChildSubmit" class="btn btn-default">확인</button>'+
                                                                        '</div>'+
                                                                    '</p>'+
                                                                        '<textarea id="commentChildText" name="commentChildText" class="form-control" style="width:98%" rows="4"></textarea>'+
                                                                '</span>'+
                                                            '</td>'+
                                                        '</tr>';
                                                          
                                    parentElement.after(commentEditor); 
                                }
                                  
                            });
                              
                            $( "#list" ).click(function( event ) {
                                location.href='/community/notice';
                            });
                            $( "#modify" ).click(function( event ) {
                                location.href='/community/modify/notice/${community.id}';
                            });
                            $( "#delete" ).click(function( event ) {
                                location.href='/community/delete/notice/${community.id}';
                            });
                            $( "#write" ).click(function( event ) {
                                location.href='/community/notice/edit';
                            });
                        });
                    </script>



					<hr />
					<div class="sub_content">
						<div class="write_table">
							<!--  로그인이 되어 있을 때  -->
							<c:if
								test="${boardList.memberNo eq sessionScope.memberBean.memberNo or !empty sessionScope.memberBean.memberAdmin}">
								<button type="submit" class="btn_submit"
									onclick="location.href='noticeUpdate.do?boardNo=${boardList.boardNo}'">수정하기</button>
								<button type="submit" class="btn_delete" onclick="deleteBoard()">삭제하기</button>
								<button class="btn_back" onclick="location.href='noticeList.do'">뒤로가기</button>
							</c:if>

							<!--  로그인이 안 되어 있을 때 -->
							<c:if
								test="${boardList.memberNo ne sessionScope.memberBean.memberNo and empty sessionScope.memberBean.memberAdmin}">
								<button class="btn_back" onclick="location.href='noticeList.do'">뒤로가기</button>
							</c:if>

						</div>
					</div>

				</div>


			</div>
		</div>
	</div>


	</section>
	<!--메인끝 -->
</body>
</html>