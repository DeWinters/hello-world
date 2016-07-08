package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mainPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>MainPage</title>\r\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"styles.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <div id=\"frame\">\r\n");
      out.write("        <h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${greeting}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h1>\r\n");
      out.write("        <form action=\"/confirmation\" method=\"post\">\r\n");
      out.write("            First name:<br>\r\n");
      out.write("            <input type=\"text\" name=\"username\" >\r\n");
      out.write("            <br>\r\n");
      out.write("            Last name:<br>\r\n");
      out.write("            <input type=\"text\" name=\"password\" >\r\n");
      out.write("            <br><br>\r\n");
      out.write("            <input type=\"submit\" value=\"Submit\">\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("        <form action=\"/addIt\" method=\"post\">\r\n");
      out.write("            Choose a number\r\n");
      out.write("            <input type=\"text\" name=\"cell1\">\r\n");
      out.write("            <br>\r\n");
      out.write("            Choose another\r\n");
      out.write("            <input type=\"text\" name=\"cell2\">\r\n");
      out.write("            <br>\r\n");
      out.write("            <input type=\"submit\" value=\"Add them\">\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("        <form action=\"/newPage\" method=\"post\">\r\n");
      out.write("            <br>\r\n");
      out.write("            <input type=\"submit\" value=\"Skip\">\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
