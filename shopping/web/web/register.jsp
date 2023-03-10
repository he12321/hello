<%@ page  contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>阿甲商城学子注册页面</title>
  <link href="../css/header.css" rel="Stylesheet"/>
  <link href="../css/footer.css" rel="Stylesheet"/>
  <link href="../css/animate.css" rel="Stylesheet"/>
  <link href="../css/login.css" rel="stylesheet" />
</head>
<body>
<!-- 页面顶部-->
<header id="top">
  <div class="top">
    <img src="../images/header/logo.png" alt=""/>
    <span>欢迎注册</span>
  </div>
</header>
<div class="parent">
  <!--<video src="audio/snow.mp4" width="100%" autoplay loop muted></video>-->
  <div class="container">
    <div class="panel rt">
      <form id="registerForm" method="post" action="../regist.do">
        <div class="txt">
          <p>新用户注册
            <span>
              <a href="login.html">直接登录</a>
            </span>
          </p>
        </div>
        <div class="form-group">
          <label for="uname">用户名：</label>
          <input required minlength="6"  maxlength="12" type="text" placeholder="请输入用户名" autofocus name="userName" id="userName"/>
          <span class="msg-default" id="unspan">用户名长度在6到9位之间</span>
        </div>
        <div class="form-group">
          <label for="upwd">登录密码：</label>
          <input required type="password" minlength="6" maxlength="12" placeholder="请输入密码" name="password" autofocus id="password"/>
          <span class="msg-default hidden"密码长度在6到12位之间></span>
        </div>
		 <div class="form-group">
          <label for="upwdconfirm">确认密码：</label>
          <input required type="password" minlength="6" maxlength="12" placeholder="请确认密码" name="upwdconfirm" autofocus id="upwdconfirm"/>
          <span class="msg-default hidden">密码长度在6到12位之间</span>
        </div>
        
        <div class="form-group">
          <label for="email">邮箱：</label>
          <input autocomplete required type="text" placeholder="请输入邮箱地址" name="email" id="email"/>
          <span class="msg-default hidden" id="uespan">请输入合法的邮箱地址</span>
        </div>
        
        <div class="form-group">
          <label for="phone">手机号：</label>
          <input id="phone" name="phone" placeholder="请输入您的手机号" required type="text" />
          <span class="msg-default hidden" id="uphspan">请输入合法的手机号</span>
        </div>
        <div class="form-group">
          <label></label>
          <input type="button" value="提交注册信息" id="bt-register"/>
        </div>
      </form>
    </div>
  </div>
</div>

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
      <p class="footer2"><img src="../images/footer/footerFont.png"alt=""/></p>
      
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
<!--弹出的小广告-->
<script src="../js/jquery-3.1.1.min.js"></script>
<script>
  $('#bt-register').click(function(){
    var lengths=0;
    $('.form-group').each(function(){
      if($(this).find('span').hasClass('msg-success')){
        lengths++;
      }
      });
      if(lengths==5){
        //提交表单
    	registerForm.submit();
    }
  })
