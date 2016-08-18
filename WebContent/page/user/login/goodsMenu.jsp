<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

#goods_info{outline:1px solid #FF0000;}
#goods_info .centerNum20150619{}

#goods_info .centerNum20150619 .c_img{
	margin:0em auto;
	outline:0px solid #FF0000;
}
#goods_info .centerNum20150619 .c_img img{
	width:100%;
}

#goods_info .centerNum20150619 .s_name{
	font-size:2em;
	padding:0.1em 0px;
	color:#333;
	outline:0px solid #FF0000;
}
#goods_info .centerNum20150619 .s_money{
	font-size:2em;
	padding:0.1em 0px;
	color:#FF6600;
	outline:0px solid #FF0000;
}

#goods_info .centerNum20150619 .buy{
	background:#FFF;
	padding:1em 0em 1em 0em;
}
#goods_info .centerNum20150619 .buy .buy_ok{
	width:100%;
	text-align:center;
	font-size:1.4em;
	padding:1em 0em 1em 0em;
	background:#FF6600;
	color:#FFF;
}
#goods_info .centerNum20150619  .s_button{
	padding:1em 0px;
}
#goods_info .centerNum20150619  .s_button a{
	font-size:1.4em;
	padding:0.2em 0px;
	color:#666;
}

#goods_info .centerNum20150619 .s_center div {
	padding:2em;
}

#goods_info .centerNum20150619 .s_center div h1 {
	font-size:1.4em;
}

#goods_info .centerNum20150619 .s_center img{
	width:100%;
}
.copyright{
	font-size:1.2em;
	padding:2em 0px;
	text-align:center;
	border:1px solid #CCC;border-style:solid none none none;
}
</style>
</head>
<body>

<div id="indexNum02">
	<div class="index-head clearfix">
		<div class="left">
			<div class="home">
				<a href="../page/userIndex.jsp" class="mall"></a>
			</div>
		</div>
		<center><span class="s_title">${goodsBean.name }</span></center>
		<div class="right">
			<a href="../page/carListAction.action" class="a1 cart" title="购物车"></a>
		</div>
	</div>
</div>
<div id="goods_info">
	<div class="centerNum20150619">
		<div class="c_img"><img src="${path }${goodsBean.image}" /></div>
		<div style="border:1px solid #CCC;border-style:none none solid none;"></div>
		<div class="s_name">${goodsBean.name }</div>
		<div class="s_money">${goodsBean.price }元起</div>
		<div class="buy">
			<table width="100%">
				<tr>
					<td><center><a class="buy_ok" href="../page/showCarGordersAction.action?goods_id=${goodsBean.id }">直接购买</a></center></td>
					<td><center><a class="buy_ok" href="../page/carAddAction.action?goods_id=${goodsBean.id }">加入购物车</a></center></td>
				</tr>
			</table>
		</div>
		<div style="border:1px solid #CCC;border-style:none none solid none;"></div>
		<div class="s_button">
			<table width="100%">
				<tr>
					<td><center><a class="aa1">概述</a></center></td>
					<td><center><a class="aa1">参数</a></center></td>
				</tr>
			</table>
		</div>
		<div class="s_center">
			<div>
				<h1>${goodsBean.description }</h1><br/>
			</div>	
		</div>


</body>
</html>


