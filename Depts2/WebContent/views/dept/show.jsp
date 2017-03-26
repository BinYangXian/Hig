<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>部门管理</title>
		<base href="<%=basePath%>">
		<link href="assets/css/bootstrap.min.css" rel="stylesheet">
		<script type="text/javascript" src="assets/js/jquery.min.js"></script>
		<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">员工管理系统</a>
				</div>

				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">首页 <span class="sr-only">(current)</span></a></li>
						<li><a href="#">关于我们</a></li>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="container">
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading">部门列表</div>
					<table class="table table-hover table-bordered">
						<tr>
							<th>部门编号</th>
							<th>部门名称</th>
							<th>员工列表</th>
							<th>部门地址</th>
						</tr>
						<c:forEach items="${depts}" var="dept">
							<tr>
								<td>${dept.deptno }</td>
								<td><a href="javascript:void(0);" data-deptno="${dept.deptno }">${dept.dname }</a></td>
								<td>
									<c:forEach items="${dept.emps }" var="emp">
										${emp.ename },
									</c:forEach>
								</td>
								<td>${dept.loc }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>