﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
     <td width='11%'>快递单号：</td><td width='39%'>${yundanjilu.kuaididanhao}</td>
    
  </table>

  </body>
</html>
