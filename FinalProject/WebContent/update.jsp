<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資訊商城</title>
<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<!-- TWzipcode -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- style -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<link rel="stylesheet" href="css/update.css">

<!-- /彈跳視窗 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous">
</script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<!-- 彈跳視窗/ -->
<style>
#span-right {
	float: right;
}
</style>
</head>
<body>
	<jsp:include page="fragment/indexTOP.jsp" />
	<div id="update-contain" class="update_contain">
		<div id="update-menu" class="menu_Style">
			<div id="menu-head" class="menu_headStyle">
				<div id="img">
					<!-- 點擊圖片跳出彈跳視窗 -->
					<label data-toggle="modal" data-target="#exampleModalCenter">
						<img src="${data.picture}" style="cursor:pointer;width:150px;height: 150px">
					</label>


					<!-- Modal 彈跳視窗內容-->
					<div class="modal fade" id="exampleModalCenter" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalCenterTitle"
						aria-hidden="true">
						<div class="modal-dialog modal-lg" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLongTitle"><input 
									type="file"  multiple id="picture"></h5>
									
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
								
									<img id="show" src="" alt="預覽圖片" />
								
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										onclick="upload()">上傳頭像</button>
								</div>
							</div>
						</div>
					</div>
					<script type="text/javascript">
					//點擊上傳
					function upload(){
						//js接收文件
						var formData = new FormData();
						formData.append("files", $("#picture")[0].files[0]);
						
						$.ajax({
							url : "http://localhost:8080/FinalProject/upload.action",
							type : "POST",
							data : formData ,
							contentType:false,
					        processData:false,//有必要，不然不行
					        mimeType:"multipart/form-data",
							success : function() {
								window.location.reload("update.jsp")
							}
						})
					}
					
					

					//用來顯示預覽圖片
					//imgInp(file的ID)
					$("#picture").change(function(){
				    	//當檔案改變後，做一些事 
				   		readURL(this);   // this代表<input id="imgInp">
				 	});
					
					function readURL(input){
						  if(input.files && input.files[0]){
						    var reader = new FileReader();
						    reader.onload = function (e) {
							    //顯示圖片的ID
						       $("#show").attr('src', e.target.result);
						    }
						    reader.readAsDataURL(input.files[0]);
						  }
					}
							
					</script>


				</div>
			</div>
			<div id="menu-content" class="menu_contentStyle"></div>
			<ul>
				<li><span><i class="fa fa-user"></i></span><a
					href="update.action">編輯使用者資訊</a></li>
				<li><span><i class="fa fa-lock"></i></span><a
					href="forgetPwdPage.jsp">登入與帳號安全</a></li>
				<li><span><i class="fa fa-file"></i></span><a href="">查詢訂單</a></li>
			</ul>
		</div>
		<div id="update-header">
			<h2>
				<b>|</b>編輯使用者資訊
			</h2>
		</div>
		<div id="update-content" class="content_Style">
			<div>
				<article class="card-body mx-auto" style="max-width: 600px;">
					<form>
						<div class="form_title">
							<span>個人檔案</span> <span id="span-right"> <a id="edit"
								href="#" onclick="edit()">編輯</a> <a id="a_update" href=""
								style="display: none;" onclick="update()">更新</a> <!--  <button id="a_update" style="display: none;" onclick="update()">更新</button>-->
							</span>
						</div>
						<div class="form-group input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"> <i class="fa fa-user"></i>
								</span>
							</div>
							<p id="p_nickName" class="form-control text-center p_hidden">${data.nickName}</p>
							<input id="nickName" name="name" class="form-control"
								style="display: none;" type="text" placeholder="(*)請輸入暱稱…"
								maxlength="8" value="${data.nickName}" required="required"
								onblur="checkReg4()" autocomplete="off" />
						</div>
						<!-- javaScript空標籤 -->
						<p class="text-center rexColor1">
							<span class="rexColor1"> <span id="img4"></span><span
								id="txt4"></span>
							</span>
						</p>

						<!-- CheckReg4() -->
						<script type="text/javascript">
							// callback function
							function checkReg4() {
								var rexMark = /[\u0021-\u002F\u003A-\u0040\u005B-\u0060\u007B-\u007E]/
								var imgValue = document.getElementById("img4")
								var txtValue = document.getElementById("txt4")
								var nickValue = document
										.getElementById("nickName").value
								// 不能為空值
								if (nickValue == "") {
									imgValue.innerHTML = '<i class="fa fa-times">'
									txtValue.innerHTML = '暱稱不能空白';
								}
								// 不能有標點符號 
								else if (rexMark.test(nickValue)) {
									imgValue.innerHTML = '<i class="fa fa-times">'
									txtValue.innerHTML = '不能有標點符號';
								} else {
									imgValue.innerHTML = "";
									txtValue.innerHTML = "";
								}
							}
						</script>
						<!-- form-group// -->

						<div class="form-group input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fa fa-tag"></i></span>
							</div>
							<p id="p_gender" class="form-control text-center">${data.gender}</p>
						</div>
						<!-- form-group// -->

						<div class="form-group input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"> <i class="fa fa-building"></i>
								</span>
							</div>
							<p id="p_birth" class="form-control text-center p_hidden">${data.birth}</p>
							<input id="birth" name="birth" class="form-control"
								style="display: none;" placeholder="出生年月日…" type="date"
								value="${data.birth}">
						</div>
						<!-- form-group// -->

						<div class="form-group input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"> <i class="fa fa-phone"></i></span>
							</div>
							<p id="p_phone" class="form-control text-center p_hidden">${data.phone}</p>
							<input id="phone" name="tel" class="form-control"
								style="display: none;" type="text" placeholder="請輸入電話…"
								maxlength="10" value="${data.phone}">
						</div>
						<!-- form-group// -->

						<div class="form-group input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i
									class="fa fa-address-card"></i></span>
							</div>
							<p id="p_address" class="form-control text-center p_hidden">${data.address}</p>
							<input id="address" name="addr" class="form-control"
								style="display: none;" type="text" placeholder="(*)地址…"
								size="25" onblur="checkReg6()" required="required"
								value="${data.address}" />
						</div>
						<!-- javaScript空標籤 -->
						<p class="text-center rexColor1">
							<span id="img6"></span><span id="txt6"></span>
						</p>
						<!-- CheckReg6() -->
						<script
							src="https://cdn.jsdelivr.net/npm/jquery-twzipcode@1.7.14/jquery.twzipcode.min.js"></script>
						<script type="text/javascript">
							$("#twzipcode")
									.twzipcode(
											{
												zipcodeIntoDistrict : true,
												"css" : [ "city form-control",
														"town form-control" ],
												countyName : 'county', // 設定取得縣市的name
												districtName : 'district', // 設定取得鄉鎮市區的name
												//  選擇縣市後執行
												onCountySelect : function() {
													var county = $(
															"select[name='county']")
															.val();
													$("#address").val(county);
												},
												//  選擇鄉鎮市區後執行
												onDistrictSelect : function() {
													var district = $(
															"select[name='district']")
															.val();
													var cityValue = $(
															"#address").val();
													addrValue = cityValue
															+ district;
													$("#address")
															.val(addrValue);
												}
											})

							// callback function
							function checkReg6() {
								var rexChina = /^[\u4E00-\u9FA5]/
								var imgValue = document.getElementById("img6")
								var txtValue = document.getElementById("txt6")
								var addrValue = document
										.getElementById("address").value
								// 不能為空值
								if (addrValue == "") {
									imgValue.innerHTML = '<i class="fa fa-times">'
									txtValue.innerHTML = '地址不能空白';
								}
								// 必須有中文
								else if (!rexChina.test(addrValue)) {
									imgValue.innerHTML = '<i class="fa fa-times">'
									txtValue.innerHTML = '必須有中文';
								} else {
									imgValue.innerHTML = "";
									txtValue.innerHTML = "";
								}
							}
						</script>
						<!-- form-group// -->

						
						<!-- form-group// -->
					</form>
					<!-- form-group end.// -->
				</article>
			</div>
			<!-- card.// -->
			<script type="text/javascript">
				function edit() {
					// 隱藏編輯按鈕、p標籤
					$("#edit").hide();
					$(".p_hidden").css("display", "none");
					//$("#p_nickName").hide();
					//$("#p_gender").hide();
					//$("#p_birth").hide();
					//$("#p_phone").hide();
					//$("#p_address").hide();

					// 顯示修改按鈕、text標籤
					$("#a_update").css('display', '');
					$("#nickName").css('display', '');
					$("#birth").css('display', '');
					$("#phone").css('display', '');
					$("#address").css('display', '');
					$("#ademail").css('display', '')
				}
				function update() {
					// 取欄位參數值傳給controller
					var name = $("#nickName").val();
					var birth = $("#birth").val();
					var tel = $("#phone").val();
					var addr = $("#address").val();
					var ademail = $("#ademail").val();
					
							$.ajax({
								url : "http://localhost:8080/FinalProject/updateData.action",
								type : "POST",
								data : "&name=" + name + "&birth=" + birth
										+ "&tel=" + tel + "&addr=" + addr
										+ "&ademail=" + ademail,
								success : function(data) {
									var result = eval(data);
								}
							})
				}
			</script>
		</div>
	</div>
</body>
</html>