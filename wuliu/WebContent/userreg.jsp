<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%request.setCharacterEncoding("utf-8");%>
<script type="text/javascript">
function mi(){
	alert("两次密码不一致");
	var m1=document.getElementById("mima").value();
	var m2=document.getElementById("mima2").value();
	if(m1!=m2){
		alert("两次密码不一致");
	}

}

</script>
<script type='text/javascript' src='dwr/interface/loginService.js'></script>
        <script type='text/javascript' src='dwr/engine.js'></script>
        <script type='text/javascript' src='dwr/util.js'></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>

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


<link rel="stylesheet" href="qtimages/hsgbanner.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body>
<%@ include file="qttop.jsp"%>

<div class="content">
	<div class="wrap">
		<div class="pad0">
			<div class="s_title">
				<div class="name">用户注册</div>
				<div class="menu">
					
				</div>
			</div>
			<div class="det_con"> 
					
					                    
                    <form action="yonghuzhuceAdd.action" name="formAdd" method="post">
				      <table width="100%" height="582" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="3" >用户注册</td>
						</tr>
						<tr ><td width="200">用户名：</td><td colspan="2"><input required="required" name='yonghuming' type='text' id='yonghuming' value='' onblur='hsgcheck()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelyonghuming' /></td></tr>
		                <tr bordercolor="#58AC22">
                          <td>密码：</td>
		                  <td><input name='mima' type='password' required="required" id='mima' value=''/ >
		                      <label id='clabelmima' />                          
		                    &nbsp;* </td>
		                  <td>确认密码：
		                    <input name='mima2' type='password'  required="required" id='mima2' value='' onblur='mi()' />
                              <label id='clabelmima2' />                          
	                      </td>
	                    </tr>
		<tr ><td width="200">姓名：</td><td colspan="2"><input name='xingming' required="required" type='text' id='xingming' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelxingming' /></td></tr>
		<tr ><td width="200">性别：</td><td colspan="2"><select name='xingbie' id='xingbie'><option value="男">男</option><option value="女">女</option></select></td></tr>
		<tr ><td width="200">出生年月：</td><td colspan="2"><input name='chushengnianyue' type='text' id='chushengnianyue' value='' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px;  border:solid 1px #000000; color:#666666'/></td></tr>
		<tr ><td width="200">qq：</td><td colspan="2"><input name='qq' type='text' id='qq' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr ><td width="200">邮箱：</td><td colspan="2"><input name='youxiang' type='text' id='youxiang' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelyouxiang' />必需邮箱格式</td></tr>
		<tr ><td width="200">电话：</td><td colspan="2"><input name='dianhua' type='text' id='dianhua' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabeldianhua' />必需电话格式</td></tr>
		<tr ><td width="200">身份证：</td><td colspan="2"><input name='shenfenzheng' type='text' id='shenfenzheng' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelshenfenzheng' />必需身份证格式</td></tr>
		<tr 0><td width="200">头像：</td><td colspan="2"><input name='touxiang' type='text' id='touxiang' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('touxiang')" style='border:solid 1px #000000; color:#666666'/></td></tr>
		<tr 1><td width="200">地址：</td><td colspan="2"><input name='dizhi' type='text' id='dizhi' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr 2><td width="200">备注：</td><td colspan="2"><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="200"  align="right">&nbsp;						    </td>
						    <td width="75%" colspan="2"  align="left">
						     <input type="submit" name="Submit5" id="Submit5" value="提交" onClick="">
						       <input type="reset" value="重置"/>&nbsp;		<input name="addtime" type="hidden" id="addtime" value="<%=connDbBean.gettime()%>" />				    </td>
						</tr>
					 </table>
			</form>
                      					
			</div>	
		</div>
	</div>		
</div>
<%@ include file="qtdown.jsp"%>

</body>

</html>

