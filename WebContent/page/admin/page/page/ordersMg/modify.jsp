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
		您现在所在的位置：首页 &rarr; 订单管理 &rarr; <span>订单管理</span>
	</div>
	<table class="table">
		<form action="ordersModifyAction.action" method="post">
		<input type="hidden" name="id" value="${ordersBean.id }" />
		<tr>
			<th style="width:30px;">订单编号</th>
			<td style="width:150px;"><input style="width:90%" type="text" name="code" readonly="readonly" value="${ordersBean.code }"/></td>
		</tr>
		<tr>
			<th style="width:30px;">订单时间</th>
			<td style="width:150px;"><input style="width:90%" type="datetime" name="time" value=""/></td>
		</tr>
		<tr>
			<th style="width:30px;">订单状态</th>
			<td style="width:150px;"><select name="state"><option>未付款</option><option>已付款</option></select></td>
		</tr>
		<tr>
			<th style="width:30px;">用户ID</th>
			<td style="width:150px;"><input style="width:90%" type="text" name="user_id" value=""/></td>
		</tr>
		<tr>
			<th style="width:180px;" colspan="2"><input style="width:50%;align:center" type="submit" value="修改"/></th>
		</tr>
		</form>
	</table>

</body>
</html>