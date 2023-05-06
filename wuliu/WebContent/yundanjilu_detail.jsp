<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<%@ page isELIgnored="false" %> 
<jsp:useBean id="yundanjiluhsgb" scope="page" class="com.action.yundanjiluAction" />
<html>
  <head>
    <title>运单记录详细</title>
    <LINK href="css.css" type=text/css rel=stylesheet>

  </head>

  <body >

  运单记录详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>快递单号：</td><td width='39%'>${yundanjilu.kuaididanhao}</td>     <td width='11%'>目的地：</td><td width='39%'>${yundanjilu.mudedi}</td></tr><tr>     <td width='11%'>收件人：</td><td width='39%'>${yundanjilu.shoujianren}</td>     <td width='11%'>收件电话：</td><td width='39%'>${yundanjilu.shoujiandianhua}</td></tr><tr>     <td width='11%'>用户名：</td><td width='39%'>${yundanjilu.yonghuming}</td>     <td width='11%'>姓名：</td><td width='39%'>${yundanjilu.xingming}</td></tr><tr>     <td width='11%'>电话：</td><td width='39%'>${yundanjilu.dianhua}</td>     <td width='11%'>物品名称：</td><td width='39%'>${yundanjilu.wupinmingcheng}</td></tr><tr>     <td width='11%'>物流费用：</td><td width='39%'>${yundanjilu.kuaidifeiyong}</td>     <td width='11%'>运单状态：</td><td width='39%'>${yundanjilu.yundanzhuangtai}</td></tr><tr>     <td width='11%'>运送车辆：</td><td width='39%'>${yundanjilu.yunsongcheliang}</td>     <td width='11%'>备注：</td><td width='39%'>${yundanjilu.beizhu}</td></tr><tr>     <td width='11%'>网点编号：</td><td width='39%'>${yundanjilu.wangdianbianhao}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

