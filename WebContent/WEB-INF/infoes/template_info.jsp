<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>My JSP 'info_teacher.jsp' starting page</title>

<%@include file="/WEB-INF/systemplate/head_info.jsp" %>
</head>

<body>

	<div class="add_massage">
		<form action=""
			method="post">
			<button>添加</button>
		</form>
	</div>
	<form action=""
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
				<th>rowid</th>
				<th>rowid</th>
				<th>rowid</th>
				
				<form id="fm_batch"
					action=""
					method="post">
				<td>

					<button title="修改信息" type="submit">
						<img alt=""
							src="/neusoftsms/imgs/Delete_Ticket_16px_1192297_easyicon.net.ico">
					</button> <i>全选</i> <input type="checkbox" id="choosebt1">

				</td>

				</form>
			</tr>

		</thead>



		<tbody>
			<cc:forEach items="" var="" varStatus="vst">
				<tr>
					<td>${vst.count }</td>
					<td>${student.stid }</td>

					<form
						action=""
						method="post">
						<td>

							<button class="bt_update" name=""
								value="">
								${student.stname }
								<div>
									<img src="./imgs/Modify_16px_1060983_easyicon.net.ico">
								</div>
							</button>

						</td>
					</form>
					<td></td>
					<td><fmt:formatDate value="" /></td>
					<td></td>

					<form action=""
						method="post">
						<td>

							<button class="bt_delete" name="student.stid"
								value="${student.stid }">
								<div>
									<input type="hidden" name="pageNum"
										value="${requestScope.pageNum }"> <img
										src="/neusoftsms/imgs/Delete_16px_1181442_easyicon.net.ico">

								</div>
							</button>
					</form>



					<input type="checkbox" name="batch_list.stid"
						value="${student.stid }">

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
				$("[name='batch_list.stid']").prop("checked", this.checked);
			});

			$("#fm_batch").submit(function() {

				$("[name='batch_list.stid']").appendTo($(this));

				return window.confirm("是否删除选中的信息?");

			});

			//反选操作
			$("#choosebt2").click(function() {
				$("[name='batch_list.stid']").each(function() {
					this.checked = !this.checked;
				});
			});
		});
	})();
</script>
</html>
