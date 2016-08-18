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
</script>
</head>
<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 商品管理 &rarr; <span>商品管理</span>
	</div>
	<table class="table">
		<form action="goodsAddAction.action" method="post" enctype="multipart/form-data">
		<tr>
			<th style="width:30px;">商品分类名字</th>
			<td style="width:150px;">
				<select name="gclass_id">
					<c:forEach items="${list }" var="gclassBean">
						<option value="${gclassBean.id }">${gclassBean.name }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th style="width:30px;">商品名字</th>
			<td style="width:150px;"><input style="width:90%" type="text" name="name" value=""/></td>
		</tr>
		<tr>
			<th style="width:30px;">商品图片</th>
			<td style="width:150px;"><input style="width:90%" type="file" name="image" value=""/></td>
		</tr>
		<tr>
			<th style="width:30px;">商品价格</th>
			<td style="width:150px;"><input style="width:90%" type="text" name="price" value=""/></td>
		</tr>
		<tr>
			<th style="width:30px;">商品描述</th>
			<td style="width:150px;"><input style="width:90%" type="text" name="description" value=""/></td>
		</tr>
		<tr>
			<th style="width:180px;" colspan="2"><input style="width:50%;align:center" type="submit" value="添加"/></th>
		</tr>
		</form>
	</table>

	
</body>


</html>
