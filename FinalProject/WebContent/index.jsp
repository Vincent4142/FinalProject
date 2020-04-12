<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<style type="text/css">
body {
	background-color:#E8E8E8;
	margin: 0px;
	padding: 0px;
}

#content {
	background-image: url(img/indexbackground.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	height: 1000px;
	margin-top: -21px;
	margin-bottom: 0px;
	text-align: center;
}


</style>
</head>
<body>

	<%@ include file="fragment/indexTOP.jsp"%>


	<div id="content">
		<h1>這是起始頁</h1>
	</div>




	<%@ include file="fragment/indexBOTTOM.jsp"%>
	

</body>
</html>