<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=yundanjilu.xls");
%>
<html>
  <head>
    <title>�˵���¼</title>
  </head>

  <body >

<table width="100%" border="1" >  
  <tr>
    <td width="30" align="center" >���</td>
    <td>��ݵ���</td>    <td>Ŀ�ĵ�</td>    <td>�ռ���</td>    <td>�ռ��绰</td>    <td>�û���</td>    <td>����</td>    <td>�绰</td>    <td>��Ʒ����</td>    <td>��ݷ���</td>    <td>�˵�״̬</td>    <td>���ͳ���</td>    <td>��ע</td>    <td>������</td>    
	
    
  </tr>
   <%
			String sql="select * from t_yundanjilu order by id desc";
int i=0;
							
						
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						
					

		
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td><%=RS_result.getString("kuaididanhao") %></td>    <td><%=RS_result.getString("mudedi") %></td>    <td><%=RS_result.getString("shoujianren") %></td>    <td><%=RS_result.getString("shoujiandianhua") %></td>    <td><%=RS_result.getString("yonghuming") %></td>    <td><%=RS_result.getString("xingming") %></td>    <td><%=RS_result.getString("dianhua") %></td>    <td><%=RS_result.getString("wupinmingcheng") %></td>    <td><%=RS_result.getString("kuaidifeiyong") %></td>    <td><%=RS_result.getString("yundanzhuangtai") %></td>    <td><%=RS_result.getString("yunsongcheliang") %></td>    <td><%=RS_result.getString("beizhu") %></td>    <td><%=RS_result.getString("wangdianbianhao") %></td>    
	

   
  </tr>
  	<%
  }
   %>
   
</table>
<br>
  </body>
</html>

