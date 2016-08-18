<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.666666.com" prefix="j" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>客户管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../../main/css/right.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function search(){
		var phone = document.getElementById("phone").phone;
		window.location.href="userTableAction.action?phone="+phone;
		}
	
	function del(id){
		if(window.confirm("你确定删除吗?")){
			window.location.href = "userDeleteAction.action?id="+id;
		}
	}
</script>
</head>
<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 用户管理 &rarr; <span>用户管理</span>
	</div>
	<div class="searchdiv">
		<div>客户手机号：<input id="phone" type="text" value="${param.phone }"/></div><div class="btn1" onclick="search()">查 找</div>
		<div class="btn1" onclick="window.location.href='add.jsp'">添加</div>
	</div>
	<table class="table">
		<tr>
			<th style="width:50px;">序列号</th>
			<th style="width:150px;">用户手机号</th>
			<th style="width:100px;">操作</th>
		</tr>
        
       <c:forEach items="${list }" var="userBean" varStatus="in">
       		<tr>	
				<td align="center">${in.index+1 }</td>
				<td align="center">${userBean.phone }</td>
				<td align="center">
	            	<a href="userFindByIdAction.action?id=${userBean.id }"><div class="modify"  title="修改"></div></a>
	                <a href="javascript:del(${userBean.id })"><div class="del"   title="删除"></div></a>
	            </td>
			</tr>
		</c:forEach>
        
		<tr>
			<td colspan="5" valign="middle" style="background:#F6F6F6">
				<j:navigator/>
			</td>
		</tr>
	</table>

	
</body>


</html>
