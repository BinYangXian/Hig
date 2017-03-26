<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<form action="uploadAction!upload.do" method="post" enctype="multipart/form-data">
			用户名:<input type="text" name="users.username"><br>
			密码:<input type="password" name="users.password"><br>
			邮箱:<input type="text" name="users.email"><br>
			文件:<input type="file" name="file"><br>
			<input type="submit" value="上传">
		</form>
	</body>
</html>