<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=pinglun.xls");
%>
<html>
  <head>
    <title>����</title>
  </head>

  <body >

<table width="100%" border="1" >
  <tr>
    <td width="30" align="center" >���</td>
    <td >����ID</td>
    <td >��������</td>
    <td >������</td>
    <td >����</td>
    <td >��</td>
    
	
    <td width="120" align="center" >���ʱ��</td>
    
  </tr>
   <%
			String sql="select * from t_pinglun order by id desc";
			int i=0;
									
			ResultSet RS_result=connDbBean.executeQuery(sql);
			while(RS_result.next()){

			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td><%=RS_result.getString("xinwenID") %></td>
    <td><%=RS_result.getString("pinglunneirong") %></td>
    <td><%=RS_result.getString("pinglunren") %></td>
    <td><%=RS_result.getString("pingfen") %></td>
    <td><%=RS_result.getString("biao") %></td>

  </tr>
  	<%
  }
   %>
   
</table>
<br>
  </body>
</html>

