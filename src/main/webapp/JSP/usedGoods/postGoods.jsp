<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布二手商品</title>
    <style>
        @import "/styles/index_home.css";
        @import "/styles/post.css";
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
    <script>
        function check(){
            var name = document.getElementById("name").value;
            var type = document.getElementById("type").value;
            var money = document.getElementById("money").value;
            var description = document.getElementById("description").value;
            var old = document.getElementById("old").value;
            var color = document.getElementById("color").value;

            if( name == null || name == "") { alert("商品名字不能为空"); return false; }
            if( type == null || type == "") { alert("商品类型不能为空"); return false; }
            if( money == null || money == "") { alert("价格不能为空"); return false; }
            if(isNaN(money)) { alert("价格只能为数字"); return false; }
            if( description == null || description == "") { alert("商品描述不能为空"); return false; }
            if( old  == null || old  == "") { alert("新旧程度不能为空"); return false; }
            if( color == null || color == "") { alert("商品颜色不能为空"); return false; }
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
    <div class="post-top-part">
        <div class="progcontrl">
            <div class="propbar" id="propbarfirst">
                <span>1. 二手商品
                    <a href="/JSP/choosePost.jsp" style="color:blue;">重选类别</a>
                </span>
            </div>
            <div class="active" id="propbartwo">
                <span>2.填写信息</span>
            </div>
            <div class="propbar" id="propbarthree">
                <span>3.完成发布</span>
            </div>
        </div>
    </div>

    <div class="paytoptips">
        <div class="paytips">
            <p>跳蚤市场所有类别信息的标题、物品详情、图片等位置均不得体现QQ\微信\电话等联系方式。</p>
            <p>请您在发帖时注意修改，以确保符合平台发帖规则</p>
            <p>上传实拍图片:上传与二手商品相关的真实图片</p>
        </div>
    </div>

    <div class="post-main">
        <form action="/postGoods" method="post" enctype="multipart/form-data" onsubmit="return check();">
            <div class="block-wrap">
                <div class="block-title"><h3>二手商品信息</h3></div>
                <div class="block-content">
                    <div class="row-wrap">
                        <div class="row-title"><span>商品标题</span></div>
                        <div class="row-content">
                            <div class="input-text" style="width: 400px">
                                <input type="text" name="name" id="name" size="58">
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>商品类型</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <select name="type" id="type" style="width: 109px;border-radius: 3px">
                                    <option value="手机">手机</option>
                                    <option value="电视机">电视机</option>
                                    <option value="洗衣机">洗衣机</option>
                                    <option value="生活家电">生活家电</option>
                                    <option value="厨卫家电">厨卫家电</option>
                                    <option value="数码产品">数码产品</option>
                                    <option value="服饰用品">服饰用品</option>
                                </select>
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>闲置价格</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <input type="text" name="money" id="money" size="11">
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>物品颜色</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <input type="text" name="color" id="color" size="11">
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>新旧程度</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <select name="old" id="old" style="width: 109px;border-radius: 3px">
                                    <option value="九八成">九八成</option>
                                    <option value="九五成">九五成</option>
                                    <option value="九成">九成</option>
                                    <option value="八成">八成</option>
                                    <option value="七成">七成</option>
                                </select>
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>商品描述</span></div>
                        <div class="row-content">
                            <div class="input-text" style="width: 500px;height: 150px">
                                <textarea type="text" name="description"  id="description" style="height: 148px;"></textarea>
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>上传照片</span></div>
                        <div class="row-content">
                            <div class="input-text" style="border: none">
                                <input type="file" name="photo" id="photo" multiple="multiple">
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title">&nbsp;</div>
                        <div class="row-content">
                            <div class="input-text submit"  style="width: 150px;background-color: #ed6d06;">
                                <input type="submit" value="发布闲置" class="submit_bt" name="">
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
