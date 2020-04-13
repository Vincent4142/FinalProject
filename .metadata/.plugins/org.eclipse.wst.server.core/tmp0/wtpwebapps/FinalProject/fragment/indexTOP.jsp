<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>indexTOP</title>

<style type="text/css">
.nav {
	padding-left:500px;
	padding-right:500px;
	margin-top: -19px;
	margin-bottom:0px;
	background-color: #272727;
}
/* 主UL */
.navul {
	
	list-style-type: none;
	font-weight: bolder;
	font-size: 20px;
	overflow: auto;
}

.navul li {
	border-radius: 5px;
	margin-left: 0px;
	margin-right: 20px;
	float: left;
	display: block;
	position: static;
}

.navul li a {
	text-decoration: none;
	color: gray;
}

.navul li a:hover {
	color: white;
}

#navright {
	float: right;
}


</style>

</head>
<body>

	<nav id="navid" class="nav" style="text-align: center;">
	    	
		<ul class="navul">
			<li><a href="index.jsp"><img alt="logo" src="img/pineapple.jpg"></a></li>
			<li><a href="eyeMakPage.jsp">eyeMak</a></li>
			<li><a href="eyePadPage.jsp">eyePad</a></li>
			<li><a href="eyeFonePage.jsp">eyeFone</a></li>

			<div id="navright">
				<li><a href="customerServicePage.jsp">客服支援</a></li>
				<li><a href="loginSystem.jsp">登入</a></li>
				<li><a href="shoppingcartPage.jsp">購物車清單</a></li>
			</div>
		</ul>
		
	</nav>



<script type="text/javascript">


</script>
</body>
</html>