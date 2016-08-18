<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户登录</title>
<link href="images/login.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	font{color:red;margin-left: 60px;font-size:10px;}
</style>
<script type="text/javascript" src="../../../common/js/check.js"></script>
<script type="text/javascript">
	function login(){
		var isPost = true;
		var email = $("email").value;
		if(!isEmail(email)){
			$("m_email").innerHTML="邮箱格式不正确";
			isPost = false;
		} else {
			$("m_email").innerHTML="";
		}
		if(isPost){
			document.getElementById("form").submit();
		}
	}
	function $(id){
		return document.getElementById(id);
	}
</script>
</head>
<body>
    <div id="login">
	     <div id="top">
		      <div id="top_left"><img src="images/login_03.gif" /></div>
			  <div id="top_center"></div>
		 </div>
		 
		 <div id="center">
		      <div id="center_left"></div>
			  <div id="center_middle">
			  	<form action="adminLoginAction.action" id="form" method="post">
			       <div id="user">Email：
			         <input style="width:120px;height:20px" type="text" autocomplete="off" name="email" id="email" value="1@163.com"/><br/>
			         <font id="m_email">${error1 }</font>
			       </div>
				   <div id="password">密 码：
				     <input style="width:120px;height:20px" type="password" name="pwd" id="pwd" value="123456"/>
				   </div>
				   <div id="code">验证码：
				     <input style="width:120px;height:10px" type="text" autocomplete="off" name="code" id="code" onFocus="showCode();" onclick="showCode()" /><br/>
				     <font>${error }</font>
				   </div>	   
				   <div id="btn" >
						<img style="margin-top: 20px;width:120px;height:30px" title="看不清请刷新" src="adminCodeAction.action" onclick="this.src='adminCodeAction.action?num='+Math.random();" />
						<a href="javascript:login();">登录</a>
						<a href="login.jsp">重置</a>
				   </div>
				</form>	  
			  </div>
			  <div id="center_right"></div>		 
		 </div>
		 <div id="down">
		      <div id="down_left">
			      <div id="inf">
                       <span class="inf_text">版本信息</span>
					   <span class="copyright">中软创新综合管理系统 2015 v1.0</span>
			      </div>
			  </div>
			  <div id="down_center">
			  	<a href="forget.html">忘记密码！</a>
			  </div>		 
		 </div>
	</div>
</body>
</html>
