<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>房屋租凭详情</title>
    <style type="text/css">
        @import "/styles/index_home.css";
        @import "/styles/house.css";
        @import "/styles/goods.css";
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
                    <a href="/JSP/choosePost.jsp"><div class="post">发布信息</div></a>
                </div>
            </div>
        </div>
        <div class="route">
            <a href="/index">综合类信息网</a>&emsp;&gt;&emsp;
            <a href="/usedGoods/searchGoodsServlet">二手商品</a>&emsp;&gt;&emsp;
            <a href="/usedGoods/detile?gid=${goods.gid}">商品详情</a>
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
                    </ul>
                </div>
                <div class="poster-desc">
                    <div class="poster-photo-box">
                        <img src="/images/user/defaultUserPhoto.jpg" class="poster-photo">
                        <span>${postUser.name}</span>
                    </div>

                </div>
            </div>
            <div class="house-basic-conn">
                <div class="house-chat-phone">
                    <span><a href="/JSP/usedGoods/GoodsPurchase.jsp">立即购买</a></span>
                </div>
            </div>
        </div>
    </div>

    <div class="house-detile-info">
        <div class="house-detile-desc">
            <div class="detile-bar">商品详情</div>
            <div class="report-text">
                <div class="report-text">
                    提交订单前切勿付
                    <span class="color">订金、押金</span>
                    等一切费用！务必
                    <span class="color">核实订单信息，</span>
                    确认订单信息无误后方可提交订单，支付费用！
                </div>
            </div>
            <ul class="ul2">
                <li>
                    <span class="left-title">商品描述</span>
                    <span class="right-text">${goods.description}</span>&nbsp;
                </li>
            </ul>
        </div>

        <div class="side-right-info" >
            <c:if test="${ ad.aid==0}">
            <c:if test="${not empty my && my.type!=1}"><a href="/JSP/ad/postAd.jsp?apid=${goods.gid+20000}"></c:if>
            <c:if test="${not empty my && my.type==1}"><a href="/JSP/user/UpgradeToAd.jsp"></c:if>
                <div class="ad"><h2>广告区域</h2></div>
                <c:if test="${not empty my}"></a></c:if>
            </c:if>
            <c:if test="${ ad.aid!=0}">
            <a href="/ad/detile?aid=${ad.aid}"><img  style=" width: 300px;height:250px;" src="/images/goods${ad.aimage}" ></a>
            </c:if>
        </div>
    </div>

    <div class="house-detile-page">
        <div class="recommed">
            <div class="detile-bar">猜你喜欢</div>
            <div class="house-recommed">
                <c:forEach begin="0" step="1" end="4" var="i" >
                    <c:if test="${not empty recommedGoodsList[i].gid}">
                        <a href="/usedGoods/detile?gid=${recommedGoodsList[i].gid}">
                            <div class="recommed-box">
                            <img src="/images/goods${recommedGoodsList[i].gimage}" width="160px" height="120px">
                                <div class="recommed-info">
                                    <h3>${recommedGoodsList[i].name}</h3>
                                    <div class="house-type">${recommedGoodsList[i].color}&emsp;${recommedGoodsList[i].old}</div>
                                    <div class="house-rent">${recommedGoodsList[i].price}元</div>
                                </div>
                            </div>
                        </a>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>

</div>
</body>
</html>
