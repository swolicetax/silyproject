/*
 * JSP generated by Resin-3.1.8 (built Mon, 17 Nov 2008 12:15:21 PST)
 */

package _jsp._bms;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _crawlview__jsp extends com.caucho.jsp.JavaPage
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
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jsp_FormatDateTag_0 = null;
    try {
      out.write(_jsp_string0, 0, _jsp_string0.length);
      if (_caucho_expr_0.evalBoolean(_jsp_env)) {
        out.write(_jsp_string1, 0, _jsp_string1.length);
        if (_jsp_loop_0 == null)
          _jsp_loop_0 = new com.caucho.jsp.IteratorLoopSupportTag();
        _jsp_loop_0.setParent((javax.servlet.jsp.tagext.Tag) null);
        java.lang.Object _jsp_items_1 = _caucho_expr_1.evalObject(_jsp_env);
        java.util.Iterator _jsp_iter_1 = com.caucho.jstl.rt.CoreForEachTag.getIterator(_jsp_items_1);
        _jsp_loop_0.init(0, Integer.MAX_VALUE, 1);
        Object _jsp_status_1 = pageContext.putAttribute("index", _jsp_loop_0);
        Object _jsp_oldVar_1 = pageContext.getAttribute("obj");
        while (_jsp_iter_1.hasNext()) {
          Object _jsp_i_1 = _jsp_iter_1.next();
          pageContext.setAttribute("obj", _jsp_i_1);
          _jsp_loop_0.setCurrent(_jsp_i_1, _jsp_iter_1.hasNext());
          out.write(_jsp_string2, 0, _jsp_string2.length);
          _caucho_expr_2.print(out, _jsp_env, false);
          out.write(_jsp_string3, 0, _jsp_string3.length);
          _caucho_expr_3.print(out, _jsp_env, false);
          out.write(_jsp_string4, 0, _jsp_string4.length);
          _caucho_expr_4.print(out, _jsp_env, false);
          out.write(_jsp_string5, 0, _jsp_string5.length);
          _caucho_expr_5.print(out, _jsp_env, false);
          out.write(_jsp_string6, 0, _jsp_string6.length);
          if (_jsp_FormatDateTag_0 == null) {
            _jsp_FormatDateTag_0 = new org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag();
            _jsp_FormatDateTag_0.setPageContext(pageContext);
            _jsp_FormatDateTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jsp_loop_0);
            _jsp_FormatDateTag_0.setPattern("yyyy-MM-dd HH:mm:ss");
          }

          _jsp_FormatDateTag_0.setValue((java.util.Date) _caucho_expr_6.evalObject(_jsp_env));
          _jsp_FormatDateTag_0.doEndTag();
          out.write(_jsp_string3, 0, _jsp_string3.length);
          if (_jsp_FormatDateTag_0 == null) {
            _jsp_FormatDateTag_0 = new org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag();
            _jsp_FormatDateTag_0.setPageContext(pageContext);
            _jsp_FormatDateTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jsp_loop_0);
            _jsp_FormatDateTag_0.setPattern("yyyy-MM-dd HH:mm:ss");
          }

          _jsp_FormatDateTag_0.setValue((java.util.Date) _caucho_expr_7.evalObject(_jsp_env));
          _jsp_FormatDateTag_0.doEndTag();
          out.write(_jsp_string3, 0, _jsp_string3.length);
          _caucho_expr_8.print(out, _jsp_env, false);
          out.write(_jsp_string3, 0, _jsp_string3.length);
          _caucho_expr_9.print(out, _jsp_env, false);
          out.write(_jsp_string3, 0, _jsp_string3.length);
          _caucho_expr_10.print(out, _jsp_env, false);
          out.write(_jsp_string3, 0, _jsp_string3.length);
          _caucho_expr_11.print(out, _jsp_env, false);
          out.write(_jsp_string3, 0, _jsp_string3.length);
          _caucho_expr_12.print(out, _jsp_env, false);
          out.write(_jsp_string3, 0, _jsp_string3.length);
          _caucho_expr_13.print(out, _jsp_env, false);
          out.write(_jsp_string3, 0, _jsp_string3.length);
          _caucho_expr_14.print(out, _jsp_env, false);
          out.write(_jsp_string3, 0, _jsp_string3.length);
          _caucho_expr_15.print(out, _jsp_env, false);
          out.write(_jsp_string7, 0, _jsp_string7.length);
          _caucho_expr_16.print(out, _jsp_env, false);
          out.write(_jsp_string3, 0, _jsp_string3.length);
          _caucho_expr_17.print(out, _jsp_env, false);
          out.write(_jsp_string4, 0, _jsp_string4.length);
          _caucho_expr_18.print(out, _jsp_env, false);
          out.write(_jsp_string3, 0, _jsp_string3.length);
          _caucho_expr_19.print(out, _jsp_env, false);
          out.write(_jsp_string3, 0, _jsp_string3.length);
          _caucho_expr_20.print(out, _jsp_env, false);
          out.write(_jsp_string3, 0, _jsp_string3.length);
          _caucho_expr_21.print(out, _jsp_env, false);
          out.write(_jsp_string3, 0, _jsp_string3.length);
          _caucho_expr_22.print(out, _jsp_env, false);
          out.write(_jsp_string3, 0, _jsp_string3.length);
          _caucho_expr_23.print(out, _jsp_env, false);
          out.write(_jsp_string8, 0, _jsp_string8.length);
        }
        pageContext.pageSetOrRemove("obj", _jsp_oldVar_1);
        pageContext.removeAttribute("index");
        out.write(_jsp_string9, 0, _jsp_string9.length);
      }
      out.write(_jsp_string10, 0, _jsp_string10.length);
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
    _caucho_expr_2 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.createTime}");
    _caucho_expr_3 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.editTime}");
    _caucho_expr_4 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.category}");
    _caucho_expr_5 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.picUrl}");
    _caucho_expr_6 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.startTime}");
    _caucho_expr_7 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.endTime}");
    _caucho_expr_8 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.orgPrice}");
    _caucho_expr_9 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.sellPrice}");
    _caucho_expr_10 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.discount}");
    _caucho_expr_11 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.title}");
    _caucho_expr_12 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.siteId}");
    _caucho_expr_13 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.detail}");
    _caucho_expr_14 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.address}");
    _caucho_expr_15 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.userCount}");
    _caucho_expr_16 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.viewFlag}");
    _caucho_expr_17 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.deleteFlag}");
    _caucho_expr_18 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.phone}");
    _caucho_expr_19 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.webSite}");
    _caucho_expr_20 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.trafficInfo}");
    _caucho_expr_21 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.biefe}");
    _caucho_expr_22 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.latlon}");
    _caucho_expr_23 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.area}");
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("bms/crawlView.jsp"), -7376784972425010181L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("WEB-INF/tld/fmt.tld"), 308338869353100094L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, new com.caucho.make.ClassDependency(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class, 7844905413159918656L));
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
  private static com.caucho.el.Expr _caucho_expr_5;
  private static com.caucho.el.Expr _caucho_expr_6;
  private static com.caucho.el.Expr _caucho_expr_7;
  private static com.caucho.el.Expr _caucho_expr_8;
  private static com.caucho.el.Expr _caucho_expr_9;
  private static com.caucho.el.Expr _caucho_expr_10;
  private static com.caucho.el.Expr _caucho_expr_11;
  private static com.caucho.el.Expr _caucho_expr_12;
  private static com.caucho.el.Expr _caucho_expr_13;
  private static com.caucho.el.Expr _caucho_expr_14;
  private static com.caucho.el.Expr _caucho_expr_15;
  private static com.caucho.el.Expr _caucho_expr_16;
  private static com.caucho.el.Expr _caucho_expr_17;
  private static com.caucho.el.Expr _caucho_expr_18;
  private static com.caucho.el.Expr _caucho_expr_19;
  private static com.caucho.el.Expr _caucho_expr_20;
  private static com.caucho.el.Expr _caucho_expr_21;
  private static com.caucho.el.Expr _caucho_expr_22;
  private static com.caucho.el.Expr _caucho_expr_23;

  private final static char []_jsp_string6;
  private final static char []_jsp_string3;
  private final static char []_jsp_string0;
  private final static char []_jsp_string7;
  private final static char []_jsp_string8;
  private final static char []_jsp_string5;
  private final static char []_jsp_string9;
  private final static char []_jsp_string10;
  private final static char []_jsp_string4;
  private final static char []_jsp_string2;
  private final static char []_jsp_string1;
  static {
    _jsp_string6 = "\"/></td>\r\n<td>".toCharArray();
    _jsp_string3 = "</td>\r\n<td>".toCharArray();
    _jsp_string0 = "\r\n\r\n\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n<title></title>\r\n</head>\r\n\r\n<body>\r\n\r\n\r\n  <table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"bmstab\" id=\"list-table\">\r\n    <tr>\r\n<!--th>\u521b\u5efa\u65f6\u95f4</th>\r\n<th>\u7f16\u8f91\u65f6\u95f4</th-->\r\n<th>\u56e2\u8d2d\u7c7b\u578b</th>\r\n<th>\u56fe\u7247</th>\r\n<th>\u5f00\u59cb\u65f6\u95f4</th>\r\n<th>\u7ed3\u675f\u65f6\u95f4</th>\r\n<th>\u539f\u4ef7\uff0c\u5206</th>\r\n<th>\u552e\u4ef7\uff0c\u5206</th>\r\n<th>\u6298\u6263,\u6298\u6263*100</th>\r\n<th>\u6807\u9898</th>\r\n<th>\u7ad9\u70b9ID</th>\r\n<th>\u8be6\u7ec6\u4fe1\u606f</th>\r\n<th>\u5546\u5bb6\u5730\u5740</th>\r\n<th>\u8d2d\u4e70\u4eba\u6570</th>\r\n<!--th>\u662f\u5426\u663e\u793a</th>\r\n<th>\u5220\u9664\u6807\u8bc6</th-->\r\n<th>\u5546\u5bb6\u7535\u8bdd</th>\r\n<th>\u5546\u5bb6\u7f51\u5740</th>\r\n<th>\u516c\u4ea4\u4fe1\u606f</th>\r\n<th>\u7b80\u4ecb</th>\r\n<th>\u7ecf\u7eac\u5ea6</th>\r\n<th>\u5730\u533a</th>\r\n      </tr>\r\n    ".toCharArray();
    _jsp_string7 = "</td>\r\n<!--td>".toCharArray();
    _jsp_string8 = "</td>\r\n      </tr>\r\n	      ".toCharArray();
    _jsp_string5 = "</td>\r\n<td><img src=\"".toCharArray();
    _jsp_string9 = "\r\n    ".toCharArray();
    _jsp_string10 = "\r\n  </table>\r\n</body>\r\n</html>\r\n".toCharArray();
    _jsp_string4 = "</td-->\r\n<td>".toCharArray();
    _jsp_string2 = "      \r\n    <tr valign=\"top\">\r\n      <!--td class=\"first-cell\" >".toCharArray();
    _jsp_string1 = "\r\n      ".toCharArray();
  }
}