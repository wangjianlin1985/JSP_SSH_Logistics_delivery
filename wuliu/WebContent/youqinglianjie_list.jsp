﻿<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>友情连接查询</TITLE> 
	<LINK href="css.css" type=text/css rel=stylesheet />
	
		
		<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
<script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
        <script language="javascript">
		   function catelogAll()
           {
                   document.getElementById("indicator").style.display="block";
                   loginService.catelogAll(callback);
               
           }
           function callback(data)
           {
               document.getElementById("indicator").style.display="none";
               DWRUtil.addOptions("catelog_id",data,"id","name");
           }
           function youqinglianjieDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="youqinglianjieDel.action?id="+id;
               }
           }
           
           function youqinglianjiePre(id)
           {
                   window.location.href="youqinglianjiePre.action?id="+id;
           }
           function yonghuzhuceIssh(id)
           {
                   window.location.href="youqinglianjieIssh.action?id="+id;
           }
           function youqinglianjieAdd()
           {
                 var url="youqinglianjieAdd.jsp";
				 window.location.href=url;
           }
           
           
           function go(index)
           {
               document.form123.index.value=index;
               document.form123.action="youqinglianjieList.action"
               document.form123.submit();
           }  
		    function check()
           {
               document.formAdd.submit();
           }
       </script>
	   
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

	<body leftmargin="2" topmargin="9" background='img/allbg.gif' onload="catelogAll()">
	
	<form action="youqinglianjieList.action" name="formAdd" method="post">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#E7E7E7">
							<td height="10" colspan="8" background="img/tbg.gif">&nbsp;&nbsp;</td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    
					      <td  bgcolor="#FFFFFF" align="left">
						  搜索:  网站名称：<input name="wangzhanmingcheng" type="text" id="wangzhanmingcheng" style='border:solid 1px #000000; color:#666666' size="12" />  网址：<input name="wangzhi" type="text" id="wangzhi" style='border:solid 1px #000000; color:#666666' size="12" />
					        <input name="button" type="button" onclick="check()" value="提交"/>
					      
                             </td>
						</tr>
					 </table>
	</form>
			
			<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
				
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="50">序号</td>
					<td >网站名称</td>
    <td >网址</td>
    
					
					<td width="140">添加时间</td>
					<td width="140">操作</td>
		        </tr>
				<%
					int i=0;
				%>
				<c:forEach items="${requestScope.page.data}" var="youqinglianjie" varStatus="sta">
				<%
					i++;
				%>
				<tr align='center' bgcolor="#FFFFFF" onMouseOver="this.style.backgroundColor='#EDDCC2'" onMouseOut="this.style.backgroundColor='#ffffff'" height="22">
					<td><%=i%></td>
					<td>${youqinglianjie.wangzhanmingcheng}</td>
    <td>${youqinglianjie.wangzhi}</td>
    
					
					<td>${youqinglianjie.addtime}</td>
					<td  align="center">
						     <input type="button" value="删除" onclick="youqinglianjieDel(${youqinglianjie.id})"/>
						     <input type="button" value="编辑" onclick="youqinglianjiePre(${youqinglianjie.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			
			<%@ include file="hsgfenye.jsp"%> 
			
			
	</body>
</html>
