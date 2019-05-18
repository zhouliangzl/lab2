<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>商品交易</title>
    <style type="text/css">
        @import "/styles/index_home.css";
        @import "/styles/house.css";
        .want{
            margin-top: 20px;
            border: 1px solid silver;
            width: 95px;
            height: 40px;
            box-shadow:0 2px 0 #EEE;
            float: left;
        }
        .WantPhoto{
            width: 20px;
            height: 15px;
            padding-left: 10px;
        }
        .buy{
            margin-top: 20px;
            border: 1px solid silver;
            width: 95px;
            height: 40px;
            box-shadow:0 2px 0 #EEE;
            text-align: center;
        }
        .conform{
            border: 1px solid #ff7043;
            width: 720px;
            height: 280px;
            font-size: 18px;
            margin-bottom: 100px;
            padding-top: 20px;
            padding-left: 200px;
        }
        .reply-button:hover{
            background: #ff7043;
        }
    </style>
</head>

<body>
<div class="top-toolbar">
    <div class="w">
        <div class="bar_left">
            <div class="index"><a href="/index">首页</a></div>
        </div>
        <div class="bar_right">
            <div class="topbar_login">
                <c:if test="${empty my}">
                    <a href="/login.jsp">登录</a>
                    <span class="gap">|</span>
                    <a href="/register.jsp">注册</a>
                </c:if>
                <c:if test="${not empty my}">
                    <div>欢迎您&nbsp;<c:if test="${my.type==2}">广告方</c:if><c:if test="${my.type==3}">管理员</c:if>:&nbsp;${my.name}&emsp;|&emsp;
                        <a href="/Logout" style="float: right"><div class="top_font" >注销</div></a>
                    </div>
                </c:if>
            </div>
            <div class="topbar_myMenu">
                <c:if test="${not empty my}">
                    <a href="/houseListByPage">个人中心</a>
                </c:if>
            </div>
        </div>
    </div>
</div>

<div class="main">
    <div class="headerWrap">
        <div class="header">
            <div class="left">
                <span class="title">综合类信息网</span>
            </div>
            <div class="right">
                <div class="button">
                    <input class="post" value="发布信息">
                </div>
            </div>
        </div>
        <div class="route">
            <a href="/index">综合类信息网</a>&emsp;&gt;&emsp;
            <a href="/usedGoods/searchGoodsServlet">二手商品</a>&emsp;&gt;&emsp;
            <a href="/usedGoods/detile?gid=${goods.gid}">商品详情</a>&emsp;&gt;&emsp;
            <a href="/JSP/usedGoods/GoodsPurchase.jsp">商品交易</a>
        </div>
    </div>

    <div class="house-title">
        <h2>${goods.name}</h2>
    </div>

    <div class="house-basic-info">
        <div class="house-basic-left">
            <div class="house-photo"><img src="/images/goods${goods.gimage}" width="520" height="390"></div>
        </div>
        <div class="house-basic-right">
            <div class="house-basic-desc">
                <div class="house-desc">
                    <div class="rent">价格：<b class="money">${goods.price}</b>元</div>

                    <ul class="ul1">
                        <li>
                            <span class="sp1" >商品类型：</span>
                            <span>${goods.type}</span>
                        </li>
                        <li>
                            <span class="sp1" >颜色：</span>
                            <span>${goods.color}</span>
                        </li>
                        <li>
                            <span class="sp1" >商品新旧程度：</span>
                            <span>${goods.old}</span>
                        </li>
                        <li>
                            <div>
                                <span class="want"><img src="/images/goods/want.png" class="WantPhoto">&emsp;想要</span>
                                <%--<span class="buy"><a href="detile.jsp"> 立即购买</a></span>--%>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="poster-desc">
                    <div class="poster-photo-box">
                        <img src="/images/user/defaultUserPhoto.jpg" class="poster-photo">
                        <span>${postUser.name}</span>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <div class="house-detile-info">
        <div class="house-detile-desc">
            <div class="detile-bar">订单详情</div>
            <div class="report-text">
                <div class="report-text">
                    提交订单前切勿付
                    <span class="color">订金、押金</span>
                    等一切费用！务必
                    <span class="color">核实订单信息，</span>
                    确认订单信息无误后方可提交订单，支付费用！
                </div>
            </div>

            <form class="conform"  method="post"  action="/AddGoodsOrder">
                <span style="left: 200px; font-size: 22px ;
                font-family: 'Agency FB'">商品订单</span><br><br>
                购买人：<input type="text" name="name" ><br><br>
                详细地址：<input type="text" name="address" ><br><br>
                联系电话：<input type="text" name="phone" ><br><br>
                <input class="reply-button" type="submit" value="提交订单"
                       style="float:right;font-size: 18px" box-shadow:0 2px 0 #EEE;>
            </form>
        </div>
    </div>
</div>
</body>
</html>
