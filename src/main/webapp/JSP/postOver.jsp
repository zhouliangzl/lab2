<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>发布完成</title>
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
            <div class="propbar" id="propbarfirst">
                <span>1.
                    <c:if test="${postType==1}"><%="租房"%></c:if>
                    <c:if test="${postType==2}"><%="二手商品"%></c:if>
                </span>

            </div>
            <div class="propbar" id="propbartwo">
                <span>2.填写信息</span>
            </div>
            <div class="active" id="propbarthree">
                <span>3.完成发布</span>
            </div>
        </div>
    </div>

    <div class="post-main">
        <div class="choose-item" style="width: 300px">
            <div class="post-over" style="color: white">
                <%--由servlet传送信息到这，判断发布成功或失败--%>
                <c:if test="${postId!=0 && not empty postId}">发布成功</c:if>
                <c:if test="${postId==0 }">发布失败</c:if>
                <c:if test="${not empty gid}">提交成功</c:if>
            </div><br>
            <%--区分租房和二手商品，需要在对应的servlet中，传postType=1或2--%>
            <%--在这里判断postType=1或2--%>

            <%--如果发布成功，并且是租房信息--%>
            <c:if test="${postId!=0 && postType==1}">
                <a href="/house/detile?hid=${postId}">查看详情</a>
            </c:if>
            <%--如果发布成功，并且是二手商品信息--%>
            <c:if test="${postId!=0 && postType==2}">
                <a href="/usedGoods/detile?gid=${postId}">查看详情</a>
            </c:if>
            <c:if test="${not empty goodsOrder}">
                <a href="/usedGoods/detile?oid=${goodsOrder.oid}">查看详情</a>
            </c:if>
        </div>
    </div>

</div>
</body>
</html>