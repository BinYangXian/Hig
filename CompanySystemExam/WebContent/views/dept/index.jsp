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
							<th>部门地址</th>
						</tr>
						<c:forEach items="${depts}" var="dept">
							<tr>
								<td>${dept.deptno }</td>
								<td><a href="javascript:void(0);" data-deptno="${dept.deptno }">${dept.dname }</a></td>
								<td>${dept.loc }</td>
							</tr>
							<tr style="display: none" class="bg-success">
								<td colspan="3">
									<table class="table table-hover table-bordered">
										
									</table>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$(function(){
				$('table.table a[data-deptno]').bind('click',function(){
					var self = this;
					var deptno = $(this).data('deptno');
					var nextTr = $(this).parent().parent().next();
					var table = nextTr.find('table.table');
					nextTr.toggle();
					if(nextTr.is(':hidden')){
						table.html('');
					}else{
						$.ajax({
							url:'deptAction!findEmpVoByDeptno.action',
							data:{"deptno":deptno},
							dataType:'json',
							success:function(json){
								var header = "<tr><th>编号</th><th>姓名</th><th>工种</th><th>工资</th><th>奖金</th><th>日期</th><th>上级</th><th>部门</th></tr>"
								var content = "";
								$.each(json,function(i,emp){
									content = content+"<tr><td>"+emp.empno+"</td><td>"+emp.ename+"</td><td>"+emp.job+"</td><td>"+emp.sal+"</td><td>"+emp.comm+"</td><td>"+emp.hiredate+"</td><td>"+emp.mgr+"</td><td>"+emp.dept+"</td></tr>"
								})
								content = content || "<tr><td colspan=\"8\" class=\"text-center\">暂无数据</td></tr>"
								table.html(header+content);
							}
						})
					}
				})
				
			})
		</script>
	</body>
</html>