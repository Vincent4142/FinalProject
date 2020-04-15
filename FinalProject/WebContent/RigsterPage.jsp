<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RigsterPage</title>

<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>

<style type="text/css">
body {
	background-color: #E8E8E8;
	margin: 0px;
	padding: 0px;
}

#content {
	background-repeat: no-repeat;
	background-size: cover;
	height: 1200px;
	margin-top: -21px;
	margin-bottom: 0px;
	margin: auto;
	width: 800px
}

#rule:hover{
	cursor: pointer;
}

select {
	width: 99%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

/* Full-width input fields */
input[type=text], input[type=password],input[type=date] {
	width: 95%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

button:hover {
	opacity: 1;
}

/* Extra styles for the cancel button */
.cancelbtn {
	padding: 14px 20px;
	background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
	float: left;
	width: 50%;
}

/* Add padding to container elements */
.container {
	padding: 16px;
}

/* Clear floats */
.clearfix::after {
	content: "";
	clear: both;
	display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
	.cancelbtn, .signupbtn {
		width: 100%;
	}
}
</style>

</head>
<body>

	<%@ include file="fragment/indexTOP.jsp"%>


	<div id="content">
		<form action="<c:url value="/signup" />" style="border: 1px solid #ccc" method="Post">
			<div class="container">
				<h1>註冊</h1>
				<p>請填寫此表格以創建一個帳戶。</p>
				<hr>
				
				<label for="name"><b>暱稱</b></label> <input type="text"
					placeholder="10個以內的文字" name="name" > 
				
				<label for="email"><b>Email(帳號)</b></label> <input type="text"
					placeholder="電子郵件信箱" name="email" > 
					
				<label for="psw"><b>密碼</b></label> <input type="password"
					placeholder="8個以上包含半型英文和數字" name="password" > 
					
				<label for="psw-repeat"><b>再次輸入密碼</b></label> <input type="password"
					placeholder="8個以上包含半型英文和數字" name="psw-repeat" >
					
				
				<label for="id"><b>身分證號碼</b></label> <input type="text"
					placeholder="身分證號碼" name="id" > 
				
					
				<label for="birth"><b>出生年月日</b></label>
				<input type="date" id="birthdate" name="birth" placeholder="2014-09-18">	
				
				
				<label for="gender"><b>性別</b></label><br>
      				<select  id="sex" name="gender">
        				<option value="male" selected>男</option>
        				<option value="female">女</option>
      				</select><br>
				
				
				<label for="tel"><b>電話</b></label> <input type="text"
					placeholder="電話號碼" name="tel" > 
					
				
				<label for="addr"><b>地址</b></label> <input type="text"
					placeholder="地址" name="addr" > 	
				
				
				
				
					
				 	
				
      			
      			<!-- 
      			<label for="country"><b>國家/地區</b></label><br>
      				<select class="form-control" id="country" name="country">
        				<option value="taiwan" selected>台灣</option>
        				<option value="usa">美國</option>
        				<option value="japan">日本</option>
        				<option value="korea">韓國</option>
        				<option value="china">中國</option>
      				</select><br>
      			
      			
      			<label for="timezone"><b>時區</b></label><br>
      				<select class="form-control" id="timezone" name="timezone">
        				<option value="UTC+8/tai" selected>(UTC+8)taiwan</option>
        				<option value="UTC-6">UTC-6</option>
        				<option value="UTC+9/jap">(UTC+9)japan</option>
        				<option value="UTC+9/kor">(UTC+9)korea</option>
        				<option value="UTC+8/ch">(UTC+8)china</option>
      				</select><br>		
				-->	
					
					 
					
				<label ><input type="checkbox" checked="checked" name="ademail" value="Y"
					style="margin-bottom: 15px;">同意寄送最新產品廣告
				</label>

				<p>
					建立帳戶即表示您同意我們的 <label id="rule" style="color: dodgerblue;" onclick="rule()">條款及細則和私隱政策</label>
				</p>

				<div class="clearfix">
					<button type="reset" class="cancelbtn">清空</button>
					<button type="submit" class="signupbtn">註冊</button>
				</div>
			</div>
		</form>
	</div>




	<%@ include file="fragment/indexBOTTOM.jsp"%>


<script type="text/javascript">

	function rule(){
		
		window.open('rule.txt','newwindow')
		

//		$.ajax({
//			url:"rule.txt",
			
//			dataType:"text",
//			success:function(data){
				
				
//			}

//		});
		
		
	}
	

</script>

</body>
</html>