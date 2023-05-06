<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

 <script language="javascript">
		  
           
           
           function go(index,lb)
           {
               document.form123.index.value=index;
               document.form123.action="news.action?lb="+lb
               document.form123.submit();
           }  
		   
       </script>
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
					
					                    
                    <table width="98%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#FA9090" class="newsline" style="border-collapse:collapse">
				
				
				<%
					int i=0;
				%>
				<c:forEach items="${requestScope.page.data}" var="xinwentongzhi" varStatus="sta">
				<%
					i++;
				%>
				<tr align='center' bgcolor="#FFFFFF" onMouseOver="this.style.backgroundColor='#EDDCC2'" onMouseOut="this.style.backgroundColor='#ffffff'" height="22">
					<td width="23"><img src="qtimages/jt.gif" height="7"></td>
					<td width="735" align="left"><a href="ggdetail.action?id=${xinwentongzhi.id}">${xinwentongzhi.biaoti}</a></td>
    
    
    <td width="160">被点击${xinwentongzhi.dianjilv}次</td>
    <td width="170">${xinwentongzhi.addtime}</td>
				  </tr>
				</c:forEach>
			</table>
			               
						   
						   <form action="" name="form123" method="post">
                  <input type="hidden" name="index"/>
            </form>
                      <br/>
		    <table border='0' cellpadding='0' cellspacing='0' align="center">
		        <tr>
			        <td width='98%' align="right">
			                 <div class="fy"> 共<span style='color:#FF0000'>${requestScope.page.totle}</span>条记录&nbsp;&nbsp;&nbsp;&nbsp;
			                  每页<span style='color:#FF0000'>${requestScope.page.pageSize}</span>条&nbsp;&nbsp;&nbsp;&nbsp;
			                  第<span style='color:#FF0000'>${requestScope.page.index}</span>页/共${requestScope.page.totlePage}页&nbsp;&nbsp;&nbsp;&nbsp;
			                <c:if test="${requestScope.page.index==1}">
			                       首&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;&nbsp;
			                </c:if>
			                <c:if test="${requestScope.page.index!=1}">
			                       <a style='color: red' href='#' onClick="go(1,'<%=lb%>')">首&nbsp;&nbsp;页</a>
			                       &nbsp;&nbsp;&nbsp;&nbsp;
			                       <a style='color: red' href='#' onClick="go(${requestScope.page.index-1},'<%=lb%>')">上一页</a>
			                       &nbsp;&nbsp;&nbsp;&nbsp;
			                </c:if>
			                <c:if test="${requestScope.page.index >= requestScope.page.totlePage}">
			                          下一页&nbsp;&nbsp;&nbsp;&nbsp;末&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;
			                </c:if>
			                <c:if test="${requestScope.page.index < requestScope.page.totlePage}">
			                       <a style='color: red' href='#' onClick="go(${requestScope.page.index+1},'<%=lb%>')">下一页</a>
			                       &nbsp;&nbsp;&nbsp;&nbsp;
			                       <a style='color: red' href='#' onClick="go(${requestScope.page.totlePage},'<%=lb%>')">末&nbsp;&nbsp;页</a>
			                </c:if>
							</div>
			        </td>
		       </tr>
		    </table>  					
			</div>	
		</div>
	</div>		
</div>
<%@ include file="qtdown.jsp"%>

</body>
</html>
