<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>申请发布广告</title>
    <style type="text/css">
        @import "/styles/index_home.css";
        @import "/styles/post.css";
    </style>
    <script>
        function check(){
            var title = document.getElementById("title").value;
            var aimage = document.getElementById("aimage").value;
            var content = document.getElementById("content").value;
            var money = document.getElementById("money").value;

            if( title  == null || title  == "") { alert("广告标题不能为空"); return false; }
            if( aimage == null || aimage == "") { alert("广告图片不能为空"); return false; }
            if( content == null || content == "") { alert("广告内容不能为空"); return false; }
            if( money == null || money == "") { alert("价格不能为空"); return false; }
            if(isNaN(money)) { alert("价格只能为数字"); return false; }
        }
    </script>
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
    <div class="paytoptips" style="margin-top: 20px">
        <div class="paytips">
            <p>请将您想发布的广告内容按平台格式认真填写</p>
            <p>广告内容禁止出现黄、赌、毒以及其他不符合社会主义核心价值观的内容</p>
            <p>租用价格不得低于200，当多位广告方申请租用该广告位时，您的价格将会影响申请结果</p>
        </div>
    </div>

    <div class="post-main">
        <form action="/ad/postAd" method="post" enctype="multipart/form-data" onsubmit="return check();">
            <div class="block-wrap">
                <div class="block-title"><h3>填写广告信息</h3></div>
                <input hidden type="text" name="apid" id="apid" value="<%=request.getParameter("apid")%>">
                <div class="row-wrap">
                    <div class="row-title"><span>广告标题</span></div>
                    <div class="row-content">
                        <div class="input-text" style="width: 400px">
                            <input type="text" name="title" id="title" size="58">
                        </div>
                        <div class="input-tips"></div>
                    </div>
                </div>
                <div class="row-wrap">
                    <div class="row-title"><span>上传照片</span></div>
                    <div class="row-content">
                        <div class="input-text" style="border: none">
                            <input type="file"  name="aimage" id="aimage" multiple="multiple">
                        </div>
                        <div class="input-tips"></div>
                    </div>
                </div>
                <div class="row-wrap">
                        <div class="row-title"><span>广告内容</span></div>
                        <div class="row-content">
                            <div class="input-text" style="width: 500px;height: 150px">
                                <textarea type="text"  name="content" id="content" style="height: 148px;"></textarea>
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>

                <div class="row-wrap">
                    <div class="row-title"><span>租用价格</span></div>
                    <div class="row-content">
                        <div class="input-text">
                            <input type="text" name="money" id="money" value="200"  size="11">
                        </div>
                        <div class="input-tips"></div>
                    </div>
                </div>

                <div class="row-wrap">
                        <div class="row-title">&nbsp;</div>
                        <div class="row-content">
                            <div class="input-text submit"  style="width: 150px;background-color: #ed6d06;">
                                <input type="submit" value="提交申请广告" class="submit_bt" name="submit">
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
