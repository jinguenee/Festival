<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>YG's World</title>
<link rel="stylesheet" type="text/css" href="/Festival/css/reset.css" />
<link href="/Festival/css/main_style.css" rel="stylesheet" type="text/css" />
<!--header,footer,전체셋팅-->
<link rel="stylesheet" type="text/css" href="/Festival/css/style(sub).css" />
<script type="text/javascript" src="/Festival/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	function logoutAjax() {
		$.ajax({
			url : "/Festival/member/logoutAjax.do",
			method : "POST",
			data : {},
			dataType : "json",

			success : function(data) {
				if (data.result == "ok") {
					location.href = "/Festival/index.do"
				} else {
					alert(data.resultMsg);
				}
			}
		});
	}
</script>
<style>
</style>
<decorator:head />
</head>
<body>
	<!-- header : s -->
	<c:import url="/WEB-INF/view/layout/header-layout.jsp"></c:import>
	<!-- header : e -->
	<div>
		<decorator:body />
	</div>
	<!-- footer : s -->
	<c:import url="/WEB-INF/view/layout/footer-layout.jsp"></c:import>
	<!-- footer : e -->

</body>
</html>