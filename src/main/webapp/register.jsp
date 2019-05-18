<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <style type="text/css">
       @import "/styles/register.css";
    </style>
</head>

<body>
<div class="main" style="  background: url(/images/jsp/register_bg.png) center top;
    background-size: cover;">
    <div class="content">
        <div class="title_box">
            <h1>欢迎注册综合类信息网</h1>
        </div>
        <form method="post" action="/user/register">
            <div class="input_box">
                <input class="input_text_style" type="text" placeholder="手机号" maxlength="11" autofocus name="uid" onkeyup="value=value.replace(/[^(\d)]/g,'')"/>
                <c:if test="${ not empty uidMsg}">
                    <br><span style="font-size: 15px; color: red;">${uidMsg}</span>
                </c:if>
            </div>

            <div class="input_box">
                <input class="input_text_style"  type="text" placeholder="昵称" autofocus name="nickname" maxlength="10">
                <c:if test="${ not empty nickMsg}">
                    <br><span style="font-size: 15px; color: red;">${nickMsg}</span>
                </c:if>
            </div>

            <div class="input_box">
                <input class="input_text_style"  type="text" placeholder="邮箱" autofocus name="email" maxlength="30">
                <c:if test="${ not empty emailMsg}">
                    <br><span style="font-size: 15px; color: red;">${emailMsg}</span>
                </c:if>
            </div>

            <div class="input_box">
                <input type="password" id="demo_input1"  class="input_text_style"placeholder="请输入6-9位密码" maxlength="9" name="password" BBC Maven Webapp onkeyup="value=value.replace(/[^(\d)]/g,'')"/>
                <img  id="demo_img1" onclick="hideShowPsw1()" style="width:20px" src="/images/jsp/passworddisplay.png">
            </div>

            <div class="input_box">
                <input type="password" id="demo_input2"  class="input_text_style" placeholder="确认密码" maxlength="9" name="confirmPassword" onkeyup="value=value.replace(/[^(\d)]/g,'')"/>
                <img id="demo_img2" onclick="hideShowPsw2()" style="width:20px" src="/images/jsp/passworddisplay.png">
                <c:if test="${ not empty passwordMsg}">
                    <br><span style="font-size: 15px; color: red;">${passwordMsg}</span>
                </c:if>
            </div>

            <div >
                <input class="input_text_style2"  type="text" placeholder="验证码" name="inputCode" maxlength="4" >
                <img src="/code" style="width: 130px;height: 50px">
            </div>
            <br>

            <div style="width: 93%">
                <input class="register_button" type="submit" value="立即注册">
            </div>
        </form>
    </div>
</div>

</body>
<script type="text/javascript">

    // 这里使用最原始的js语法实现，可对应换成jquery语法进行逻辑控制
    var demoImg1 = document.getElementById("demo_img1");
    var demoInput1 = document.getElementById("demo_input1");
    var demoImg2 = document.getElementById("demo_img2");
    var demoInput2 = document.getElementById("demo_input2");
    //隐藏text block，显示password block
    function hideShowPsw1() {
        if (demoInput1.type == "password") {
            demoInput1.type = "text";
            demo_img1.src = "/images/jsp/passworddisplay.png";
        } else {
            demoInput1.type = "password";
            demo_img1.src = "/images/jsp/notdisplay.png";
        }
    }

    function hideShowPsw2(){
        if (demoInput2.type == "password") {
            demoInput2.type = "text";
            demo_img2.src = "/images/jsp/passworddisplay.png";
        }else {
            demoInput2.type = "password";
            demo_img2.src = "/images/jsp/notdisplay.png";
        }
    }

</script>
</html>
