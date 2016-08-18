<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.666666.com" prefix="j" %>
<!DOCTYPE html>
<html>
<head>
<title>订单管理</title>
<meta charset=UTF-8" >
<link href="../../main/css/right.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="../../../../common/css/jquery.datetimepicker.css"/ >
<script src="../../../../common/js/jquery-1.7.2.min.js"></script>
<script src="../../../../common/js/jquery.datetimepicker.full.min.js"></script>
<script>
	$('#datetimepicker').datetimepicker({
	dayOfWeekStart : 1,
	lang:'en',
	disabledDates:['1986/01/08','1986/01/09','1986/01/10'],
	startDate:	'1986/01/05'
	});
	function search(){
		var code = document.getElementById("code").value;
		window.location.href="ordersTableAction.action?code="+code;
		}

</script>
</head>
<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 订单管理 &rarr; <span>订单管理</span>
	</div>
	<table class="table">
		<form action="ordersAddAction.action" method="post">
		<tr>
			<th style="width:30px;">订单编号</th>
			<td style="width:150px;"><input style="width:90%" type="text" name="code" value=""/></th>
		</tr>
		<tr>
			<th style="width:30px;">订单时间</th>
			<td style="width:150px;"><input style="width:90%" id="datetimepicker" type="text" name="time" value=""/></td>
		</tr>
		<tr>
			<th style="width:30px;">订单状态</th>
			<td style="width:150px;"><select name="state"><option>未付款</option><option>已付款</option></select></td>
		</tr>
		<tr>
			<th style="width:30px;">客户ID</th>
			<td style="width:150px;"><input style="width:90%" type="text" name="user_id" value=""/></td>
		</tr>
		<tr>
			<th style="width:180px;" colspan="6"><input style="width:50%;align:center" type="submit" value="添加"/></th>
		</tr>
		</form>
	</table>

	
</body>


</html>
