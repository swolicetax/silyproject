#-*- coding: UTF-8 -*-
from cdctools import *
from Karrigell_QuickForm import Karrigell_QuickForm as KQF

CDCPATH = "Z:/Karrigell-2.3.5/webapps/cdc"
CDROM = 'i:/'
def htmhead(title):
    '''默认页面头声明
    @note: 为了复用，特别的组织成独立函式,根据Karrigell 非页面访问约定，函式名称
    加"_"
    @param title: 页面标题信息
    @return: 标准的HTML 代码
    '''
    htm = """<html><HEAD>
    <title>%s</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    </HEAD>
    <body>""" % title
    return htm
## 默认页面尾声明
htmfoot = """
<h5>design by:<a href="mailto:Zoom.Quiet@gmail.com">Zoom.Quiet</a>
powered by : <a href="http://python.org">Python</a> +
<a href="http://karrigell.sourceforge.net"> KARRIGELL 2.3.5</a>
</h5>
</body></html>"""

def index(**args):
    '''默认主页
    @note: 使用简单的表单／链接操作来完成原有功能的界面化
    @param args: 数组化的不定参数
    @return: 标准的HTML 页面
     '''
    print htmhead("PyCDC WEB")
    p = KQF('fm_cdwalk', 'POST', "index", "CD Walk")
    p.addHtmNode('text', "keywd", "文件名", {'size':20, 'maxlength':50})
    p.addGroup(["submit", "btn_submit", "Walk it!", "btn"])
    p.display()
    p = KQF('fm_cdwalk', 'POST', "index", "CD Walk")
    p.addHtmNode('text', "keywd", "关键字", {'size':20, 'maxlength':50})
    p.addGroup(["submit", "btn_submit", "Search It!", "btn"])
    p.display()
    if 0 == len(QUERY):
        pass
    else:
        if "Search" in QUERY:
            print I("try search *.cdc for KEY:%s"%QUERY['keywd']),BR(),
            cdcGrep("%s/"%CDCPATH,QUERY['keywd'])
        elif "Walk" in QUERY:
            iniCDinfo(CDROM,"%s/%s"%(CDCPATH,QUERY['keywd']))
        else:
            pass
    print htmfoot
