<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Festival_View</title>
   
   
    <!--header,footer,전체셋팅-->
   <link href="/css/main_style.css" rel="stylesheet" type="text/css" />
    <link href="/css/reset.css" rel="stylesheet" type="text/css" />
    <link href="/css/style_h.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
    <!--메인, 서브 스타일 셋팅-->
    <script type="text/javascript" src="/js/common/angular-1.6.4/angular.js"></script>
   <script type="text/javascript" src="/js/common/jquery/jquery-1.12.4.min.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script type="text/javascript" src="/js/common/common.js"></script>
    
    <!-- AngulerJS 외부js 가져오기 -->
   <script type="text/javascript" src="/js/festival/festivalApp.js"></script>
   <script type="text/javascript" src="/js/festival/festivalController.js"></script>
   
    <!--다음지도--><!-- 진근 : 라이브러리 추가함 -->
<!--<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=5572454a0ecafc7acd2c51fe7d5bed7c&libraries=services,clusterer,drawing"></script> -->
   <script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=0aa4e62923fbb9c8b879aec456fb7eec&libraries=services,clusterer,drawing"></script>
    <!--다음지도 끝-->
    
    <!-- 별점 스크립트 -->
    <script type="text/javascript" src="/js/common/js/scale.fix.js"></script>
    <script type="text/javascript" src="/js/common/js/star-rating.min.js"></script>
    <!-- 별점 스크립트 끝-->
    
    <!-- 별점 스크립트 -->
    <script type="text/javascript" src="/js/common/js/jquery.js"></script>
    <script type="text/javascript" src="/js/common//js/jquery.emojiRatings.js"></script>
    
    <!-- 별점 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- 별점 끝-->

    <!-- 아코디언   -->
    <script>
        $(function() {
            //아코디언
            $(".accordian #showAc").hide();
            $(".accordian #title").click(function() {
                var showAc = $(".accordian #showAc");
                showAc.slideUp();

                if (!$(this).next().is(":visible")) {
                    $(this).next().slideDown();
                }
            });
        });
    </script>
    <!--아코디언 script-->
   
</head>
<body>
    
   <!--메인 -->
    <section class="sec" ng-app="festivalApp" ng-controller="FestivalController" ng-init="selectFestivalView()">

        <!--축제정보-->
        <div class="about_guide">
            <div class="about">
                <h2 class="title">축제 정보</h2>
                <div class="title_hr"></div>
            </div>
            <br/>
            <!--축제정보 좌측-->
            <!-- main_slide1 -->
            <div id="myCarousel" class="carousel slide main_visual" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <a href="#"><span class="first-slide visual01"></span></a>
                    </div>
                    <div class="item">
                        <a href="#"><span class="second-slide visual02"></span></a>
                    </div>
                    <div class="item">
                        <a href="#"><span class="third-slide visual03"></span></a>
                    </div>
                </div>
                <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
            <!--축제정보 우측-->
            <!--   table  -->
            <table class="info_table">
