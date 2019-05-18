<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>房屋租凭搜索</title>
    <style type="text/css">
        @import "/styles/index_home.css";
        @import "/styles/user.css";
        .center2{
            padding-left: 200px;
            width: 280px;
            padding-bottom: 20px;
            margin-left: 250px;
        }
    </style>
    <%--<link rel="stylesheet" href="/style/index_home.css" type="text/css">--%>
</head>
<body >
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
                <form action="/Index/GoodsSearchServlet">
                    <div class="searchbar">
                        <img src="" class="search_img">
                        <div >
                            <input class="keyword" name="keyWord"  placeholder="二手商品" value="<%=request.getParameter("keyWord")==null?"":request.getParameter("keyWord")%>"/>
                        </div>
                        <div class="button">
                            <input class="search" value="搜 索" type="submit">
                        </div>
                        <div class="hotwords">
                        </div>
                    </div>
                </form>
                <div class="button">
                    <a href="/JSP/choosePost.jsp"><div class="post">发布信息</div></a>
                </div>
            </div>
        </div>
        <ul class="navcon">
            <li class="nav"><a href="/index">首页</a></li>
            <li class="nav"><a href="/Index/HouseDivideByPage">房屋租赁</a></li>
            <li class="nav"><a href="/usedGoods/searchGoodsServlet" >二手商品</a></li>
            <li class="nav"><a href="" >广告招租</a></li>
            <li class="nav"><a href="" >临时工</a></li>
        </ul>
    </div>

    <div class="route"><a href="/index">综合类信息网</a>&emsp;&gt;&emsp;<a href="/usedGoods/searchGoodsServlet">二手商品</a> </div>

    <div class="keyBox">
        <div class="type">
            <span class="keyName">类别：</span>
            <ul>
                <li class="l0">不限</li>
                <li >手机</li>
                <li >电视机</li>
                <li >洗衣机</li>
                <li >生活家电</li>
                <li >厨卫家电</li>
                <li >数码产品</li>
                <li >服饰用品</li>
            </ul>
        </div><br>
        <div class="price">
            <span class="keyName">价格：</span>
            <ul>
                <li class="l0">不限</li>
                <li >500元以下</li>
                <li >500-1000元</li>
                <li >1000-1500元</li>
                <li >1500-2000元</li>
                <li >2000-3000元</li>
                <li >3000-4500元</li>
                <li >4500元以上</li>
            </ul>
        </div><br>
        <div class="old">
            <span class="keyName">新旧程度：</span>
            <ul>
                <li class="l0">不限</li>
                <li >全新</li>
                <li >九八成</li>
                <li >九五成</li>
                <li >八成</li>
                <li >七成</li>
                <li >七成以下</li>
            </ul>
        </div><br>
    </div>

<c:if test="${not empty goods}">
    <div class="house-infor">
        <c:forEach items="${goods}" var="goods">
                <div class="infor-box">
                    <a href="/usedGoods/detile?gid=${goods.gid}">
                        <div class="house-photo"><img src="/images/goods${goods.gimage}" width="150" height="110"></div>
                        <div class="content">
                            <h2 class="title">${goods.name}</h2>
                            <p class="des">${goods.type}</p>
                            <p class="des">颜色：${goods.color}&emsp;成色：${goods.old}</p>
                            <p class="des" style="    overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">
                                    ${goods.description}
                            </p>
                        </div>
                        <div class="list-right">
                            <div class="rent"><b class="money">${goods.price}</b>元</div>
                        </div>
                    </a>
                </div>
        </c:forEach>
        <div class="bottomPage">
            <div class="center2">
                第${ PageCode }页/共${ TotalPage }页
                <a href="${ pageContext.request.contextPath }/usedGoods/searchGoodsServlet?pc=1">首页</a>
                <c:if test="${ PageCode > 1 }">
                    <a href="${ pageContext.request.contextPath }/usedGoods/searchGoodsServlet?pc=${PageCode - 1}">上一页</a>
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
                    <a href="${ pageContext.request.contextPath }/usedGoods/searchGoodsServlet?pc=${i}">[${ i }]</a>
                </c:forEach>
                <c:if test="${ PageCode < TotalPage }">
                    <a href="${ pageContext.request.contextPath }/usedGoods/searchGoodsServlet?pc=${PageCode + 1}">下一页</a>
                </c:if>
                <a href="${ pageContext.request.contextPath }/usedGoods/searchGoodsServlet?pc=${TotalPage}">尾页</a>
            </div>
        </div>
    </div>
</c:if>


    <c:if test="${not empty IndexGoods}">
        <div class="house-infor">
            <c:forEach items="${IndexGoods}" var="goods">
                <div class="infor-box">
                    <a href="/usedGoods/detile?gid=${goods.gid}">
                        <div class="house-photo"><img src="/images/goods${goods.gimage}" width="150" height="110"></div>
                        <div class="content">
                            <h2 class="title">${goods.name}</h2>
                            <p class="des">${goods.type}</p>
                            <p class="des">颜色：${goods.color}&emsp;成色：${goods.old}</p>
                            <p class="des" style="    overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">
                                    ${goods.description}
                            </p>
                        </div>
                        <div class="list-right">
                            <div class="rent"><b class="money">${goods.price}</b>元</div>
                        </div>
                    </a>
                </div>
            </c:forEach>
            <div class="bottomPage">
                <div class=" center">
                    第${ PageCode }页/共${ TotalPage }页
                    <a href="${ pageContext.request.contextPath }/Index/GoodsSearchServlet?pc=1&&keyWord=<%=request.getParameter("keyWord")==null?"":request.getParameter("keyWord")%>">首页</a>
                    <c:if test="${ PageCode > 1 }">
                        <a href="${ pageContext.request.contextPath }/Index/GoodsSearchServlet?pc=${PageCode - 1}&&keyWord=<%=request.getParameter("keyWord")==null?"":request.getParameter("keyWord")%>"">上一页</a>
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
                        <a href="${ pageContext.request.contextPath }/Index/GoodsSearchServlet?pc=${i}&&keyWord=<%=request.getParameter("keyWord")==null?"":request.getParameter("keyWord")%>"">[${ i }]</a>
                    </c:forEach>
                    <c:if test="${ PageCode < TotalPage }">
                        <a href="${ pageContext.request.contextPath }/Index/GoodsSearchServlet?pc=${PageCode + 1}&&keyWord=<%=request.getParameter("keyWord")==null?"":request.getParameter("keyWord")%>"">下一页</a>
                    </c:if>
                    <a href="${ pageContext.request.contextPath }/Index/GoodsSearchServlet?pc=${TotalPage}&&keyWord=<%=request.getParameter("keyWord")==null?"":request.getParameter("keyWord")%>"">尾页</a>
                </div>
            </div>
        </div>
    </c:if>


    <div class="house-search-page">
        <div class="recommed">
            <div class="detile-bar">热推手机</div>
            <div class="house-recommed">
                <div class="recommed-box">
                    <img src="/images/goods/iphonex.jpg" width="160px" height="120px">
                    <div class="recommed-info">
                        <h3>手机类型</h3>
                        <div class="house-type">iphoneXS MAX搭载了苹果最新研制的A12仿生处理器，
                            搭配上iOS12系统</div>
                        <div class="house-rent">9599 元</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
