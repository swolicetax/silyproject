/*
 * JSP generated by Resin-3.1.8 (built Mon, 17 Nov 2008 12:15:21 PST)
 */

package _jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _commentlist__jsp extends com.caucho.jsp.JavaPage
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
    dms.tag.UserTag _jsp_UserTag_1 = null;
    comm.page.PageTag _jsp_PageTag_2 = null;
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
          if (_jsp_FormatDateTag_0 == null) {
            _jsp_FormatDateTag_0 = new org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag();
            _jsp_FormatDateTag_0.setPageContext(pageContext);
            _jsp_FormatDateTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jsp_loop_0);
            _jsp_FormatDateTag_0.setPattern("MM\u6708dd\u65e5 HH\u70b9mm\u5206");
          }

          _jsp_FormatDateTag_0.setValue((java.util.Date) _caucho_expr_3.evalObject(_jsp_env));
          _jsp_FormatDateTag_0.doEndTag();
          out.write(_jsp_string4, 0, _jsp_string4.length);
          _caucho_expr_4.print(out, _jsp_env, false);
          out.write(_jsp_string5, 0, _jsp_string5.length);
          if (_jsp_UserTag_1 == null) {
            _jsp_UserTag_1 = new dms.tag.UserTag();
            _jsp_UserTag_1.setPageContext(pageContext);
            _jsp_UserTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jsp_loop_0);
          }

          _jsp_UserTag_1.setUserId(new java.lang.Long(_caucho_expr_4.evalLong(_jsp_env)));
          _jsp_UserTag_1.doStartTag();
          out.write(_jsp_string6, 0, _jsp_string6.length);
        }
        pageContext.pageSetOrRemove("obj", _jsp_oldVar_1);
        pageContext.removeAttribute("index");
        out.write(_jsp_string7, 0, _jsp_string7.length);
      }
      out.write(_jsp_string8, 0, _jsp_string8.length);
      if (_jsp_PageTag_2 == null) {
        _jsp_PageTag_2 = new comm.page.PageTag();
        _jsp_PageTag_2.setPageContext(pageContext);
        _jsp_PageTag_2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_PageTag_2.setName("page");
        _jsp_PageTag_2.setAction("index.do?method=listComment&type=1");
        _jsp_PageTag_2.setFormName("c1Form");
      }

      _jsp_PageTag_2.doStartTag();
      out.write(_jsp_string9, 0, _jsp_string9.length);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      if (_jsp_FormatDateTag_0 != null)
        _jsp_FormatDateTag_0.release();
      if (_jsp_UserTag_1 != null)
        _jsp_UserTag_1.release();
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
    manager.addTaglibFunctions(_jsp_functionMap, "mytld", "/tld/MyTld");
    com.caucho.jsp.PageContextImpl pageContext = new com.caucho.jsp.PageContextImpl(webApp, this);
    _caucho_expr_0 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${list!=null&&!empty list}");
    _caucho_expr_1 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${list}");
    _caucho_expr_2 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.content}");
    _caucho_expr_3 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.createTime}");
    _caucho_expr_4 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${obj.userId}");
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("commentList.jsp"), 6030053118758540967L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("WEB-INF/tld/fmt.tld"), 308338869353100094L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, new com.caucho.make.ClassDependency(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class, 7844905413159918656L));
    depend = new com.caucho.vfs.Depend(appDir.lookup("WEB-INF/tld/MyTld.tld"), -2192669327613808265L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, new com.caucho.make.ClassDependency(dms.tag.UserTag.class, -4164810695213726271L));
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

  private final static char []_jsp_string9;
  private final static char []_jsp_string5;
  private final static char []_jsp_string3;
  private final static char []_jsp_string6;
  private final static char []_jsp_string8;
  private final static char []_jsp_string7;
  private final static char []_jsp_string2;
  private final static char []_jsp_string0;
  private final static char []_jsp_string4;
  private final static char []_jsp_string1;
  static {
    _jsp_string9 = "\r\n    	</td>\r\n  </tr-->\r\n  </table>".toCharArray();
    _jsp_string5 = "\">".toCharArray();
    _jsp_string3 = "<br/>".toCharArray();
    _jsp_string6 = "</a>\r\n</td></tr>\r\n    ".toCharArray();
    _jsp_string8 = "\r\n    <!--tr>\r\n    	<td>\r\n    		".toCharArray();
    _jsp_string7 = "\r\n    ".toCharArray();
    _jsp_string2 = "\r\n<tr><td>\r\n".toCharArray();
    _jsp_string0 = "\r\n\r\n\r\n	    \r\n <table cellSpacing=2 cellPadding=2 width=\"700\" border=0 id=\"c1\" align=\"center\">\r\n	    ".toCharArray();
    _jsp_string4 = " <a href=\"home.do?method=sendMsg&tid=".toCharArray();
    _jsp_string1 = "\r\n      ".toCharArray();
  }
}
