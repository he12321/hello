<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>我的订单 - 阿甲学子商城</title>
<link href="../css/myOrder.css" rel="Stylesheet" />
<link href="../css/header.css" rel="Stylesheet" />
<link href="../css/footer.css" rel="Stylesheet" />
<link href="../css/personage.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="../css/icon/css/bootstrap.min.css">
<link href="../css/icon/css/cropper.min.css" rel="stylesheet">
<link href="../css/icon/css/sitelogo.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="../css/icon/css/font-awesome.min.css">
</head>
<body>
	<!-- 页面顶部-->
	<header id="top">
		<div id="logo" class="lf">
			<img class="animated jello" src="../images/header/logo.png"
				alt="logo" />
		</div>
		<div id="top_input" class="lf">
			<input id="input" type="text" placeholder="请输入您要搜索的内容" />
			<div class="seek" tabindex="-1">
				<div class="actived">
					<span>分类搜索</span> <img src="../images/header/header_normal.png"
						alt="" />
				</div>
				<div class="seek_content">
					<div id="shcy">生活餐饮</div>
					<div id="xxyp">学习用品</div>
					<div id="srdz">私人订制</div>
				</div>
			</div>
			<a href="" class="rt"><img id="search"
				src="../images/header/search.png" alt="搜索" /></a>
		</div>
		<div class="rt">
			<ul class="lf">
				<li><a href="myCollect.html" title="我的收藏"><img class="care"
						src="../images/header/care.png" alt="" /></a><b>|</b></li>
				<li><a href="myOrder.html" title="我的订单"><img class="order"
						src="../images/header/order.png" alt="" /></a><b>|</b></li>
				<li><a href="cart.html" title="我的购物车"><img class="shopcar"
						src="../images/header/shop_car.png" alt="" /></a><b>|</b></li>
				<li><a href="lookforward.html">帮助</a><b>|</b></li>
				<li><a href="login.html">登录</a></li>
			</ul>
		</div>
	</header>
	<!-- 主导航-->
	<nav id="nav">
		<ul>
			<li><a href="index.html">首页</a></li>
			<li><a href="item_food.html">生活餐饮</a></li>
			<li><a href="itemCat.html">学习用品</a></li>
			<li><a href="lookforward.html">私人定制</a></li>
		</ul>
	</nav>
	<!-- 我的订单导航栏-->
	<div id="nav_order">
		<ul>
			<li><a href="">首页<span>&gt;</span>个人中心
			</a></li>
		</ul>
	</div>
	<!--我的订单内容区域 #container-->
	<div id="container" class="clearfix">
		<!-- 左边栏-->
		<div id="leftsidebar_box" class="lf">
			<div class="line"></div>
			<dl class="my_order">
				<dt onClick="changeImage()">
					我的订单 <img src="../images/myOrder/myOrder2.png">
				</dt>
				<dd class="first_dd">
					<a href="myOrder.html">全部订单</a>
				</dd>
				<dd>
					<a href="#"> 待付款 <span> <!--待付款数量-->
					</span>
					</a>
				</dd>
				<dd>
					<a href="#"> 待收货 <span> <!--待收货数量-->1
					</span>
					</a>
				</dd>
				<dd>
					<a href="#"> 待评价<span> <!--待评价数量-->
					</span>
					</a>
				</dd>
				<dd>
					<a href="#">退货退款</a>
				</dd>
			</dl>

			<dl class="footMark">
				<dt onClick="changeImage()">
					我的优惠卷<img src="../images/myOrder/myOrder1.png">
				</dt>
			</dl>

			<dl class="address">
				<dt>
					收货地址<img src="../images/myOrder/myOrder1.png">
				</dt>
				<dd>
					<a href="addressAdmin.html">地址管理</a>
				</dd>
			</dl>
			<dl class="count_managment">
				<dt onClick="changeImage()">
					帐号管理<img src="../images/myOrder/myOrder1.png">
				</dt>
				<dd class="first_dd">
					<a href="personage.html">我的信息</a>
				</dd>
				<dd>
					<a href="personal_password.html">安全管理</a>
				</dd>
			</dl>
		</div>
		<!-- 右边栏-->
		<!--个人信息头部-->
		<div class="rightsidebar_box rt">
			<div class="rs_header">
				<span class="rs_header_active"><a href="personage.html">我的信息</a></span>
				<span><a href="personal_password.html">安全管理</a></span>
			</div>

			<!--个人信息具体内容 -->
			<div class="rs_content">
				<!--头像-->
				<div class="rs_content_headPortrait">
					<span class="same">我的头像：</span> <img
						src="../images/personage/touxiang.png" alt="" id="icon"
						width="50px" height="50px" /> <input type="hidden" name="iconPic"
						value="" id="iconPic"> <span
						class="change_headPortrait same_click" data-toggle="modal"
						data-target="#avatar-modal">更改头像</span>
				</div>
				<!--用户名-->
				<div class="rs_content_username">
					<span class="same">用户名：</span> <span class="same rs_username">000000</span>
					<input class="ed_username" value="" style="display: none;" /> <span
						class="change_username same_click">更改用户名</span>
				</div>
				<!--性别-->
				<div class="rs_content_sex">
					<span class="same">性别：</span> <span class="man selected"> <img
						src="../images/personage/select.png" alt="" />男
					</span> <span class="women"> <img
						src="../images/personage/un_select.png" alt="" />女
					</span>
				</div>



				<form id="msgChange" method="post" name="msgChange"
					action="../msgChange.do">

					<!--绑定电话-->
					<div class="rs_content_tel">
						<span class="same">绑定电话：</span> <input required id="phone"
							name="phone" placeholder="请输入您的手机号" type="text" /> <span
							class="msg-default hidden" id="uphspan">请输入合法的手机号</span>
					</div>


					<!--绑定邮箱-->
					<div class="rs_content_tel">
						<span class="same">绑定邮箱：</span> <input required id="email"
							name="email" placeholder="请输入邮箱地址" type="text" /> <span
							class="msg-default hidden" id="uespan">请输入合法的邮箱地址</span>
					</div>


					<!--保存按钮-->
					<div class="form-group">
						<label></label> <input type="button" value="保存更改信息" id="bt-change"
							class="save" />
					</div>

				</form>


			</div>
		</div>
	</div>
	<!-- 头像插件 -->
	<div class="modal fade" id="avatar-modal" aria-hidden="true"
		aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<form class="avatar-form">
					<div class="modal-header">
						<button class="close" data-dismiss="modal" type="button">×</button>
						<h4 class="modal-title" id="avatar-modal-label">上传图片</h4>
					</div>
					<div class="modal-body">
						<div class="avatar-body">
							<div class="avatar-upload">
								<input class="avatar-src" name="avatar_src" type="hidden">
								<input class="avatar-data" name="avatar_data" type="hidden">
								<label for="avatarInput" style="line-height: 35px;">图片上传</label>
								<button class="btn btn-info" type="button" style="height: 35px;"
									onClick="$('input[id=avatarInput]').click();">请选择图片</button>
								<span id="avatar-name"></span> <input class="avatar-input hide"
									id="avatarInput" name="avatar_file" type="file">
							</div>
							<div class="row">
								<div class="col-md-9">
									<div class="avatar-wrapper"></div>
								</div>
								<div class="col-md-3">
									<div class="avatar-preview preview-lg" id="imageHead"></div>
								</div>
							</div>
							<div class="row avatar-btns">
								<div class="col-md-4">
									<div class="btn-group">
										<button class="btn btn-info fa fa-undo" data-method="rotate"
											data-option="-90" type="button" title="Rotate -90 degrees">
											向左旋转</button>
									</div>
									<div class="btn-group">
										<button class="btn  btn-info fa fa-repeat"
											data-method="rotate" data-option="90" type="button"
											title="Rotate 90 degrees">向右旋转</button>
									</div>
								</div>
								<div class="col-md-5" style="text-align: right;">
									<button class="btn btn-info fa fa-arrows"
										data-method="setDragMode" data-option="move" type="button"
										title="移动">
										<span class="docs-tooltip" data-toggle="tooltip" title=""
											data-original-title="$().cropper("setDragMode", "move")">
										</span>
									</button>
									<button type="button" class="btn btn-info fa fa-search-plus"
										data-method="zoom" data-option="0.1" title="放大图片">
										<span class="docs-tooltip" data-toggle="tooltip" title=""
											data-original-title="$().cropper("zoom", 0.1)"> <!--<span class="fa fa-search-plus"></span>-->
										</span>
									</button>
									<button type="button" class="btn btn-info fa fa-search-minus"
										data-method="zoom" data-option="-0.1" title="缩小图片">
										<span class="docs-tooltip" data-toggle="tooltip" title=""
											data-original-title="$().cropper("zoom", -0.1)"> <!--<span class="fa fa-search-minus"></span>-->
										</span>
									</button>
									<button type="button" class="btn btn-info fa fa-refresh"
										data-method="reset" title="重置图片">
										<span class="docs-tooltip" data-toggle="tooltip" title=""
											data-original-title="$().cropper("
											reset")" aria-describedby="tooltip866214">
									</button>
								</div>
								<div class="col-md-3">
									<button id="button_save"
										class="btn btn-info btn-block avatar-save fa fa-save"
										type="button" data-dismiss="modal">保存修改</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 品质保障，私人定制等-->
	<div id="foot_box">
		<div class="icon1 lf">
			<img src="../images/footer/icon1.png" alt="" />

			<h3>品质保障</h3>
		</div>
		<div class="icon2 lf">
			<img src="../images/footer/icon2.png" alt="" />

			<h3>私人定制</h3>
		</div>
		<div class="icon3 lf">
			<img src="../images/footer/icon3.png" alt="" />

			<h3>学员特供</h3>
		</div>
		<div class="icon4 lf">
			<img src="../images/footer/icon4.png" alt="" />

			<h3>专属特权</h3>
		</div>
	</div>
	<!-- 页面底部-->
	<div class="foot_bj">
		<div id="foot">
			<div class="lf">
				<p class="footer1">
					<img src="../images/footer/logo.png" alt="" class=" footLogo" />
				</p>
				<p class="footer2">
					<img src="../images/footer/footerFont.png" alt="" />
				</p>

			</div>
			<div class="foot_left lf">
				<ul>
					<li><a href="#"><h3>买家帮助</h3></a></li>
					<li><a href="#">新手指南</a></li>
					<li><a href="#">服务保障</a></li>
					<li><a href="#">常见问题</a></li>
				</ul>
				<ul>
					<li><a href="#"><h3>商家帮助</h3></a></li>
					<li><a href="#">商家入驻</a></li>
					<li><a href="#">商家后台</a></li>
				</ul>
				<ul>
					<li><a href="#"><h3>关于我们</h3></a></li>
					<li><a href="#">关于阿甲</a></li>
					<li><a href="#">联系我们</a></li>
					<li><img src="../images/footer/wechat.png" alt="" /> <img
						src="../images/footer/sinablog.png" alt="" /></li>
				</ul>
			</div>
			<div class="service">
				<p>阿甲商城客户端</p>
				<img src="../images/footer/ios.png" class="lf"> <img
					src="../images/footer/android.png" alt="" class="lf" />
			</div>
			<div class="download">
				<img src="../images/footer/erweima.png">
			</div>
			<!-- 页面底部-备案号 #footer -->
			<div class="record">&copy;2017 阿甲集团有限公司 版权所有 京ICP证xxxxxxxxxxx</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/order.js"></script>
