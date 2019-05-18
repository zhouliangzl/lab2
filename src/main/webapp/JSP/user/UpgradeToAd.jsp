<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>升级为广告方</title>
    <style type="text/css">
        @import "/styles/index_home.css";
        @import "/styles/user.css";
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
    <div class="user_body_left" <c:if test="${my.type==2||my.type==3}"> style="height: 300px" </c:if>>
        <div class="user_info">
            <div class="user-photo-box">
                <img src="/images/user/defaultUserPhoto.jpg" class="userphoto">
                <span>${my.name}</span>
            </div>
        </div>
        <div style="border-bottom: 1px solid #888888;">
            <div class="user_info_profile">
                <span>金币：${my.coin}</span>
                <br>金币作为本网站的支付方式
            </div>
        </div>
        <c:if test="${my.type==2}">
            <div class="user_manage">
                <a href="">申请广告</a>
            </div>
        </c:if>
        <c:if test="${my.type==3}">
            <div class="user_manage">
                <a href="/JSP/user/manageUser.jsp">管理用户</a>
            </div>
        </c:if>
    </div>

    <div class="user_body_right">
        <form method="post" action="/user/upgradeToAd">
            <h2>升级为广告方</h2>
            <input type="file" name="">
            <input type="submit" class="upgradeOver_bt" value="提交申请">
        </form>
    </div>
</div>


</body>
</html>