<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false" %> 



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
        
       
		
		<script type='text/javascript' src='dwr/interface/loginService.js'></script>
        <script type='text/javascript' src='dwr/engine.js'></script>
        <script type='text/javascript' src='dwr/util.js'></script>
		
        <script language="javascript">
            function check()
            {
                 var userPwReal="${sessionScope.userxinxi.pwd}";
                 if(document.formPw.userPw.value !=userPwReal)
                 {
                     alert("原密码不正确");
                     return ;
                 }
                 
                 if(document.formPw.userPw1.value =="")
                 {
                     alert("新密码不能空");
                     return ;
                 }
                 
                 document.getElementById("indicator").style.display="block";
                 loginService.allusersPwEdit(document.formPw.userPw1.value,callback);
            }
            function callback(data)
            {
                document.getElementById("indicator").style.display="none";
                alert("修改成功");
            }
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='img/allbg.gif'>
			<form method="post" action="userPwEdit.action" name="formPw">
			<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
				<tr bgcolor="#EEF4EA">
				    <td colspan="2" background="img/wbg.gif" class='title'><span>密码修改</span></td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">
				         登录名：
				    </td>
				    <td width="75%" bgcolor="#FFFFFF">
				        <input type="text" value="${sessionScope.username }" name="userName" size="20" disabled="disabled"/>
				    </td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">
				        原密码：
				    </td>
				    <td width="75%" bgcolor="#FFFFFF">
				        <input type="password" name="userPw" id="userPw" size="22"/>
				    </td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">
				         新密码：
				    </td>
				    <td width="75%" bgcolor="#FFFFFF">
				        <input type="password" id="userPw1" name="userPw1" size="22"/>
				    </td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">&nbsp;
				        
				    </td>
			        <td width="75%" bgcolor="#FFFFFF">
			             <input type="button" value="修改" onclick="check()"/>
			             &nbsp;&nbsp;&nbsp;
			             <input type="reset" value="重置"/>
			             <img id="indicator" src="img/loading32.gif" alt="Loading..." style="display:none"/>
			        </td>
				</tr>
			</table>
			</form>
   </body>
</html>
