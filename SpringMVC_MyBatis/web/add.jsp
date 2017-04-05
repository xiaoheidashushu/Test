<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
$(function(){
	$("#ename").keyup(function(){
		//{"ename":$("#ename").val()}
		$.post("ec/fe","ename="+$("#ename").val(),function(data){
			console.log(typeof(data));
			if(data){
				$("#nameinfo").html("<font color='red' size='2'><b>用户名已经存在</b></font>");
			}else{
				$("#nameinfo").html("<font color='green' size='2'><b>用户名可以使用</b></font>");
			}
		},"json");
	});
});

</script>
<body>
<form>
	姓名：
	<input type="text" value="zhangsan" name="ename" id="ename"/>
	<span id="nameinfo"></span>
	<br> 职业：
	<input type="text" value="工程师" name="job" />
	<br> 生日:
	<input type="text" value="2017-3-30" name="hiredate" />
	<br> 
	<%-- 部门：
	<select>
		<c:forEach items="" var="">
			<option value=""></option>
		</c:forEach>
	</select> --%>
	<input type="submit" value="添加" />
	
	</form>
</body>
</html>