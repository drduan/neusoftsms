<%@page import="com.sun.xml.internal.bind.v2.TODO"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
// neusoftsms

System.out.print(path);
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
//@@@httpserverName localhost serverport8080
//System.out.print("@@@"+ request.getScheme()+"serverName"+request.getServerName()+"serverport"+request.getServerPort());
%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
<body>
${param.er}
	<form action="/neusoftsms/neusoft/crol/teacherAction_getInfo"
		method="post">
		tid:<input type="text" name="teacher.tid"> tname:<input
			type="text" name="teacher.tname"> tage:<input type="text"
			name="teacher.tage">
		<button>ok</button>
	</form>
</body>
</html>
