<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>用户信息</title>
    <style type="text/css">
        @import "/styles/index_home.css";
        @import "/styles/user.css";
    </style>
</head>
<body>
<!--顶部-->
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
    <div class="user_body_left">
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
        <form method="post" action="/GoodsOrderSearchBytime">
            <div class="bar">
                <div class="type_item"><a href="/houseListByPage">发布的房源</a></div>
                <div class="type_item"><a href="/listByPage">发布的商品</a></div>
                <div class="type_item"><a href="/GoodsOrderListByPage">我的订单</a></div>
                <div class="type_item"><a href="/SignHouseListByPage">我的合同</a></div>
            </div>

            <div class="bar">
                <div class="search_item">
                    <span style="color: #ff4910">订单条件查询&emsp;</span>
                    <span>按时间：</span>
                    <div class="item">
                        <input type="radio" value="Asc" name="sortByTime" > 升序
                    </div>
                    <div class="item">
                        <input type="radio" value="Desc" name="sortByTime" checked>降序
                    </div>
                </div>
                <div class="search_item">
                    <span>日期：</span>
                    <div class="item">
                        <select name="year">
                            <option value="0">不限</option>
                            <c:forEach var="i" begin="2010" step="1" end="2020">
                                <option value="${i}">${i}</option>
                            </c:forEach>
                        </select>年
                    </div>

                    <div class="item">
                        <select name="month">
                            <option value="0" selected>不限</option>
                            <c:forEach var="i" begin="1" step="1" end="12">
                                <option value="${i}">${i}</option>
                            </c:forEach>
                        </select>月
                    </div>

                    <div class="item">
                        <select name="day">
                            <option value="0" selected>不限</option>
                            <c:forEach var="i" begin="1" step="1" end="31">
                                <option value="${i}">${i}</option>
                            </c:forEach>
                        </select>日
                    </div>
                </div>

                <div class="search_item">
                    <span>关键字：</span>
                    <div class="input-text">
                        <input type="text" name="keyWord" class="inputStyle" value="<%=request.getParameter("keyWord")==null?"":request.getParameter("keyWord")%>"/>
                    </div>
                </div>

                <div class="search_item">
                    <div class="submit_box">
                        <input type="submit" value="查询" name="search" class="submit_bt">
                    </div>
                </div>
            </div>
        </form>

        <div class="show_result">

<%--发布的房屋样式--%>
<c:if test="${not empty houses}">
    <c:forEach items="${houses}" var="houses" >
            <%--发布的房屋样式--%>
            <div class="infor-box">
                <%--${houses[i].hid}--%>
                <a href="/house/detile?hid=${houses.hid}">
                    <%--${houses[i].photo}--%>
                    <div class="infor_type"><h2>发布的房源</h2></div>
                    <div class="house-photo"><img src="/images/house${houses.photo}" width="150" height="110"></div>
                    <div class="content">
                        <%--${houses[i].title}学府大道 地铁口 中央香榭 豪装三房 房东自住装修 随时看房--%>
                        <h2 class="title">${houses.title}</h2>
                            <%--3室2厅1卫1厨1阳台,精品装修--%>
                        <p class="des">${houses.type}&emsp;${houses.decoration}</p>
                            <%--红谷滩新区--%>
                        <p class="des">${houses.region}</p>
                            <%--红角洲 丰和南大道1888号--%>
                        <p class="des">${houses.address}</p>
                    </div>
                    <div class="list-right">
                            <%--<div class="sendTime">2019-1-6 1200</div>--%>
                        <div class="rent"><b>${houses.rent}</b>元/月</div>
                    </div>
                    <div class="opration">
                        <a href="/house/updateStart?hid=${houses.hid}">修改</a>
                        <a href="/house/delete?hid=${houses.hid}">删除</a>
                    </div>
                </a>
            </div>
    </c:forEach>
        <div class="bottomPage">
            <center>
                第${ PageCode }页/共${ TotalPage }页
                <a href="${ pageContext.request.contextPath }/houseListByPage?pc=1">首页</a>
                <c:if test="${ PageCode > 1 }">
                    <a href="${ pageContext.request.contextPath }/houseListByPage?pc=${PageCode - 1}">上一页</a>
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
                    <a href="${ pageContext.request.contextPath }/houseListByPage?pc=${i}">[${ i }]</a>
                </c:forEach>
                <c:if test="${ PageCode < TotalPage }">
                    <a href="${ pageContext.request.contextPath }/houseListByPage?pc=${PageCode + 1}">下一页</a>
                </c:if>
                <a href="${ pageContext.request.contextPath }/houseListByPage?pc=${TotalPage}">尾页</a>
            </center>
        </div>
