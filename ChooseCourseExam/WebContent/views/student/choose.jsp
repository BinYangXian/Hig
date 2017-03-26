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
				<form action="studentAction!choose.action" method="post">
					<input type="hidden" name="student.stuId" value="${param.stuId }">
					<div class="panel panel-default">
						<div class="panel-heading">课程列表</div>
						<table class="table table-hover table-bordered">
							<tr>
								<th width="50">选择</th>
								<th>课程名称</th>
							</tr>
							<c:forEach items="${courses }" var="cou">
								<tr>
									<td><input type="checkbox" name="ids" value="${cou.cid }"></td>
									<td>${cou.courseName }</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<button type="submit" class="btn btn-warning">提交</button>
				</form>
			</div>
		</div>
	<script type="text/javascript" src="assets/js/jquery.js"></script>
  	<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
  	<script type="text/javascript">
  		$(function(){
  			$.ajax({
  				url:'studentAction!findAllCourse.action',
  				data:{"student.stuId":"${param.stuId}"},
				dataType:"json",
				success:function(json){
					var obj={};
					$.each(json,function(i,o){
						obj[o]=o;
					})
					$(':checkbox[name="ids"]').each(function(i,o){
  						o.checked = ($(o).val() in obj);
  					});
				}
  			})
  		})
  	</script>
	</body>
</html>