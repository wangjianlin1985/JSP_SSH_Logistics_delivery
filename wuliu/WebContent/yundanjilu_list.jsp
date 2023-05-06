<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("gb2312");%>
<jsp:useBean id="yundanjiluhsgb" scope="page" class="com.action.yundanjiluAction" /> 



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>运单记录查询</TITLE>
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
           function yundanjiluDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="yundanjiluDel.action?id="+id;
               }
           }
           
		   function yundanjiluDetail(id)
           {
                  // window.location.href="yundanjiluDetail.action?id="+id;
				   window.open("ydjlDetail.action?id="+id,"_blank");
           }
           function yundanjiluPre(id)
           {
                   window.location.href="yundanjiluPre.action?id="+id;
           }
		   function yundanjiluPrelb(id)
           {
                   window.location.href="yundanjiluPrelb.action?id="+id;
           }
           function yundanjiluIssh(id)
           {
                   window.location.href="yundanjiluIssh.action?id="+id;
           }
           function yundanjiluAdd()
           {
                 var url="yundanjiluAdd.jsp";
				 window.location.href=url;
           }
           
           
           function go(index)
           {
               document.form123.index.value=index;
               document.form123.action="yundanjiluList.action"
               document.form123.submit();
           }  
		    function check()
           {
               document.formAdd.submit();
           }
       </script>
	   
	</head>

	<body leftmargin="2" topmargin="9" background='img/allbg.gif' onload="catelogAll()">
	
	<form action="yundanjiluList.action" name="formAdd" method="post">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#E7E7E7">
							<td height="10" colspan="8" background="img/tbg.gif">所有运单记录列表</td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    
					      <td  bgcolor="#FFFFFF" align="left">
						  搜索:  物流单号：<input name="kuaididanhao" type="text" id="kuaididanhao" style='border:solid 1px #000000; color:#666666' size="12" />  目的地：<input name="mudedi" type="text" id="mudedi" style='border:solid 1px #000000; color:#666666' size="12" />  收件人：<input name="shoujianren" type="text" id="shoujianren" style='border:solid 1px #000000; color:#666666' size="12" /> 运单状态：<select name='yundanzhuangtai' id='yundanzhuangtai' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><option value="已取件">已取件</option><option value="派送中">派送中</option><option value="已签收">已签收</option><option value="异常件">异常件</option></select> 运送车辆：<select name='yunsongcheliang' id='yunsongcheliang' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><%=connDbBean.hsggetoption("t_cheliangxinxi","chepaihao")%></select>  网点编号：<input name="wangdianbianhao" type="text" id="wangdianbianhao" style='border:solid 1px #000000; color:#666666' size="12" />
					        <input name="button" type="button" onclick="check()" value="查询"/> <input type="button" value="导出excel" onclick="javascript:location.href='yundanjilu_listxls.jsp';"/>
					      
                             </td>
						</tr>
					 </table>
	</form>
			
			<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
				
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="50">序号</td>
					<td >物流单号</td>    <td >目的地</td>    <td >收件人</td>    <td >收件电话</td>    <td >用户名</td>    <td >姓名</td>    <td >电话</td>    <td >物品名称</td>    <td >物流费用</td>    <td >运单状态</td>    <td >运送车辆</td>        <td >网点编号</td>    
					
					<td width="140">添加时间</td>
					<td width="140">操作</td>
		        </tr>
				<%
					int i=0;
				%>
				<c:forEach items="${requestScope.page.data}" var="yundanjilu" varStatus="sta">
				<%
					i++;
				%>
				<tr align='center' bgcolor="#FFFFFF" onMouseOver="this.style.backgroundColor='#EDDCC2'" onMouseOut="this.style.backgroundColor='#ffffff'" height="22">
					<td><%=i%></td>
					<td>${yundanjilu.kuaididanhao}</td>    <td>${yundanjilu.mudedi}</td>    <td>${yundanjilu.shoujianren}</td>    <td>${yundanjilu.shoujiandianhua}</td>    <td>${yundanjilu.yonghuming}</td>    <td>${yundanjilu.xingming}</td>    <td>${yundanjilu.dianhua}</td>    <td>${yundanjilu.wupinmingcheng}</td>    <td>${yundanjilu.kuaidifeiyong}</td>    <td>${yundanjilu.yundanzhuangtai}</td>    <td>${yundanjilu.yunsongcheliang}</td>        <td>${yundanjilu.wangdianbianhao}</td>    
					
					<td>${yundanjilu.addtime}</td>
					<td  align="center" width="200px">
						     <input type="button" value="删除" onclick="yundanjiluDel(${yundanjilu.id})"/>
						     <input type="button" value="编辑" onclick="yundanjiluPre(${yundanjilu.id})"/>
							 
							 <input type="button" value="详细" onclick="yundanjiluDetail(${yundanjilu.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			 <%
			String sql="select * from t_yundanjilu where 1=1 ";
				if(request.getParameter("kuaididanhao")=="" ||request.getParameter("kuaididanhao")==null ){}else{String nkuaididanhao=new String(request.getParameter("kuaididanhao").getBytes("8859_1"));if(nkuaididanhao.contains("?")){nkuaididanhao=request.getParameter("kuaididanhao");}sql=sql+" and kuaididanhao like '%"+nkuaididanhao+"%'";}if(request.getParameter("mudedi")=="" ||request.getParameter("mudedi")==null ){}else{String nmudedi=new String(request.getParameter("mudedi").getBytes("8859_1"));if(nmudedi.contains("?")){nmudedi=request.getParameter("mudedi");}sql=sql+" and mudedi like '%"+nmudedi+"%'";}if(request.getParameter("shoujianren")=="" ||request.getParameter("shoujianren")==null ){}else{String nshoujianren=new String(request.getParameter("shoujianren").getBytes("8859_1"));if(nshoujianren.contains("?")){nshoujianren=request.getParameter("shoujianren");}sql=sql+" and shoujianren like '%"+nshoujianren+"%'";}if(request.getParameter("yundanzhuangtai")=="" ||request.getParameter("yundanzhuangtai")==null ){}else{sql=sql+" and yundanzhuangtai like '%"+request.getParameter("yundanzhuangtai")+"%'";}if(request.getParameter("yunsongcheliang")=="" ||request.getParameter("yunsongcheliang")==null ){}else{sql=sql+" and yunsongcheliang like '%"+request.getParameter("yunsongcheliang")+"%'";}if(request.getParameter("wangdianbianhao")=="" ||request.getParameter("wangdianbianhao")==null ){}else{String nwangdianbianhao=new String(request.getParameter("wangdianbianhao").getBytes("8859_1"));if(nwangdianbianhao.contains("?")){nwangdianbianhao=request.getParameter("wangdianbianhao");}sql=sql+" and wangdianbianhao like '%"+nwangdianbianhao+"%'";}
			sql+=" order by id desc";
double kuaidifeiyongz=0;
							
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						kuaidifeiyongz=kuaidifeiyongz+Float.valueOf(RS_result.getString("kuaidifeiyong")).floatValue();
						
						
			 }
			%>
		共计物流费用:<%=kuaidifeiyongz%>； 
			
			<%@ include file="hsgfenye.jsp"%> 
			
			
	</body>
</html>
