<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>管理用户</title>
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
        <c:if test="${my.type==1}">
            <div class="user_manage">
                <a href="">升级为广告方</a>
            </div>
        </c:if>
        <c:if test="${my.type==2}">
            <div class="user_manage">
                <a href="">申请广告</a><br>
                <a href="">管理已申请的广告</a>
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
                <caption><h2>用户管理</h2></caption>
                <tr>
                    <td>用户ID</td><td>名称</td><td>邮箱</td><td>金币</td><td>修改</td><td>删除</td>
                </tr>
                <C:if test="${not empty users}">
                    <c:forEach items="${users}" var="users">
                        <tr>
                            <td>${users.uid}</td><td>${users.name}</td><td>${users.email}</td><td>${users.coin}</td>
                                <%--修改的servlet转跳到/JSP/user/updateUser.jsp，命名为UpdateStartServlet--%>
                                <%--updateUser.jsp提交修改后，调到处理执行update SQL的servlet，命名为UpdateOverServlet--%>
                            <td><a href="/user/updateUserStart?uid=${users.uid}" >修改</a></td>
                                <%--删除的servlet--%>
                            <td><a href="/user/delete?uid=${users.uid}">删除</a></td>
                        </tr>
                    </c:forEach>
            </table>

                    <div >
                        <center>
                            第${ PageCode }页/共${ TotalPage }页
                            <a href="${ pageContext.request.contextPath }/user/manageUser?pc=1">首页</a>
                            <c:if test="${ PageCode > 1 }">
                                <a href="${ pageContext.request.contextPath }/user/manageUser?pc=${PageCode - 1}">上一页</a>
                            </c:if>
                            <c:choose>
                                <%--如果totalPage <= 10 --%>
                                <c:when test="${ TotalPage <= 10 }">
                                    <c:set var="begin" value="1"></c:set>
                                    <c:set var="end" value="${ TotalPage }"></c:set>
                                </c:when>
                                <c:otherwise>
                                    <%--算法：begin=pageCode -5  end = pageCode +4 --%>
                                    <c:set var="begin" value="${ PageCode - 5 }"></c:set>
                                    <c:set var="end" value="${ PageCode + 4 }"></c:set>
                                    <%--头溢出  尾部溢出 --%>
                                    <c:if test="${ begin < 1 }">
                                        <c:set var="begin" value="1"></c:set>
                                        <c:set var="end" value="10"></c:set>
                                    </c:if>
                                    <c:if test="${ end > TotalPage }">
                                        <c:set var="begin" value="${ TotalPage - 9 }"></c:set>
                                        <c:set var="end" value="${ TotalPage }"></c:set>
                                    </c:if>
                                </c:otherwise>
                            </c:choose>
                                <%--目的：先1-10 for(int i=1;i<=10;i++) --%>
                            <c:forEach var="i" begin="${ begin }" end="${ end }" step="1">
                                <a href="${ pageContext.request.contextPath }/user/manageUser?pc=${i}">[${ i }]</a>
                            </c:forEach>
                            <c:if test="${ PageCode < TotalPage }">
                                <a href="${ pageContext.request.contextPath }/user/manageUser?pc=${PageCode + 1}">下一页</a>
                            </c:if>
                            <a href="${ pageContext.request.contextPath }/user/manageUser?pc=${TotalPage}">尾页</a>
                        </center>
                    </div>
                </C:if>

        </form>
    </div>
</div>


</body>
</html>