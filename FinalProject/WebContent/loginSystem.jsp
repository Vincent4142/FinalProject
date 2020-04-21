<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1">
<title>LoginPage</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
	margin:auto;
	
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
.signbtn:hover{
	
	text-decoration:underline;
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
</style>
</head>
<body>

	<%@ include file="fragment/indexTOP.jsp"%>


	<div id="content">
		<h2>用戶登入</h2>
		<h3>${msg} ${msgs} ${updatemsg}</h3>
		<form action="<c:url value="/login" />" method="post" id="form1">


			<div class="container">
				<label for="uname"><b>帳號</b></label> <input type="text"
					placeholder="請輸入帳號" name="email" id="email" onblur="verifymail()" required> 
				<div id="checkmailtxt" style="color: red"></div><br>
					
				<label for="psw"><b>密碼</b></label> <input type="password"
					placeholder="請輸入密碼" name="password" id="password" onblur="verifypwd()" required>
				<div id="checkpwdtxt" style="color: red"></div><br>
				
				<button type="submit">登入</button>
				<p style="color: red">${errors.msg}</p>
				<a href="forgetPwdPage.jsp">忘記密碼?</a>
			</div>

			<div class="container">
				還沒有註冊?<a  class="signbtn" href="RigsterPage.jsp">建立新帳號</a>
				
			</div>
		</form>

		<div>
			<input type="button" value="一鍵輸入" onclick="input()">
		</div>
	</div>




	<%@ include file="fragment/indexBOTTOM.jsp"%>


<script type="text/javascript">

	function input(){
		$("#email").val("w92532@hotmail.com");
		$("#password").val("w41420");
		//form1.submit();
	}


	function verifymail() {

	    let txt = document.getElementById("checkmailtxt");
	    let name1 = document.getElementById("email").value;

	    let emailRule = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z]+$/;
	    
	    if (name1 == "") {
	        txt.innerHTML = "不可空白";
	        
	    }
	    else if(name1.search(emailRule)== -1){
	     
	        txt.innerHTML = "錯誤的email格式";

	    }
	    else {
	        txt.innerHTML = "";
	    }

	    

	}


	function verifypwd() {
		var rexEng = /[A-Za-z]/
		var rexNum = /[0-9]/
		
		var txtValue = document.getElementById("checkpwdtxt")
		var pwdValue = document.getElementById("password").value
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
	

</script>

</body>
</html>