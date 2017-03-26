<%@page import="com.cdsxt.po.Company"%>
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
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">公司管理系统</a>
				</div>

				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="companyAction.action">首页 <span class="sr-only">(current)</span></a></li>
						<li><a href="#">关于我们</a></li>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="container">
			<div class="row">
				<ol class="breadcrumb">
					<%
						//写一下java代码
						//得到作用域中的当前对象
						//Company company = (Company)request.getAttribute("company");
					  	Company root = (Company)request.getAttribute("company");
						//默认认为 company不为空
						String home = "<li><a href=\"companyAction.action\"><i class=\"glyphicon glyphicon-home\"></i></a></li>";
					  	if(root!=null){
					  		String str = "<li class=\"active\">"+root.getName()+"</li>";
					  		while(root.getParent()!=null){
					  			root = root.getParent();
					  			str="<li><a href=\"companyAction.action?parent="+root.getId()+"\">"+root.getName()+"</a></li>"+str;
					  		}
					  		home = home+str;
					  	}else{
					  		home = "<li class=\"active\"><i class=\"glyphicon glyphicon-home\"></i></li>";
					  	}
				  		out.write(home);
					%>
				</ol>
			</div>
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading">公司列表</div>
					<table class="table table-hover table-bordered">
						<tr>
							<th>编号</th>
							<th>名称</th>
							<th>父公司</th>
						</tr>
						<c:forEach items="${companys }" var="comp">
							<tr>
								<td>${comp.id }</td>
								<td><a href="companyAction.action?parent=${comp.id }">${comp.name }</a></td>
								<td>${comp.parent.name }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>