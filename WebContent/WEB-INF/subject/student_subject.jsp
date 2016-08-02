<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<title>My JSP 'info_teacher.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link type="text/css" rel="stylesheet" href="./css/student_subject.css">
<script type="text/javascript"
	src="/neusoftsms/sysjs/jquery-2.1.1.min.js"></script>
</head>

<body>
	<div style="width:650px;float:left;">
		<i style="color:red;">学生姓名：</i> <i
			style="font-style:normal; font-weight: bold;">${student.stname }</i>
		&nbsp; <i style="color:red;">所在班级：</i><i
			style="font-style:normal; font-weight: bold;">${student.classinfo.clname }</i>
	</div>
	<div class="btn_sub1">
		
		<button id="button_sub" style="width:50px;float:left;">保存</button>
		
	<form action="/neusoftsms/neusoft/crol/studentaction/toSubject"
			method="post" style="width:50px;float:left;">
			<button name="student.stid" value="${student.stid }">重置</button>
	</form>
	</div>
	
	<hr style="clear: both;">
	<div class="sub_title">
		<div class="sub_title_left">已选课程</div>
		<div class="sub_title_right">未选课程</div>
	</div>

	<form id="fm_submit" action="/neusoftsms/neusoft/crol/studentaction/updateSubjectOfStudent" method="post">
		<input type="hidden" name="student.stid"value="${student.stid }">
		<div id="dv1">
			<cc:forEach items="${subjects_now }" var="StudentAndSubject">
				<div>
					${StudentAndSubject.id.subjectinfo.subname}
					<button type="button">
						<img src="/neusoftsms/imgs/arrow_right_16px_533384_easyicon.net.ico">
					<input type="hidden"name="sub_infos.subid"
						value="${StudentAndSubject.id.subjectinfo.subid}">
					</button>
					

				</div>
			</cc:forEach>
	</div>
</form>
	<div id="dv2">

		<cc:forEach items="${subjects_all }" var="subject">

			<div>
				${subject.subname}
				<button type="button">
					<img src="/neusoftsms/imgs/arrow_left_16px_533383_easyicon.net.ico">
				<input type="hidden"name="sub_infos.subid"
						value="${subject.subid}">
				</button>

			</div>
		</cc:forEach>

	</div>

	<hr style="clear:both; margin-top:50px;">
	<pre style="font-size: 12px;color:red;line-height: 20px;">
操作说明：
	    1、点击左右箭头实现课程调整。
	    2、点击保存按钮进行已选课程的保存。
	    3、在没有提交操作之前可以点击重置按钮恢复原有状态。
	
	</pre>
</body>
<script type="text/javascript">
	(function() {
		$("")
				.ready(
						function() {
							$("#dv1>div>button,#dv2>div>button")
									.click(
											function() {

												if ($(this).parent().parent()[0].id == "dv1") {
													$(this).children("img").css("float","left");
													$(this).children("img").attr("src","/neusoftsms/imgs/arrow_left_16px_533383_easyicon.net.ico");
													$("#dv2").append(
															$(this).parent());
												} else {
													$(this).children("img")
															.css("float",
																	"right");
													$(this)
															.children("img")
															.attr("src",
																	"/neusoftsms/imgs/arrow_right_16px_533384_easyicon.net.ico");
													$("#dv1").append(
															$(this).parent());
												}

											});
	  		$("#button_sub").click(function(){
	  			$("#fm_submit")[0].submit();
	  		});
		});
	})();
</script>

</html>
