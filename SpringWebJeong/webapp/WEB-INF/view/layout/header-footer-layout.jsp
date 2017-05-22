<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><decorator:title default="Spring 테스트웹"></decorator:title></title>

	<!-- 공통 CSS -->
	<link rel="stylesheet" type="text/css" href="/js/common/holdon/HoldOn.css" />
	
	<!-- 공통 JS -->
	<script type="text/javascript" src="/js/common/jquery/jquery-3.2.1.js"> </script>
	<script type="text/javascript" src="/js/common/common.js"> </script>
	<script type="text/javascript" src="/js/common/holdon/HoldOn.js"> </script>
	
	<decorator:head />
</head>
<body>

	<div>공통 헤더</div>
	<hr />

	<div>
		<decorator:body />
	</div>

	<hr />
	<div>공통 푸터</div>
</body>
</html>



