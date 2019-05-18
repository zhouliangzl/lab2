<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <style type="text/css">
        @import "/styles/login.css";
    </style>
</head>

<body>
<div class="main" style="">
    <div class="content">
        <div class="title_box">
            <h1>欢迎登录综合信息类网</h1>
        </div>

        <form method="post" action="/user/login">
            <div class="input_box">
                <input class="input_text_style" type="text" placeholder="手机号" maxlength="11" autofocus name="uid" onkeyup="value=value.replace(/[^(\d)]/g,'')"/>
                <c:if test="${ not empty uidMsg}">
                    <br><span style="font-size: 15px; color: red;">${uidMsg}</span>
                </c:if>
            </div>

            <div class="input_box">
                <input type="password" id="demo_input" class="input_text_style" placeholder="密码" maxlength="9" name="password" onkeyup="value=value.replace(/[^(\d)]/g,'')"/>
                <img  id="demo_img" onclick="hideShowPsw()" style="width:20px" src="/images/jsp/passworddisplay.png">
                <c:if test="${ not empty loginMsg}">
                    <br><span style="font-size: 15px; color: red;">${loginMsg}</span>
                </c:if>
            </div>

            <div style="width: 90%;">
                <input class="register_button" type="submit" value="登录">
            </div>
        </form>
    </div>
</div>

</body>
<script type="text/javascript">
    // 这里使用最原始的js语法实现，可对应换成jquery语法进行逻辑控制
    var demoImg = document.getElementById("demo_img");
    var demoInput = document.getElementById("demo_input");
    //隐藏text block，显示password block
    function hideShowPsw() {
        if (demoInput.type == "password") {
            demoInput.type = "text";
            demo_img.src = "/images/jsp/notdisplay.png";
        } else {
            demoInput.type = "password";
            demo_img.src = "/images/jsp/passworddisplay.png";
        }
    }
</script>
</html>
