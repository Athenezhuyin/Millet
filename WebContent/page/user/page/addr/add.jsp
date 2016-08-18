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
<link rel="stylesheet" type="text/css" href="../../../../common/css/common.css">
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
	background:url(../../../../common/images/icon_home.png) no-repeat;
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
	background:url(../../../../common/images/icon_03.png) no-repeat;
	background-size:100% 100%;
}
#indexNum02 .index-head .right .cart{
	background:url(../../../../common/images/icon_02.png) no-repeat;
	background-size:100% 100%;
}

#user_dd{
	/*outline:1px solid #FF0000;background:#eee;*/
	padding-bottom:1em;
}
#user_dd .dd_center{
	width:90%;
	margin:0 auto;
}
#user_dd .dd_center .s1{
	font-size:1.4em;
	padding:0.4em 0px;
	color:#666;
}
#user_dd .dd_center .io_01{
	width:100%;
	border-radius:0.2em;
	border:1px solid #d3d4d6;
	font-size:1.4em;
	padding:0.4em 0px;
}
#user_dd .dd_center .select01{
	width:49%;
	border-radius:0.2em;
	border:1px solid #d3d4d6;
	font-size:1.6em;
	float:left;
}
#user_dd .dd_center .select02{
	width:100%;
	border-radius:0.2em;
	border:1px solid #d3d4d6;
	font-size:1.6em;
}
#user_dd .dd_center .text1{
	font-size:1.4em;
	width:100%;
	height:6em;
}

#user_dd .dd_center .io_02{
	width:100%;
	background:#ff6600;
	color:#FFF;
	border-radius:0.2em;
	font-size:2em;
	padding:0.4em 0px;
	border:0px;
}
</style>
<script type="text/javascript" src="../../../../common/js/check.js"></script>
<script type="text/javascript">
	function isPost(){
		var isPost = true;
		var street = $("street").value;
		if(street.length < 10){
			isPost=false;
			$("m_street").innerHTML="字数不够";
		} else {
			$("m_street").innerHTML="";
		}
		var postcode = $("postcode").value;
		if(!checkSecCode(postcode)){
			isPost=false;
			$("m_postcode").innerHTML="邮编格式不正确";
		} else {
			$("m_postcode").innerHTML="";
		}
		var phone = $("phone").value;
		if(!checkMobile(phone)){
			isPost=false;
			$("m_phone").innerHTML="手机号格式不正确";
		} else {
			$("m_phone").innerHTML="";
		}
		return isPost;
	}
	function $(id){
		return document.getElementById(id);
	}
</script>
</head>
<body>

<div id="indexNum02">
	<div class="index-head clearfix">
		<div class="left">
			<div class="home">
				<a href="userIndex.jsp" class="mall"></a>
			</div>
		</div>
		<center><span class="s_title">订单确认</span></center>

	</div>
</div>
<div id="user_dd">
	<form action="addrAddAction.action" method="get" onsubmit="return isPost();">
		<div class="dd_center">
			<div class="s1">收货人姓名</div>
			<input type="text" name="name" value="" class="io_01" placeholder="请填写真实姓名" />
			<div class="s1">收货地址</div>
			<div class="clearfix" style="padding:px 0px 0.4em 0px;">
				<select name="provinceid" id="province" onchange="getCity();" class="select01">
				</select>
				<select name="cityid" id="city" onchange="getDistrict();" class="select01" style="float:right;">
				</select>
			</div>
			<div style="height:1em;"></div>
			<select name="districtid" id="district" class="select02">
			</select>
			<div style="height:1em;"></div>
			<textarea id="street" name="street" class="text1" placeholder="路名或街道地址，门牌号，不少于10个字" value="12345678901234565"></textarea>
			<font color="red" id="m_street"></font>
			<div class="s1">邮政编码</div>
			<input type="text" id="postcode" name="postcode" class="io_01" placeholder="邮政编码，为6位数字" value="123456"/>
			<font color="red" id="m_postcode"></font>
			<div class="s1">手机号码</div>
			<input type="text" id="phone" name="phone" class="io_01" placeholder="联系人电话，11位数字" value="13345678901"/>
			<font color="red" id="m_phone"></font>
			<div style="height:1em;"></div>
			<input type="submit" class="io_02" value="确认完成" />
		</div>
	</form>
</div>
<br /><br /><br /><br />
</body>
<script type="text/javascript">
	getProvince();
	function getProvince(){
		 var xmlHttpRequest = new XMLHttpRequest();
		 xmlHttpRequest.open("get","jLAction.action?method=province");
		 xmlHttpRequest.onreadystatechange = function(){
			 if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
				 var data = eval(xmlHttpRequest.responseText);
				 var arr = [];
				 for(var i=0;i<data.length;i++){
					 arr.push("<option  value ='"+data[i][0]+"'>"+data[i][1]+"</option>");
				 }
				 document.getElementById("province").innerHTML=arr.join("");
			 }
			 getCity();
		 }
		 xmlHttpRequest.send(null);
	}
	
	
	function getCity(){
		 var xmlHttpRequest = new XMLHttpRequest();
		 xmlHttpRequest.open("get","jLAction.action?method=city&&id="+document.getElementById("province").value);
		 xmlHttpRequest.onreadystatechange = function(){
			 if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
				 var data = eval(xmlHttpRequest.responseText);
				 var arr = [];
				 for(var i=0;i<data.length;i++){
					 arr.push("<option  value ='"+data[i][0]+"'>"+data[i][1]+"</option>");
				 }
				 document.getElementById("city").innerHTML=arr.join("");
			 }
			 getDistrict();
		 }
		 xmlHttpRequest.send(null);
	}
	
	function getDistrict(){
		var xmlHttpRequest = new XMLHttpRequest();
		 xmlHttpRequest.open("get","jLAction.action?method=district&&id="+document.getElementById("city").value);
		 xmlHttpRequest.onreadystatechange = function(){
			 if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
				 var data = eval(xmlHttpRequest.responseText);
				 var arr = [];
				 for(var i=0;i<data.length;i++){
					 arr.push("<option  value ='"+data[i][0]+"'>"+data[i][1]+"</option>");
				 }
				 document.getElementById("district").innerHTML=arr.join("");
			 }
		 }
		 xmlHttpRequest.send(null);
		 
	}
</script>
</html>



