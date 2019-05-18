<head>
    <%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>修改出租信息</title>
    <style type="text/css">
        @import "/styles/index_home.css";
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
    <div class="post-top-part">
        <div class="progcontrl">
            <div class="propbar" id="propbarfirst">
                <span>1. 租房
                </span>
            </div>
            <div class="active" id="propbartwo">
                <span>2.修改信息</span>
            </div>
            <div class="propbar" id="propbarthree">
                <span>3.修改完成</span>
            </div>
        </div>
    </div>

    <div class="paytoptips">
        <%--<span class="payhorns"></span>--%>
        <div class="paytips">
            <p>修改真实性承诺: 为维护真房源环境，请据实修改。如发现虚假，平台将封禁账号</p>
            <p>身份真实: 依据真实身份发帖</p>
            <p>上传实拍图片:上传与房源相关的真实图片</p>
            <p>房源如实描述:房源真实在租，位置及厅室等信息真实有效</p>
            <p>房租标价合理:标明实际租住价格，承诺不收取额外费用</p>
        </div>
    </div>

    <div class="post-main">
        <form action="/house/updateOver?hid=${house.hid}" method="post" enctype="multipart/form-data" >
            <div class="block-wrap">
                <div class="block-title"><h3>房屋信息</h3></div>
                <div class="block-content">
                    <div class="row-wrap">
                        <div class="row-title"><span>租房地址</span></div>
                        <div class="row-content">
                            <div class="input-text" style="width: 400px">
                                <input type="hidden" name="uid" value="${uid}">
                                <input type="text" name="address" size="63" value="${house.address}"></div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>租房面积</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <input type="text" name="area" size="7" value="${house.area}">
                                <span>平米</span>
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>租房楼层</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <input type="text" name="floor"  size="9"  value="${house.floor}">
                                <span>楼</span>
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>租金</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <input type="text" name="rent"  size="9" value="${house.rent}">
                                <span>元</span>
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>区域</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <select name="region" style="width: 109px;border-radius: 3px">
                                    <option value="东湖" <c:if test="${house.region=='东湖'}">selected</c:if>>东湖</option>
                                    <option value="西湖" <c:if test="${house.region=='西湖'}">selected</c:if>>西湖</option>
                                    <option value="新建区" <c:if test="${house.region=='新建区'}">selected</c:if>>新建区</option>
                                    <option value="南昌县" <c:if test="${house.region=='南昌县'}">selected</c:if>>南昌县</option>
                                    <option value="湾里" <c:if test="${house.region=='湾里'}">selected</c:if>>湾里</option>
                                    <option value="青山湖区" <c:if test="${house.region=='青山湖区'}">selected</c:if>>青山湖区</option>
                                    <option value="红谷滩新区" <c:if test="${house.region=='红谷滩新区'}">selected</c:if>>红谷滩新区</option>
                                    <option value="高新区" <c:if test="${house.region=='高新区'}">selected</c:if>>高新区</option>
                                    <option value="昌北经济开发区" <c:if test="${house.region=='昌北经济开发区'}">selected</c:if>>昌北经济开发区</option>
                                    <option value="象湖" <c:if test="${house.region=='象湖'}">selected</c:if>>象湖</option>
                                    <option value="南昌周边" <c:if test="${house.region=='南昌周边'}">selected</c:if>>南昌周边</option>
                                </select>
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>房型</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <input type="text" name="type" value="${house.type}" size="30">
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>租房朝向</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <select name="orient"  style="width: 109px;border-radius: 3px">
                                    <option value="北" <c:if test="${house.orient=='北'}">selected</c:if>>北</option>
                                    <option value="南" <c:if test="${house.orient=='南'}">selected</c:if>>南</option>
                                    <option value="西" <c:if test="${house.orient=='西'}">selected</c:if>>西</option>
                                    <option value="东" <c:if test="${house.orient=='东'}">selected</c:if>>东</option>
                                    <option value="东北" <c:if test="${house.orient=='东北'}">selected</c:if>>东北</option>
                                    <option value="西北" <c:if test="${house.orient=='西北'}">selected</c:if>>西北</option>
                                    <option value="东南" <c:if test="${house.orient=='东南'}">selected</c:if>>东南</option>
                                    <option value="西南" <c:if test="${house.orient=='西南'}">selected</c:if>>西南</option>
                                </select>
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>装修情况</span></div>
                        <div class="row-content">
                            <div class="input-text">
                                <select name="decoration"  style="width: 109px;border-radius: 3px">
                                    <option value="毛胚" <c:if test="${house.decoration=='毛胚'}">selected</c:if>>毛胚</option>
                                    <option value="简单装修" <c:if test="${house.decoration=='简单装修'}">selected</c:if>>简单装修</option>
                                    <option value="中等装修" <c:if test="${house.decoration=='中等装修'}">selected</c:if>>中等装修</option>
                                    <option value="精品装修" <c:if test="${house.decoration=='精品装修'}">selected</c:if>>精品装修</option>
                                    <option value="豪华装修" <c:if test="${house.decoration=='豪华装修'}">selected</c:if>>豪华装修</option>
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
                                <input type="text" name="title" size="63" value="${house.title}">
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>周围环境</span></div>
                        <div class="row-content">
                            <div class="input-text" style="width: 500px;height: 80px">
                                <textarea type="text" name="environ" style="height: 78px;">
                                     ${house.environ}
                                </textarea>
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>详细描述</span></div>
                        <div class="row-content">
                            <div class="input-text"  style="width: 500px;height: 150px">
                                <textarea type="text" name="description"  style="height: 148px;">
                                     ${house.description}
                                </textarea>
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>更换照片</span></div>
                        <div class="row-content">
                            <img src="/images/house${house.photo}" width="640" height="480">
                            <div class="input-text" style="border: none">
                                <input type="file" name="photo" multiple="multiple">
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
                                <input type="text" name="connect" size="9" value="${house.connect}">
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title"><span>联系电话</span></div>
                        <div class="row-content">
                            <div class="input-text"  style="width: 150px">
                                <input type="text" name="phone" value="${house.phone}">
                            </div>
                            <div class="input-tips"></div>
                        </div>
                    </div>
                    <div class="row-wrap">
                        <div class="row-title">&nbsp;</div>
                        <div class="row-content">
                            <div class="input-text submit"  style="width: 150px;background-color: #ed6d06;">
                                <input type="submit" value="完成修改" class="submit_bt" name="">
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
