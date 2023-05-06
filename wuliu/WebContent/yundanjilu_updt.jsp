<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
						<tr ><td width="200">快递单号：</td><td><input name='kuaididanhao' type='text' id='kuaididanhao' value='<%=connDbBean.getID()%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">目的地：</td><td><input name='mudedi' type='text' id='mudedi' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">收件人：</td><td><input name='shoujianren' type='text' id='shoujianren' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">收件电话：</td><td><input name='shoujiandianhua' type='text' id='shoujiandianhua' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">用户名：</td><td><input name='yonghuming' type='text' id='yonghuming' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">电话：</td><td><input name='dianhua' type='text' id='dianhua' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">物品名称：</td><td><input name='wupinmingcheng' type='text' id='wupinmingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">物流费用：</td><td><input name='kuaidifeiyong' type='text' id='kuaidifeiyong' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelkuaidifeiyong' /></td></tr>		<tr 0><td width="200">运单状态：</td><td><select name='yundanzhuangtai' id='yundanzhuangtai'><option value="已取件">已取件</option><option value="派送中">派送中</option><option value="已签收">已签收</option><option value="异常件">异常件</option></select></td></tr>		<tr 1><td width="200">运送车辆：</td><td><select name='yunsongcheliang' id='yunsongcheliang' style=' height:19px; border:solid 1px #000000; color:#666666'><%=connDbBean.hsggetoption("t_cheliangxinxi","chepaihao")%></select></td></tr>		<tr 2><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		<tr 3><td width="200">网点编号：</td><td><input name='wangdianbianhao' type='text' id='wangdianbianhao' onblur='' style='border:solid 1px #000000; color:#666666' value='' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						     <input type="submit" name="Submit5" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;<input type="hidden" name="id" value="${requestScope.yundanjilu.id}"/>
						    </td>
						</tr>
						<script language="javascript">document.form1.kuaididanhao.value='${yundanjilu.kuaididanhao}';</script>	<script language="javascript">document.form1.mudedi.value='${yundanjilu.mudedi}';</script>	<script language="javascript">document.form1.shoujianren.value='${yundanjilu.shoujianren}';</script>	<script language="javascript">document.form1.shoujiandianhua.value='${yundanjilu.shoujiandianhua}';</script>	<script language="javascript">document.form1.yonghuming.value='${yundanjilu.yonghuming}';</script>	<script language="javascript">document.form1.xingming.value='${yundanjilu.xingming}';</script>	<script language="javascript">document.form1.dianhua.value='${yundanjilu.dianhua}';</script>	<script language="javascript">document.form1.wupinmingcheng.value='${yundanjilu.wupinmingcheng}';</script>	<script language="javascript">document.form1.kuaidifeiyong.value='${yundanjilu.kuaidifeiyong}';</script>	<script language="javascript">document.form1.yundanzhuangtai.value='${yundanjilu.yundanzhuangtai}';</script>	<script language="javascript">document.form1.yunsongcheliang.value='${yundanjilu.yunsongcheliang}';</script>	<script language="javascript">document.form1.beizhu.value='${yundanjilu.beizhu}';</script>	<script language="javascript">document.form1.wangdianbianhao.value='${yundanjilu.wangdianbianhao}';</script>	
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
