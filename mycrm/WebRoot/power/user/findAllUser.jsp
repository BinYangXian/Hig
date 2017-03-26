<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>

<!--  -->
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>


</head>

<body>
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td class="topg"></td>
		</tr>
	</table>

	<table border="0" cellspacing="0" cellpadding="0" class="wukuang"
		width="100%">
		<tr>
			<td width="1%"><img src="images/tleft.gif" /></td>
			<td width="39%" align="left">[账户管理]</td>

			<td width="57%" align="right"><a href="javascript:addUser()">
					<img src="images/button/tianjia.gif" />
			</a></td>
			<td width="3%" align="right"><img src="images/tright.gif" /></td>
		</tr>
	</table>

	<table border="0" cellspacing="0" cellpadding="0"
		style="margin-top:5px;">
		<tr>
			<td><img src="images/result.gif" /></td>
		</tr>
	</table>

	<table width="100%" border="1">
		<tr class="henglan" style="font-weight:bold;">
			<td width="10%" align="center">用户名</td>
			<td width="10%" align="center">姓名</td>
			<td width="15%" align="center">职务</td>
			<td width="15%" align="center">修改</td>
			<td width="15%" align="center">删除</td>
		</tr>

		<c:forEach items="${userVos }" var="u">
			
			<tr name='showTable'>
				<td align="center">${u.userName }</td>
				<td align="center">${u.staffName==''?'*未分配员工*':u.staffName }</td>
				<td align="center">${u.roleName==''?'*未分配职位*':u.roleName }</td>
				<td width="7%" align="center"><a
					href="javascript:void(0)" onclick="updateUser(this)" userId="${u.userId }" userName="${u.userName }"><img
						src="images/button/modify.gif" class="img" /></a></td>
				<td width="7%" align="center"><a
					href="javascript:void(0)" onclick="deleteUser(this)" userId="${u.userId }"><img
						src="images/button/modify.gif" class="img" /></a></td>
			</tr>
		</c:forEach>
	</table>

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h5 class="modal-title" id="myModalLabel">添加账户</h5>
				</div>
				<div class="modal-body">
					<!-- 添加用户表单  -->
					<form role="form" method="post"
						 id="saveUser"
						onsubmit="return saveUser()">
						<div class="form-group">
							<input type="hidden" name="userId" id="updateForm"/>
							<input type="hidden" name="curPage"/>
								<span style="color:green">用户名:</span> <span style="color:red"
									id="msgName"></span> <span><input type="text"
									class="form-control" id="username" placeholder="请输入用户名"
									name="username" onchange="checkName()"></span> <span
									style="color:green">密码:</span> <span style="color:red"
									id="msgPassword"></span> <input type="password"
									class="form-control" id="password" placeholder="请输入密码"
									name="password" onchange="checkPassword()"> <span
									style="color:green">确认密码:</span> <span style="color:red"
									id="msgTwoPassword"></span> <input type="password"
									class="form-control" id="twoPassword" placeholder="请再输入密码"
									onchange="checkPasswordTwo()">
								<p>&nbsp;</p>
								<span style="color:red" id="msgRoleId"></span>
								<div class="form-group">
									<select class="form-control" name="roleId" id="roleId"
										onchange="checkeSelect()">
										<option value="0">---选择职务---</option>
									</select>
								</div>
								<input type="submit" class="btn btn-default" value="提交"
									name="submit">
							</div>
					</form>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>

 
<table border="0" cellspacing="0" cellpadding="0" align="center">
 <tr align="center">
    		<td colspan="5">
 				<jsp:include page="/pageUtil.jsp">
 					<jsp:param value="power/userAction_findAll.action" name="url"/>
 				</jsp:include>
    		</td>
    	</tr>
</table>
<form action="power/userAction_deleteUser.action" method="post" id="deleteForm">
<table id="deleteUser">
	
</table>
</from>
	<script type="text/javascript">
		//检查角色
		function checkeSelect() {
			var nameObj = document.getElementById("roleId");
			var nameValue = nameObj.value;
			var msg = document.getElementById("msgRoleId");
			msg.innerHTML = "";
			if (nameValue == 0) {
				msg.innerHTML = "请选择角色";
				return false;
			} else {
				return true;
			}
		}
	
		//验证密码
		function checkPassword() {
			var nameRge = /^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,22}$/;
			var nameObj = document.getElementById("password");
			var nameValue = nameObj.value;
			var msg = document.getElementById("msgPassword");
			msg.innerHTML = "";
			if (!nameRge.test(nameValue) || !nameValue) {
				msg.innerHTML = "密码格式错误或为空";
				return false;
			} else {
				return true;
			}
		}
	
		function checkPasswordTwo() {
			var nameObj = document.getElementById("password");
			var nameValue = nameObj.value;
			var twoPasswordObj = document.getElementById("twoPassword");
			var twoPasswordValue = twoPasswordObj.value;
			var msgTwo = document.getElementById("msgTwoPassword");
			msgTwo.innerHTML = "";
			if (nameValue != twoPasswordValue) {
				msgTwo.innerHTML = "两次密码不同，请重新输入!"
				return false;
			} else {
				return true;
			}
		}
	
		//验证用户名
		var nameRge = /^[A-Za-z0-9]{5,10}$/;
		function checkName() {
			var nameObj = document.getElementById("username");
			var nameValue = nameObj.value;
			var msg = document.getElementById("msgName");
			msg.innerHTML = "";
			if (!nameRge.test(nameValue) || !nameValue) {
				msg.innerHTML = "用户名格式错误或为空";
				return false;
			} else {
				return true;
			}
		}
	
		function saveUser() {
			var checkName1 = checkName();
			var checkPassword1 = checkPassword();
			var checkPasswordTwo1 = checkPasswordTwo();
			var checkeSelect1 = checkeSelect();
			console.log(checkName1);
			if (checkName1 && checkPassword1 && checkPasswordTwo1 && checkeSelect1) {
				return true;
			} else {
				return false;
			}
		}
	
		//获取角色下拉菜单
		var select = $("select[class='form-control']");
		$(function() {
			$.ajax({
				url : "power/userAction_getRoleVo.action",
				type : "json",
				success : function(data) {
					$.each(data, function(i, o) {
						select.append($('<option value="' + o.roleId + '">' + o.roleName + '</option>'));
					})
	
				}
			})
	
		})
		
	</script>
<script type="text/javascript">

$(function(){
	$("tr[name='showTable']").each(function(i){
		if(i%2!=0){
			$(this).addClass("tabtd2");
		}else{
			$(this).addClass("tabtd1");
		}
	})
})
//添加用户
	function addUser() {
		
		$("#saveUser").prop("action","power/userAction_addUser.action");
		$("#myModal").modal('show');
	}
//修改用户
		function updateUser(obj){
		var userId=obj.getAttribute("userId");
		var userName=obj.getAttribute("userName");
		$("#updateForm").val(userId);
		$("#saveUser").prop("action","power/userAction_updateUser.action");
		var tep=$("#curPage").val();
		$("input[name='curPage']").val(tep);
		$("#username").val(userName);
		$("#myModal").modal('show');
		console.log(userId)
		}
//删除用户 $("#deleteFrom").submit();
function deleteUser(obj){
	var tep=$("#curPage").val();
	var userId=$(obj).attr("userId");
	console.log(userId);
	$("#deleteUser").append("<input type='text' name='userId' value="+userId+">");
	$("#deleteUser").append("<input type='text' name='curPage' value="+tep+">");
	$("#deleteForm").submit();

}
</script>
</body>
</html>