</script>
<script>
  /*1.对用户名进行验证*/
  userName.onblur = function(){
    if(this.validity.valueMissing){
      this.nextElementSibling.innerHTML = '用户名不能为空';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('用户名不能为空');
    }else if(this.validity.tooShort){
      this.nextElementSibling.innerHTML = '用户名不能少于6位';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('用户名不能少于6位');
    }else {
      var data =userName.value;    
      /**发起异步GET请求，询问服务器用户名是否已经存在**/
      //1 创建xhr
      var xhr = new XMLHttpRequest();
      //2 监听状态改变 01234，4最有价值
      xhr.onreadystatechange = function(){
        if(xhr.readyState===4){//响应完成
          var result = xhr.responseText;          
          if(result=="0"){
        	  unspan.className = 'msg-error';
        	  unspan.innerHTML = "账号已经被占用，不能重复注册！";
          }else if(result=="1"){
        	  unspan.className = 'msg-success';
        	  unspan.innerHTML = "恭喜！该账号可以注册！";
          }else{
        	  unspan.className = 'msg-error';
        	  unspan.innerHTML = "服务器正在维护！请与管理员联系";
          }
        }
      }
      //3 打开连接
      xhr.open("GET","../checkUserName.do?userName="+data, true);
      //4 发送请求
      xhr.send(null);
    }
  }
  
  
  
  password.onfocus = function(){
	    this.nextElementSibling.innerHTML = '密码长度在6到12位之间';
	    this.nextElementSibling.className = 'msg-default';
	  }
  password.onblur = function(){
    if(this.validity.valueMissing){
      this.nextElementSibling.innerHTML = '密码不能为空';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('密码不能为空');
    }else if(this.validity.tooShort){
      this.nextElementSibling.innerHTML = '密码长度不能少于6位';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('密码长度在尽量别少于6位');
    }else {
      this.nextElementSibling.innerHTML = '密码格式正确';
      this.nextElementSibling.className = 'msg-success';
      this.setCustomValidity('');
    }
  }
  
  
  upwdconfirm.onfocus = function(){
    this.nextElementSibling.innerHTML = '密码长度在6到12位之间';
    this.nextElementSibling.className = 'msg-default';
  }  
  upwdconfirm.onblur = function(){
	var up = password.value;// 密码
	var rup = upwdconfirm.value;// 确认密码
    if(this.validity.valueMissing){
      this.nextElementSibling.innerHTML = '密码不能为空';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('密码不能为空');
    }else if(this.validity.tooShort){
      this.nextElementSibling.innerHTML = '密码长度在尽量别少于6位';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('密码长度在尽量别少于6位');
    }else if(up!=rup){
    	 this.nextElementSibling.innerHTML = '两次密码输入必须一致！！！';
         this.nextElementSibling.className = 'msg-error';
         this.setCustomValidity('两次密码输入必须一致！！！');
    }else {
      this.nextElementSibling.innerHTML = '确认密码格式正确';
      this.nextElementSibling.className = 'msg-success';
      this.setCustomValidity('');
    }
  }
  
  
  
  /*3.对邮箱地址进行验证*/
  email.onblur = function(){
	var reg = /^\w+@\w+\.\w+$/;
	var data =email.value;
    if(this.validity.valueMissing){
      this.nextElementSibling.innerHTML = '邮箱不能为空';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('邮箱不能为空');
    }else if(!reg.test(data)){
      this.nextElementSibling.innerHTML = '邮箱格式不正确';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('邮箱格式不正确');
    }else {
      /**发起异步GET请求，询问服务器用户名是否已经存在**/     
      var xhr = new XMLHttpRequest();     
      xhr.onreadystatechange = function(){
        if(xhr.readyState===4){//响应完成
          var result = xhr.responseText;          
          if(result=="0"){
        	  uespan.className = 'msg-error';
        	  uespan.innerHTML = "邮箱已经被占用，不能重复注册！";
          }else if(result=="1"){
        	  uespan.className = 'msg-success';
        	  uespan.innerHTML = "恭喜！该邮箱可以注册！";
          }else{
        	  uespan.className = 'msg-error';
        	  uespan.innerHTML = "服务器正在维护！请与管理员联系";
          }
        }
      }
      //3 打开连接
      xhr.open('GET','../checkEmail.do?email='+data, true);
      //4 发送请求
      xhr.send(null);     
    }
  }  
  email.onfocus = function(){
    this.nextElementSibling.innerHTML = '请输入合法的邮箱地址';
    this.nextElementSibling.className = 'msg-default';
  }  
  
  /*3.对手机号进行验证*/
  phone.onblur = function(){	  
	var data = phone.value;
	var reg = /^1[3|4|5|6|7|8]\d{9}$/;	  
    if(this.validity.valueMissing){
      this.nextElementSibling.innerHTML = '手机号不能为空';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('手机号不能为空');
    }else if(!reg.test(data)){
      this.nextElementSibling.innerHTML = '手机号格式不正确';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('手机号格式不正确');
    }else {
      /**发起异步GET请求，询问服务器用户名是否已经存在**/
      var xhr = new XMLHttpRequest();
      xhr.onreadystatechange = function(){
        if(xhr.readyState===4){//响应完成
        	var result = xhr.responseText;
        	if(result=="0"){
          	  uphspan.className = 'msg-error';
          	  uphspan.innerHTML = "手机号不能重复注册！";
            }else if(result=="1"){
          	  uphspan.className = 'msg-success';
          	  uphspan.innerHTML = "恭喜！该手机号可以注册！";
            }else{
          	  uphspan.className = 'msg-error';
          	  uphspan.innerHTML = "服务器正在维护！请与管理员联系";
            }
        }
      }
      //3 打开连接
      xhr.open('GET','../checkPhone.do?phone='+data, true);
      //4 发送请求
      xhr.send(null);
    }
  }
  phone.onfocus = function(){
    this.nextElementSibling.innerHTML = '请输入合法的手机号';
    this.nextElementSibling.className = 'msg-default';
  }
</script>
</body>
</html>