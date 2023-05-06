<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html class="no-js">
<head>
<meta  />
<title>仓库物流管理系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="qtimages/css/reset.css" rel="stylesheet" />
<link href="qtimages/css/main.css" rel="stylesheet"/>
<script src="qtimages/jquery.js"></script> 
<script src="js/jquery.SuperSlide.2.1.1.js"></script>


<script type="text/javascript" src="qtimages/inc.js"></script>
<link rel="stylesheet" href="qtimages/hsgbanner.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
<body>
<%@ include file="qttop.jsp"%>
<%@ include file="bht.jsp"%>
<div class="content">
	<%-- <div class="icon">
		<div class="wrap">
			<div class="icon_list">
				<ul>
					<li><a href="#" class="i1">品牌介绍</a></li>
					<li><a href="#" class="i2">企业荣誉</a></li>
					<li><a href="#" class="i3">团队力量</a></li>
					<li><a href="#" class="i4">专业技术</a></li>
					<li><a href="#" class="i5">相关视频</a></li>
				</ul>
			</div>
			
		</div>
	</div> --%>
	<div class="wrap">
		
		<div class="pad20">
			<div class="title">
				<div class="name name2"><h3>站内新闻</h3>News</div>
				<div class="more"><a href="news.action?lb=站内新闻">更多 ></a></div>
			</div>
			<div class="f4_x"></div>
			<div class="wwdt">
				<div class="l_pic">
					<a href="news.php?lb=站内新闻"><img src="qtimages/news.jpg"/></a>
					<a href="news.php?lb=站内新闻">所有资讯,这里都有,快来看看！</a>
				</div>
				<div class="c_news">
				
					<div class="news_sj">
						<ul>
						  <s:iterator value="#request.xinwentongzhiznxwList" id="xinwentongzhiznxw">
							<li><a href="ggdetail.action?id=<s:property value='#xinwentongzhiznxw.id'/>"><span><s:property value="#xinwentongzhiznxw.addtime.substring(0,10)"/></span> 
							
							<s:if test="#xinwentongzhiznxw.biaoti.length() > 20">
									 <s:property value="#xinwentongzhiznxw.biaoti.substring(0,20)"/>
								</s:if>
								<s:else>
									<s:property value="#xinwentongzhiznxw.biaoti"/>
								</s:else>
								
								 </a></li>
						  </s:iterator>
							
							
							
							
						</ul>
					</div>
					<a href="news.action?lb=站内新闻" class="more">更多动态</a>
				</div>
				<div class="r_tw">
					<ul class="r_tw_list">
						<li>
							<div class="pic"><a href="#"><img src="qtimages/news1.jpg"/></a></div>
							<div class="txt"><a href="#">我们的团队</a><span>xxxx-xx-xx</span></div>
						</li>
						<li>
							<div class="pic"><a href="#"><img src="qtimages/news2.jpg"/></a></div>
							<div class="txt"><a href="#">我们的风彩</a><span>xxxx-xx-xx</span></div>
						</li>
					</ul>
					<a href="news.action?lb=站内新闻" class="more">更多动态</a>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<!--<div id="adsBox" class="adsBox mrt20">
			<div class="hd">
				<ul>
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</div>
			<div class="bd">
				<ul>
					<li><a href="#" target="_blank"><img src="qtimages/ad1.jpg" /></a></li>
					<li><a href="#" target="_blank"><img src="qtimages/ad1.jpg" /></a></li>
					<li><a href="#" target="_blank"><img src="qtimages/ad1.jpg" /></a></li>
				</ul>
			</div>
		</div>-->
		<%-- <div class="pad20 slideGroup">
			<div class="title">
				<div class="name name2"><h3>产品展示</h3>Products</div>
				<div class="more"><a href="#">更多 ></a></div>
				<div class="clear"></div>
			</div>
			<div class="parHd">
				<ul> 
					<li>A类产品</li>
					<li>B类产品</li>
					<li>C类产品</li>
					<li>D类产品</li>
					
				</ul>
			</div>
			<div class="parBd">
				<div class="slideBox">
					<a class="sPrev" href="javascript:void(0)"></a>
					<ul>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp01.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp02.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp03.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp04.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp05.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp01.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp02.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品</a><span class="eye">140</span></div>
						</li>
					</ul>
					<a class="sNext" href="javascript:void(0)"></a>
				</div><!-- slideBox End -->

				<div class="slideBox">
					<a class="sPrev" href="javascript:void(0)"></a>
					<ul>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp01.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品2</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp02.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品2</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp03.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品2</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp04.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品2</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp05.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品2</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp01.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品2</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp02.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品</a><span class="eye">140</span></div>
						</li>
					</ul>
					<a class="sNext" href="javascript:void(0)"></a>
				</div><!-- slideBox End -->
				
				<div class="slideBox">
					<a class="sPrev" href="javascript:void(0)"></a>
					<ul>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp01.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品3</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp02.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品3</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp03.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品3</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp04.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品3</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp05.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品3</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp01.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品3</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp02.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品3</a><span class="eye">140</span></div>
						</li>
					</ul>
					<a class="sNext" href="javascript:void(0)"></a>
				</div><!-- slideBox End -->

				<div class="slideBox">
					<a class="sPrev" href="javascript:void(0)"></a>
					<ul>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp01.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp02.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp03.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp04.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp05.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp01.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品</a><span class="eye">140</span></div>
						</li>
						<li>
							<div class="pic"><a href="#" target="_blank"><img src="qtimages/zp02.jpg" /></a></div>
							<div class="tit"><a href="#" target="_blank">薇薇学生美甲作品</a><span class="eye">140</span></div>
						</li>
					</ul>
					<a class="sNext" href="javascript:void(0)"></a>
				</div><!-- slideBox End -->
			</div><!-- parBd End -->
		</div> --%>
		<div class="pad20">
			<div class="title">
				<div class="name name2"><h3>系统简介</h3>About us</div>
				<div class="more"><a href="dx_detail.jsp?lb=系统简介">更多 ></a></div>
			</div>
			<div class="f4_x"></div>
			<div class="wwdt">
				<div class="l_pic">
					<a href="#"><img src="qtimages/about.jpg"/></a>
					<a href="#">仓库物流管理系统</a>
				</div>
				<div class="c_news l2em">
					　<%=connDbBean.readzd("t_dx","content","leibie","系统简介")%> 
    ...　<a href="dx_detail.jsp?lb=系统简介">[详细]</a>
				</div>
				<div class="r_tw">
					<ul class="about_list">
						<li>
							<div class="pic"><a href="#"><img src="qtimages/i_honor.jpg"/></a></div>
							<div class="txt"><h4><a href="#">我们的荣誉资质</a></h4>深受市政府的扶持和支持。共获得各类奖项2000多个...</div>
						</li>
						<li>
							<div class="pic"><a href="#"><img src="qtimages/i_sz.jpg"/></a></div>
							<div class="txt"><h4><a href="#">我们的团队力量</a></h4>拥有专业负责的技术人员20人......</div>
						</li>
						
					</ul>
					<a href="#" class="more2">查看更多</a>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="pad20">
			<div class="title">
				<div class="name name2"><h3>友情链接</h3>Links</div>
				<div class="more"></div>
			</div>
			<div class="f4_x"></div>
			<div class="links">
				
				  <%
										
										List qtyqlj=connDbBean.hsgselect("select * from t_youqinglianjie  order by id desc ",4);
			
			if(!qtyqlj.isEmpty()){
			
				for(int i=0;i<qtyqlj.size();i++){
					if(i<7)
					{
					List qtyqlj2 =(ArrayList)qtyqlj.get(i);
					
									
										%>
    	<a href="<%=qtyqlj2.get(2) %>" target="_blank"><%=qtyqlj2.get(1) %></a>
		 <%
								  }}}
								  %>
					  
			</div>
		</div>
	
	</div>
</div>
<%@ include file="qtdown.jsp"%>
<!-- The Scripts -->

</body>
</html>
