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

#goods_list{outline:0px solid #FF0000;}
#goods_list .centerNum20150617{
	width:90%;
	margin:0em auto;
	outline:0px solid #FF0000;
}
#goods_list .centerNum20150617 .goods_content{
	position:relative;
	z-index:999;
	padding:2em 0em 2em 0em;
	border:1px solid #f4f4f4;
	border-style:none none solid none;
}

#goods_list .centerNum20150617 .goods_content .g_img{
	width:3em;
	height:3em;
	position:absolute;
	left:1em;
	top:1.5em;
	z-index:1;
	outline:0px solid #FF0000;
}
#goods_list .centerNum20150617 .goods_content .g_name{
	font-size:1.65em;
	color:#666;
	margin-left:2.8em;
	position:relative;
	z-index:1;
}
#goods_list .centerNum20150617 .goods_content .foor{
	width:3em;
	height:3em;
	position:absolute;
	right:1em;
	top:1.5em;
	z-index:1;
	color:#999;
	outline:0px solid #FF0000;
	background:url(../../../common/images/icon_s_06.png) no-repeat;
	background-size:100% 100%;
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
#goods_list .search{
	width:94%;
	margin:0.5em auto;
	position:relative;
	outline:0px solid #FF0000;
	padding:1em 0em;
}
#goods_list .search .goodsValue{
	width:80%;
	font-size:2em;
	margin-left:1em;
	border:1px solid #FFF;
}
#goods_list .search .start{
	width:3em;
	height:3em;
	outline:0px solid #FF0000;
	position:absolute;
	right:0em;
	top:0.5em;
	background:url(../../../common/images/icon_s_07.png) no-repeat;
	background-size:100% 100%;
}
#goods_list .search .back{
	height:1em;
	width:100%;
	outline:0px solid #FF0000;
	background:url(../../../common/images/icon_s_08.png) no-repeat;
	background-size:100% 100%;
}


</style>
<script type="text/javascript">
	function search(){
		var name = document.getElementById("name").value;
		window.location.href = "showGclassTableAction.action?name="+name;
	}
</script>
</head>
<body>

<div id="indexNum02">
	<div class="index-head clearfix">
		<div class="left">
			<div class="home">
				<a href="index.htm" class="mall"></a>
			</div>
		</div>
		<center><span class="s_title">商品分类</span></center>
		<div class="right">
			<a href="" class="a1 cart" title="购物车"></a>
		</div>
	</div>
</div>
<div id="goods_list">
	<div class="search">
		<input name="goodsValue" id="name" class="goodsValue"  />
		<div class="start" onclick="search();"></div>
		<div class="back"></div>
	</div>
	<div class="centerNum20150617">
		<ul>
			<c:forEach items="${list }" var="gclassBean">
			<li class="goods_content">
				<div class="g_name">${gclassBean.name }</div>
				<div class="foor" onclick="window.location.href='showGoodsFindByGclassIdAction.action?gclass_id=${gclassBean.id}'"></div>
			</li>
			</c:forEach>
		</ul>
	</div>
	<div class="pcUrl">切换到电脑版</div>
	<div class="download"><img src="../../../common/images/icon_s_05.png" /></div>
</div>


</body>
</html>


