/*
 * JSP generated by Resin-3.1.8 (built Mon, 17 Nov 2008 12:15:21 PST)
 */

package _jsp._bms;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _servicelist__jsp extends com.caucho.jsp.JavaPage
{
  private static final java.util.HashMap<String,java.lang.reflect.Method> _jsp_functionMap = new java.util.HashMap<String,java.lang.reflect.Method>();
  private boolean _caucho_isDead;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    javax.servlet.http.HttpSession session = request.getSession(true);
    com.caucho.server.webapp.WebApp _jsp_application = _caucho_getApplication();
    javax.servlet.ServletContext application = _jsp_application;
    com.caucho.jsp.PageContextImpl pageContext = _jsp_application.getJspApplicationContext().allocatePageContext(this, _jsp_application, request, response, null, session, 8192, true, false);
    javax.servlet.jsp.PageContext _jsp_parentContext = pageContext;
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    final javax.el.ELContext _jsp_env = pageContext.getELContext();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    response.setContentType("text/html; charset=utf-8");
    request.setCharacterEncoding("UTF-8");
    com.caucho.jsp.IteratorLoopSupportTag _jsp_loop_0 = null;
    comm.page.PageTag _jsp_PageTag_0 = null;
    try {
      out.write(_jsp_string0, 0, _jsp_string0.length);
      out.print((request.getContextPath()));
      out.write(_jsp_string1, 0, _jsp_string1.length);
      out.print((request.getContextPath()));
      out.write(_jsp_string2, 0, _jsp_string2.length);
      out.print((request.getContextPath()));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print((request.getContextPath()));
      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print((request.getContextPath()));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print((request.getContextPath()));
      out.write(_jsp_string6, 0, _jsp_string6.length);
      if (_caucho_expr_0.evalBoolean(_jsp_env)) {
        out.write(_jsp_string7, 0, _jsp_string7.length);
        if (_jsp_loop_0 == null)
          _jsp_loop_0 = new com.caucho.jsp.IteratorLoopSupportTag();
        java.lang.Object _jsp_items_1 = _caucho_expr_1.evalObject(_jsp_env);
        java.util.Iterator _jsp_iter_1 = com.caucho.jstl.rt.CoreForEachTag.getIterator(_jsp_items_1);
        _jsp_loop_0.init(0, Integer.MAX_VALUE, 1);
        Object _jsp_status_1 = pageContext.putAttribute("index", _jsp_loop_0);
        Object _jsp_oldVar_1 = pageContext.getAttribute("obj");
        while (_jsp_iter_1.hasNext()) {
          Object _jsp_i_1 = _jsp_iter_1.next();
          pageContext.setAttribute("obj", _jsp_i_1);
          _jsp_loop_0.setCurrent(_jsp_i_1, _jsp_iter_1.hasNext());
          out.write(_jsp_string8, 0, _jsp_string8.length);
          _caucho_expr_2.print(out, _jsp_env, false);
          out.write(_jsp_string9, 0, _jsp_string9.length);
          _caucho_expr_3.print(out, _jsp_env, false);
          out.write(_jsp_string10, 0, _jsp_string10.length);
          _caucho_expr_4.print(out, _jsp_env, false);
          out.write(_jsp_string11, 0, _jsp_string11.length);
          _caucho_expr_4.print(out, _jsp_env, false);
          out.write(_jsp_string12, 0, _jsp_string12.length);
        }
        pageContext.pageSetOrRemove("obj", _jsp_oldVar_1);
        pageContext.removeAttribute("index");
        out.write(_jsp_string13, 0, _jsp_string13.length);
      }
      out.write(_jsp_string14, 0, _jsp_string14.length);
      if (_jsp_PageTag_0 == null) {
        _jsp_PageTag_0 = new comm.page.PageTag();
        _jsp_PageTag_0.setPageContext(pageContext);
        _jsp_PageTag_0.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_PageTag_0.setName("page");
        _jsp_PageTag_0.setAction("service.do?method=list");
        _jsp_PageTag_0.setFormName("serviceListForm");
      }

      _jsp_PageTag_0.doStartTag();
      out.write(_jsp_string15, 0, _jsp_string15.length);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      _jsp_application.getJspApplicationContext().freePageContext(pageContext);
    }
  }

  private java.util.ArrayList _caucho_depends = new java.util.ArrayList();

  public java.util.ArrayList _caucho_getDependList()
  {
    return _caucho_depends;
  }

  public void _caucho_addDepend(com.caucho.vfs.PersistentDependency depend)
  {
    super._caucho_addDepend(depend);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  public boolean _caucho_isModified()
  {
    if (_caucho_isDead)
      return true;
    if (com.caucho.server.util.CauchoSystem.getVersionId() != 1886798272571451039L)
      return true;
    for (int i = _caucho_depends.size() - 1; i >= 0; i--) {
      com.caucho.vfs.Dependency depend;
      depend = (com.caucho.vfs.Dependency) _caucho_depends.get(i);
      if (depend.isModified())
        return true;
    }
    return false;
  }

  public long _caucho_lastModified()
  {
    return 0;
  }

  public java.util.HashMap<String,java.lang.reflect.Method> _caucho_getFunctionMap()
  {
    return _jsp_functionMap;
  }

  public void init(ServletConfig config)
    throws ServletException
  {
    com.caucho.server.webapp.WebApp webApp
      = (com.caucho.server.webapp.WebApp) config.getServletContext();
    super.init(config);
    com.caucho.jsp.TaglibManager manager = webApp.getJspApplicationContext().getTaglibManager();
    manager.addTaglibFunctions(_jsp_functionMap, "c", "http://java.sun.com/jstl/core");
    manager.addTaglibFunctions(_jsp_functionMap, "fmt", "http://java.sun.com/jstl/fmt");
    manager.addTaglibFunctions(_jsp_functionMap, "fn", "http://java.sun.com/jstl/functions");
    manager.addTaglibFunctions(_jsp_functionMap, "mytld", "/tld/MyTld");
    com.caucho.jsp.PageContextImpl pageContext = new com.caucho.jsp.PageContextImpl(webApp, this);
    _caucho_expr_0 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${list!=null&&!empty list}");
    _caucho_expr_1 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${list}");
    _caucho_expr_2 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.name}");
    _caucho_expr_3 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.pic}");
    _caucho_expr_4 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.id}");
  }

  public void destroy()
  {
      _caucho_isDead = true;
      super.destroy();
  }

  public void init(com.caucho.vfs.Path appDir)
    throws javax.servlet.ServletException
  {
    com.caucho.vfs.Path resinHome = com.caucho.server.util.CauchoSystem.getResinHome();
    com.caucho.vfs.MergePath mergePath = new com.caucho.vfs.MergePath();
    mergePath.addMergePath(appDir);
    mergePath.addMergePath(resinHome);
    com.caucho.loader.DynamicClassLoader loader;
    loader = (com.caucho.loader.DynamicClassLoader) getClass().getClassLoader();
    String resourcePath = loader.getResourcePathSpecificFirst();
    mergePath.addClassPath(resourcePath);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("bms/serviceList.jsp"), -7307706236375992213L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("WEB-INF/tld/MyTld.tld"), -5717761395423970168L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, new com.caucho.make.ClassDependency(comm.page.PageTag.class, 4257593798314990154L));
  }

  static {
    try {
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  private static com.caucho.el.Expr _caucho_expr_0;
  private static com.caucho.el.Expr _caucho_expr_1;
  private static com.caucho.el.Expr _caucho_expr_2;
  private static com.caucho.el.Expr _caucho_expr_3;
  private static com.caucho.el.Expr _caucho_expr_4;

  private final static char []_jsp_string15;
  private final static char []_jsp_string10;
  private final static char []_jsp_string8;
  private final static char []_jsp_string12;
  private final static char []_jsp_string4;
  private final static char []_jsp_string6;
  private final static char []_jsp_string11;
  private final static char []_jsp_string9;
  private final static char []_jsp_string13;
  private final static char []_jsp_string3;
  private final static char []_jsp_string14;
  private final static char []_jsp_string1;
  private final static char []_jsp_string5;
  private final static char []_jsp_string2;
  private final static char []_jsp_string7;
  private final static char []_jsp_string0;
  static {
    _jsp_string15 = "</div>\r\n  </div>\r\n</div>\r\n</body>\r\n</html>\r\n".toCharArray();
    _jsp_string10 = "\" height=\"40\" width=\"50\"/></td>\r\n      <td align=\"center\">\r\n      	<a href=\"service.do?method=view&id=".toCharArray();
    _jsp_string8 = "      \r\n    <tr>\r\n      <td class=\"first-cell\" >".toCharArray();
    _jsp_string12 = ");return false;\">\u5220\u9664</a> </td>\r\n      </tr>\r\n	      ".toCharArray();
    _jsp_string4 = "/js/li.js\" type=\"text/javascript\"></script>\r\n<script src=\"".toCharArray();
    _jsp_string6 = "/images/gwbms_03.gif\" width=\"16\" height=\"16\" border=\"0\" align=\"absmiddle\" />\u6dfb\u52a0\u670d\u52a1</a></div>\r\n  <div class=\"clear\"></div>\r\n</div>\r\n<div class=\"gwbmscon\">\r\n\r\n  <table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"bmstab\" id=\"list-table\">\r\n    <tr>\r\n      <th>\u540d\u79f0</th>\r\n      <th>\u56fe\u7247</th>\r\n      <th align=\"center\">\u64cd\u4f5c</th>\r\n      </tr>\r\n    ".toCharArray();
    _jsp_string11 = "\">\u7f16\u8f91</a> | <a href=\"#\" onclick=\"deleteRule(".toCharArray();
    _jsp_string9 = "</td>\r\n      <td><img src=\"".toCharArray();
    _jsp_string13 = "\r\n    ".toCharArray();
    _jsp_string3 = "/js/jquery-1.4.2g.js\" type=\"text/javascript\"></script>\r\n<script src=\"".toCharArray();
    _jsp_string14 = "\r\n  </table>\r\n  <div align=\"right\">".toCharArray();
    _jsp_string1 = "/style/bms.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n<link href=\"".toCharArray();
    _jsp_string5 = "/js/bmsPage.js\" type=\"text/javascript\"></script>\r\n<script>\r\n	function deleteRule(id){\r\n	 if (confirm(\"\u786e\u5b9e\u5220\u9664\u5417\uff1f\u64cd\u4f5c\u4e0d\u53ef\u6062\u590d\uff01\")){\r\n		location.href=\"service.do?method=delete&id=\"+id;\r\n	 }\r\n	 return false;\r\n	}\r\n	\r\n</script>\r\n</head>\r\n\r\n<body>\r\n<div class=\"pagecoantiner\">\r\n<div class=\"bmstop\">\r\n  <div class=\"bmstitle\">\u4fdd\u969c\u670d\u52a1\u7ba1\u7406 </div>\r\n  <div class=\"bmsadd\"><a href=\"service.jsp\"><img src=\"".toCharArray();
    _jsp_string2 = "/style/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n<script src=\"".toCharArray();
    _jsp_string7 = "\r\n      ".toCharArray();
    _jsp_string0 = "\r\n\r\n\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n<title></title>\r\n<link href=\"".toCharArray();
  }
}
