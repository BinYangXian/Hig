<%@ page language="java" import="com.google.gson.Gson" import="com.cdsxt.po.Users" import="java.util.*" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ import="com.cdsxt.po.Users" %> --%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=utf-8");
	String data=request.getParameter("data");
	Users user=new Gson().fromJson(data,Users.class);
	request.setAttribute("user", user);
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
		<form action="usersAction?mark=update" method="post" >
			账号：&nbsp<input type="text" name="id" value="${user.id }"><br/>
			用户名：<input type="text" name="username" value="${user.username }"><br/>
			密码：&nbsp<input type="text" name="password" value="${user.password }"><br/>
			email：<input type="text" name="email" value="${user.email }"><br/>
			年龄：&nbsp<input type="text" name="age" value="${user.age }">
		</form>
	</body>
</html>
