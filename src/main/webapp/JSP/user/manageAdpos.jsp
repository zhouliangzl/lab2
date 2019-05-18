<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>管理广告</title>
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
                <a href="/user/manageUser">管理用户</a><br>
                <a href="/user/manageAd">管理广告</a>
            </div>
        </c:if>
    </div>

    <div class="user_body_right">
        <form method="post" action="">
            <table border="1">
                <caption><h2>广告管理</h2></caption>
                <tr>
                    <td>广告位</td><td>广告区域位置</td><td>状态</td><td>正在展示广告</td><td>修改展示广告</td><td>管理竞标</td>
                </tr>
                <c:forEach begin="0" end="1999" step="1" var="i">
                    <c:if test="${adposs[i]!=0}">
                        <tr style="font-size: 14px;">
                            <td>${adposs[i]}</td>

                            <td class="user_manage">
                                <c:if test="${adposs[i]<=20000}">
                                    <a href="http://localhost:8080/house/detile?hid=${adposs[i]}">查看</a>
                                </c:if>
                                <c:if test="${adposs[i]>20000}">
                                    <a href="http://localhost:8080/usedGoods/detile?gid=${adposs[i]-20000}">查看</a>
                                </c:if>
                            </td>
                            <td>

                                <c:if test="${adposStatus[i]==0}">
                                    空闲
                                </c:if>
                                <c:if test="${adposStatus[i]==1}">
                                    占用
                                </c:if>

                            </td>
                                <%--<td>--%>
                                <%--<c:if test="${adposs.apstatus}==0">空闲</c:if>--%>
                                <%--<c:if test="${adposs.apstatus}==1">占用</c:if>--%>
                                <%--</td>--%>
                                <%--&lt;%&ndash;apstatus状态为0表示空，1表示正在展示&ndash;%&gt;--%>
                                <%--<td><c:if test="${adposs.apstatus}==1">--%>
                                <%--<a href="/JSP/ad/adDetail.jsp?aid=">详情</a>--%>
                                <%--</c:if></td>--%>
                            <td class="user_manage">
                                <c:if test="${adposStatus[i]==1}">
                                    <a href="/ad/jumpUpdate?apid=${adposs[i]}">修改</a>
                                </c:if>
                                <c:if test="${adposStatus[i]==0}">
                                    <a href="http://localhost:8080/ad/jump?apid=${adposs[i]}">发布</a>
                                </c:if>
                            </td>
                            <td class="user_manage">
                                <a href="/ad/jumpManageAdServlet?apid=${adposs[i]}&adposStatus=${adposStatus[i]}">管理</a>
                            </td>
                        </tr>
                    </c:if>

                </c:forEach>
            </table>
        </form>
    </div>
</div>


</body>
</html>