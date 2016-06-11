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
		action="/neusoftsms/neusoft/crol/studentaction/insertOrUpdate"
		method="post">
		<table class="table_update">
			<tr>
				<td>编 号：</td>
				<td>
				<cc:if test="${requestScope.student!=null }">
				
				${student.stid }
				<input type="hidden" name="student.stid" title="编 号" value="${student.stid }">
				<input type="hidden" name="insertOrUpdate" value="update">
				</cc:if>
				<cc:if test="${requestScope.student==null }">
				
				${student.stid }
				<input type="text" name="student.stid" title="编 号" notnull="true" value="${student.stid }">
				<input type="hidden" name="insertOrUpdate" value="insert1">
				</cc:if>
				</td>

			</tr>

			<tr>
				<td>姓 名：</td>
				<td><input type="text" name="student.stname" title="姓 名" notnull="true" value="${student.stname }"></td>

			</tr>

			<tr>
				<td>性 别：</td>
				<td><input type="radio" value="1" ${student.stsex==1?"checked='checked'":" " } checked="checked"
					name="student.stsex" > <span><img
						src="/neusoftsms/imgs/user_male_24px_1185717_easyicon.net.ico"></span> 
						<input type="radio" value="2" ${student.stsex==2?"checked='checked'":" " } name="student.stsex"><span><img
						src="/neusoftsms/imgs/Woman_24px_1176979_easyicon.net.ico"></span></td>
			</tr>

			<tr>
				<td>生 日：</td>
				<td><input type="text" class="date_picker" readonly="readonly"
					notnull="true" name="student.stbirthday" title="生 日"
					value='<fmt:formatDate value="${student.stbirthday }" />'
					notnull="true"></td>

			</tr>

			<tr>
				<td>班 级：</td>
				<td><select name="student.classinfo.clid">
						<cc:forEach items="${requestScope.infoes }" var="classinfo">
							<option value="${classinfo.clid }"
							${student.classinfo.clid==classinfo.clid?"selected='selected'":"" }
							
							>${classinfo.clname }</option>
						</cc:forEach>
				</select></td>

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
		<cc:if test="${requestScope.student!=null }">
		
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
