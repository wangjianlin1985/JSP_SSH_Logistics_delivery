<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=youqinglianjie.xls");
%>
<html>
  <head>
    <title>��������</title>
  </head>

  <body >

<table width="100%" border="1" >
  <tr>
    <td width="30" align="center" >���</td>
    <td >��վ����</td>
    <td >��ַ</td>
    
	
    <td width="120" align="center" >���ʱ��</td>
    
  </tr>
    <%
			String sql="select * from t_youqinglianjie order by id desc";
			int i=0;
									
			ResultSet RS_result=connDbBean.executeQuery(sql);
			while(RS_result.next()){

			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td><%=RS_result.getString("wangzhanmingcheng") %></td>
    <td><%=RS_result.getString("wangzhi") %></td>
    <td><%=RS_result.getString("addtime") %></td>
   
  </tr>
  	<%
  }
   %>
   
</table>
<br>
  </body>
</html>

