<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>TOP</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	window.setInterval(go, 1000);
	function go(){
		var date = new Date();
		var time = date.toLocaleString();
		document.getElementById("time").innerHTML = time;
	}
</script>
</head>

<body>
<div id="top">
	      <div id="logo"></div>
		  <div id="user">【欢迎您】：${adminBean.email }【IP】：admin【今天】：<font id="time"></font></div>	 
	 </div>
</body>
</html>
