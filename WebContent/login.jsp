<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE>
<html>
<head>


<title>系统登陆</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#td1 {
	text-align: center;
	width: 400px;
	font-size: 13px;
	line-height: 40px;
	border: 1px solid #6188ae;
	border-radius: 6px;
}

li {
	list-style: none;
}

.wrap {
	margin-top: 200px;
	margin: auto;
	width: 1200px;
	margin-left: auto;
	margin-right: auto;
	height: 700px;
	background-image:
		url("/neusoftsms/imgs/caabd40224a257155ce4e94401664bc7.jpg");
	background-repeat: no-repeat;
	position: relative;
	left: 20px;
}

.wrap .wrap_table {
	width: 500px;
	padding-top: 165px;
	margin-left: auto;
	margin-right: auto;
}
</style>
<script type="text/javascript">
	<cc:if test="${requestScope.msg=='no'}">
	alert("您的用户名或密码错误");
	</cc:if>
	<cc:if test="${requestScope.msg=='exit'}">
	alert("用户已经安全退出，如需操作请重新登陆");
	</cc:if>
</script>
</head>


<body>


	<div class="wrap">
		<form id="fm1" action="/neusoftsms/neusoft/crol/logaction/login"
			method="post">
			<div class="wrap_table">
				<table id="td1">
					<tr>
						<td
							style="font-size: 20px; background-color: #668bb0; color: #ffffff"><img
							alt=""
							src="/neusoftsms/imgs/preferences_system_login_24px_541072_easyicon.net.ico"
							style="float: left; margin-top: 8px;">
							&nbsp;&nbsp;&nbsp;系统登陆</td>

					</tr>
					<tr>
						<td style="height: 150px;">
							<ul id="bg">
								<li>用户名：<input type="text" name="userinfo.logname"
									title="用户名" notnull="true"></li>
								<li>密 &nbsp;&nbsp;码：<input type="password"
									name="userinfo.keyword" title="密码" notnull="true"></li>
							</ul>
						</td>
					</tr>

					<tr style="background-color: #6188ae">

						<td style="text-align: center;">
							<button>
								<img alt=""
									src="/neusoftsms/imgs/Login_16px_583562_easyicon.net.ico">
								登录
							</button>
							<button type="reset">
								<img alt=""
									src="/neusoftsms/imgs/reset_16px_1067287_easyicon.net.ico">
								重置
							</button>
						</td>
					</tr>



				</table>
			</div>

		</form>


	</div>
</body>

</html>
