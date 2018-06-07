/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.31
 * Generated at: 2018-06-04 10:58:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bean.BorderInfos;
import java.util.List;
import bean.BoradDAO;

public final class BoardSearhList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("bean.BorderInfos");
    _jspx_imports_classes.add("bean.BoradDAO");
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t");

		
	    int pages = Integer.parseInt(request.getParameter("pages"));
		
		BoradDAO bdao = new BoradDAO();

		String searchText = (String) request.getParameter("text");
	
      out.write("\r\n");
      out.write("\t<table border=\"1\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th colspan=\"5\" width=600>검색된 게시판</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr height=50>\r\n");
      out.write("\t\t\t<td width=25>index</td>\r\n");
      out.write("\t\t\t<td width=40>제목</td>\r\n");
      out.write("\t\t\t<td width=40>작성자</td>\r\n");
      out.write("\t\t\t<td width=40>작성일</td>\r\n");
      out.write("\t\t\t<td width=40>조회</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");

		int pageSize = 5;
        int max = pageSize * pages;
        int min = max - pageSize ;
		List<BorderInfos> list = bdao.searchBoardCut(searchText, max, min);
		for(int i=0;i<list.size();i++){
		
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>");
      out.print(list.get(i).getSeq());
      out.write("</td>\r\n");
      out.write("\t\t\t<td><a href=\"borde/list.jsp?list.get(i).getSeq()=");
      out.print(list.get(i).getSeq());
      out.write('"');
      out.write('>');
      out.print(list.get(i).getTitle());
      out.write("</a></td>\r\n");
      out.write("\t\t\t<td>");
      out.print(list.get(i).getWriter());
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(list.get(i).getWritedate());
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(list.get(i).getViewcount());
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write(" \t\t  <tr><td style=\"align-content:center;\" align=\"center\"> ");
      out.print(bdao.getSearchPageNavi(pages, searchText));
      out.write(" </td></tr>\r\n");
      out.write(" \t\t  <tr><td><button id=\"back\">이전</button></td></tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t<script>\r\n");
      out.write("\t   document.getElementById(\"back\").onclick = function(){\r\n");
      out.write("\t        location.href=\"BorderList.jsp?currentPage=1\";\r\n");
      out.write("\t    }\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
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
