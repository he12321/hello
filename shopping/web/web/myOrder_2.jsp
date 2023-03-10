<%@ page  contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="../css/myOrder.css" rel="Stylesheet" />
    <link href="../css/header.css" rel="Stylesheet" />
    <link href="../css/footer.css" rel="Stylesheet" />
</head>
<body>
<div id="header">
    <!-- 头部-->
    <header id="top">
        <div id="logo" class="lf">
            <img class="animated jello" src="../images/header/logo.png" alt="logo"/>
        </div>
        <div id="top_input" class="lf">
            <input id="input" type="text" placeholder="请输入您要搜索的内容"/>
            <div class="seek" tabindex="-1">
                <div class="actived" ><span>分类搜索</span> <img src="../images/header/header_normal.png" alt=""/></div>
                <div class="seek_content" >
                    <div id="shcy" >生活餐饮</div>
                    <div id="xxyp" >学习用品</div>
                    <div id="srdz" >私人订制</div>
                </div>
            </div>
            <a href="" class="rt"><img id="search" src="../images/header/search.png" alt="搜索"/></a>
        </div>
        <div class="rt">
            <ul class="lf">
                <li><a href="myCollect.html" title="我的收藏"><img class="care" src="../images/header/care.png" alt=""/></a><b>|</b></li>
                <li><a href="myOrder.html" title="我的订单"><img class="order" src="../images/header/order.png" alt=""/></a><b>|</b></li>
                <li><a href="cart.html" title="我的购物车"><img class="shopcar" src="../images/header/shop_car.png" alt=""/></a><b>|</b></li>
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
    <!-- 主导航-->
    <nav id="nav1">
        <!-- 我的订单导航栏-->
        <div id="nav_order" class="lf">
            <ul>
                <li><a href="">首页<span>&gt;</span>订单管理</a></li>
            </ul>
        </div>
    </nav>
</div>
</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
    <!-- 左边栏-->
    <div id="leftsidebar_box" class="lf">
        <div class="line"></div>
        <dl class="my_order">
            <dt onClick="changeImage()">我的订单
                <img src="../images/myOrder/myOrder2.png">
            </dt>
            <dd class="first_dd"><a href="#">全部订单</a></dd>
            <dd>
                <a href="#">
                    待付款
                    <span><!--待付款数量--></span>
                </a>
            </dd>
            <dd>
                <a href="#">
                    待收货
                    <span><!--待收货数量-->1</span>
                </a>
            </dd>
            <dd>
                <a href="#">
                    待评价<span><!--待评价数量--></span>
                </a>
            </dd>
            <dd>
                <a href="#">退货退款</a>
            </dd>
        </dl>

        <dl class="footMark">
            <dt onClick="changeImage()">我的优惠卷<img src="../images/myOrder/myOrder1.png"></dt>
        </dl>

        <dl class="address">
            <dt>收货地址<img src="../images/myOrder/myOrder1.png"></dt>
        </dl>

        <dl class="count_managment">
            <dt onClick="changeImage()">帐号管理<img src="../images/myOrder/myOrder1.png"></dt>
            <dd class="first_dd"><a href="#">我的信息</a></dd>
            <dd><a href="#">安全管理</a></dd>
        </dl>
    </div>
    <!-- 右边栏-->
    <div class="rightsidebar_box rt" >
        <div class="order_empty">
            <img src="../images/myOrder/myOrder3.png" alt=""/>
            <p>你可能还没有订单(⊙o⊙)</p>
            <span>赶紧去下单吧 <b>去购物</b></span>
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
                <li><a href="#">关于达内</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="../images/footer/wechat.png" alt=""/>
                    <img src="../images/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>达内商城客户端</p>
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
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/order.js"></script>

</html>>