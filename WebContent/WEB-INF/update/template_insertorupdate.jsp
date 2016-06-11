<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>

<title>添加-更新-学生信息</title>


<%@include file="/WEB-INF/systemplate/head_update.jsp" %>

</head>

<body>
	<!--${requestScope.infoes }  -->
	<!--  ${requestScope.student }-->
	<form id="fm1"
		action=""
		method="post">
		<table class="table_update">
			<tr>
				<td>item1</td>
				<td>
				<cc:if test="${false }">
				
				${student.stid }
				<input type="hidden" name="student.stid" title="" value="">
				<input type="hidden" name="insertOrUpdate" value="update">
				</cc:if>
				<cc:if test="${false }">
				
				
				<input type="text" name="student.stid" title="编 号" notnull="true" value="">
				<input type="hidden" name="insertOrUpdate" value="">
				</cc:if>
				</td>

			</tr>

			<tr>
				<td>item2：</td>
				<td><input type="text" name="student.stname" title="姓 名" notnull="true" value=""></td>

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
			/**
			 * 指定表单加载客户端验证，通过自定义属性，指定验证
			 */
			$("#fm1").submit(function() {
							var ok = true;
							$(this).find("[notnull=true]").each(function() {
								if (isNull(this)) 
									ok = false;
								
							});
		});

	})();
</script>
</html>
