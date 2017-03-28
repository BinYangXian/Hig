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
		<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
	</head>
	<body>
		<div class="navbar navbar-default" role="navigation">
		  <div class="container">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#">选课管理</a>
		    </div>
		
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		        <li class="active"><a href="studentAction">学生首页</a></li>
		        <li ><a href="courseAction">课程首页</a></li>
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</div>
		
		<div class="container">
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading">学生列表<button class="btn btn-primary btn-sm pull-right" data-toggle="modal" data-target="#addStudent" style="margin-top: -5px;">添加学生</button></div>
					<table class="table table-hover table-bordered">
						<tr>
							<th>学生编号</th>
							<th>学生姓名</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${students }" var="stu">
							<tr>
								<td>${stu.stuId }</td>
								<td>${stu.stuName }</td>
								<td>
									<a href="courseAction!choose?stuId=${stu.stuId }" class="btn btn-primary btn-sm">选课</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		
		<!-- Modal -->
	<div class="modal fade" id="addStudent" tabindex="-1" role="dialog" aria-labelledby="addStudentLabel" aria-hidden="true">
	  <form action="studentAction!save" class="form-horizontal" method="post">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="addStudentLabel">添加学生</h4>
	      </div>
	      <div class="modal-body">
	         <div class="form-group">
			    <label class="col-sm-2 control-label">姓名：</label>
			    <div class="col-sm-6">
			      <input type="text" name="student.stuName" class="form-control"  placeholder="输入姓名">
			    </div>
			  </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="submit" class="btn btn-primary">保存</button>
	      </div>
	    </div>
	  </div>
	  </form>
	</div>
		
	<script type="text/javascript" src="assets/js/jquery.js"></script>
  	<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
	</body>
</html>