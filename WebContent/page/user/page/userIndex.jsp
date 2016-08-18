<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-control" content="no-cache" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0,minimal-ui" />   
<meta name="apple-mobile-web-app-capable" content="yes" />
<title>个人信息页</title>
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

#user_info{outline:1px solid #FF0000;background:#ebeced;}
#user_info .user_img{
	position:relative;
}
#user_info .user_img img{
	width:100%;
}
#user_info .user_img .span{
	font-size:2em;
	color:#fff;
	position:absolute;
	top:35%;
	right:20%;
}
#user_info .list{
	
}
#user_info .list .center{
	margin:1em;
}
#user_info .list .xx{
	padding:1.5em 0px;
	position:relative;
	background:#FFF;
	border:1px solid #e5e5e5;
	border-style:none none solid none;
}
#user_info .list .xx .ico{
	outline:0px solid #FF0000;
	width:1em;
	height:1em;
	position:absolute;
	left:2em;
	top:1.5em;
}
#user_info .list .xx .span{
	outline:0px solid #FF0000;
	margin-left:3em;
	font-size:2em;
	
}

#user_info .list .xx .but{
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
		<center><span class="s_title">我的账户</span></center>
		<div class="right">
			<a href="../page/carListAction.action" class="a1 cart" title="购物车"></a>
		</div>
	</div>
</div>
<div id="user_info">
	<div class="user_img">
		<img src="../../../common/images/icon_s_09.png" />
		<div class="span" >${userBean.phone }<br /><br /><a href="../page/showUserExitAction.action">点击退出</a></div>
	</div>
	<div class="list">
		<ul class="center">
			<li class="xx">
				<div class="ico"><img src="../../../common/images/icon_s_10.png" /></div>
				<div class="span">订单查询</div>
				<div class="but" onclick="window.location.href='../page/showGordersListAction.action'"></div>
			</li>
			<li class="xx">
				<div class="ico"><img src="../../../common/images/icon_s_10.png" /></div>
				<div class="span">地址管理</div>
				<div class="but" onclick="window.location.href='../page/addr/addrTableAction.action'"></div>
			</li>
		</ul>
	</div>
	<div class="download"><img src="../../../common/images/icon_s_05.png" /></div>
</div>


</body>
</html>


