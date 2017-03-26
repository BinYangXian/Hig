<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>更改口令</title>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<link href="css/sys.css" type="text/css" rel="stylesheet" />
	<style>
		.updpwd{
			background-color: #2ae;
		}
		.login_btn{
			background-color: #9be;
			width: 99px;
			font-size: 14px;
			font-family: 微软雅黑;
		}
		.upd_pwd_msg{
			font-size: 14px;
			text-align: right;
		}
	</style>
	<script  type="text/javascript">
		function closeWindow(){
			window.history.back(-1); 
		}
	</script>
</head>

<body class="updpwd">
	<form action="power/userAction_updatePwd.action" method="post" onsubmit="return valiPwd()">
		<table style="width: 200px">
			<tr>
				<td colspan="2">
					<span id="msgId" class="upd_pwd_msg"> </span>
				</td>
			</tr>
			<tr>
				<td>原始密码：</td>
				<td><input type="password" name="oldPwd" value="" /></td>
			</tr>
			<tr>
				<td>新&nbsp;密&nbsp;码：</td>
				<td><input type="password" name="newPwd" value="" /></td>
				
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" name="reNewPassword" value="" onchange="valiPwd()"/></td>
				<td id="reNewPassword"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit"  value="修改" class="login_btn"/>
					<button type="reset" value="关闭" class="login_btn" onclick="closeWindow()">关闭</button>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
			function valiPwd(obj){
				var pwd=$("input[name='newPwd']").val();
				var valiPwd=$("input[name='reNewPassword']").val();
				if(valiPwd!=pwd){
					alert("两次密码不一致，请重新输入");
					$("input[name='reNewPassword']").val("")
					return false;
				}
				return true;
			}

	</script>
</body>
</html>
