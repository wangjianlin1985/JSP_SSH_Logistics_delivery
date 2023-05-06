<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("gb2312");%>
<jsp:useBean id="kuaidiwangdianhsgb" scope="page" class="com.action.kuaidiwangdianAction" /> 



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>物流网点查询</TITLE>
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
           function kuaidiwangdianDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="kuaidiwangdianDel.action?id="+id;
               }
           }
           
		   function kuaidiwangdianDetail(id)
           {
                  // window.location.href="kuaidiwangdianDetail.action?id="+id;
				   window.open("kdwdDetail.action?id="+id,"_blank");
           }
           function kuaidiwangdianPre(id)
           {
                   window.location.href="kuaidiwangdianPre.action?id="+id;
           }
		   function kuaidiwangdianPrelb(id)
           {
                   window.location.href="kuaidiwangdianPrelb.action?id="+id;
           }
           function kuaidiwangdianIssh(id)
           {
                   window.location.href="kuaidiwangdianIssh.action?id="+id;
           }
           function kuaidiwangdianAdd()
           {
                 var url="kuaidiwangdianAdd.jsp";
				 window.location.href=url;
           }
           
           
           function go(index)
           {
               document.form123.index.value=index;
               document.form123.action="kuaidiwangdianList.action"
               document.form123.submit();
           }  
		    function check()
           {
               document.formAdd.submit();
           }
       </script>
	   
	</head>

	<body leftmargin="2" topmargin="9" background='img/allbg.gif' onload="catelogAll()">
	
	<form action="kuaidiwangdianList.action" name="formAdd" method="post">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#E7E7E7">
							<td height="10" colspan="8" background="img/tbg.gif">所有物流网点列表</td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    
					      <td  bgcolor="#FFFFFF" align="left">
						  搜索:  网点名称：<input name="wangdianmingcheng" type="text" id="wangdianmingcheng" style='border:solid 1px #000000; color:#666666' size="12" />  网点地址：<input name="wangdiandizhi" type="text" id="wangdiandizhi" style='border:solid 1px #000000; color:#666666' size="12" />  派送范围：<input name="paisongfanwei" type="text" id="paisongfanwei" style='border:solid 1px #000000; color:#666666' size="12" />
					        <input name="button" type="button" onclick="check()" value="查询"/> <input type="button" value="导出excel" onclick="javascript:location.href='kuaidiwangdian_listxls.jsp';"/>
					      
                             </td>
						</tr>
					 </table>
	</form>
			
			<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
				
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="50">序号</td>
					<td >网点编号</td>    <td >密码</td>    <td >网点名称</td>    <td >负责人</td>    <td >联系电话</td>    <td >网点地址</td>            <td  width='80' align='center'>是否审核</td>
					
					<td width="140">添加时间</td>
					<td width="140">操作</td>
		        </tr>
				<%
					int i=0;
				%>
				<c:forEach items="${requestScope.page.data}" var="kuaidiwangdian" varStatus="sta">
				<%
					i++;
				%>
				<tr align='center' bgcolor="#FFFFFF" onMouseOver="this.style.backgroundColor='#EDDCC2'" onMouseOut="this.style.backgroundColor='#ffffff'" height="22">
					<td><%=i%></td>
					<td>${kuaidiwangdian.wangdianbianhao}</td>    <td>${kuaidiwangdian.mima}</td>    <td>${kuaidiwangdian.wangdianmingcheng}</td>    <td>${kuaidiwangdian.fuzeren}</td>    <td>${kuaidiwangdian.lianxidianhua}</td>    <td>${kuaidiwangdian.wangdiandizhi}</td>            <td align='center'>${kuaidiwangdian.issh} <input type="button" value="审核" onclick="kuaidiwangdianIssh(${kuaidiwangdian.id})"/></td>    
					
					<td>${kuaidiwangdian.addtime}</td>
					<td  align="center" width="200px">
						     <input type="button" value="删除" onclick="kuaidiwangdianDel(${kuaidiwangdian.id})"/>
						     <input type="button" value="编辑" onclick="kuaidiwangdianPre(${kuaidiwangdian.id})"/>
							 
							 <input type="button" value="详细" onclick="kuaidiwangdianDetail(${kuaidiwangdian.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			
			
			<%@ include file="hsgfenye.jsp"%> 
			
			
	</body>
</html>
