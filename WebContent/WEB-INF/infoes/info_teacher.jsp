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

<link type="text/css" rel="stylesheet" href="./css/info.css">
<script type="text/javascript"
	src="/neusoftsms/sysjs/jquery-2.1.1.min.js"></script>
</head>

<body>
	<div class="add_massage">
		<form action="/neusoftsms/neusoft/crol/teacheraction/toInsertOrUpdate"
			method="post">
			<button>添加</button>
		</form>
	</div>
	<form action=""/neusoftsms/neusoft/crol/teacheraction/getInfo""
		method="post">
		<div class="bt_cotr">
			<button name="pageNum" value="1">首页</button>
			<button name="pageNum" value="${requestScope.pageNum-1 }">上页</button>
			<button name="pageNum" value="${requestScope.pageNum+1 }">下页</button>
			<button name="pageNum" value="${requestScope.pageCount }">尾页</button>
		</div>
	</form>

	<table class="tb">

		<thead class="tb_th">

			<tr>
			    <th></th>
				<th>编号</th>
				<th>姓名</th>
				<th>年龄</th>
				<form id="fm_batch"
					action="/neusoftsms/neusoft/crol/teacheraction/delete"
					method="post">
				<td>

					<button title="批量删除信息" type="submit">
						<img alt=""
							src="/neusoftsms/imgs/Delete_Ticket_16px_1192297_easyicon.net.ico">
					</button> <i>全选</i> <input type="checkbox" id="choosebt1">

				</td>

				</form>
			</tr>

		</thead>



		<tbody>
			<cc:forEach items="${requestScope.infoes }" var="teacher" varStatus="vst">
				<tr>
					<td>${vst.count }</td>
					<td>${teacher.tid }</td>
		
					<form
						action="/neusoftsms/neusoft/crol/teacheraction/toInsertOrUpdate"
						method="post">
						<td>

							<button class="bt_update" name="teacher.tid"
								value="${teacher.tid }">
								${teacher.tname }
								<div>
									<img src="./imgs/Modify_16px_1060983_easyicon.net.ico">
								</div>
							</button>

						</td>
					</form>
					<td>${teacher.tage }</td>
					<form action="/neusoftsms/neusoft/crol/teacheraction/delete"
						method="post">
						<td>

							<button class="bt_delete" name="teacher.tid"
								value="${teacher.tid }">
								<div>
									<input type="hidden" name="pageNum"
										value="${requestScope.pageNum }"> <img
										src="./imgs/Delete_16px_1181442_easyicon.net.ico">

								</div>
							</button>
					</form>



					<input type="checkbox" name="batch_list.tid"
						value="${teacher.tid }" >

					</td>

				</tr>
		</tbody>
		</cc:forEach>

	</table>


</body>
</form>
<script type="text/javascript">
	(function() {
		$("").ready(function() {
			$(".bt_delete").click(function() {
				return window.confirm("是否确认删除？");
			});

			$("#choosebt1").click(function() {
				$("[name='batch_list.tid']").prop("checked", this.checked);
			});

			$("#fm_batch").submit(function() {

				$("[name='batch_list.tid']").appendTo($(this));

				return window.confirm("是否删除选中的信息?");

			});

			//反选操作
			$("#choosebt2").click(function() {
				$("[name='batch_list.tid']").each(function() {
					this.checked = !this.checked;
				});
			});
		});
	})();
</script>
</html>
