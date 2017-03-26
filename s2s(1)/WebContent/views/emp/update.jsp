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
		<style type="text/css">
			.info{
				padding: 3px 10px;
				border-bottom: 1px dotted #ececec;
			}
			
			.info label{
				display: inline-block;
				width: 100px;
				text-align: right;
			}
			
			.info label:AFTER {
				content: ':';
			}
		</style>
	</head>
	<body>
		<form action="empAction!updateEmp.action">
			<div class="info">
				<label>Empno</label>
				<input type="text" name="emp.empno" value="${emp.empno }">
			</div>
			<div class="info">
				<label>Ename</label>
				<input type="text" name="emp.ename" value="${emp.ename}">
			</div>
			<div class="info">
				<label>Job</label>
				<input type="text" name="emp.job" value="${emp.job }">
			</div>
			<div class="info">
				<label>Hiredate</label>
				<input type="text" name="emp.hiredate" value="${emp.hiredate }">
			</div>
			<div class="info">
				<label>Sal</label>
				<input type="text" name="emp.sal" value="${emp.sal }">
			</div>
			<div class="info">
				<label>Comm</label>
				<input type="text" name="emp.comm" value="${emp.comm }">
			</div>
			<div class="info">
				<label>Mgr</label>
				<input type="text" name="emp.mgr" value="${emp.mgr }">
			</div>
			<div class="info">
				<label>Deptno</label>
				<input type="text" name="emp.deptno" value="${emp.deptno }">
			</div>
			<div class="info" style="padding-left:113px;">
				<input type="submit" value="Submit">
			</div>
		</form>
	</body>
</html>