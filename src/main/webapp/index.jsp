<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>首页</title>
    <style type="text/css">
        @import "/styles/index_home.css";
        @import "/styles/index_main.css";
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
                <a href="/Index/HouseDivideByPage">
                    <div class="button">
                        <input class="search bt" value="搜索租房">
                    </div>
                </a>
                <a href="/usedGoods/searchGoodsServlet">
                    <div class="button">
                        <input class="search bt" value="搜索二手商品">
                    </div>
                </a>
                <div class="button">
                    <a href="/JSP/choosePost.jsp"><div class="post">发布信息</div></a>
                </div>
            </div>
        </div>
        <ul class="navcon">
            <li class="nav"><a href="/index" >首页</a></li>
            <li class="nav"><a href="/Index/HouseDivideByPage">房屋租凭</a></li>
            <li class="nav"><a href="/usedGoods/searchGoodsServlet" >二手商品</a></li>
            <li class="nav"><a href="" >广告招租</a></li>
            <li class="nav"><a href="" >临时工</a></li>
        </ul>
    </div>

    <div class="house">
        <div class="right_show">
            <c:forEach var="i" begin="0" end="7" step="1">
                <c:if test="${not empty houses[i]}">
                <a href="/house/detile?hid=${houses[i].hid}">
                    <div class="show-box" <c:if test="${i>3}"> style="margin-top:19px" </c:if>>
                        <img src="/images/house${houses[i].photo}" width="180px" height="120px">
                        <div class="house-info">
                            <h3>${houses[i].title}</h3>
                            <div class="house-type">${houses[i].type}&emsp;${houses[i].area}平米</div>
                            <div class="house-rent"><span>${houses[i].rent}</span>元/月</div>
                        </div>
                    </div>
                </a>
                </c:if>
            </c:forEach>

        </div>
        <div class="poster">
            <div class="title">
                <span>房屋租赁</span>
            </div>
            <img src='/images/jsp/banner02.jpg' height="420px" width="300px">
        </div>
    </div>

    <div class="usedGoods">
        <div class="right_show">
                <c:forEach var="i" begin="0" end="7" step="1">
                    <c:if test="${not empty goodss[i]}">
                    <a href="/usedGoods/detile?gid=${goodss[i].gid}">
                        <div class="show-box"<c:if test="${i>3}"> style="margin-top:19px" </c:if>>
                            <img src="/images/goods${goodss[i].gimage}" width="180px" height="120px">
                            <div class="house-info">
                                <h3>${goodss[i].name}</h3>
                                <div class="house-type">${goodss[i].type}&emsp;${goodss[i].old}</div>
                                <div class="house-rent"><span>${goodss[i].price}</span>金币</div>
                            </div>
                        </div>
                    </a>
                    </c:if>
                </c:forEach>
        </div>
        <div class="poster">
            <img src='/images/jsp/usedGoodsPoster.jpg' height="420px" width="300px">
        </div>
    </div>
</div>
</body>
</html>
