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
		您现在所在的位置：首页 &rarr; 商品管理 &rarr; <span>商品管理</span>
	</div>
	<table class="table">
		<form action="goodsModifyAction.action" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${goodsBean.id }" />
		<tr>
			<th style="width:30px;">商品名称</th>
			<td style="width:150px;"><input style="width:90%" type="text" name="name" value="${goodsBean.name }"/></td>
		</tr>
		<tr>
			<th style="width:30px;">商品价格</th>
			<td style="width:150px;"><input style="width:90%" type="text" name="price" value="${goodsBean.price }"/></td>
		</tr>
		<tr>
			<th style="width:30px;">商品图片</th>
			<td style="width:150px;"><input style="width:90%" type="file" name="image" value=""/></td>
		</tr>
		<tr>
			<th style="width:180px;" colspan="2"><input style="width:50%;align:center" type="submit" value="修改"/></th>
		</tr>
		</form>
	</table>

</body>
</html>