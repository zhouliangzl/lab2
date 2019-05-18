<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>选择发布类型</title>
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
    <div class="post-top-part">
        <div class="progcontrl">
            <div class="active" id="propbarfirst">
                <span>1.选择发布</span>
            </div>
            <div class="propbar" id="propbartwo">
                <span>2.填写信息</span>
            </div>
            <div class="propbar" id="propbarthree">
                <span>3.完成发布</span>
            </div>
        </div>
    </div>

    <div class="post-main">
        <div class="choose-item">

            <c:if test="${not empty my}"><a href="/JSP/house/postHouse.jsp"></c:if>
                <c:if test="${empty my}"><a href="/login.jsp"></c:if>
            <div class="post-item">租房</div>
            <c:if test="${not empty my}"></a></c:if>


            <c:if test="${not empty my}"><a href="/JSP/usedGoods/postGoods.jsp"></c:if>
                <c:if test="${empty my}"><a href="/login.jsp"></c:if>
                    <div class="post-item">二手商品</div>
            <c:if test="${not empty my}"></a></c:if>

        </div>
    </div>

</div>

</body>
</html>