<script type="text/javascript" src="../js/personal.js"></script>
<script src="../js/icon/bootstrap.min.js"></script>
<script src="../js/icon/cropper.js"></script>
<script src="../js/icon/sitelogo.js"></script>
<script src="../js/icon/html2canvas.min.js" type="text/javascript"
	charset="utf-8"></script>



<script type="text/javascript">
	/*1.对邮箱地址进行验证*/
	email.onblur = function() {
		var reg = /^\w+@\w+\.\w+$/;
		var data = email.value;
		if (this.validity.valueMissing) {
			this.nextElementSibling.innerHTML = '邮箱不能为空';
			this.nextElementSibling.className = 'msg-error';
			this.setCustomValidity('邮箱不能为空');
		} else if (!reg.test(data)) {
			this.nextElementSibling.innerHTML = '邮箱格式不正确';
			this.nextElementSibling.className = 'msg-error';
			this.setCustomValidity('邮箱格式不正确');
		} else {
			/**发起异步GET请求，询问服务器用户名是否已经存在**/
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function() {
				if (xhr.readyState === 4) {//响应完成
					var result = xhr.responseText;
					if (result == "0") {
						uespan.className = 'msg-error';
						uespan.innerHTML = "邮箱已经被占用，不能重复注册！";
					} else if (result == "1") {
						uespan.className = 'msg-success';
						uespan.innerHTML = "恭喜！该邮箱可以注册！";
					} else {
						uespan.className = 'msg-error';
						uespan.innerHTML = "服务器正在维护！请与管理员联系";
					}
				}
			}
			//3 打开连接
			xhr.open('GET', '../checkEmail.do?email=' + data, true);
			//4 发送请求
			xhr.send(null);
		}
	}
	email.onfocus = function() {
		this.nextElementSibling.innerHTML = '请输入合法的邮箱地址';
		this.nextElementSibling.className = 'msg-default';
	}

	/*2.对手机号进行验证*/
	phone.onblur = function() {
		var data = phone.value;
		var reg = /^1[3|4|5|6|7|8]\d{9}$/;
		if (this.validity.valueMissing) {
			this.nextElementSibling.innerHTML = '手机号不能为空';
			this.nextElementSibling.className = 'msg-error';
			this.setCustomValidity('手机号不能为空');
		} else if (!reg.test(data)) {
			this.nextElementSibling.innerHTML = '手机号格式不正确';
			this.nextElementSibling.className = 'msg-error';
			this.setCustomValidity('手机号格式不正确');
		} else {
			/**发起异步GET请求，询问服务器用户名是否已经存在**/
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function() {
				if (xhr.readyState === 4) {//响应完成
					var result = xhr.responseText;
					if (result == "0") {
						uphspan.className = 'msg-error';
						uphspan.innerHTML = "手机号不能重复注册！";
					} else if (result == "1") {
						uphspan.className = 'msg-success';
						uphspan.innerHTML = "恭喜！该手机号可以注册！";
					} else {
						uphpan.className = 'msg-error';
						uphspan.innerHTML = "服务器正在维护！请与管理员联系";
					}
				}
			}
			//3 打开连接
			xhr.open('GET', '../checkPhone.do?phone=' + data, true);
			//4 发送请求
			xhr.send(null);
		}
	}
	phone.onfocus = function() {
		this.nextElementSibling.innerHTML = '请输入合法的手机号';
		this.nextElementSibling.className = 'msg-default';
	}
