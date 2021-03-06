<%@page import="com.zrcx.millet.gorders.dao.GordersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-control" content="no-cache" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0,minimal-ui" />   
<meta name="apple-mobile-web-app-capable" content="yes" />
<title>小米-为发烧而生</title>
<link rel="stylesheet" type="text/css" href="../../../common/css/common.css">
<style>
body{
	background:#FFF;
}
#indexNum02 .index-head{
	outline:1px solid #e7e7e7;
	border-style:none none solid none;
	background:#F4F4F4;
	padding:1.2em 0em 1.2em 0em;
	position:relative;
}
#indexNum02 .index-head .s_title{
	font-size:2.365em;
	color:#666;
	outline:0px solid #0033CC;
}
#indexNum02 .index-head .left{
	outline:0px solid #FF0000;
	position:absolute;
	left:1em;
	top:1.2em;
	padding:0em 1em 0em 0px;
}
#indexNum02 .index-head .left .home{
	outline:0px solid #FF0000;
}
#indexNum02 .index-head .left .home .mall{
	width:3em;
	height:3em;
	color: #424242;
	display:inline-block;
	outline:0px solid #FF0000;
	margin-left:1em;
	background:url(../../../common/images/icon_home.png) no-repeat;
	background-size:100% 100%;
}
#indexNum02 .index-head .right{
	outline:0px solid #FF0000;
	position:absolute;
	right:1em;
	top:1.2em;
	padding:0em 1em 0em 0px;
}
#indexNum02 .index-head .right .a1{
	width:3em;
	height:3em;
	display:inline-block;
	margin-left:1em;
	outline:0px solid #FF0000;
	
}
#indexNum02 .index-head .right .user{
	background:url(../../../common/images/icon_03.png) no-repeat;
	background-size:100% 100%;
}
#indexNum02 .index-head .right .cart{
	background:url(../../../common/images/icon_02.png) no-repeat;
	background-size:100% 100%;
}

#goods_list{outline:0px solid #FF0000;background:#FFF;}
#goods_list .centerNum20150702{}
#goods_list .centerNum20150702 .goods_content{
	padding:0em;
	background:#FFF;
	margin:1em;
}

#goods_list .centerNum20150702 .goods_content .g_info{
	padding:1em;
	border:1px solid #f4f4f4;
	border-style:none none solid none;
	position:relative;
}
#goods_list .centerNum20150702 .goods_content .g_info table{
	
}
#goods_list .centerNum20150702 .goods_content .g_info table .td_left{
	width:20%;
	color:#999;
}
#goods_list .centerNum20150702 .goods_content .g_info table .td_right{
	width:80%;
	color:#999;
	padding:0.2em;
}
#goods_list .centerNum20150702 .goods_content .g_info .g_buttonImg{
	width:3em;
	height:3em;
	position:absolute;
	right:1em;
	top:2em;
	z-index:1;
	color:#999;
	outline:0px solid #FF0000;
	background:url(../../../common/images/icon_s_06.png) no-repeat;
	background-size:100% 100%;
}
	
#goods_list .centerNum20150702 .goods_content .g_info   img{
	width:8em;
	height:8em;
}

#goods_list .centerNum20150702 .goods_content .g_info .s_name{
	outline:0px solid #FF0000;
	font-size:1.8em;
	color:#999;
}
#goods_list .centerNum20150702 .goods_content .g_info .money{
	outline:0px solid #FF0000;
	font-size:1.2em;
	color:#999;
}


.s_js{
	border:1px solid #CCC;
	border-style:solid none none none;
	padding:2em 0em;
	position:relative;
}
.s_js .js_jz{
	font-size:1.4em;
	color:#FF6600;
}
.s_js .js_ok{
	font-size:2em;
	color:#FFF;
	background:#FF6600;
	border-radius:0.2em;
	width:8em;
	text-align:center;
	padding:0.3em 0em;
}

</style>
</head>
<body>

<div id="indexNum02">
	<div class="index-head clearfix">
		<div class="left">
			<div class="home">
				<a href="../login/showGoodsTableAction.action" class="mall"></a>
			</div>
		</div>
		<center><span class="s_title">订单详情</span></center>
		<div class="right">
			<a href="carListAction.action" class="a1 cart" title="购物车"></a>
		</div>
	</div>
</div>
<div id="goods_list">
	<div class="centerNum20150702">
		<ul>
			<c:forEach items="${list}" var="gordersBean" varStatus="in">
			<c:if test="${in.index<1 }">
			<li class="goods_content">		
				<div class="g_info">
					<table width="100%">
						<tr>
							<td align="right" class="td_left">订单状态：</td>
							<td class="td_right">${gordersBean.state==0?"未付款":"已付款" }</td>
						</tr>
						<tr>
							<td align="right" class="td_left">商品总价：</td>
							<td class="td_right">
								${objs[1] }元&nbsp;&nbsp;&nbsp;
								优惠：10元&nbsp;&nbsp;&nbsp;
								运费：10元&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
						<tr>
							<td align="right" class="td_left">应付金额：</td>
							<td class="td_right">
								${objs[1]+20 }元&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
					</table>
				</div>
			</li>
			<li class="goods_content">		
				<div class="g_info">
					<table width="100%">
						<tr>
							<td align="right" class="td_left">物流信息：</td>
							<td class="td_right">顺丰(北京)</td>
						</tr>
						<tr>
							<td align="right" class="td_left">运单号：</td>
							<td class="td_right"></td>
						</tr>						
					</table>
				</div>
			</li>
			<li class="goods_content">		
				<div class="g_info">
					<table width="100%">
						<tr>
							<td align="right" class="td_left">下单日期：</td>
							<td class="td_right">${gordersBean.time }</td>
						</tr>
						<tr>
							<td align="right" class="td_left">订单编号：</td>
							<td class="td_right">${gordersBean.code }</td>
						</tr>	
						<tr>
							<td align="right" class="td_left">收货地址：</td>
							<td class="td_right">
								${addrBean.province }${addrBean.city }${addrBean.district }${addrBean.street }
								<br/>${addrBean.name } ${addrBean.phone }
							</td>
						</tr>	
						<tr>
							<td align="right" class="td_left">收货时间：</td>
							<td class="td_right">
								工作日送货(适用办公地址)
							</td>
						</tr>	
						<tr>
							<td align="right" class="td_left">发票类型：</td>
							<td class="td_right">
								个人纸质发票
							</td>
						</tr>	
						<tr>
							<td align="right" class="td_left">发票抬头：</td>
							<td class="td_right">
								个人
							</td>
						</tr>							
					</table>
				</div>
			</li>
			</c:if>
			<li class="goods_content">		
				<div class="g_info">
					<table width="100%">
						<tr>
							<td width=1><img src="${path }${gordersBean.image }" /></td>
							<td>								
									<span class="s_name">${gordersBean.name }</span><br /><br />
									<span class="money">售价：${gordersBean.price }元&nbsp;&nbsp;&nbsp;数量：${gordersBean.number }个&nbsp;&nbsp;&nbsp;总计：${gordersBean.price*gordersBean.number }元</span>
									<br />
							</td>
						</tr>
					</table>
					
				</div>
			</li>
			</c:forEach>
		</ul>
	</div>
	
</div>
	<br /><br /><br /><br />

</body>
</html>


