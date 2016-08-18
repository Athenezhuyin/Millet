<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.666666.com" prefix="j" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>管理员管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../../main/css/right.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../../../../common/js/check.js"></script>
<script type="text/javascript">
	function isPost(){
		var isPost = true;
		var email = $("email").value;
		if(!isEmail(email)){
			isPost=false;
			$("m_email").innerHTML="邮箱格式不正确";
		} else {
			$("m_email").innerHTML="";
		}
			
		return isPost;
	}
	function $(id){
		return document.getElementById(id);
	}
	function search(){
		var email = document.getElementById("email").value;
		window.location.href="adminTableAction.action?email="+email;
		}
</script>
</head>
<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 管理员管理 &rarr; <span>管理员管理</span>
	</div>
	<table class="table">
		<form action="adminAddAction.action" method="post" onsubmit="return isPost();" enctype="multipart/form-data">
		<tr>
			<th style="width:30px;">邮箱</th>
			<td style="width:150px;"><input style="width:80%" id="email" type="text" name="email" value=""/><font color="red" id="m_email"></font></td>
		</tr>
		<tr>
			<th style="width:30px;">密码</th>
			<td style="width:150px;"><input style="width:80%" type="password" name="pwd" value=""/></td>
		</tr>
		<tr>
			<th style="width:30px;">一寸照片</th>
			<td style="width:150px;"><input style="width:90%" type="file" name="image" value=""/></td>
		</tr>
		<tr>
			<th style="width:180px;" colspan="2"><input style="width:50%;align:center" type="submit" value="添加"/></th>
		</tr>
		</form>
	</table>

	
</body>


</html>
