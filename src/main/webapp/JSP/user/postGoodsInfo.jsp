<%--
  Created by IntelliJ IDEA.
  User: pcdn
  Date: 2019/1/9
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>商品订单发布分页</title>
</head>
<body>
<div class="main" style="margin-top: 40px">
<table border="1" width="90%" cellpadding="5" align="center">
    <tr>
        <th>序号</th>
        <th>名称</th>
        <th>类型</th>
        <th>价格</th>
        <th>描述</th>
        <th>新旧程度</th>
        <th>颜色</th>
    </tr>
    <%-- varStatus="s"      <td>${ s.count }</td>--%>
    <c:forEach items="${ BeanList }" var="Goods" varStatus="s">
        <tr align="center">
            <td>${ s.count }</td>
            <td>${ Goods.name }</td>
            <td>${ Goods.type }</td>
            <td>${ Goods.price }</td>
            <td>${ Goods.description }</td>
            <td>${ Goods.old }</td>
            <td>${ Goods.color }</td>
        </tr>
    </c:forEach>
</table>

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

</body>
</html>