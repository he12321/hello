<%@ page  contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>阿甲商城学子登陆页面</title>
    <link href="../css/header.css" rel="Stylesheet"/>
    <link href="../css/footer.css" rel="Stylesheet"/>
    <link href="../css/animate.css" rel="Stylesheet"/>
    <link href="../css/login.css" rel="stylesheet"/>
</head>
<body>
<!-- 页面顶部-->
<header id="top">
    <div class="top">
        <img src="../images/header/logo.png" alt=""/>
        <span>欢迎登录</span>
    </div>
</header>
<div id="container">
    <div id="cover" class="rt">
        <form id="login-form" method="post" name="form1">
            <div class="txt">
                <p>登录学子商城
                    <span>
                        <a href="register.jsp">新用户注册</a>
                    </span>
                </p>
                <div class="text">
                    <input type="text" placeholder="请输入您的用户名" name="userName" id="userName" onblur="checkUserName();" value="${cookie.su.value}" required>
                    <span><img src="../images/login/yhm.png"></span>
                </div>
                
                <div class="text">
                    <input type="password" id="password" placeholder="请输入您的密码" name="password" onblur="checkPassword();" id="password" value="${cookie.sp.value }" required minlength="6" maxlength="15">
                    <span><img src="../images/login/mm.png"></span>
                </div>
                <div class="chose">
                    <input type="checkbox" class="checkbox" name="isAuto" id="isAuto" value="0">自动登录
                    <span>忘记密码？</span>
                </div>
                <input class="button_login" type="button" value="登录" id="bt-login" onclick="toLogin();"/>
            </div>
        </form>
    </div>
</div>
<!--错误提示-->
<div id="showResult"></div>
<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="../images/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="../images/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="../images/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="../images/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
            <p class="footer1"><img src="../images/footer/logo.png" alt="" class=" footLogo"/></p>
            <p class="footer2"><img src="../images/footer/footerFont.png"
			alt=""/></p>
            
        </div>
        <div class="foot_left lf" >
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
                <li>
                    <img src="../images/footer/wechat.png" alt=""/>
                    <img src="../images/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>阿甲商城客户端</p>
            <img src="../images/footer/ios.png" class="lf">
            <img src="../images/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="../images/footer/erweima.png">
        </div>
		<!-- 页面底部-备案号 #footer -->
            <div class="record">
                &copy;2017 阿甲集团有限公司 版权所有 京ICP证xxxxxxxxxxx
			</div>
    </div>
</div>

<script>
	function checkUserName(){
		var un = userName.value;
		showResult.innerHTML = "";
		if(un==""){
			showResult.style.color = "red";
			showResult.innerHTML = "账号不能为空";
			return false;
		}
		if(un.length<6 || un.length>12){
			showResult.style.color = "red";
			showResult.innerHTML = "账号必须是6-12位";
			return false;
		}
		return true;
	}
	function checkPassword(){
		var up = password.value;
		showResult.innerHTML = "";
		if(up==""){
			showResult.style.color = "red";
			showResult.innerHTML = "密码不能为空";
			return false;
		}
		if(up.length<6 || up.length>12){
			showResult.style.color = "red";
			showResult.innerHTML = "密码必须是6-12位";
			return false;
		}
		return true;
	}
	
	function toLogin(){
		var result = checkUserName()&&checkPassword();
		var strParam = "";
		if(result){
			var un = userName.value;
			var up = password.value;
			var ia = isAuto.checked;// 自动登录是否被勾选
			if(ia){
				strParam+="userName="+un+"&password="+up+"&isAuto="+ia;
			}else{
				strParam+="userName="+un+"&password="+up;
			}
			//实现异步登录
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4){
					var resResult = xhr.responseText;
					if(resResult=="1"){
						window.location.href="index.jsp"
					}else if(resResult=="2"){
						showResult.style.color = "red";
						showResult.innerHTML = "账号或密码错误";
					}else{
						showResult.style.color = "red";
						showResult.innerHTML = "服务器正在维护！";
					}
				}
			};
			xhr.open("post","../login.do",true);
			xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
			xhr.send(strParam);
		}
	}
</script>
</body>
</html>