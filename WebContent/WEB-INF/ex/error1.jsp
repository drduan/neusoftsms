<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	isErrorPage="true"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'error1.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#err {
	font-size: 16px;
	font-family: 黑体;
	font-weight: bold;
	margin-left: 20px;
	margin-top: 40px;
}

#messages {
	font-size: 36px;
	font-weight: bold;
	font-family: 黑体;
	color: #ff0000;
	box-shadow: 0px 6px 6px gray;
	width: 300px;
	height: 80px;
	border-radius: 26px;
	line-height: 80px;
	text-align: center;
	background-color: #ffffcc;
	letter-spacing: 16px
}
#second{color:red;font-size:16px;font-family:fantasey;}
</style>
<script type="text/javascript"
	src="/neusoftsms/sysjs/jquery-2.1.1.min.js"></script>
</head>

<body>
	<div id="messages">系统提示</div>
	<div id="err">
		<%=exception != null
					? exception.getMessage()
					: "您所请求的页码内容不存在，请检查操作！"%>
		系统将于<span id="second"></span>秒钟之后<a
			href="http://macbookpro:8080/neusoftsms/index.jsp">转回主页</a>
	</div>

</body>
<script type="text/javascript">
	(function() {
		var second=60;
		$("").ready(function() {
			window.setInterval(function(){
			if(second==0){
				window.location.href="http://macbookpro:8080/neusoftsms/index.jsp"
			}
			$("#second").html(second--);
			}, 1000);
		});
	})();
</script>
</html>
