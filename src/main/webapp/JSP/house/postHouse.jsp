<head>
    <%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>发布出租信息</title>
    <style type="text/css">
        @import "/styles/index_home.css";
        @import "/styles/post.css";
    </style>
    <script>
        function check(){
            var address = document.getElementById("address").value;
            var area = document.getElementById("area").value;
            var floor = document.getElementById("floor").value;
            var rent = document.getElementById("rent").value;
            var region = document.getElementById("region").value;
            var type1 = document.getElementById("type1").value;
            var orient = document.getElementById("orient").value;
            var decoration = document.getElementById("decoration").value;
            var title = document.getElementById("title").value;
            var environ = document.getElementById("environ").value;
            var description = document.getElementById("description").value;
            var photo = document.getElementById("photo").value;
            var connect = document.getElementById("connect").value;
            var phone = document.getElementById("phone").value;

            if(address == null || address == "") { alert("地址不能为空"); return false; }
            if(area == null || area == "") { alert("面积不能为空"); return false; }
            if(isNaN(area)) { alert("面积只能为数字"); return false; }
            if(floor == null || floor == "") { alert("楼层不能为空"); return false; }
            if(isNaN(floor)) { alert("楼层只能为数字"); return false; }
            if(rent == null || rent == "") { alert("租金不能为空"); return false; }
            if(isNaN(rent)) { alert("租金只能为数字"); return false; }
            if(region == null || region == "") { alert("区域不能为空"); return false; }
            if(type1 == null || type1 == "") { alert("房型不能为空"); return false; }
            if(orient == null || orient == "") { alert("朝向不能为空"); return false; }
            if(decoration == null || decoration == "") { alert("装修不能为空"); return false; }
            if(title == null || title == "") { alert("标题不能为空"); return false; }
            if(environ == null || environ == "") { alert("周围环境不能为空"); return false; }
            if(description == null || description == "") { alert("描述不能为空"); return false; }
            if(photo == null || photo == "" ) { alert("图片不能为空"); return false; }
            if(connect == null || connect == "") { alert("联系人不能为空"); return false; }
            if(phone == null || phone == "") { alert("电话不能为空"); return false; }
            if(isNaN(phone)) { alert("电话只能为数字"); return false; }
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
                <span>1. 租房
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
        <%--<span class="payhorns"></span>--%>
        <div class="paytips">
            <p>发帖真实性承诺: 为维护真房源环境，请据实发帖。如发现虚假，平台将封禁账号</p>
            <p>身份真实: 依据真实身份发帖</p>
            <p>上传实拍图片:上传与房源相关的真实图片</p>
            <p>房源如实描述:房源真实在租，位置及厅室等信息真实有效</p>
            <p>房租标价合理:标明实际租住价格，承诺不收取额外费用</p>
        </div>
    </div>

    <div class="post-main">
        <form action="/house/postHouse" method="post" enctype="multipart/form-data" onsubmit="return check();">
            <div class="block-wrap">
                <div class="block-title"><h3>房屋信息</h3></div>
                <div class="block-content">
                    <div class="row-wrap">
                        <div class="row-title"><span>租房地址</span></div>
                        <div class="row-content">
                            <div class="input-text" style="width: 400px">
                                <input type="text" name="address" id="address" size="63"></div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>租房面积</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <input type="text" name="area" id="area" size="7">
                                <span>平米</span>
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>租房楼层</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <input type="text" name="floor" id="floor" size="9">
                                <span>楼</span>
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>租金</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <input type="text" name="rent" id="rent" size="9">
                                <span>元</span>
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>区域</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <select name="region" id="region" style="width: 109px;border-radius: 3px">
                                    <option value="东湖">东湖</option>
                                    <option value="西湖">西湖</option>
                                    <option value="新建区">新建区</option>
                                    <option value="南昌县">南昌县</option>
                                    <option value="湾里">湾里</option>
                                    <option value="青山湖区">青山湖区</option>
                                    <option value="红谷滩新区">红谷滩新区</option>
                                    <option value="高新区">高新区</option>
                                    <option value="昌北经济开发区">昌北经济开发区</option>
                                    <option value="象湖">象湖</option>
                                    <option value="南昌周边">南昌周边</option>
                                </select>
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>房型</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <input type="text" name="type1" id="type1" value="0" size="9">
                                <span>室</span>
                            </div>
                            <div class="input-text">
                                <input type="text" name="type2" value="0" size="9">厅
                            </div>
                            <div class="input-text">
                                <input type="text" name="type3" value="0" size="9">卫
                            </div>
                            <div class="input-tips"></div>
                        </div>
                        <div class="row-title"><span>&nbsp;</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <input type="text" name="type4" value="0" size="9">厨
                            </div>
                            <div class="input-text" style="width: 120px">
                                <input type="text" name="type5" value="0" size="9">阳台
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>租房朝向</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <select name="orient" id="orient" style="width: 109px;border-radius: 3px">
                                    <option value="北">北</option>
                                    <option value="南">南</option>
                                    <option value="西">西</option>
                                    <option value="东">东</option>
                                    <option value="东北">东北</option>
                                    <option value="西北">西北</option>
                                    <option value="东南">东南</option>
                                    <option value="西南">西南</option>
                                </select>
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>装修情况</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <select name="decoration" id="decoration" style="width: 109px;border-radius: 3px">
                                    <option value="毛胚">毛胚</option>
                                    <option value="简单装修">简单装修</option>
                                    <option value="中等装修">中等装修</option>
                                    <option value="精品装修">精品装修</option>
                                    <option value="豪华装修">豪华装修</option>
                                </select>
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="block-wrap">
                <div class="block-title"><h3>发布信息</h3></div>
                <div class="block-content">
                    <div class="row-wrap">
                        <div class="row-title"><span>标题</span></div>
                        <div class="row-content">
                            <div class="input-text" style="width: 400px">
                                <input type="text" id="title" name="title" size="63">
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>周围环境</span></div>
                        <div class="row-content">
                            <div class="input-text" style="width: 500px;height: 80px">
                                <textarea type="text" name="environ" id="environ" style="height: 78px;"></textarea>
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>详细描述</span></div>
                        <div class="row-content">
                            <div class="input-text"  style="width: 500px;height: 150px">
                                <textarea type="text" name="description" id="description" style="height: 148px;"></textarea>
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
                </div>
            </div>

            <div class="block-wrap">
                <div class="block-title"><h3>联系信息</h3></div>
                <div class="block-content">
                    <div class="row-wrap">
                        <div class="row-title"><span>联系人</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <input type="text" name="connect" id="connect" size="9">
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>联系电话</span></div>
                        <div class="row-content">
                            <div class="input-text"  style="width: 150px">
                                <input type="text" name="phone" id="phone">
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title">&nbsp;</div>
                        <div class="row-content">
                            <div class="input-text submit"  style="width: 150px;background-color: #ed6d06;">
                                <input type="submit" value="发布" class="submit_bt" name="">
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
