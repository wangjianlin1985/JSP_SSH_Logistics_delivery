﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<%@ page isELIgnored="false" %> 
<jsp:useBean id="yundanjiluhsgb" scope="page" class="com.action.yundanjiluAction" />


<script type='text/javascript' src='dwr/interface/loginService.js'></script>
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>添加运单记录</TITLE>
	    
      
        <LINK href="css.css" type=text/css rel=stylesheet>
       
	</head>

<script language="javascript">
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="yundanjiluUpdt.action" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" >修改运单记录</td>
						</tr>
						<tr ><td width="200">快递单号：</td><td><input name='kuaididanhao' type='text' id='kuaididanhao' value='<%=connDbBean.getID()%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						     <input type="submit" name="Submit5" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;<input type="hidden" name="id" value="${requestScope.yundanjilu.id}"/>
						    </td>
						</tr>
						<script language="javascript">document.form1.kuaididanhao.value='${yundanjilu.kuaididanhao}';</script>
					 </table>
			</form>
   </body>
</html>



<script language=javascript src='js/ajax.js'></script>
<script language=javascript >  
 
 function checkform(){  
 
	var kuaidifeiyongobj = document.getElementById("kuaidifeiyong"); if(kuaidifeiyongobj.value==""){document.getElementById("clabelkuaidifeiyong").innerHTML="&nbsp;&nbsp;<font color=red>请输入快递费用</font>";return false;}else{document.getElementById("clabelkuaidifeiyong").innerHTML="  "; } 


return true;   
}   
popheight=450;
</script>  