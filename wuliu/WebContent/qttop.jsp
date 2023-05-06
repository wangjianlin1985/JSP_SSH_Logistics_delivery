<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<div class="header">
	<div class="wrap">
		<div class="head_top">
			<div class="logo fl"><a href="#"><img src="qtimages/logo.gif" width="79" height="78"/></a></div>
			<div style="position:absolute; top:30px; margin-left:130px;">
				<div style="font-family:宋体; color:#666666; WIDTH: 100%; FONT-WEIGHT: bold; FONT-SIZE: 19pt; margin-top:5pt">
                    <div align="left">仓库物流管理系统</div>
                </div>
			</div>
			<div style="float:right"> 
			
			<%
			if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")=="")
			{
			%>
               <a href="userlog.jsp">用户登陆</a> | <a href="userreg.jsp">用户注册</a> | <a href="kuaidiwangdianadd.jsp">网点注册</a>
					<%
					}
					else
					{
					%>
				当前用户: ${sessionScope.username},权限: ${sessionScope.cx}; <a href="logout.jsp">退出</a>|<a href="main.jsp">个人后台</a>
				<%
				}
				%>
			
			
			</div>
			<div class="phone fr"><img src="qtimages/phone.jpg"/></div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="nav_bar">
		<div class="wrap">
			<div class="nav">
				<ul>
					<li id="m4" class="m"><h3><a href="index.action">系统首页</a></h3></li>
					<li id="m4" class="m"><h3><a href="dx_detail.jsp?lb=系统简介">系统简介</a></h3></li>
					<li id="m2" class="m">
						<h3><a style="cursor:pointer">新闻资讯</a></h3>
						<ul class="sub">
						  <li><a href="news.action?lb=站内新闻">站内新闻</a></li>
						  <li><a href="news.action?lb=网点公告">网点公告</a></li>
						  <li><a href="news.action?lb=行业资讯">行业资讯</a></li>
						
						</ul>
					</li>
					<%-- <li id="m3" class="m">
						<h3><a href="#">站内新闻</a></h3>
						<ul class="sub">
						  <li><a href="#">基础效果</a></li>
						  <li><a href="#">基础效果</a></li>
						  <li><a href="#">基础效果</a></li>
						  <li><a href="#">基础效果</a></li>
						</ul>
					</li> --%>
					<li id="m4" class="m"><h3><a href="kdwdList.action">网点查询</a></h3></li>
					<li id="m4" class="m"><h3><a href="ydjlList.action">快件追踪</a></h3></li>
					<li id="m2" class="m">
						<h3><a >在线留言</a></h3>
						<ul class="sub">
						  <li><a href="lyb.jsp">我要留言</a></li>
						  <li><a href="lyblist.action">查看留言</a></li>

						</ul>
					</li>
					<li id="m4" class="m"><h3><a href="login.jsp">后台管理</a></h3></li>
				</ul>
			</div>
			<div class="search">
				<div class="s_pad">
					<form id="formsearch" name="formsearch" method="post" action="news.action">
						<input type="text" name="biaoti" id="biaoti" value="" class="ss_txt"/>
						<input type="submit" name="dl" id="button" value="" class="ss_bott"  hidefocus />
					</form>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</div>
