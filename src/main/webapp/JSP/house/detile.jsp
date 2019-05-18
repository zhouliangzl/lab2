<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>房屋租凭详情</title>
    <style type="text/css">
        @import "/styles/index_home.css";
        @import "/styles/house.css";
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
            <a href="/Index/HouseDivideByPage">房屋租凭</a>&emsp;&gt;&emsp;
            <a href="/house/detile?hid=${house.hid}">租凭详情</a>
        </div>
    </div>

    <div class="house-title">
        <h2>${house.title}</h2>
    </div>

    <div class="house-basic-info">
        <div class="house-basic-left">
            <div class="house-photo"><img src="/images/house${house.photo}" width="520" height="390"></div>
        </div>
        <div class="house-basic-right">
            <div class="house-basic-desc">
                <div class="house-desc">
                    <div class="rent"><b class="money">${house.rent}</b>元/月</div>
                    <ul class="ul1">
                        <li>
                            <span class="sp1" >房屋类型：</span>
                            <span>${house.type}&emsp;${house.area}平米</span>
                        </li>
                        <li>
                            <span class="sp1" >朝向楼层：</span>
                            <span>${house.orient}&emsp;${house.floor}</span>
                        </li>
                        <li>
                            <span class="sp1" >装修情况：</span>
                            <span>${house.decoration}</span>
                        </li>
                        <li>
                            <span class="sp1" >所属区域：</span>
                            <span>${house.region}</span>
                        </li>
                        <li>
                            <span class="sp1" >详细地址：</span>
                            <span>${house.address}</span>
                        </li>
                    </ul>
                </div>
                <div class="poster-desc">
                    <div class="poster-photo-box">
                        <img src="/images/user/defaultUserPhoto.jpg" class="poster-photo">
                        <span>${house.connect}</span>
                    </div>
                </div>
            </div>
            <div class="house-basic-conn">
                <div class="house-chat-phone">
                    <i class="house-chat-icon"></i>
                    <span>${house.phone}</span>
                </div>
                <div class="house-sign">
                    <span><a href="/JSP/house/signHouse.jsp">在线签订合同</a></span>
                </div>
            </div>
        </div>
    </div>

    <div class="house-detile-info">
        <div class="house-detile-desc">
            <div class="detile-bar">房源详情</div>
            <div class="report-text">
                签约前切勿付
                <span class="color">订金、押金、租金</span>
                等一切费用！务必
                <span class="color">实地看房，</span>
                查验房东和房屋证件！
            </div>
            <ul class="ul2">
                <li>
                    <span class="left-title">周围环境</span>
                    <span class="right-text">${house.environ}</span>&nbsp;
                </li>
                <li>
                    <span class="left-title">房源描述</span>
                    <span class="right-text">${house.description}</span>&nbsp;
                </li>

            </ul>
        </div>

        <div class="side-right-info" >
            <c:if test="${ ad.aid==0}">
                <c:if test="${not empty my && my.type!=1}"><a href="/JSP/ad/postAd.jsp?apid=${house.hid}"></c:if>
                <c:if test="${not empty my && my.type==1}"><a href="/JSP/user/UpgradeToAd.jsp"></c:if>
                <div class="ad"><h2>广告区域</h2></div>
                <c:if test="${not empty my}"></a></c:if>
            </c:if>
            <c:if test="${ ad.aid!=0}">
                <a href="/ad/detile?apid=${ad.apid}">
                    <img src="/images/adv${ad.aimage}" width="100" height="100">
                    广告
                </a>
            </c:if>
        </div>
    </div>

    <div class="house-detile-page">
        <div class="recommed">
            <div class="detile-bar">猜你喜欢</div>
            <div class="house-recommed">
                <c:forEach begin="0" step="1" end="4" var="i" >
                    <c:if test="${not empty recommedHousesList[i].hid}">
                        <a href="/house/detile?hid=${recommedHousesList[i].hid}">
                            <div class="recommed-box">
                                <img src="/images/house${recommedHousesList[i].photo}" width="160px" height="120px">
                                <div class="recommed-info">
                                    <h3>${recommedHousesList[i].title}</h3>
                                    <div class="house-type">${recommedHousesList[i].type}&emsp;${recommedHousesList[i].area}平米</div>
                                    <div class="house-rent">${recommedHousesList[i].rent}元/月</div>
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
