<%--
  Created by IntelliJ IDEA.
  User: pcdn
  Date: 2019/1/9
  Time: 8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布二手商品</title>
    <style>
        @import "/styles/index_home.css";
        .conform{
            margin-left: 120px;
            border: 1px solid #ff7043;
            width: 700px;
            height: 580px;
            font-size: 18px;
            margin-bottom: 100px;
            padding-top: 20px;
            padding-left: 200px;
        }
        .reply-button:hover{
            background: #ff7043;
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
    <h1 style="text-align: center">修改二手商品</h1>
    <div class="conform">
        <form action="/Goods/updateOver?gid=${Goods.gid}" method="post">
            商品名称：<input type="text" name="name" value="${Goods.name}"><br><br>
            商品类型：<select name="type" class="">
            <option>手机</option>
            <option>电视机</option>
            <option>洗衣机</option>
            <option>生活家电</option>
            <option>厨卫家电</option>
            <option>数码产品</option>
            <option>服饰用品</option>
        </select><br><br>
        商品价格：<input type="text" name="money" class="" value="${Goods.price}"><br><br>
        商品描述：<textarea name="description"  id="" cols="30" rows="10">${Goods.description}</textarea><br><br>
        新旧程度：<input type="text" name="old" class="" value="${Goods.old}"><br><br>
        商品颜色：<input type="text" name="color" class="" value="${Goods.color}"><br><br>
        <input class="reply-button" type="submit" value="确认修改" style="font-size: 18px" box-shadow:0 2px 0 #EEE;>
        </form>
    </div>
</div>
</body>
</html>
