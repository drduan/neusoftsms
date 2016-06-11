<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>

<title>添加-更新-老师信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="/neusoftsms/dt_picker/dt_picker.css">
<script type="text/javascript"
	src="/neusoftsms/dt_picker/jquery-2.1.1.min.js"></script>
<script type="text/javascript"
	src="/neusoftsms/dt_picker/jquery.date_input.pack.js"></script>
<link type="text/css" rel="stylesheet"
	href="/neusoftsms/css/insert_student.css">
</head>

<body>
	<!--${requestScope.infoes }  -->
	<!--  ${requestScope.teacher }-->
	<form id="fm1"
		action="/neusoftsms/neusoft/crol/teacheraction/insertOrUpdate"
		method="post">
		<table class="table_update">
			<tr>
				<td>讲师工号：</td>
				<td>
				<cc:if test="${requestScope.teacher!=null }">
				
				${teacher.tid }
				<input type="hidden" name="teacher.tid" title="编 号" value="${teacher.tid }">
				<input type="hidden" name="insertOrUpdate" value="update">
				</cc:if>
				<cc:if test="${requestScope.teacher==null }">
				
				${teacher.tid }
				<input type="text" name="teacher.tid" title="编 号" notnull="true" value="${teacher.tid }">
				<input type="hidden" name="insertOrUpdate" value="insert1">
				</cc:if>
				</td>

			</tr>

			<tr>
				<td>讲师姓名：</td>
				<td><input type="text" name="teacher.tname" title="姓 名" notnull="true" value="${teacher.tname }"></td>

			</tr>


			<tr>
				<td>讲师年龄：</td>
				<td><input type="text" name="teacher.tage" title="年 龄" notnull="true" value="${teacher.tage }"></td>

			</tr>

			
			<tr>
				<td colspan="2">
					<hr />
					<div class="btn_submit">
						<input type="submit" name="" value="提交"> <input
							type="reset" name="">
					</div>
				</td>

			</tr>

		</table>
		<cc:if test="${requestScope.teacher!=null }">
		
		</cc:if>
	</form>
</body>
<script type="text/javascript">
	(function() {
		$("").ready(function() {
			$('.date_picker').date_input();

			$("#fm1").submit(function() {
				var ok = true;
				$(this).find("[notnull=true]").each(function() {
					if (isNull(this)) 
						ok = false;
					
				});
			/* 用于进行非空验证的方法*/
				function isNull(ipt) {
					$(ipt).next(".validate_1").remove();
					if (ipt.value=="") {
						$(ipt).after("<span class='validate_1'><img src='/neusoftsms/imgs/Warning_16px_1186332_easyicon.net.ico'>"+ipt.title+"不能为空</span>");
						$(ipt).next(".validate_1").css({
							left:$(ipt).offset().left-7,
							top:$(ipt).offset().top-2
						}).fadeIn(300);
						$(ipt).next().click(function(){
							$(this).fadeOut(200,function(){
								$(ipt).focus();
							});
							
						});
						return true;
					}
						return false;
				}
				return ok;
			});

		});

	})();
</script>
</html>
