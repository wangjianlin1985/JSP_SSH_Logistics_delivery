<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>





<script type='text/javascript' src='dwr/interface/loginService.js'></script>
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>

<div class="banner">
	<div class="focusBox">
		<ul class="pic">
			<%
			List sybht=connDbBean.getShouyebht();
			if(!sybht.isEmpty()){
				for(int i=0;i<sybht.size();i++){
					if (i<=5)
					{
					List sybht2 =(ArrayList)sybht.get(i);
			

	


			%>
			<li style="background:url(<%=sybht2.get(2)%>) center top no-repeat;"><a href="ggdetail.action?id=<%=sybht2.get(0)%>"></a></li>
			<%
			}
			}
			}
			%>
			
		</ul>
		<a class="prev" href="javascript:void(0)"></a>
		<a class="next" href="javascript:void(0)"></a>
		<ul class="hd">
		<%
		for(int i=0;i<sybht.size();i++)
		{
		%>
			<li></li>
			<%
	  }
	  %>
			
		</ul>
	</div>
</div>

