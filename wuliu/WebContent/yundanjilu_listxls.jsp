<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=yundanjilu.xls");
%>
<html>
  <head>
    <title>运单记录</title>
  </head>

  <body >

<table width="100%" border="1" >  
  <tr>
    <td width="30" align="center" >序号</td>
    <td>快递单号</td>    <td>目的地</td>    <td>收件人</td>    <td>收件电话</td>    <td>用户名</td>    <td>姓名</td>    <td>电话</td>    <td>物品名称</td>    <td>快递费用</td>    <td>运单状态</td>    <td>运送车辆</td>    <td>备注</td>    <td>网点编号</td>    
	
    
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

