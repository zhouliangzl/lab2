/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.8.v20171121
 * Generated at: 2019-05-10 08:04:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.JSP.house;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class postHouse_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("file:/F:/curriculumDesign/src/main/webapp/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1546150985916L));
    _jspx_dependants.put("jar:file:/F:/curriculumDesign/src/main/webapp/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153356282000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<head>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    <title>发布出租信息</title>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        @import \"/styles/index_home.css\";\r\n");
      out.write("        @import \"/styles/post.css\";\r\n");
      out.write("    </style>\r\n");
      out.write("    <script>\r\n");
      out.write("        function check(){\r\n");
      out.write("            var address = document.getElementById(\"address\").value;\r\n");
      out.write("            var area = document.getElementById(\"area\").value;\r\n");
      out.write("            var floor = document.getElementById(\"floor\").value;\r\n");
      out.write("            var rent = document.getElementById(\"rent\").value;\r\n");
      out.write("            var region = document.getElementById(\"region\").value;\r\n");
      out.write("            var type1 = document.getElementById(\"type1\").value;\r\n");
      out.write("            var orient = document.getElementById(\"orient\").value;\r\n");
      out.write("            var decoration = document.getElementById(\"decoration\").value;\r\n");
      out.write("            var title = document.getElementById(\"title\").value;\r\n");
      out.write("            var environ = document.getElementById(\"environ\").value;\r\n");
      out.write("            var description = document.getElementById(\"description\").value;\r\n");
      out.write("            var photo = document.getElementById(\"photo\").value;\r\n");
      out.write("            var connect = document.getElementById(\"connect\").value;\r\n");
      out.write("            var phone = document.getElementById(\"phone\").value;\r\n");
      out.write("\r\n");
      out.write("            if(address == null || address == \"\") { alert(\"地址不能为空\"); return false; }\r\n");
      out.write("            if(area == null || area == \"\") { alert(\"面积不能为空\"); return false; }\r\n");
      out.write("            if(isNaN(area)) { alert(\"面积只能为数字\"); return false; }\r\n");
      out.write("            if(floor == null || floor == \"\") { alert(\"楼层不能为空\"); return false; }\r\n");
      out.write("            if(isNaN(floor)) { alert(\"楼层只能为数字\"); return false; }\r\n");
      out.write("            if(rent == null || rent == \"\") { alert(\"租金不能为空\"); return false; }\r\n");
      out.write("            if(isNaN(rent)) { alert(\"租金只能为数字\"); return false; }\r\n");
      out.write("            if(region == null || region == \"\") { alert(\"区域不能为空\"); return false; }\r\n");
      out.write("            if(type1 == null || type1 == \"\") { alert(\"房型不能为空\"); return false; }\r\n");
      out.write("            if(orient == null || orient == \"\") { alert(\"朝向不能为空\"); return false; }\r\n");
      out.write("            if(decoration == null || decoration == \"\") { alert(\"装修不能为空\"); return false; }\r\n");
      out.write("            if(title == null || title == \"\") { alert(\"标题不能为空\"); return false; }\r\n");
      out.write("            if(environ == null || environ == \"\") { alert(\"周围环境不能为空\"); return false; }\r\n");
      out.write("            if(description == null || description == \"\") { alert(\"描述不能为空\"); return false; }\r\n");
      out.write("            if(photo == null || photo == \"\" ) { alert(\"图片不能为空\"); return false; }\r\n");
      out.write("            if(connect == null || connect == \"\") { alert(\"联系人不能为空\"); return false; }\r\n");
      out.write("            if(phone == null || phone == \"\") { alert(\"电话不能为空\"); return false; }\r\n");
      out.write("            if(isNaN(phone)) { alert(\"电话只能为数字\"); return false; }\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"top-toolbar\">\r\n");
      out.write("    <div class=\"w\">\r\n");
      out.write("        <div class=\"bar_left\">\r\n");
      out.write("            <div class=\"index\"><a href=\"/index\">首页</a></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"bar_right\">\r\n");
      out.write("            <div class=\"topbar_login\">\r\n");
      out.write("                ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                ");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"topbar_myMenu\">\r\n");
      out.write("                ");
      if (_jspx_meth_c_005fif_005f4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"main\">\r\n");
      out.write("    <div class=\"post-top-part\">\r\n");
      out.write("        <div class=\"progcontrl\">\r\n");
      out.write("            <div class=\"propbar\" id=\"propbarfirst\">\r\n");
      out.write("                <span>1. 租房\r\n");
      out.write("                    <a href=\"/JSP/choosePost.jsp\" style=\"color:blue;\">重选类别</a>\r\n");
      out.write("                </span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"active\" id=\"propbartwo\">\r\n");
      out.write("                <span>2.填写信息</span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"propbar\" id=\"propbarthree\">\r\n");
      out.write("                <span>3.完成发布</span>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"paytoptips\">\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <div class=\"paytips\">\r\n");
      out.write("            <p>发帖真实性承诺: 为维护真房源环境，请据实发帖。如发现虚假，平台将封禁账号</p>\r\n");
      out.write("            <p>身份真实: 依据真实身份发帖</p>\r\n");
      out.write("            <p>上传实拍图片:上传与房源相关的真实图片</p>\r\n");
      out.write("            <p>房源如实描述:房源真实在租，位置及厅室等信息真实有效</p>\r\n");
      out.write("            <p>房租标价合理:标明实际租住价格，承诺不收取额外费用</p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"post-main\">\r\n");
      out.write("        <form action=\"/house/postHouse\" method=\"post\" enctype=\"multipart/form-data\" onsubmit=\"return check();\">\r\n");
      out.write("            <div class=\"block-wrap\">\r\n");
      out.write("                <div class=\"block-title\"><h3>房屋信息</h3></div>\r\n");
      out.write("                <div class=\"block-content\">\r\n");
      out.write("                    <div class=\"row-wrap\">\r\n");
      out.write("                        <div class=\"row-title\"><span>租房地址</span></div>\r\n");
      out.write("                        <div class=\"row-content\">\r\n");
      out.write("                            <div class=\"input-text\" style=\"width: 400px\">\r\n");
      out.write("                                <input type=\"text\" name=\"address\" id=\"address\" size=\"63\"></div>\r\n");
      out.write("                            <div class=\"input-tips\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row-wrap\">\r\n");
      out.write("                        <div class=\"row-title\"><span>租房面积</span></div>\r\n");
      out.write("                        <div class=\"row-content\">\r\n");
      out.write("                            <div class=\"input-text\">\r\n");
      out.write("                                <input type=\"text\" name=\"area\" id=\"area\" size=\"7\">\r\n");
      out.write("                                <span>平米</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"input-tips\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row-wrap\">\r\n");
      out.write("                        <div class=\"row-title\"><span>租房楼层</span></div>\r\n");
      out.write("                        <div class=\"row-content\">\r\n");
      out.write("                            <div class=\"input-text\">\r\n");
      out.write("                                <input type=\"text\" name=\"floor\" id=\"floor\" size=\"9\">\r\n");
      out.write("                                <span>楼</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"input-tips\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row-wrap\">\r\n");
      out.write("                        <div class=\"row-title\"><span>租金</span></div>\r\n");
      out.write("                        <div class=\"row-content\">\r\n");
      out.write("                            <div class=\"input-text\">\r\n");
      out.write("                                <input type=\"text\" name=\"rent\" id=\"rent\" size=\"9\">\r\n");
      out.write("                                <span>元</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"input-tips\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row-wrap\">\r\n");
      out.write("                        <div class=\"row-title\"><span>区域</span></div>\r\n");
      out.write("                        <div class=\"row-content\">\r\n");
      out.write("                            <div class=\"input-text\">\r\n");
      out.write("                                <select name=\"region\" id=\"region\" style=\"width: 109px;border-radius: 3px\">\r\n");
      out.write("                                    <option value=\"东湖\">东湖</option>\r\n");
      out.write("                                    <option value=\"西湖\">西湖</option>\r\n");
      out.write("                                    <option value=\"新建区\">新建区</option>\r\n");
      out.write("                                    <option value=\"南昌县\">南昌县</option>\r\n");
      out.write("                                    <option value=\"湾里\">湾里</option>\r\n");
      out.write("                                    <option value=\"青山湖区\">青山湖区</option>\r\n");
      out.write("                                    <option value=\"红谷滩新区\">红谷滩新区</option>\r\n");
      out.write("                                    <option value=\"高新区\">高新区</option>\r\n");
      out.write("                                    <option value=\"昌北经济开发区\">昌北经济开发区</option>\r\n");
      out.write("                                    <option value=\"象湖\">象湖</option>\r\n");
      out.write("                                    <option value=\"南昌周边\">南昌周边</option>\r\n");
      out.write("                                </select>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"input-tips\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row-wrap\">\r\n");
      out.write("                        <div class=\"row-title\"><span>房型</span></div>\r\n");
      out.write("                        <div class=\"row-content\">\r\n");
      out.write("                            <div class=\"input-text\">\r\n");
      out.write("                                <input type=\"text\" name=\"type1\" id=\"type1\" value=\"0\" size=\"9\">\r\n");
      out.write("                                <span>室</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"input-text\">\r\n");
      out.write("                                <input type=\"text\" name=\"type2\" value=\"0\" size=\"9\">厅\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"input-text\">\r\n");
      out.write("                                <input type=\"text\" name=\"type3\" value=\"0\" size=\"9\">卫\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"input-tips\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"row-title\"><span>&nbsp;</span></div>\r\n");
      out.write("                        <div class=\"row-content\">\r\n");
      out.write("                            <div class=\"input-text\">\r\n");
      out.write("                                <input type=\"text\" name=\"type4\" value=\"0\" size=\"9\">厨\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"input-text\" style=\"width: 120px\">\r\n");
      out.write("                                <input type=\"text\" name=\"type5\" value=\"0\" size=\"9\">阳台\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"input-tips\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row-wrap\">\r\n");
      out.write("                        <div class=\"row-title\"><span>租房朝向</span></div>\r\n");
      out.write("                        <div class=\"row-content\">\r\n");
      out.write("                            <div class=\"input-text\">\r\n");
      out.write("                                <select name=\"orient\" id=\"orient\" style=\"width: 109px;border-radius: 3px\">\r\n");
      out.write("                                    <option value=\"北\">北</option>\r\n");
      out.write("                                    <option value=\"南\">南</option>\r\n");
      out.write("                                    <option value=\"西\">西</option>\r\n");
      out.write("                                    <option value=\"东\">东</option>\r\n");
      out.write("                                    <option value=\"东北\">东北</option>\r\n");
      out.write("                                    <option value=\"西北\">西北</option>\r\n");
      out.write("                                    <option value=\"东南\">东南</option>\r\n");
      out.write("                                    <option value=\"西南\">西南</option>\r\n");
      out.write("                                </select>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"input-tips\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row-wrap\">\r\n");
      out.write("                        <div class=\"row-title\"><span>装修情况</span></div>\r\n");
      out.write("                        <div class=\"row-content\">\r\n");
      out.write("                            <div class=\"input-text\">\r\n");
      out.write("                                <select name=\"decoration\" id=\"decoration\" style=\"width: 109px;border-radius: 3px\">\r\n");
      out.write("                                    <option value=\"毛胚\">毛胚</option>\r\n");
      out.write("                                    <option value=\"简单装修\">简单装修</option>\r\n");
      out.write("                                    <option value=\"中等装修\">中等装修</option>\r\n");
      out.write("                                    <option value=\"精品装修\">精品装修</option>\r\n");
      out.write("                                    <option value=\"豪华装修\">豪华装修</option>\r\n");
      out.write("                                </select>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"input-tips\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"block-wrap\">\r\n");
      out.write("                <div class=\"block-title\"><h3>发布信息</h3></div>\r\n");
      out.write("                <div class=\"block-content\">\r\n");
      out.write("                    <div class=\"row-wrap\">\r\n");
      out.write("                        <div class=\"row-title\"><span>标题</span></div>\r\n");
      out.write("                        <div class=\"row-content\">\r\n");
      out.write("                            <div class=\"input-text\" style=\"width: 400px\">\r\n");
      out.write("                                <input type=\"text\" id=\"title\" name=\"title\" size=\"63\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"input-tips\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row-wrap\">\r\n");
      out.write("                        <div class=\"row-title\"><span>周围环境</span></div>\r\n");
      out.write("                        <div class=\"row-content\">\r\n");
      out.write("                            <div class=\"input-text\" style=\"width: 500px;height: 80px\">\r\n");
      out.write("                                <textarea type=\"text\" name=\"environ\" id=\"environ\" style=\"height: 78px;\"></textarea>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"input-tips\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row-wrap\">\r\n");
      out.write("                        <div class=\"row-title\"><span>详细描述</span></div>\r\n");
      out.write("                        <div class=\"row-content\">\r\n");
      out.write("                            <div class=\"input-text\"  style=\"width: 500px;height: 150px\">\r\n");
      out.write("                                <textarea type=\"text\" name=\"description\" id=\"description\" style=\"height: 148px;\"></textarea>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"input-tips\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row-wrap\">\r\n");
      out.write("                        <div class=\"row-title\"><span>上传照片</span></div>\r\n");
      out.write("                        <div class=\"row-content\">\r\n");
      out.write("                            <div class=\"input-text\" style=\"border: none\">\r\n");
      out.write("                                <input type=\"file\" name=\"photo\" id=\"photo\" multiple=\"multiple\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"input-tips\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"block-wrap\">\r\n");
      out.write("                <div class=\"block-title\"><h3>联系信息</h3></div>\r\n");
      out.write("                <div class=\"block-content\">\r\n");
      out.write("                    <div class=\"row-wrap\">\r\n");
      out.write("                        <div class=\"row-title\"><span>联系人</span></div>\r\n");
      out.write("                        <div class=\"row-content\">\r\n");
      out.write("                            <div class=\"input-text\">\r\n");
      out.write("                                <input type=\"text\" name=\"connect\" id=\"connect\" size=\"9\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"input-tips\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row-wrap\">\r\n");
      out.write("                        <div class=\"row-title\"><span>联系电话</span></div>\r\n");
      out.write("                        <div class=\"row-content\">\r\n");
      out.write("                            <div class=\"input-text\"  style=\"width: 150px\">\r\n");
      out.write("                                <input type=\"text\" name=\"phone\" id=\"phone\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"input-tips\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row-wrap\">\r\n");
      out.write("                        <div class=\"row-title\">&nbsp;</div>\r\n");
      out.write("                        <div class=\"row-content\">\r\n");
      out.write("                            <div class=\"input-text submit\"  style=\"width: 150px;background-color: #ed6d06;\">\r\n");
      out.write("                                <input type=\"submit\" value=\"发布\" class=\"submit_bt\" name=\"\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"input-tips\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /JSP/house/postHouse.jsp(56,16) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty my}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                    <a href=\"/login.jsp\">登录</a>\r\n");
          out.write("                    <span class=\"gap\">|</span>\r\n");
          out.write("                    <a href=\"/register.jsp\">注册</a>\r\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /JSP/house/postHouse.jsp(61,16) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty my}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                    <div>欢迎您&nbsp;");
          if (_jspx_meth_c_005fif_005f2(_jspx_th_c_005fif_005f1, _jspx_page_context))
            return true;
          if (_jspx_meth_c_005fif_005f3(_jspx_th_c_005fif_005f1, _jspx_page_context))
            return true;
          out.write(":&nbsp;");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${my.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("&emsp;|&emsp;\r\n");
          out.write("                        <a href=\"/Logout\" style=\"float: right\"><div class=\"top_font\" >注销</div></a>\r\n");
          out.write("                    </div>\r\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f2_reused = false;
    try {
      _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
      // /JSP/house/postHouse.jsp(62,34) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${my.type==2}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
      if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('广');
          out.write('告');
          out.write('方');
          int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      _jspx_th_c_005fif_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f2_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f3_reused = false;
    try {
      _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
      // /JSP/house/postHouse.jsp(62,71) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${my.type==3}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
      if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('管');
          out.write('理');
          out.write('员');
          int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      _jspx_th_c_005fif_005f3_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f3, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f3_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f4_reused = false;
    try {
      _jspx_th_c_005fif_005f4.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f4.setParent(null);
      // /JSP/house/postHouse.jsp(68,16) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty my}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f4 = _jspx_th_c_005fif_005f4.doStartTag();
      if (_jspx_eval_c_005fif_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                    <a href=\"/houseListByPage\">个人中心</a>\r\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
      _jspx_th_c_005fif_005f4_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f4, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f4_reused);
    }
    return false;
  }
}
