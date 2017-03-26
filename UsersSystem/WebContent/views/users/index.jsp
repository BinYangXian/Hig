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
					<a class="navbar-brand" href="#">员工管理系统</a>
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
					<div class="panel-heading">员工列表<button class="btn btn-primary btn-sm pull-right" data-toggle="modal" data-target="#addUser" style="margin-top:-6px;"><i class="glyphicon glyphicon-plus"></i> 添加</button></div>
					<table class="table table-bordered table-hover">
						<tr>
							<th>员工编号</th>
							<th>员工名字</th>
							<th>职位</th>
							<th>上司编号</th>
							<th>入职时间</th>
							<th>薪水</th>
							<th>奖金</th>
							<th>部门编号</th>
						</tr>
						<c:forEach items="${emps }" var="e">
							<tr>
								<td>${e.empno }</td>
								<td>${e.ename }</td>
								<td>${e.job }</td>
								<td>${e.mgr }</td>
								<td>${e.hiredate }</td>
								<td>${e.sal }</td>
								<td>${e.comm }</td>
								<td>${e.deptno }</td>
								<td width="200">
									<button class="btn btn-warning btn-sm" data-emps-empno="${e.empno }" data-toggle="modal" data-target="#updateUser" ><i class="glyphicon glyphicon-pencil"></i> 修改</button>
									<a href="usersAction!delete?emp.empno=${e.empno }" class="btn btn-danger btn-sm"><i class="glyphicon glyphicon-trash"></i> 删除</a>
								</td>
							</tr>
						</c:forEach>
						
					</table>
					<div class="panel-footer">分页</div>
				</div>
			</div>
		</div>
		
		<form action="usersAction!save" method="post" class="form-horizontal">
			<div class="modal fade" id="addUser" tabindex="-1" role="dialog" aria-labelledby="addUserLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							<h5 class="modal-title" id="addUserLabel">添加员工</h5>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label class="col-sm-2 control-label">员工姓名</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="emp.ename" placeholder="员工姓名">
									<!-- <input type="hidden" name="emp.ename" > -->
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">职位</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="emp.job" placeholder="员工姓名">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">上司编号</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="emp.mgr" placeholder="员工姓名">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">入职时间</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="emp.hiredate" placeholder="员工姓名">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">薪水</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="emp.sal" placeholder="员工姓名">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">奖金</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="emp.comm" placeholder="员工姓名">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">部门编号</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="emp.deptno" placeholder="员工姓名">
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"  data-dismiss="modal">取消</button>
							<button type="submit" class="btn btn-primary">提交</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		
		<form action="usersAction!update" method="post" class="form-horizontal">
			<div class="modal fade" id="updateUser" tabindex="-1" role="dialog" aria-labelledby="updateUserLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							<h5 class="modal-title" id="updateUserLabel">修改信息</h5>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label class="col-sm-2 control-label">员工姓名</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="emp.ename" placeholder="员工姓名">
									<input type="hidden" name="emp.empno" >
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">职位</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="emp.job" placeholder="员工姓名">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">上司编号</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="emp.mgr" placeholder="员工姓名">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">入职时间</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="emp.hiredate" placeholder="员工姓名">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">薪水</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="emp.sal" placeholder="员工姓名">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">奖金</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="emp.comm" placeholder="员工姓名">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">部门编号</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="emp.deptno" placeholder="员工姓名">
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
							<button type="submit" class="btn btn-primary">提交</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		
		<script type="text/javascript">
			$(function(){
				$('table.table [data-toggle="modal"]').bind('click',function(){
					var empno = $(this).data('emps-empno');
					var target = $($(this).data('target'));
					$.ajax({
						url:'usersAction!findById',
						data:{'emp.empno':empno},
						dataType:'json',
						success:function(json){
							target.find('.modal-body :input').each(function(i,o){
								var colName=o.name;
								var index=colName.indexOf(".");
								//alert(colName.substr(index+1,colName.length-index));
								$(o).val(json[colName.substr(index+1,colName.length-index)]);
							});
						}
					})
				})
				
			})
		</script>
	</body>
</html>