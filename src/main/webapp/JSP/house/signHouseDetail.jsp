<%@ page import="java.text.SimpleDateFormat" %>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>合同详情</title>
    <style type="text/css">
        @import "/styles/index_home.css";
        @import "/styles/sign.css";
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

    <div class="sign_title" style="padding-top: 10px">
        <span>房屋租赁合同</span>
    </div>

    <div class="contract_box">
        <div class="mutual_infor">
            <p class="title">本合同双方当事人：</p>
            <br>

            <p>出租方（以下简称甲方）: ${house.connect}</p>
            <p>联系电话 : ${house.phone}</p>
            <br>
            <p>承租方（以下简称乙方）:  ${signHouse.connect}</p>
            <p>联系电话:  ${signHouse.phone}</p>
            <p>身份证:  ${signHouse.idCard}</p>
        </div>

        <div class="law_infor">
            <span>根据《中华人民共和国合同法》《中华人民共和国城市房地产管理法》及其他有关法律、法规规定，在平等、自愿、协商一致的基础上，甲、乙双方就下列房屋的租赁达成如下协议：</span>
        </div>

        <div class="content">
            <div class="part">
                <p>第一条、租赁范围</p>
                <span>1. 甲方房屋（以下简称该房屋）坐落于</span>
                <span class="infor">${house.region}&emsp;${house.address}</span>
                <span>；位于第</span>
                <span class="infor">${house.floor}</span>
                <span>层，房屋结构为</span>
                <span class="infor">${house.type}</span>
                <span>，建筑面积</span>
                <span class="infor">${house.area}</span>
                <span>平方米</span>
            </div>
            <div class="part">
                <p>第二条、租赁时间</p>
                <span>1. 本合同生效时间为1年，自</span>
                <span class="infor"> ${timeStart}</span>
                <span>至</span>
                <span class="infor">${timeEnd}</span>
                <span>合同到期后如甲乙双方均未提出反对意见，本合同代理期自动延长6个月。</span>
                <span>合同到期后，如甲方或乙方提出终止本合同，则按本合同中合同终止条款处理。</span>
                <br>

                <span>2. 在本合同有效代理期内，除非甲方或乙方违约，双方不得单方面终止本合同。</span><br>
                <span>3. 在本合同有效代理期内，甲方不得在地区指定其他代商。</span>
            </div>

            <div class="part">
                <p>第三条、费用负担</p>
                <span>1. 本项目的推广费用（包括但不仅包括报纸电视广告、印制宣传材料、售楼书、制作沙盘等）由甲方负责支付。该费用应在费用发生前一次性到位。
具体销售工作人员的开支及日常支出由乙方负责支付。</span>
            </div>
        </div>

        <span>身份证照片： </span>
        <img src="/images/house/contract${signHouse.idImage}" width="400" height="300">
    </div>

        <button class="submit_bt">返回上一页</button>
</div>

</body>
</html>
