<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.666666.com" prefix="j" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../../main/css/right.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function search(){
		var name = document.getElementById("name").value;
		window.location.href="goodsTableAction.action?name="+name;
		}
	
	function del(id){
		if(window.confirm("你确定删除吗?")){
			window.location.href = "goodsDeleteAction.action?id="+id;
		}
	}
</script>
</head>
<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 商品管理 &rarr; <span>商品管理</span>
	</div>
	<div class="searchdiv">
		<div>商品名称：<input id="name" type="text" value="${param.name }"/></div><div class="btn1" onclick="search()">查 找</div>
		<div class="btn1" onclick="window.location.href='goodsFindByGclassAllIdAction.action'">添加</div>
	</div>
	<table class="table">
		<tr>
			<th style="width:50px;">序列号</th>
			<th style="width:150px;">商品分类名称</th>
			<th style="width:150px;">商品名称</th>
			<th style="width:150px;">商品图片</th>
			<th style="width:150px;">商品价格</th>
			<th style="width:150px;">商品描述</th>
			<th style="width:100px;">操作</th>
		</tr>
        
       <c:forEach items="${list }" var="goodsBean" varStatus="in">
       		<tr>	
				<td align="center">${in.index+1 }</td>
				<td align="center">${goodsBean.gname }</td>
				<td align="center">${goodsBean.name }</td>
				<td align="center"><img width="100px" height="100px" src="${path }${goodsBean.image}"/></td>
				<td align="center">${goodsBean.price }</td>
				<td align="center">${goodsBean.description }</td>
				<td align="center">
	            	<a href="goodsFindByIdAction.action?id=${goodsBean.id }"><div class="modify"  title="修改"></div></a>
	                <a href="javascript:del(${goodsBean.id })"><div class="del"   title="删除"></div></a>
	            </td>
			</tr>
		</c:forEach>
        
		<tr>
			<td colspan="7" valign="middle" style="background:#F6F6F6">
				<j:navigator/>
			</td>
		</tr>
	</table>

	
</body>


</html>
