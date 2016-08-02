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

<title>添加-更新-学生信息</title>

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
	<!--  ${requestScope.student }-->
	<form id="fm1"
		action="/neusoftsms/neusoft/crol/classinfoaction/insertOrUpdate"
		method="post">
		<table class="table_update">
			<tr>
				<td>班级编号：</td>
				<td>
				<cc:if test="${requestScope.classinfo==null }">
				${classinfo.clid }
				
				<input type="text" name="classinfo.clid" title="班级编号" notnull="true"  value="${classinfo.clid }">
				<input type="hidden" name="insertOrUpdate" value="insert1">
				</cc:if>
				<cc:if test="${requestScope.classinfo!=null }">
				
				${classinfo.clid }
				<input type="hidden" name="classinfo.clid" title="班级编号" value="${classinfo.clid }">
				<input type="hidden" name="insertOrUpdate" value="update">
				</cc:if>
				</td>

			</tr>

			<tr>
				<td>班级名称：</td>
				<td><input type="text" name="classinfo.clname" title="班级名称" notnull="true" value="${classinfo.clname }"></td>

			</tr>

			
			<tr>
				<td>开班日期：</td>
				<td><input type="text" class="date_picker" readonly="readonly"
					notnull="true" name="classinfo.clbegindate" title="开班日期"
					value='<fmt:formatDate value="${classinfo.clbegindate }" />'
					notnull="true"></td>

			</tr>
			<tr>
				<td>节课日期：</td>
				<td><input type="text" class="date_picker" readonly="readonly"
					notnull="true" name="classinfo.clenddate" title="节课日期"
					value='<fmt:formatDate value="${classinfo.clenddate }" />'
					notnull="true"></td>

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