<!--                 <thead> -->
<!--                     <tr> -->
<!--                         <th class="info_table_t">축제 이름</th> -->
<%--                         <td class="info_table_t">${fBean.festival_name}</td> --%>
<!--                     </tr> -->
<!--                 </thead> -->
                <tbody>
                     <tr>
                        <th class="info_table_t">축제 이름</th>
                        <td class="info_table_t">${fBean.festival_name}</td>
                    </tr>
                    <tr>
                        <th class="info_table_t">축제 기간</th>
                        <td class="info_table_t">${fBBean.fb_startdate} ~ ${fBBean.fb_enddate}</td>
                    </tr>
                    <tr>
                        <th class="info_table_t">축제 주소</th>
                        <td class="info_table_t">${fBBean.fb_address}</td>
                    </tr>
                    <tr>
                        <th class="info_table_t">축제 주관/주최 단체</th>
                        <td class="info_table_t">${fBBean.fb_org_name}</td>
                    </tr>
                    <tr>
                        <th class="info_table_t">축제 주관/주최 전화번호</th>
                        <td class="info_table_t">${fBBean.fb_org_phone}</td>
                    </tr>
                    <tr>
                        <th class="info_table_t">축제 주관/주최 홈페이지</th>
                        <td class="info_table_t"><a href="${fBBean.fb_org_link}">${fBBean.fb_org_link}</a></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <!--축제정보 끝-->

        <!-- 세부정보 -->
        <div class="gallery">
            <h2 class="title">세부 정보</h2>
            <div class="title_hr"></div>
            <br/><br/>
            <div class="sub_content">
                <!--아코디언-->
                <div id="accordian" class="accordian">
                    <ul>
                        <li>
                            <div id="title" class="ac_title">축제 설명</div>
                            <div id="showAc" class="ac_cont">
                                ${fBean.festival_detail_intro}
                            </div>
                        </li>
                        <li>
                            <div id="title" class="clear_after ac_title">이용 요금</div>
                            <div id="showAc" class="ac_cont">
                                ${fBean.festival_detail_fee}
                            </div>   
                        </li>
                        <li>
                            <div id="title" class="clear_after ac_title">주차 여부</div>
                            <div id="showAc" class="ac_cont">
                                ${fBean.festival_detail_parking}
                            </div>
                        </li>
                        <li>
                            <div id="title" class="clear_after ac_title">운영 시간</div>
                            <div id="showAc" class="ac_cont">
                                ${fBean.festival_detail_time}
                            </div>
                        </li>
                        <li>
                            <div id="title" class="clear_after ac_title">주의 사항</div>
                            <div id="showAc" class="ac_cont">
                                ${fBean.festival_detail_notice}
                            </div>
                        </li>
                    </ul>
                </div>
                <!-- 아코디언 끝 -->
            </div>
        </div>
        <!-- 세부정보 끝 -->

        <!--축제정보-->
        <div class="maptitle">
            <div class="about">
                <h2 class="title">지도 정보</h2>
                <div class="title_hr">
                </div>
            </div>
            <!--지도-->
            <!-- //main_slide1 -->
            <div class="map">
                <div class="service_list">
                   
                    <div id="map" style="width:1200px;height:400px;"></div>
                     
                     <script>
                       var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
                       mapOption = { 
                           center: new daum.maps.LatLng("${fBean.festival_location_x}", "${fBean.festival_location_y}"), // 지도의 중심좌표
                           level: 3 // 지도의 확대 레벨
                       };

                      var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
   
                      // 마커가 표시될 위치입니다 
                      var markerPosition  = new daum.maps.LatLng("${fBean.festival_location_x}", "${fBean.festival_location_y}"); 
   
                      // 마커를 생성합니다
                      var marker = new daum.maps.Marker({
                          position: markerPosition,
                          clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
                      });
   
                      // 마커가 지도 위에 표시되도록 설정합니다
                      marker.setMap(map);

                      
                      ///////////////////////////////////////////////////////////////////////////////
                      // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
                  var mapTypeControl = new daum.maps.MapTypeControl();
                  
                  // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
                  // daum.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
                  map.addControl(mapTypeControl, daum.maps.ControlPosition.TOPRIGHT);
                  
                  // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
                  var zoomControl = new daum.maps.ZoomControl();
                  map.addControl(zoomControl, daum.maps.ControlPosition.RIGHT);
                  ///////////////////////////////////////////////////////////////////////////////
                      
                  
                      // 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
                  var iwContent = '<div style="padding:5px;"><a target="_blank" href="${fBBean.fb_org_link}">${fBean.festival_name}<a/></div> <div style="padding:5px;"><a href="http://map.daum.net/link/to/${fBean.festival_name}, ${fBean.festival_location_x}, ${fBean.festival_location_y}" style="color:blue" target="_blank">길찾기</a> </div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
                      iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
                  
                  // 인포윈도우를 생성합니다
                  var infowindow = new daum.maps.InfoWindow({
                      content : iwContent,
                      removable : iwRemoveable
                  });
                  
                  // 마커에 클릭이벤트를 등록합니다
                  daum.maps.event.addListener(marker, 'click', function() {
                        // 마커 위에 인포윈도우를 표시합니다
                        infowindow.open(map, marker);  
                  });
                    </script>
                </div>
            </div>
            <hr/>
        </div>
        <!-- 댓글 입력 -->
        <div class="container">
            <div id="reply" class="reply">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <form id="demo">
                            <div class="form-group">
                                <label for="firstName">닉네임</label>
                                <input type="text" class="form-control" id="firstName" name="firstName">
                            </div>
                            <div class="form-group">
                                <label for="comments">덧글입력</label>
                                <textarea class="form-control" id="comments" name="comments"></textarea>
                            </div>
                            <div class="form-group" id="rating">
                                <label for="rating">평가</label>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">등록 </button>
                        </form>
                    </div>
                </div>
                
            </div>
            <!-- 댓글 입력 끝-->
         <!-- 별점 스크립트 -->
<!--             <script src="/js/common/js/jquery.js"></script> -->
<!--             <script src="/js/common//js/jquery.emojiRatings.js"></script> -->
            <script type="text/javascript">
               $(function(){
                  $("#rating").emojiRating({
                        fontSize: 32,
                        onUpdate: function(count) {
                            $(".review-text").show();
                            $("#starCount").html(count + " Star");
                        }
                    });
                    
                    $("#demo").submit(function(e) {
                        e.preventDefault();
                        var
                            name = $(this).find('#firstName').val(),
                            comments = $(this).find('#comments').val(),
                            rating = $(this).find('.emoji-rating').val(),
                            alert = 'Name: ' + name + '\nComments: ' + comments + '\nRating: ' + rating;


                        // css 디테일은 영관이가 하자 ~~~
                   var str = "";
                   str += "<div class='form-group'>";
                   str += "Name : <label for='firstName'>" + name + "</label><br/>";
                   str += "Comments : " + comments;
                   str += "</div>";
                        
                   // 최상위로 댓글 작성
                        $("#reply").after(str);
                   
                   $.ajax({
                      type : "post",
                      url : "/festival/festival_reply.do",
                      data : {
                         fr_content : comments, 
                         fr_starpoint : rating, 
                         fr_member_ideaname : name,
                         
                         festival_no : "${fBean.festival_no}", 
                         member_no : "1" // test용
                      },
                      dataType : "json",
                      success : function(data) {
                         if (data.result == "ok") {
                            alert(data.resultMsg);
                         } else {
                            alert(data.resultMsg);
                         }
                      }
                   }); // end of ajax
                    });
               });
            </script>
            <!-- 별점스크립트 끝 -->
            
        </div>
        
    </section>
    <!--메인끝 -->
    
</body>
</html>