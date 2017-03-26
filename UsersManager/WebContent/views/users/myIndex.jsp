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
		<title>Insert title here</title>
		<base href="<%=basePath%>">
		<link href="assets/css/bootstrap.min.css" rel="stylesheet">
		<script type="text/javascript" src="assets/js/jquery.min.js"></script>
		<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
	</head>
	<body>
		
		<div class="navbar navbar-default">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">用户管理系统</a>
				</div>
		
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">首页 <span class="sr-only">(current)</span></a></li>
						<li><a href="#">关于我们</a></li>
					</ul>
		
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Admin <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">个人信息</a></li>
								<li><a href="#">修改密码</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">安全退出</a></li>
							</ul>
						</li>
					</ul>
				</div><!-- /.navbar-collapse -->
			</div><!-- /.container-fluid -->
		</div>
		
		<div class="container">
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading">用户列表<button class="btn btn-primary btn-sm pull-right" data-toggle="modal" data-target="#addUser" style="margin-top:-6px;"><i class="glyphicon glyphicon-plus"></i> 添加</button></div>
					<table class="table table-bordered table-hover">
						<tr>
							<th>ID</th>
							<th>用户名</th>
							<th>密码</th>
							<th>邮箱</th>
							<th>年龄</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${users }" var="user">
							<tr>
								<td>${user.id }</td>
								<td>${user.username }</td>
								<td>${user.password }</td>
								<td>${user.email }</td>
								<td>${user.age }</td>
								<td width="200">
									<a href="updateUser.jsp?mark=update&data={id:${user.id },username:${user.username },password:${user.password },email:${user.email },age:${user.age }}" >修改</a>
									<a href="usersAction?mark=del&id=${user.id }" class="btn btn-danger btn-sm"><i class="glyphicon glyphicon-trash"></i> 删除</a>
								</td>
							</tr>
						</c:forEach>
						
					</table>
					<div class="panel-footer">分页</div>
				</div>
			</div>
		</div>
		

		<div class="modal fade" id="addUser" tabindex="-1" role="dialog" aria-labelledby="addUserLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h5 class="modal-title" id="myModalLabel">添加用户</h4>
					</div>
					<div class="modal-body">
						<form action="usersAction?mark=add" method="post" >
							账号：&nbsp<input type="text" name="id"><br/>
							用户名：<input type="text" name="username"><br/>
							密码：&nbsp<input type="text" name="password"><br/>
							email：<input type="text" name="email"><br/>
							年龄：&nbsp<input type="text" name="age">
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="submitForm()">提交</button>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
	<script>
		function submitForm(){
		/* 	$('input').each(function(){
				$(this).get(0).onblur=function(){
					if($(this).get(0).value==""){
						$(this).get(0).append($(this).get(0).name+'<h5>不能为空</h5>')
					}
				}
			}) */
			($('form')).get(0).submit();
		}
	</script>