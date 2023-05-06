<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<jsp:useBean id="yundanjiluhsgb" scope="page" class="com.action.yundanjiluAction" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type='text/javascript' src='dwr/interface/loginService.js'></script>
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<!DOCTYPE html>
<html class="no-js">
<head>
<meta />
<title>运单记录</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="qtimages/css/reset.css" rel="stylesheet" />
<link href="qtimages/css/main.css" rel="stylesheet"/>
<link href="qtimages/css/sub.css" rel="stylesheet"/>
<script src="qtimages/jquery.js"></script> 
<script src="js/jquery.SuperSlide.2.1.1.js"></script>

<script type="text/javascript" src="qtimages/inc.js"></script>
<link rel="stylesheet" href="qtimages/hsgbanner.css">
</head>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
        <script language="javascript">
		  
             function check()
           {
               document.formssearch.submit();
           }
           
         
           
           function go(index)
           {
               document.form123.index.value=index;
               document.form123.action="ydjlList.action"
               document.form123.submit();
           }  
		   
       </script>
<%

%>

<body>
<%@ include file="qttop.jsp"%>

<div class="content">
	<div class="wrap">
		<div class="pad0">
			<div class="s_title">
				<div class="name">运单记录</div>
				<div class="menu">
					
				</div>
			</div>
			<div class="det_con"> 
					
					                    
                    


<form action="ydjlList.action" name="formssearch" method="post">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#E7E7E7">
							<td height="10" colspan="8" background="img/tbg.gif">&nbsp;&nbsp;</td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    
					      <td  bgcolor="#FFFFFF" align="left">
						 搜索:  物流单号：<input name="kuaididanhao" type="text" id="kuaididanhao" style='border:solid 1px #000000; color:#666666' size="12" />  
             <%-- 目的地：<input name="mudedi" type="text" id="mudedi" style='border:solid 1px #000000; color:#666666' size="12" />  收件人：<input name="shoujianren" type="text" id="shoujianren" style='border:solid 1px #000000; color:#666666' size="12" /> 运单状态：<select name='yundanzhuangtai' id='yundanzhuangtai' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><option value="已取件">已取件</option><option value="派送中">派送中</option><option value="已签收">已签收</option><option value="异常件">异常件</option></select> 运送车辆：<select name='yunsongcheliang' id='yunsongcheliang' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><%=connDbBean.hsggetoption("t_cheliangxinxi","chepaihao")%></select>  网点编号：<input name="wangdianbianhao" type="text" id="wangdianbianhao" style='border:solid 1px #000000; color:#666666' size="12" /> --%>
					        <input name="button" type="button" onClick="check()" value="提交"/> <input name="button" type="button" onClick="location.href='woyaojijianadd.jsp';" value="我要寄件"/> <!--qiehauanshitu-->
					      
                          </td>
						</tr>
					 </table>
	</form>
	
<br />
<table width="98%" border="0"  align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse" class="newsline">
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td bgcolor='#CCFFFF'>物流单号</td>
    <td bgcolor='#CCFFFF'>目的地</td>
    <td bgcolor='#CCFFFF'>收件人</td>
    <td bgcolor='#CCFFFF'>收件电话</td>
    <%-- <td bgcolor='#CCFFFF'>用户名</td>
    <td bgcolor='#CCFFFF'>姓名</td>
    <td bgcolor='#CCFFFF'>电话</td>
    <td bgcolor='#CCFFFF'>物品名称</td>
    <td bgcolor='#CCFFFF'>物流费用</td> --%>
    <td bgcolor='#CCFFFF'>运单状态</td>
    <td bgcolor='#CCFFFF'>运送车辆</td>
    
    <td bgcolor='#CCFFFF'>网点编号</td>
    
   
    
    <%-- <td width="60" align="center" bgcolor="CCFFFF">操作</td> --%>
  </tr>
  
                     <%
					int i=0;
				%>
				<c:forEach items="${requestScope.page.data}" var="yundanjilu" varStatus="sta">
				<%
					i++;
				%>
  <tr onMouseOver="this.style.backgroundColor='#EDDCC2'" onMouseOut="this.style.backgroundColor='#ffffff'">
    <td  align="center"><%=i+1 %></td>
    <td>${yundanjilu.kuaididanhao}</td>
    <td>${yundanjilu.mudedi}</td>
    <td>${yundanjilu.shoujianren}</td>
    <td>${yundanjilu.shoujiandianhua}</td>
    <%-- <td>${yundanjilu.yonghuming}</td>
    <td>${yundanjilu.xingming}</td>
    <td>${yundanjilu.dianhua}</td>
    <td>${yundanjilu.wupinmingcheng}</td>
    <td>${yundanjilu.kuaidifeiyong}</td> --%>
    <td>${yundanjilu.yundanzhuangtai}</td>
    <td>${yundanjilu.yunsongcheliang}</td>
    
    <td>${yundanjilu.wangdianbianhao}</td>
    
	
    <%-- <td  align="center"><a href="ydjlDetail.action?id=${yundanjilu.id}">详细</a></td> --%>
  </tr>
  </c:forEach>
   
</table>
<br>

<%@ include file="hsgfenye.jsp"%> 




                      					
			</div>	
		</div>
	</div>		
</div>
<%@ include file="qtdown.jsp"%>

</body>
</html>