</c:if>

<%--发布的二手商品样式--%>
 <c:if test="${not empty goodss}">
     <c:forEach items="${goodss}" var="goods" >
            <%--发布的二手商品样式--%>
            <div class="infor-box">
                <%--${goods[i].gid}--%>
                <a href="/usedGoods/detile?gid=${goods.gid}">
                    <%--${goods[i].gimage}--%>
                    <div class="infor_type"><h2>发布的商品</h2></div>
                    <div class="house-photo"><img src="/images/goods${goods.gimage}" width="150" height="110"></div>
                    <div class="content">
                        <%--${goods[i].name}--%>
                        <h2 class="title">${goods.name}</h2>
                        <%--${goods[i].type}--%>
                        <p class="des">${goods.type}</p>
                        <%--${goods[i].rcolor} ${goods[i].old}--%>
                        <p class="des">颜色：${goods.color}  成色：${goods.old}</p>
                    </div>
                    <div class="list-right">
                        <%--<div class="sendTime">2019-1-6</div>--%>
                        <div class="rent"><b>${goods.price}</b>元</div>
                    </div>
                    <div class="opration">
                        <a href="/Goods/updateStart?gid=${ goods.gid }">修改</a>
                        <a href="/Goods/delete?gid=${ goods.gid }">删除</a>
                    </div>
                </a>
            </div>
    </c:forEach>
            <div class="bottomPage">
                <center>
                    第${ PageCode }页/共${ TotalPage }页
                    <a href="${ pageContext.request.contextPath }/listByPage?pc=1">首页</a>
                    <c:if test="${ PageCode > 1 }">
                        <a href="${ pageContext.request.contextPath }/listByPage?pc=${PageCode - 1}">上一页</a>
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
                        <a href="${ pageContext.request.contextPath }/listByPage?pc=${i}">[${ i }]</a>
                    </c:forEach>
                    <c:if test="${ PageCode < TotalPage }">
                        <a href="${ pageContext.request.contextPath }/listByPage?pc=${PageCode + 1}">下一页</a>
                    </c:if>
                    <a href="${ pageContext.request.contextPath }/listByPage?pc=${TotalPage}">尾页</a>
                </center>
            </div>
</c:if>

<%--所查询的订单样式--%>
<c:if test="${not empty searchGoodsOrders}">
    <c:forEach items="${searchGoodsOrders}" var="goodsOrder" >
        <div class="infor-box">
                <div class="infor_type"><h2>我的订单</h2></div>
                <div class="house-photo"><img src="/images/goods${goodsOrder.oimage}" width="150" height="110"></div>
            <div class="content">
                <h2 class="title">收货人：${goodsOrder.name}</h2>
                <p class="des">我的收货地址：${goodsOrder.address}</p>
                <p class="des">我的电话：${goodsOrder.phone}</p>
                <p class="des">订单时间：${goodsOrder.otime}</p>
            </div>
            <div class="list-right">
                <div class="rent"><b>${goodsOrder.price}</b>元</div>
            </div>
            <div class="opration">
                <a href="/DeleteGoodsOrder?oid=${goodsOrder.oid}">删除</a>
            </div>
        </div>
    </c:forEach>
    <div class="bottomPage">
        <center>
            第${ PageCode }页/共${ TotalPage }页
            <a href="${ pageContext.request.contextPath }/GoodsOrderSearchBytime?pc=1&&keyWord=<%=request.getParameter("keyWord")==null?"":request.getParameter("keyWord")%>">首页</a>
            <c:if test="${ PageCode > 1 }">
                <a href="${ pageContext.request.contextPath }/GoodsOrderSearchBytime?pc=${PageCode - 1}&&keyWord=<%=request.getParameter("keyWord")==null?"":request.getParameter("keyWord")%>">上一页</a>
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
                <a href="${ pageContext.request.contextPath }/GoodsOrderSearchBytime?pc=${i}&&keyWord=<%=request.getParameter("keyWord")==null?"":request.getParameter("keyWord")%>">[${ i }]</a>
            </c:forEach>
            <c:if test="${ PageCode < TotalPage }">
                <a href="${ pageContext.request.contextPath }/GoodsOrderSearchBytime?pc=${PageCode + 1}&&keyWord=<%=request.getParameter("keyWord")==null?"":request.getParameter("keyWord")%>">下一页</a>
            </c:if>
            <a href="${ pageContext.request.contextPath }/GoodsOrderSearchBytime?pc=${TotalPage}&&keyWord=<%=request.getParameter("keyWord")==null?"":request.getParameter("keyWord")%>">尾页</a>
        </center>
    </div>
