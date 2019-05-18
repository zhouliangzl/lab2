<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>房屋租凭搜索</title>
    <style type="text/css">
        @import "/styles/index_home.css";
        .center1{
            padding-left: 200px;
            width: 280px;
            padding-bottom: 20px;
            margin-left: 250px;
        }
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
                <form action="/Index/HouseSearchServlet">
                    <div class="searchbar">
                        <img src="" class="search_img">
                        <div >
                            <input class="keyword" name="keyWord" placeholder="二手商品" value="<%=request.getParameter("keyWord")==null?"":request.getParameter("keyWord")%>"/>
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
            <li class="nav"><a href="/index" >首页</a></li>
            <li class="nav"><a href="/Index/HouseDivideByPage">房屋租凭</a></li>
            <li class="nav"><a href="/usedGoods/searchGoodsServlet">二手商品</a></li>
            <li class="nav"><a href="" >广告招租</a></li>
            <li class="nav"><a href="" >临时工</a></li>
        </ul>
    </div>

    <div class="route">
        <a href="/index">综合类信息网</a>&emsp;&gt;&emsp;
        <a href="/Index/HouseDivideByPage">房屋租凭</a>
    </div>

    <form method="post">
        <div class="keyBox">
            <%
                //如果是数字，则用-1表示不限
                String region = "";
                int area = -1;
                int floor = -1;
                int rent = -1;
                String decoration = "";
                String type = "";

                //单独使用try，避免影响
                try{
                    if(request.getParameter("region")!=null)
                        region = request.getParameter("region");
                } catch (Exception e) { e.printStackTrace(); }
                try{
                    if(request.getParameter("area")!=null)
                        area = Integer.parseInt(request.getParameter("area"));
                } catch (Exception e) { e.printStackTrace(); }
                try{
                    if(request.getParameter("floor")!=null)
                        floor = Integer.parseInt(request.getParameter("floor"));
                } catch (Exception e) { e.printStackTrace(); }
                try{
                    if(request.getParameter("rent")!=null)
                        rent = Integer.parseInt(request.getParameter("rent"));
                } catch (Exception e) { e.printStackTrace(); }
                try{
                    if(request.getParameter("decoration")!=null)
                        decoration = request.getParameter("decoration");
                } catch (Exception e) { e.printStackTrace(); }
                try{
                    if(request.getParameter("type")!=null)
                        type = request.getParameter("type");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
            <div class="region">
                <input type="hidden" name="region" value="<%=region%>">
                <span class="keyName">区域：</span>
                <ul>
                    <li class="l0"><button value="">不限</button></li>
                    <li><button value="东湖">东湖</button></li>
                    <li><button value="西湖">西湖</button></li>
                    <li><button value="新建区">新建区</button></li>
                    <li><button value="南昌县">南昌县</button></li>
                    <li><button value="湾里">湾里</button></li>
                    <li><button value="青山湖区">青山湖区</button></li>
                    <li><button value="红谷滩新区">红谷滩新区</button></li>
                    <li><button value="高新区">高新区</button></li>
                    <li><button value="昌北经济开发区">昌北经济开发区</button></li>
                    <li><button value="象湖">象湖</button></li>
                </ul>
            </div><br>
            <div class="area">
                <input type="hidden" name="region" value="<%=area%>">
                <span class="keyName">面积：</span>
                <ul>
                    <li class="l0"><button value="-1" onclick="">不限</button></li>
                    <li><button value="0">25平米以下</button></li>
                    <c:forEach var="i" begin="25" end="125" step="25">
                        <li><button value="${i}">${i}-${i+25}平米</button></li>
                    </c:forEach>
                    <li><button value="150">150平米以上</button></li>
                </ul>
            </div><br>
            <div class="floor">
                <input type="hidden" name="region" value="<%=floor%>">
                <span class="keyName">楼层：</span>
                <ul>
                    <li class="l0"><button value="-1">不限</button></li>
                    <c:forEach var="i" begin="1" end="13" step="3">
                        <li><button value="${i}">${i}-${i+3}楼</button></li>
                    </c:forEach>
                    <li><button value="17">17以上</button></li>
                </ul>
            </div><br>
            <div class="rent">
                <input type="hidden" name="region" value="<%=rent%>">
                <span class="keyName">租金：</span>
                <ul>
                    <li class="l0"><button value="-1">不限</button></li>
                    <li><button value="0">500元以下</button></li>
                    <c:forEach var="i" begin="500" end="2500" step="500">
                        <li><button value="${i}">${i}-${i+500}元</button></li>
                    </c:forEach>
                    <li><button value="3000">3000元以上</button></li>
                </ul>
            </div><br>
            <div class="type">
                <input type="hidden" name="region" value="<%=type%>">
                <span class="keyName">房型：</span>
                <ul>
                    <li class="l0"><button value="">不限</button></li>
                    <li><button value="1室">一室</button></li>
                    <li><button value="2室">两室</button></li>
                    <li><button value="3室">三室</button></li>
                    <li><button value="4室">四室</button></li>
                    <li><button value="5室">四室以上</button></li>
                </ul>
            </div><br>
            <div class="decoration">
                <input type="hidden" name="region" value="<%=decoration%>">
                <span class="keyName">装修：</span>
                <ul>
                    <li class="l0"><button value="">不限</button></li>
                    <li><button value="毛胚">毛胚</button></li>
                    <li><button value="简单装修">简单装修</button></li>
                    <li><button value="中等装修">中等装修</button></li>
                    <li><button value="精品装修">精品装修</button></li>
                    <li><button value="豪华装修">豪华装修</button></li>
                </ul>
            </div><br>
        </div>
    </form>

    <div class="house-infor">
        <c:if test="${not empty houses}">
        <c:forEach items="${houses}" var="houses">
                <div class="infor-box">
                    <a href="/house/detile?hid=${houses.hid}">
                        <div class="house-photo"><img src="/images/house${houses.photo}" width="150" height="110"></div>
                        <div class="content">
                            <h2 class="title">${houses.title}</h2>
                            <p class="des">${houses.type}&emsp;${houses.decoration}</p>
                            <p class="des">${houses.region} </p>
                            <p class="des">${houses.address}</p>
                        </div>
                        <div class="list-right">
                            <%--<div class="sendTime">2019-1-6</div>--%>
                            <div class="rent"><b>${houses.rent}</b>元/月</div>
                        </div>
                    </a>
                </div>
        </c:forEach>
            <div class="bottomPage">
                <div class="center1">
                    第${ PageCode }页/共${ TotalPage }页
                    <a href="${ pageContext.request.contextPath }/Index/HouseDivideByPage?pc=1">首页</a>
                    <c:if test="${ PageCode > 1 }">
                        <a href="${ pageContext.request.contextPath }/Index/HouseDivideByPage?pc=${PageCode - 1}">上一页</a>
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
                        <a href="${ pageContext.request.contextPath }/Index/HouseDivideByPage?pc=${i}">[${ i }]</a>
                    </c:forEach>
                    <c:if test="${ PageCode < TotalPage }">
                        <a href="${ pageContext.request.contextPath }/Index/HouseDivideByPage?pc=${PageCode + 1}">下一页</a>
                    </c:if>
                    <a href="${ pageContext.request.contextPath }/Index/HouseDivideByPage?pc=${TotalPage}">尾页</a>
                </div>
            </div>
        </c:if>

    <c:if test="${not empty IndexHouses}">
    <c:forEach items="${IndexHouses}" var="houses">
        <div class="infor-box">
            <a href="/house/detile?hid=${houses.hid}">
                <div class="house-photo"><img src="/images/house${houses.photo}" width="150" height="110"></div>
                <div class="content">
                    <h2 class="title">${houses.title}</h2>
                    <p class="des">${houses.type}&emsp;${houses.decoration}</p>
                    <p class="des">${houses.region} </p>
                    <p class="des">${houses.address}</p>
                </div>
                <div class="list-right">
                        <%--<div class="sendTime">2019-1-6</div>--%>
                    <div class="rent"><b>${houses.rent}</b>元/月</div>
                </div>
            </a>
        </div>
    </c:forEach>
    <div class="bottomPage">
        <div class="center1">
            第${ PageCode }页/共${ TotalPage }页
            <a href="${ pageContext.request.contextPath }/Index/HouseSearchServlet?pc=1&&keyWord=<%=request.getParameter("keyWord")==null?"":request.getParameter("keyWord")%>">首页</a>
            <c:if test="${ PageCode > 1 }">
                <a href="${ pageContext.request.contextPath }/Index/HouseSearchServlet?pc=${PageCode - 1}&&keyWord=<%=request.getParameter("keyWord")==null?"":request.getParameter("keyWord")%>">上一页</a>
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
                <a href="${ pageContext.request.contextPath }/Index/HouseSearchServlet?pc=${i}&&keyWord=<%=request.getParameter("keyWord")==null?"":request.getParameter("keyWord")%>">[${ i }]</a>
            </c:forEach>
            <c:if test="${ PageCode < TotalPage }">
                <a href="${ pageContext.request.contextPath }/Index/HouseSearchServlet?pc=${PageCode + 1}&&keyWord=<%=request.getParameter("keyWord")==null?"":request.getParameter("keyWord")%>">下一页</a>
            </c:if>
            <a href="${ pageContext.request.contextPath }/Index/HouseSearchServlet?pc=${TotalPage}&&keyWord=<%=request.getParameter("keyWord")==null?"":request.getParameter("keyWord")%>">尾页</a>
            </div>
        </div>
        </c:if>
     </div>

    <div class="house-search-page">
        <div class="recommed">
            <div class="detile-bar">广告招租</div>
            <div class="house-recommed">
                <div class="recommed-box">
                    <img src="/images/house/house1.jpg" width="160px" height="120px">
                    <div class="recommed-info">
                        <h3>广告位招租，点击进入广告展示申请页面</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
