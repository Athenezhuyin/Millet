<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.666666.com" prefix="j" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>地址管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../css/right.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function del(id){
		if(window.confirm("你确定删除吗?")){
			window.location.href = "addrDeleteAction.action?id="+id;
		}
	}
</script>
</head>
<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr;地址管理 &rarr; <span>地址管理</span>
	</div>
	<div class="searchdiv">
		<div class="btn1" onclick="window.location.href='../userIndex.jsp'">返回</div>
		<div class="btn1" onclick="window.location.href='add.jsp'">添加</div>
	</div>
	<table class="table">
		<tr>
			<th style="width:50px;">序列号</th>
			<th style="width:300px;">地址</th>
			<th style="width:150px;">邮编</th>
			<th style="width:150px;">电话号</th>
			<th style="width:50px;">操作</th>
		</tr>
        
       <c:forEach items="${list }" var="addrBean" varStatus="in">
       		<tr>	
				<td align="center">${in.index+1 }</td>
				<td align="center">${addrBean.province }${addrBean.city }${addrBean.district }${addrBean.street }</td>
				<td align="center">${addrBean.postcode }</td>
				<td align="center">${addrBean.phone }</td>
				<td align="center">
	            	<a href="javascript:del(${addrBean.id })"><div class="del"   title="删除"></div></a>
	            </td>
			</tr>
		</c:forEach>
	</table>

	
</body>


</html>
