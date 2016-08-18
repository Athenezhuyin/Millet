<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.666666.com" prefix="j" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>订单管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../../main/css/right.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function search(){
		var code = document.getElementById("code").value;
		window.location.href="ordersTableAction.action?code="+code;
		}
	
	function del(id){
		if(window.confirm("你确定删除吗?")){
			window.location.href = "ordersDeleteAction.action?id="+id;
		}
	}
</script>
</head>
<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 订单管理 &rarr; <span>订单管理</span>
	</div>
	<div class="searchdiv">
		<div>订单编号：<input id="code" type="text" value="${param.code }"/></div><div class="btn1" onclick="search()">查 找</div>
		<div class="btn1" onclick="add.jsp'">添加</div>
	</div>
	<table class="table">
		<tr>
			<th style="width:50px;">序列号</th>
			<th style="width:150px;">订单编号</th>
			<th style="width:150px;">订单时间</th>
			<th style="width:150px;">订单状态</th>
			<th style="width:150px;">客户ID</th>
			<th style="width:100px;">操作</th>
		</tr>
        
       <c:forEach items="${list }" var="ordersBean" varStatus="in">
       		<tr>	
				<td align="center">${in.index+1 }</td>
				<td align="center">${ordersBean.code }</td>
				<td align="center">${ordersBean.time }</td>
				<td align="center">${ordersBean.state==0?"未付款":"已付款" }</td>
				<td align="center">${ordersBean.user_id }</td>
				<td align="center">
	            	<a href="ordersFindByIdAction.action?id=${ordersBean.id }"><div class="modify"  title="修改"></div></a>
	                <a href="javascript:del(${ordersBean.id })"><div class="del"   title="删除"></div></a>
	            </td>
			</tr>
		</c:forEach>
        
		<tr>
			<td colspan="6" valign="middle" style="background:#F6F6F6">
				<j:navigator/>
			</td>
		</tr>
	</table>

	
</body>


</html>
