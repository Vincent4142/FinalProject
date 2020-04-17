<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updatePwdPage</title>
<style type="text/css">
body {
	background-color: #E8E8E8;
	margin: 0px;
	padding: 0px;
}

#content {
	background-repeat: no-repeat;
	background-size: cover;
	height: 1000px;
	margin-top: -21px;
	margin-bottom: 0px;
	margin: auto;
	width: 800px
}

form {
	border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

.signbtn {
	width: auto;
	padding: 5px 5px;
	border-radius: 10px;
	border: 2px solid pink;
	margin: 10px;
	background-color: white;
	text-decoration: none;
}

.signbtn:hover {
	text-decoration: underline;
	background-color: #CCFFFF;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}

#user {
	background-color: #E8E8E8;
	color: blue;
	border: 0px;
	font-size: 20px;
}
</style>
</head>
<body>

	<%@ include file="fragment/indexTOP.jsp"%>

	<div id="content">
		<h2>修改密碼</h2>

		<form action="<c:url value="/memorycover.action" />" method="post" onsubmit="return checksubmit();">
			<label><b>目前使用者:</b></label> <input id="user" type="text"
				name="email" value=${ email} readonly="readonly" />
			<div class="container">
				<label for="psw"><b>請輸入密碼</b></label> <input type="password"
					placeholder="請輸入密碼" name="password" id="pwd" onkeyup="checkReg2()"
					required> 
				<span style="color: red" id="txt2"></span><br><br>
							
					
					<label for="psw-repeat"><b>請再次輸入密碼</b></label> <input
					type="password" placeholder="請再次輸入密碼" name="pwd-repeat" id="repwd"
					onkeyup="checkReg3()" required>
				<span style="color: red" id="txt3"></span><br><br>	

				<button type="submit">完成修改</button>


			</div>


		</form>


	</div>

	<%@ include file="fragment/indexBOTTOM.jsp"%>



	<script type="text/javascript">
		function checksubmit(){

			var pwd=document.getElementById("txt2").innerHTML;
			var pwdre=document.getElementById("txt3").innerHTML;
			
			if( pwd !="" || pwdre !=""){
				window.alert("欄位輸入錯誤！請重新輸入");
				return false;
			}
			else{
				return true;
			}
		}


	
		// callback function
		function checkReg2() {
			var rexEng = /[A-Za-z]/
			var rexNum = /[0-9]/
			
			var txtValue = document.getElementById("txt2")
			var pwdValue = document.getElementById("pwd").value
			// 不能為空值
			if (pwdValue == "") {
				
				txtValue.innerHTML = '密碼不能空白';
			}
			// 至少六個字
			else if (pwdValue.length < 6) {
				
				txtValue.innerHTML = '至少六個字';
			}
			// 判斷英文
			else if (!rexEng.test(pwdValue)) {
				
				txtValue.innerHTML = '沒有英文';
			}
			// 判斷數字
			else if (!rexNum.test(pwdValue)) {
				
				txtValue.innerHTML = '沒有數字';
			} else {
				
				txtValue.innerHTML = "";
			}
		}
		// callback function
		function checkReg3() {
			var rexEng = /[A-Za-z]/
			var rexNum = /[0-9]/
			
			var txtValue = document.getElementById("txt3")
			var pwdValue = document.getElementById("pwd").value
			var repwdValue = document.getElementById("repwd").value
			// 不能為空值
			if (repwdValue == "") {
				
				txtValue.innerHTML = '二次密碼不能空白';
			}
			// 至少六個字
			else if (repwdValue.length < 6) {
				
				txtValue.innerHTML = '至少六個字';
			}
			// 判斷英文
			else if (!rexEng.test(repwdValue)) {
				
				txtValue.innerHTML = '沒有英文';
			}
			// 判斷數字
			else if (!rexNum.test(repwdValue)) {
				
				txtValue.innerHTML = '沒有數字';
			}
			// 密碼相等
			else if (repwdValue != pwdValue) {
				
				txtValue.innerHTML = '二次密碼和密碼不同';
			} else {
				
				txtValue.innerHTML = "";
			}
		}
	</script>
</body>
</html>