/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.31
 * Generated at: 2020-04-17 03:31:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/fragment/indexTOP.jsp", Long.valueOf(1587094253512L));
    _jspx_dependants.put("/fragment/indexBOTTOM.jsp", Long.valueOf(1586701463000L));
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
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>index</title>\n");
      out.write("<script src=\"http://code.jquery.com/jquery-1.12.4.min.js\"></script>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("body {\n");
      out.write("\tbackground-color:#E8E8E8;\n");
      out.write("\tmargin: 0px;\n");
      out.write("\tpadding: 0px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#content {\n");
      out.write("\tbackground-image: url(img/indexbackground.jpg);\n");
      out.write("\tbackground-repeat: no-repeat;\n");
      out.write("\tbackground-size: cover;\n");
      out.write("\theight: 1000px;\n");
      out.write("\tmargin-top: -21px;\n");
      out.write("\tmargin-bottom: 0px;\n");
      out.write("\ttext-align: center;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>indexTop</title>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\tpadding: 0px;\r\n");
      out.write("\tbackground-color: #E8E8E8;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".top1 {\r\n");
      out.write("\tmargin: 0px 20% 0px 20%;\r\n");
      out.write("\toverflow: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".fixed_top1 {\r\n");
      out.write("\t/* fixed 固定住位置, top:0 代表固定在最上面 */\r\n");
      out.write("\tposition: fixed;\r\n");
      out.write("\ttop: 0;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#containTop {\r\n");
      out.write("\tbackground-color: #272727;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#m1 {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#m2 {\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table tr td {\r\n");
      out.write("\tpadding-right: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table tr td a {\r\n");
      out.write("\tcolor: #F0F0F0;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("table tr td a:hover {\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"containTop\">\r\n");
      out.write("\t\t<div id=\"header\" class=\"top1\">\r\n");
      out.write("\t\t\t<table id=\"m1\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><a href=\"index.jsp\"><img src=\"img/index.jpg\" /></a></td>\r\n");
      out.write("\t\t\t\t<td><a href=\"\">eyeMac</a></td>\r\n");
      out.write("\t\t\t\t<td><a href=\"\">eyePad</a></td>\r\n");
      out.write("\t\t\t\t<td><a href=\"\">eyePhone</a></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<table id=\"m2\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><a href=\"#\"><img src=\"img/query.jpg\" onclick=\"query()\" /></a></td>\r\n");
      out.write("\t\t\t\t<td><a href=\"\">支援</a></td>\r\n");
      out.write("\t\t\t\t<td><a href=\"loginSystem.jsp\">登入</a></td>\r\n");
      out.write("\t\t\t\t<td><a href=\"\">購物車</a></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t//offset() ：讀取指定元素在頁面(文件)上的相對坐標，\r\n");
      out.write("\t\t//回傳含有top及left屬性的物件            \r\n");
      out.write("\r\n");
      out.write("\t\tlet navbarPosition = $('#containTop').offset().top;\r\n");
      out.write("\t\t$(window).scroll(function() {\r\n");
      out.write("\t\t\tlet scrollTop = $(this).scrollTop();\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (scrollTop > navbarPosition) {\r\n");
      out.write("\t\t\t\t$('#containTop').addClass(\"fixed_top1\")\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t$(\"#containTop\").removeClass(\"fixed_top1\")\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t})\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<div id=\"content\">\n");
      out.write("\t\t<h1>這是起始頁</h1>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>indexBOTTOM</title>\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write("\t\n");
      out.write("\t#bottom{\n");
      out.write("\t\tbackground-color:#E8E8E8;\n");
      out.write("\t\ttext-align: center;\n");
      out.write("\t\tmargin-top: -17px;\n");
      out.write("\t\t\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div id=\"bottom\">\n");
      out.write("\t\t<p>© 2020 台灣sampple 版權所有。</p>\n");
      out.write("\n");
      out.write("\t\t<p>使用Internet Explorer 11、Chrome、Firefox及較新版本之瀏覽器去瀏覽本網站的效果最佳。</p>\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("\t\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
}
