<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("gb2312");%>
<jsp:useBean id="cheliangxinxihsgb" scope="page" class="com.action.cheliangxinxiAction" /> 



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>车辆信息查询</TITLE>
	<LINK href="css.css" type=text/css rel=stylesheet />
	
		
		<script type='text/javascript' src='dwr/interface/loginService.js'></script>
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
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
           function cheliangxinxiDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="cheliangxinxiDel.action?id="+id;
               }
           }
           
		   function cheliangxinxiDetail(id)
           {
                  //tanchuangfanshi1 window.location.href="cheliangxinxiDetail.action?id="+id;
				  //tanchuangfanshi2 window.open("clxxDetail.action?id="+id,"_blank");
           }
           function cheliangxinxiPre(id)
           {
                   window.location.href="cheliangxinxiPre.action?id="+id;
           }
		   function cheliangxinxiPrelb(id)
           {
                   window.location.href="cheliangxinxiPrelb.action?id="+id;
           }
           function cheliangxinxiIssh(id)
           {
                   window.location.href="cheliangxinxiIssh.action?id="+id;
           }
           function cheliangxinxiAdd()
           {
                 var url="cheliangxinxiAdd.jsp";
				 window.location.href=url;
           }
           
           
           function go(index)
           {
               document.form123.index.value=index;
               document.form123.action="cheliangxinxiList.action"
               document.form123.submit();
           }  
		    function check()
           {
               document.formAdd.submit();
           }
       </script>
	   
	</head>

	<body leftmargin="2" topmargin="9" background='img/allbg.gif' onload="catelogAll()">
	
	<form action="cheliangxinxiList.action" name="formAdd" method="post">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#E7E7E7">
							<td height="10" colspan="8" background="img/tbg.gif">所有车辆信息列表</td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    
					      <td  bgcolor="#FFFFFF" align="left">
						  搜索:  车牌号：<input name="chepaihao" type="text" id="chepaihao" style='border:solid 1px #000000; color:#666666' size="12" />  驾驶员：<input name="jiashiyuan" type="text" id="jiashiyuan" style='border:solid 1px #000000; color:#666666' size="12" /> 状态：<select name='zhuangtai' id='zhuangtai' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><option value="空闲">空闲</option><option value="在用">在用</option></select>
					        <input name="button" type="button" onclick="check()" value="查询"/> <input type="button" value="导出excel" onclick="javascript:location.href='cheliangxinxi_listxls.jsp';"/>
					      
                             </td>
						</tr>
					 </table>
	</form>
			
			<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
				
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="50">序号</td>
					<td >车牌号</td>    <td >驾驶员</td>    <td >状态</td>    <td >备注</td>    
					
					<td width="140">添加时间</td>
					<td width="140">操作</td>
		        </tr>
				<%
					int i=0;
				%>
				<c:forEach items="${requestScope.page.data}" var="cheliangxinxi" varStatus="sta">
				<%
					i++;
				%>
				<tr align='center' bgcolor="#FFFFFF" onMouseOver="this.style.backgroundColor='#EDDCC2'" onMouseOut="this.style.backgroundColor='#ffffff'" height="22">
					<td><%=i%></td>
					<td>${cheliangxinxi.chepaihao}</td>    <td>${cheliangxinxi.jiashiyuan}</td>    <td>${cheliangxinxi.zhuangtai}</td>    <td>${cheliangxinxi.beizhu}</td>    
					
					<td>${cheliangxinxi.addtime}</td>
					<td  align="center" width="200px">
						     <input type="button" value="删除" onclick="cheliangxinxiDel(${cheliangxinxi.id})"/>
						     <input type="button" value="编辑" onclick="cheliangxinxiPre(${cheliangxinxi.id})"/>
							 
							 
					</td>
				</tr>
				</c:forEach>
			</table>
			
			
			
			<%@ include file="hsgfenye.jsp"%> 
			
			
	</body>
</html>
