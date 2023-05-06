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
<%
  String id="";
id = request.getParameter("id"); 
String mudedi="";
String shoujianren="";
String shoujiandianhua="";
String yonghuming="";
String xingming="";
String dianhua="";
String wupinmingcheng="";

if(id!=null){
	List yundanjiluListlbdq = yundanjiluhsgb.getLbdqYundanjilu(Integer.parseInt(id),7);
	mudedi=(String)yundanjiluListlbdq.get(0);
  	shoujianren=(String)yundanjiluListlbdq.get(1);
  	shoujiandianhua=(String)yundanjiluListlbdq.get(2);
  	yonghuming=(String)yundanjiluListlbdq.get(3);
  	xingming=(String)yundanjiluListlbdq.get(4);
  	dianhua=(String)yundanjiluListlbdq.get(5);
  	wupinmingcheng=(String)yundanjiluListlbdq.get(6);
  	

} 
   %>
<script language="javascript">

function gows()
{
	document.location.href="yundanjilu_add.jsp?id=<%=id%>";
}
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
			<form action="yundanjiluAdd.action" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" >添加运单记录<input name="addtime" type="hidden" id="addtime" value="<%=connDbBean.gettime()%>" /></td>
						</tr>
						<tr ><td width="200">物流单号：</td><td><input name='kuaididanhao' type='text' id='kuaididanhao' value='<%=connDbBean.getID()%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr ><td width="200">目的地：</td><td><input name='mudedi' type='text' id='mudedi' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr ><td width="200">收件人：</td><td><input name='shoujianren' type='text' id='shoujianren' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr ><td width="200">收件电话：</td><td><input name='shoujiandianhua' type='text' id='shoujiandianhua' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr ><td width="200">用户名：</td><td><input name='yonghuming' type='text' id='yonghuming' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr ><td width="200">电话：</td><td><input name='dianhua' type='text' id='dianhua' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr ><td width="200">物品名称：</td><td><input name='wupinmingcheng' type='text' id='wupinmingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr ><td width="200">物流费用：</td><td><input name='kuaidifeiyong' type='text' id='kuaidifeiyong' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelkuaidifeiyong' /></td></tr>
		<tr 0><td width="200">运单状态：</td><td><select name='yundanzhuangtai' id='yundanzhuangtai'><option value="已取件">已取件</option><option value="派送中">派送中</option><option value="已签收">已签收</option><option value="异常件">异常件</option></select></td></tr>
		<tr 1><td width="200">运送车辆：</td><td><select name='yunsongcheliang' id='yunsongcheliang' style=' height:19px; border:solid 1px #000000; color:#666666'><%=connDbBean.hsggetoption2("t_cheliangxinxi","chepaihao")%></select></td></tr>
		<tr 2><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>
		<tr 3><td width="200">网点编号：</td><td><input name='wangdianbianhao' type='text' id='wangdianbianhao' onblur='' style='border:solid 1px #000000; color:#666666' value='' /></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						     <input type="submit" name="Submit5" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.mudedi.value='<%=mudedi%>';document.form1.mudedi.setAttribute("readOnly",'true');</script>
		<script language="javascript">document.form1.shoujianren.value='<%=shoujianren%>';document.form1.shoujianren.setAttribute("readOnly",'true');</script>
		<script language="javascript">document.form1.shoujiandianhua.value='<%=shoujiandianhua%>';document.form1.shoujiandianhua.setAttribute("readOnly",'true');</script>
		<script language="javascript">document.form1.yonghuming.value='<%=yonghuming%>';document.form1.yonghuming.setAttribute("readOnly",'true');</script>
		<script language="javascript">document.form1.xingming.value='<%=xingming%>';document.form1.xingming.setAttribute("readOnly",'true');</script>
		<script language="javascript">document.form1.dianhua.value='<%=dianhua%>';document.form1.dianhua.setAttribute("readOnly",'true');</script>
		<script language="javascript">document.form1.wupinmingcheng.value='<%=wupinmingcheng%>';document.form1.wupinmingcheng.setAttribute("readOnly",'true');</script>
		<script language="javascript">document.form1.wangdianbianhao.value='<%=request.getSession().getAttribute("username")%>';document.form1.wangdianbianhao.setAttribute("readOnly",'true');</script>
						
					 </table>
			</form>
   </body>
</html>



<script language=javascript src='js/ajax.js'></script>
<script language=javascript >  
 
 function checkform(){  
 
	var kuaidifeiyongobj = document.getElementById("kuaidifeiyong"); if(kuaidifeiyongobj.value==""){document.getElementById("clabelkuaidifeiyong").innerHTML="&nbsp;&nbsp;<font color=red>请输入快递费用</font>";return false;}else{document.getElementById("clabelkuaidifeiyong").innerHTML="  "; } 
	var kuaidifeiyongobj = document.getElementById("kuaidifeiyong"); if(kuaidifeiyongobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(kuaidifeiyongobj.value)){document.getElementById("clabelkuaidifeiyong").innerHTML=""; }else{document.getElementById("clabelkuaidifeiyong").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    


return true;   
}   
popheight=450;
</script>  
