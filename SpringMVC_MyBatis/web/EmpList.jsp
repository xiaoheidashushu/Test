<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>哈喽我的,欢迎${u.realname }</h1>
<table cellspacing="0" width="800px" border="1">
		<tr>
			<th>编号</th>
			<th>名字</th>
			<th>职位</th>
			<th>经理</th>
			<th>生日</th>
			<th>工资</th>
			<th>信息</th>
			<th>部门名字</th>
		</tr>
		<c:forEach var="emplist" items="${emplist }">
			<tr>
				<td>${emplist.empno }</td>
				<td>${emplist.ename }</td>
				<td>${emplist.job }</td>
				<td>${emplist.mgr }</td>
				<td><fmt:formatDate value="${emplist.hiredate }" pattern="yyyy-MM-dd"/></td>
				<td>${emplist.sal }</td>
				<td>${emplist.comm }</td>
				<td>${emplist.dept.dname }</td>
			</tr>

		</c:forEach>



	</table>
</body>
</html>