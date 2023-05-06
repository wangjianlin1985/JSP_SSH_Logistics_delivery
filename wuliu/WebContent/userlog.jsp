<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="code" scope="page" class="com.util.CheckCode" />
<%request.setCharacterEncoding("utf-8");%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html class="no-js">
<head>
<meta />
<title>用户登陆</title>
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
<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
<script language="javascript">
		function checklog()
		{                                                                                         
		     if(document.userlog.username.value=="")
			 {
			 	alert("请输入用户名");
				document.userlog.username.focus();
				return false;
			 }
			 if(document.userlog.pwd1.value=="")
			 {
			 	alert("请输入密码");
				document.userlog.pwd1.focus();
				return false;
			 }
			 
			if (document.userlog.pagerandom.value != document.userlog.yzm.value) {
			alert("验证码错误！");
			document.userlog.pagerandom.focus();
			return false;
	}
			 document.getElementById("indicator").style.display="block";
			 loginService.login(document.userlog.username.value,document.userlog.pwd1.value,document.userlog.cx.value,callback);
		}
		
		function callback(data)
		{
		    document.getElementById("indicator").style.display="none";
		    if(data=="noyzm")
		    {
		        alert("验证码错误");
		    }
		    if(data=="no")
		    {
		        alert("用户名错误");
		    }
			if(data=="no")
		    {
		        alert("用户名或密码错误");
		    }
		    if(data=="yes")
		    {
		        alert("通过验证,系统登录成功");
		        window.location.href="index.action";
		    }
		    
		}
		
		
		
	    </script>
<body>
<%@ include file="qttop.jsp"%>

<div class="content">
	<div class="wrap">
		<div class="pad0">
			<div class="s_title">
				<div class="name">用户登陆</div>
				<div class="menu">
					
				</div>
			</div>
			<div class="det_con"> 
					
					                    
                      <c:if test="${sessionScope.username==null}">
                          <form action="" method="post" name="userlog" id="userlog" style="display: inline">
                            <table width="100%" height="31%" border="0" cellpadding="0" cellspacing="0">
                              <tr>
                                <td width="78" height="28">&nbsp;</td>
                                <td width="114" height="40">用户名:</td>
                                <td height="28" colspan="2"><input name="username" type="text" id="username" style="width:200px; height:30px; border:solid 1px #000000; color:#666666" /></td>
                              </tr>
                              <tr>
                                <td height="28">&nbsp;</td>
                                <td height="40">密码:</td>
                                <td height="4" colspan="2"><input name="pwd1" type="password" id="pwd1"  style="width:200px; height:30px; border:solid 1px #000000; color:#666666" /></td>
                              </tr>
                              <tr>
                                <td height="28">&nbsp;</td>
                                <td height="40">权限:</td>
                                <td height="4" colspan="2"><select name="cx" id="cx" style="width:100px; height:30px; border:solid 1px #000000; color:#666666" >
                                    <option value="注册用户">注册用户</option>
                                    <option value="快递网点">快递网点</option>
									<!--quxanxiaxndexnglxu-->
                                </select></td>
                              </tr>
                              <tr >
                                <td height="28">&nbsp;</td>
                                <td height="40">验证码</td>
                                <td width="58" height="4"><INPUT class=input_new id=pagerandom size=5 maxlength="4" name=pagerandom onKeyUp="this.value=this.value.replace(/\D/gi,'')" style="width:50px; height:20px; border:solid 1px #000000; color:#666666"/></td>
                                <td width="890" height="4" align=left><%
								String yzm=code.getCheckCode();
								%>  <input type="hidden" name="yzm" value="<%=yzm %>" >
							    <%=yzm %></td>
                              </tr>
                              <script type="text/javascript">
          
           function loadimage(){ 
document.getElementById("randImage").src = "image.jsp?"+Math.random(); 
} 

           
                                  </script>
                              <tr>
                                <td height="38" colspan="4" align="center">
                                  <table width="100%" border="0">
                                    <tr>
                                      <td width="16%" align="right"><img id="indicator" src="qtimages/loading.gif" style="display:none"/></td>
                                      <td width="84%"><input type="button" name="Submit" value="登陆" class="hsgbutton" onClick="return checklog();" />
                                      <input type="reset" name="Submit2" value="重置" class="hsgbutton" /></td>
                                    </tr>
                                  </table></td>
                              </tr>
                            </table>
                          </form>
                        
						 </c:if>
                         <c:if test="${sessionScope.username!=null}">
						  <table width="90%" height="15%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                              <td width="31%" height="40">用户名</td>
                              <td width="69%" height="40"> <%=request.getSession().getAttribute("username")%> </td>
                            </tr>
                            <tr>
                              <td height="40">权限</td>
                              <td height="40"> ${sessionScope.cx}</td>
                            </tr>
                            <tr>
                              <td height="30" colspan="2" align="center"><input type="button" name="Submit3" value="退出" onClick="javascript:location.href='logout.jsp';" />
                                  <input type="button" name="Submit32" value="个人后台" onClick="javascript:location.href='main.jsp';" />
                              </td>
                            </tr>
                          </table>
						 </c:if>
                      					
			</div>	
		</div>
	</div>		
</div>
<%@ include file="qtdown.jsp"%>

</body>
</html>
