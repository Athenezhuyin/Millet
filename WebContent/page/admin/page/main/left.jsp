<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="../../../../common/js/jquery-1.7.2.min.js"></script>
</head>
<body>
	<div id="left">
		<div id="left_menu"></div>
		<div id="left_tree">
			<div id="tree_text">
				<ul id="globalNav">
					<li>
						<a>管理员管理</a>
						<ul>
							<li>
								<a class="a" href="../page/adminMg/adminTableAction.action" target="right">管理员管理</a>
							</li>
						</ul>
					</li>
					
					<li>
						<a>商品分类管理</a>
						<ul>
							<li>
								<a class="a" href="../page/gclassMg/gclassTableAction.action" target="right">商品分类管理</a>
							</li>
						</ul>
					</li>
					<li>
						<a>商品管理</a>
						<ul>
							<li>
								<a class="a" href="../page/goodsMg/goodsTableAction.action" target="right">商品管理</a>
							</li>
						</ul>
					</li>
					<li>
						<a>客户管理</a>
						<ul>
							<li>
								<a class="a" href="../page/userMg/userTableAction.action" target="right">用户管理</a>
							</li>
						</ul>
					</li>
					<li>
						<a>订单管理</a>
						<ul>
							<li>
								<a class="a" href="../page/ordersMg/ordersTableAction.action" target="right">订单管理</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
		<div id="tree_down"/>
     </div>
</body>
</html>

<script type="text/javascript">
$(function(){
	initHeight();
	$("#globalNav").children().each(function(index){
		var item = $(this);
		var tag_a = item.children().eq(0);
		tag_a.attr("href", "#this");
		var tag_ul = item.children().eq(1);
		if(index == 0) {
			tag_ul.show();
		}
		tag_a.click(function(){
			tag_ul.toggle();
		});
	});
	
	$(".a").click(function(){
		$(".a").css({"color":"black", "font-weight":"normal"});
		$(this).css({"color":"red", "font-weight":"bold"});
	});
})
window.onresize=function() {
	initHeight();
}
function initHeight(){
	$("#left_tree").css("height", document.documentElement.clientHeight-80);
	$("#tree_text").css("height", document.documentElement.clientHeight-80);
}
</script>
