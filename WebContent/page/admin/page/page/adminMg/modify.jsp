<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../../main/css/right.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 管理员管理 &rarr; <span>管理员管理</span>
	</div>
	<table class="table">
		<form action="adminModifyAction.action" method="post">
		<input type="hidden" name="id" value="${adminBean.id }" />
		<tr>
			<th style="width:30px;">邮箱</th>
			<td style="width:150px;"><input style="width:90%" type="text" name="email" readonly="readonly" value="${adminBean.id }"/></th>
		</tr>
		<tr>
			<th style="width:30px;">密码</th>
			<td style="width:150px;"><input style="width:90%" type="password" name="pwd" value="${123456}"/></th>
		</tr>
		<tr>
			<th style="width:180px;" colspan="2"><input style="width:50%;align:center" type="submit" value="重置密码123456"/></th>
		</tr>
		</form>
	</table>

</body>
</html>