</c:if>

<%--我的订单样式--%>
    <c:if test="${not empty goodsOrders}">
        <c:forEach items="${goodsOrders}" var="goodsOrder" >
            <div class="infor-box">
                <div class="infor_type"><h2>我的订单</h2></div>
                <div class="house-photo"><img src="/images/goods${goodsOrder.oimage}" width="150" height="110"></div>
                <div class="content">
                    <h2 class="title">收货人：${goodsOrder.name}</h2>
                    <p class="des">我的收货地址：${goodsOrder.address}</p>
                    <p class="des">我的电话：${goodsOrder.phone}</p>
                    <p class="des">订单时间：${goodsOrder.otime}</p>
                </div>
                <div class="list-right">
                    <div class="rent"><b>${goodsOrder.price}</b>元</div>
                </div>
                <div class="opration">
                    <a href="/DeleteGoodsOrder?oid=${goodsOrder.oid}">删除</a>
                </div>
            </div>
        </c:forEach>
        <div class="bottomPage">
            <center>
                第${ PageCode }页/共${ TotalPage }页
                <a href="${ pageContext.request.contextPath }/GoodsOrderListByPage?pc=1">首页</a>
                <c:if test="${ PageCode > 1 }">
                    <a href="${ pageContext.request.contextPath }/GoodsOrderListByPage?pc=${PageCode - 1}">上一页</a>
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
                    <a href="${ pageContext.request.contextPath }/GoodsOrderListByPage?pc=${i}">[${ i }]</a>
                </c:forEach>
                <c:if test="${ PageCode < TotalPage }">
                    <a href="${ pageContext.request.contextPath }/GoodsOrderListByPage?pc=${PageCode + 1}">下一页</a>
                </c:if>
                <a href="${ pageContext.request.contextPath }/GoodsOrderListByPage?pc=${TotalPage}">尾页</a>
            </center>
        </div>
    </c:if>

<%--购买的订单样式--%>
    <c:if test="${not empty signHouses}">
        <c:forEach begin="0" var="i" step="1" end="${housesSize}">
            <a href="/house/signHouseDetail?sid=${signHouses[i].sid}">
                <div class="infor-box">
                    <div class="infor_type"><h2>我的合同</h2></div>
                    <div class="house-photo"><img src="/images/house${housess[i].photo}" width="150" height="110"></div>
                    <div class="content">
                        <h2 class="title">${housess[i].title}</h2>
                        <p class="des">姓名：${signHouses[i].connect}</p>
                        <p class="des">电话：${signHouses[i].phone}</p>
                        <p class="des">合同签订时间：${signHouses[i].stime}</p>
                    </div>
                    <div class="list-right">
                        <div class="rent"><b>${housess[i].rent}</b>元/月</div>
                    </div>
                    <div class="opration">
                        <a href="">删除</a>
                    </div>
                </div>
            </a>
        </c:forEach>
        <div class="bottomPage">
            <center>
                第${ PageCode }页/共${ TotalPage }页
                <a href="${ pageContext.request.contextPath }/SignHouseListByPage?pc=1">首页</a>
                <c:if test="${ PageCode > 1 }">
                    <a href="${ pageContext.request.contextPath }/SignHouseListByPage?pc=${PageCode - 1}">上一页</a>
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
                    <a href="${ pageContext.request.contextPath }/SignHouseListByPage?pc=${i}">[${ i }]</a>
                </c:forEach>
                <c:if test="${ PageCode < TotalPage }">
                    <a href="${ pageContext.request.contextPath }/SignHouseListByPage?pc=${PageCode + 1}">下一页</a>
                </c:if>
                <a href="${ pageContext.request.contextPath }/SignHouseListByPage?pc=${TotalPage}">尾页</a>
            </center>
        </div>
</c:if>
</div>
</div>
</div>
</body>
</html>