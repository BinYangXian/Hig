<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<base href="<%=basePath%>">
	</head>
	<body>
		<table style="width: 100%;border-collapse: collapse;" border="1">
			<tr>
				<th>Empno</th>
				<th>Ename</th>
				<th>Job</th>
				<th>Hiredate</th>
				<th>Mgr</th>
				<th>Deptno</th>
				<th>Sal</th>
				<th>Comm</th>
				<th>Operation</th>
			</tr>
			
			<c:forEach items="${emps }" var="e">
				<tr>
					<td>${e.empno }</td>
					<td>${e.ename }</td>
					<td>${e.job }</td>
					<td>${e.hiredate }</td>
					<td>${e.mgr }</td>
					<td>${e.deptno }</td>
					<td>${e.sal }</td>
					<td>${e.comm }</td>
					<td>
						<a href="empAction!updateEmpView.action?emp.empno=${e.empno }">update</a>
						<a href="">delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>