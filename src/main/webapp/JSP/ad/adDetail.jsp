<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>广告详情</title>
    <style type="text/css">
        @import "/styles/index_home.css";
        @import "/styles/post.css";
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
    <div class="post-main">
            <div class="block-wrap">
                <div class="block-title"><h3>广告信息</h3></div>

                <div class="row-wrap">
                    <div class="row-title"><span>广告标题</span></div>
                    <div class="row-content">
                        <div class="input-text" style="width: 500px;">${ad.title}</div>
                        <div class="input-tips"></div>
                    </div>
                </div>

                <div class="row-wrap">
                    <div class="row-title"><span>广告内容</span></div>
                    <div class="row-content">
                        <div class="input-text" style="width: 500px;">${ad.content}</div>
                        <div class="input-tips"></div>
                    </div>
                </div>
                <div class="row-wrap" >
                    <div class="row-title"><span>广告图片</span></div>
                    <div class="row-content" style=" height:400px">
                        <div class="input-text" style="border: none">
                            <img src="/images/adv${ad.aimage}" height="400">
                        </div>
                        <div class="input-tips"></div>
                    </div>
                </div>

            </div>
    </div>
</div>

</body>
</html>