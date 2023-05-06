<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%request.setCharacterEncoding("utf-8");%>

<!DOCTYPE html>
<html class="no-js">
<head>
<meta />
<title>内容详细</title>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<%
String lb=request.getParameter("lb");
%>
<body>
<%@ include file="qttop.jsp"%>

<div class="content">
	<div class="wrap">
		<div class="pad0">
			<div class="s_title">
				<div class="name"><%=lb%></div>
				<div class="menu">
					
				</div>
			</div>
			<div class="det_con"> 
					
					                    
                    <table width="97%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#B8D8E8" class="newsline" style="border-collapse:collapse">
                            
                            <tr>
                              <td height="104"><%=connDbBean.readzd("t_dx","content","leibie",lb)%></td>
                            </tr>
                            <tr>
                              <td align="right"><input type="button" onClick="javaScript:history.back();" value="返回" /></td>
                            </tr>
                          </table>
                      					
			</div>	
		</div>
	</div>		
</div>
<%@ include file="qtdown.jsp"%>

</body>
</html>
