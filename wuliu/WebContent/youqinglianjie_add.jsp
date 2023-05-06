<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 

<%
String path = request.getContextPath(); 
%>
<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
<script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>添加友情连接</TITLE>
	    
      
        <LINK href="css.css" type=text/css rel=stylesheet>
       
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

	<body>
			<form action="youqinglianjieAdd.action" name="formAdd" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" >添加友情连接</td>
						</tr>
						<tr ><td width="200">网站名称：</td><td><input name='wangzhanmingcheng' type='text' id='wangzhanmingcheng' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelwangzhanmingcheng' /></td></tr>
		<tr ><td width="200">网址：</td><td><input name='wangzhi' type='text' id='wangzhi' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelwangzhi' /></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						     <input type="submit" name="Submit5" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>



<script language=javascript src='js/ajax.js'></script>
<script language=javascript >  
 
 function checkform(){  
 
	var wangzhanmingchengobj = document.getElementById("wangzhanmingcheng"); if(wangzhanmingchengobj.value==""){document.getElementById("clabelwangzhanmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入网站名称</font>";return false;}else{document.getElementById("clabelwangzhanmingcheng").innerHTML="  "; } 
	var wangzhiobj = document.getElementById("wangzhi"); if(wangzhiobj.value==""){document.getElementById("clabelwangzhi").innerHTML="&nbsp;&nbsp;<font color=red>请输入网址</font>";return false;}else{document.getElementById("clabelwangzhi").innerHTML="  "; } 
	


return true;   
}   
popheight=450;
</script>  