</script>

<script>
	$('#bt-change').click(function() {
		var lengths = 0;
			if ($('#uphspan').hasClass('msg-success')) {
				lengths++;
			}
			if ($('#uespan').hasClass('msg-success')) {
				lengths++;
			}

		if (lengths == 2) {
			alert("修改成功");
			msgChange.submit();
		}
	});
</script>



<script type="text/javascript">
	//做个下简易的验证  大小 格式  
	$('#avatarInput').on('change', function(e) {
		var filemaxsize = 1024 * 5;//5M 
		var target = $(e.target);
		var Size = target[0].files[0].size / 1024;
		if (Size > filemaxsize) {
			alert('图片过大，请重新选择!');
			$(".avatar-wrapper").childre().remove;
			return false;
		}
		if (!this.files[0].type.match(/image.*/)) {
			alert('请选择正确的图片!')
		} else {
			var filename = document.querySelector("#avatar-name");
			var texts = document.querySelector("#avatarInput").value;
			var teststr = texts; //你这里的路径写错了 
			testend = teststr.match(/[^\\]+\.[^\(]+/i); //直接完整文件名的 
			filename.innerHTML = testend;
		}

	});

	$(".avatar-save").on("click", function() {
		var img_lg = document.getElementById('imageHead');
		// 截图小的显示框内的内容 
		html2canvas(img_lg, {
			allowTaint : true,
			taintTest : false,
			onrendered : function(canvas) {
				canvas.id = "mycanvas";
				//生成base64图片数据 
				var dataUrl = canvas.toDataURL("image/png");
				var newImg = document.createElement("img");
				newImg.src = dataUrl;
				imagesAjax(dataUrl)
			}
		});
	})
	function imagesAjax(src) {
		var data = {};
		data.img = src;
		$.ajax({
			url : "",
			data : data,
			type : "POST",
			dataType : 'json',
			success : function(re) {
				if (re) {
					if (re.status == 200) {
						$('#icon').attr('src', re.data.url);
						$('#iconPic').val(re.data.url);
					} else {
						alert("上传失败")
					}

				}
			}
		});
	}
</script>
<script type="text/javascript">
	$("#icon").click(function() {
		window.open($(this).attr("src"));
	})
</script>
<!--<script>
	$(".x").click(function(){
		$(".modal").hide();
	})
	$(".change_headPortrait").click(function(){
		$(".modal").show();
	})
</script>-->
<script>
	$("#button_save").click(function() {
		var url = $("#imageHead img").attr("src");
		$('#icon').attr('src', url);
	})
</script>
</html>>