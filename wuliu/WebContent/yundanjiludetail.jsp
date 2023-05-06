<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<jsp:useBean id="yundanjiluhsgb" scope="page" class="com.action.yundanjiluAction" />
<!--qtxlixstd-->
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

<script language=javascript> 
function hsgpinglun(nbiao,nid){ 
popheight=450;
pop('hsgpinglun.jsp?biao='+nbiao+'&id='+nid,'在线评论',550,250) ;
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
					
					                    
                    
   <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse"  class="newsline">  
      <tr>
		 <td width='11%'>物流单号：</td><td width='39%'>${yundanjilu.kuaididanhao}</td>     <td width='11%'>目的地：</td><td width='39%'>${yundanjilu.mudedi}</td></tr><tr>     <td width='11%'>收件人：</td><td width='39%'>${yundanjilu.shoujianren}</td>     <td width='11%'>收件电话：</td><td width='39%'>${yundanjilu.shoujiandianhua}</td></tr><tr>     <td width='11%'>用户名：</td><td width='39%'>${yundanjilu.yonghuming}</td>     <td width='11%'>姓名：</td><td width='39%'>${yundanjilu.xingming}</td></tr><tr>     <td width='11%'>电话：</td><td width='39%'>${yundanjilu.dianhua}</td>     <td width='11%'>物品名称：</td><td width='39%'>${yundanjilu.wupinmingcheng}</td></tr><tr>     <td width='11%'>物流费用：</td><td width='39%'>${yundanjilu.kuaidifeiyong}</td>     <td width='11%'>运单状态：</td><td width='39%'>${yundanjilu.yundanzhuangtai}</td></tr><tr>     <td width='11%'>运送车辆：</td><td width='39%'>${yundanjilu.yunsongcheliang}</td>     <td width='11%'>备注：</td><td width='39%'>${yundanjilu.beizhu}</td></tr><tr>     <td width='11%'>网点编号：</td><td width='39%'>${yundanjilu.wangdianbianhao}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" /><input type=button name=Submit52 value=打印 onClick="javascript:window.print()"  /> <!--jixaaxnnxiu--></td></tr>
    
  </table>
                      					
			</div>	
		</div>
	</div>		
</div>
<%@ include file="qtdown.jsp"%>

</body>
</html>
