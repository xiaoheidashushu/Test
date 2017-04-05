<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
$(function(){
	$("#uname").blur(function(){
		if ($("#uname").val()=="") {
			$("#myspan").html("<font color='red' size='2'>用户名不能为空</font>");
		}
	});
});
</script>
<base href="<%=basePath %>">
<body>
	<h1>哈喽我的</h1>
	<form action="uc/islogin" method="post">
		用户名：<input type="text" value="zhangsan" name="username" id="uname" />
		<span id="myspan"></span><br> 密码<input type="text" value="123"
			name="userpassword" /> <br> <input type="submit" value="登入" />
	</form>
</body>
</html>