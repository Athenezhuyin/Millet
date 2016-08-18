<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
 
#indexNum01 .index-head{
	outline:0px solid #FF0000;
	background:#F4F4F4;
}
#indexNum01 .index-head .left{
	outline:0px solid #FF0000;
	float:left;
}
#indexNum01 .index-head .left .home{
	outline:0px solid #FF0000;
}
#indexNum01 .index-head .left .home .mall{
	font-size:2em;
	color: #424242;
	display:inline-block;
	outline:0px solid #FF0000;
	margin-left:1em;
	margin:0.75em;
}
#indexNum01 .index-head .right{
	outline:0px solid #FF0000;
	float:right;
	padding:1.2em 1em 1.2em 0px;
}
#indexNum01 .index-head .right .a1{
	width:3em;
	height:3em;
	display:inline-block;
	margin-left:1em;
	outline:0px solid #FF0000;
	
}
#indexNum01 .index-head .right .user{
	background:url(../../../common/images/icon_03.png) no-repeat;
	background-size:100% 100%;
}
#indexNum01 .index-head .right .cart{
	background:url(../../../common/images/icon_02.png) no-repeat;
	background-size:100% 100%;
}

#centerNum01 .img_center{
	outline:0px solid #0033cc;
} 
#centerNum01 .img_center img{
	width:100%;
} 
#centerNum01 .s_submit{
	background:#FFF;
}
#centerNum01 .s_submit .s_center{
	width:23%;
	height:7em;
	border:1px solid #F5F5F5;
	border-style:none solid none none;
	float:left;
}

#centerNum01 .s_submit .c1{
	border:0px;
}
#centerNum01 .s_submit .s_center .s_background{
	height:5em;
	width:5em;
	margin:0 auto;
}
#centerNum01 .s_submit .s_center .s_span{
	line-height:1em;
	text-align:center;
	outline:0px solid #FF0000;
}
#centerNum01 .s_submit .s_center .b1{
	background:url(../../../common/images/icon_s_01.png) no-repeat;
	background-size:100% 100%;
	
}
#centerNum01 .s_submit .s_center .b2{
	background:url(../../../common/images/icon_s_02.png) no-repeat;
	background-size:100% 100%;
}
#centerNum01 .s_submit .s_center .b3{
	background:url(../../../common/images/icon_s_03.png) no-repeat;
	background-size:100% 100%;
}
#centerNum01 .s_submit .s_center .b4{
	background:url(../../../common/images/icon_s_04.png) no-repeat;
	background-size:100% 100%;
}
#centerNum01 .title{
	border:1px solid #f4f4f4;
	margin-top:0.1em;
}
#centerNum01 .t_01{
	padding:1em 0px 1em 1em;
	font-size:2em;
	background:#FFF;
	border-style:solid none solid none;
}
#centerNum01 .t_02{
	padding:1em 0px 1em 1em;
	font-size:2em;
	text-align:center;
	background:#FFF;
	border-style:solid none none none;
	color:#999;
}

#centerNum01 .t_04 img{
	width:100%;
}
#centerNum01 .chenp{
	background:#FFF;
}
#centerNum01 .list{
	width:49%;
	float:left;
}
#centerNum01 .list img{
	width:100%;
}
#centerNum01 .l_num02{
	border:1px solid #F4F4F4;
	border-style:solid none none solid;
	margin:0px 0px 0px 1px;
}

.pcUrl{
	padding:1em 0px 1em 0em;
	font-size:1.4em;
	text-align:center;
	background:#f4f4f4;
	border:1px solid #FF0000;
	border-style:none none solid none;
	color:#FF0000;
}
.download{
	margin:0em;
	padding:0em;
	border:1px solid #626262;
	background:#626262;
}
.download  img{
	width:100%;
}

</style>
<script type="text/javascript">
	function showGclass(){
		window.location.href="showGclassTableAction.action";
	}
</script>
</head>
<body>

<div id="indexNum01">
	<div class="index-head clearfix">
		<div class="left">
			<div class="home">
				<a href="" class="mall">商城</a>
			</div>
		</div>
		
		<div class="right">
			<a href="../page/userIndex.jsp" class="a1 user" title="个人中心"></a>
			${userBean.phone }
			<a href="../page/carListAction.action" class="a1 cart" title="购物车"></a>
		</div>
	</div>
</div>
<div id="centerNum01">
	<div class="img_nav">
		<ul>
			<li class="img_center">
				<img src="../../../common/images/T1IAVjBmET1RXrhCrK.jpg" />
			</li>
		</ul>
	</div>
	<div class="s_submit">
		<ul class="clearfix">
			<li class="s_center" onclick="location.href='goods_list.htm';">
				<div class="s_background b1"></div>
				<div class="s_span">全部商品</div>
			</li>
			<li class="s_center">
				<div class="s_background b2" onclick="showGclass();"></div>
				<div class="s_span" onclick="showGclass();">搜索</div>
			</li>
			<li class="s_center">
				<div class="s_background b3"></div>
				<div class="s_span">小米社区</div>
			</li>
			<li class="s_center c1">
				<div class="s_background b4"></div>
				<div class="s_span">客户端</div>
			</li>
		
		</ul>
	</div>
	
	<div class="title t_01">最新上市</div>
	<div class="chenp">
		<ul class="clearfix">
			<c:forEach items="${list }" var="goodsBean">
				<li class="list l_num01"><a href="showGoodsMenuAction.action?id=${goodsBean.id }"><img  style="width:200px;height:200px;margin-left:5px" src="${path }${goodsBean.image}" /></a>${goodsBean.name }￥${goodsBean.price }</li>
			</c:forEach>
	    </ul>
	</div>
	<div class="title t_02" onclick="location.href='goods_list.htm';">查看更多配件&nbsp;&nbsp;&nbsp;&gt;</div>
	<div class="download"><img src="../../../common/images/icon_s_05.png" /></div>
</div>
</body>
</html>


