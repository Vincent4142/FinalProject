<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>indexTop</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
body {
	margin: 0px;
	padding: 0px;
	background-color: #E8E8E8;
}

.top1 {
	margin: 0px 20% 0px 20%;
	overflow: auto;
}

.fixed_top1 {
	/* fixed 固定住位置, top:0 代表固定在最上面 */
	position: fixed;
	top: 0;
	width: 100%;
}

#containTop {
	background-color: #272727;
}

#m1 {
	float: left;
}

#m2 {
	float: right;
}

table tr td {
	padding-right: 20px;
}

table tr td a {
	color: #F0F0F0;
	text-decoration: none;
}

table tr td a:hover {
	color: white;
	text-decoration: none;
}
</style>
</head>
<body>
	<div id="containTop">
		<div id="header" class="top1">
			<table id="m1">
				<tr>
					<td><a href="index.jsp"><img src="img/index.jpg" /></a></td>
					<td><a href="">eyeMac</a></td>
					<td><a href="">eyePad</a></td>
					<td><a href="">eyePhone</a></td>
				</tr>
			</table>
			<table id="m2">
				<tr>
					<td><a href=""><img src="img/query.jpg" onclick="query()" /></a></td>
					<td><a href="">支援</a></td>
					<c:if test="${empty identity }">
						<td><a href="loginSystem.jsp">登入</a></td>
					</c:if>
					<c:if test="${!empty identity }">
						<td><a id="logout" href="<c:url value="/logout.do" />">登出</a></td>
					</c:if>
					<c:if test="${!empty identity }">
						<td><a id="update" href="<c:url value="update.action" />">個人資料</a></td>
					</c:if>
					<td><a href="">購物車</a></td>
				</tr>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			//offset() ：讀取指定元素在頁面(文件)上的相對坐標，
			//回傳含有top及left屬性的物件            

			let navbarPosition = $('#containTop').offset().top;
			$(window).scroll(function() {
				let scrollTop = $(this).scrollTop();

				if (scrollTop > navbarPosition) {
					$('#containTop').addClass("fixed_top1")
				} else {
					$("#containTop").removeClass("fixed_top1")
				}
			});
		})

		
	</script>
</body>
</html>