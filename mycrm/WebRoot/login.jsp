<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">
<title>登陆</title>
<!--  
<SCRIPT src="js/jquery-1.9.1.min.js" type="text/javascript"></SCRIPT>
-->
<SCRIPT src="js/jquery-1.9.1.min.js" type="text/javascript"></SCRIPT>
<!--  -->

<STYLE>
body {
	background: #ebebeb;
	font-family: "Helvetica Neue", "Hiragino Sans GB", "Microsoft YaHei",
		"\9ED1\4F53", Arial, sans-serif;
	color: #222;
	font-size: 12px;
}

* {
	padding: 0px;
	margin: 0px;
}

.top_div {
	background: #3e9bf1;
	width: 100%;
	height: 400px;
}

.ipt {
	border: 1px solid #d3d3d3;
	padding: 10px 10px;
	width: 290px;
	border-radius: 4px;
	padding-left: 35px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
		.15s;
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s
}

.ipt:focus {
	border-color: #66afe9;
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6)
}

.u_logo {
	background: url("images/username.png") no-repeat;
	padding: 10px 10px;
	position: absolute;
	top: 43px;
	left: 65px;
}

.p_logo {
	background: url("images/password.png") no-repeat;
	padding: 10px 10px;
	position: absolute;
	top: 12px;
	left: 65px;
}

a {
	text-decoration: none;
}

.tou {
	background: url("images/tou.png") no-repeat;
	width: 97px;
	height: 92px;
	position: absolute;
	top: -87px;
	left: 140px;
}

.left_hand {
	background: url("images/left_hand.png") no-repeat;
	width: 32px;
	height: 37px;
	position: absolute;
	top: -38px;
	left: 150px;
}

.right_hand {
	background: url("images/right_hand.png") no-repeat;
	width: 32px;
	height: 37px;
	position: absolute;
	top: -38px;
	right: -64px;
}

.initial_left_hand {
	background: url("images/hand.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -12px;
	left: 100px;
}

.initial_right_hand {
	background: url("images/hand.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -12px;
	right: -112px;
}

.left_handing {
	background: url("images/left-handing.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -24px;
	left: 139px;
}

.right_handinging {
	background: url("images/right_handing.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -21px;
	left: 210px;
}
</STYLE>

<SCRIPT type="text/javascript">
	$(function() {
		//得到焦点
		$("#password").focus(function() {
			$("#left_hand").animate({
				left : "150",
				top : " -38"
			}, {
				step : function() {
					if (parseInt($("#left_hand").css("left")) > 140) {
						$("#left_hand").attr("class", "left_hand");
					}
				}
			}, 2000);
			$("#right_hand").animate({
				right : "-64",
				top : "-38px"
			}, {
				step : function() {
					if (parseInt($("#right_hand").css("right")) > -70) {
						$("#right_hand").attr("class", "right_hand");
					}
				}
			}, 2000);
		});
		//失去焦点
		$("#password").blur(function() {
			$("#left_hand").attr("class", "initial_left_hand");
			$("#left_hand").attr("style", "left:100px;top:-12px;");
			$("#right_hand").attr("class", "initial_right_hand");
			$("#right_hand").attr("style", "right:-112px;top:-12px");
		});
	});
</SCRIPT>
</HEAD>
<BODY>
	<DIV class="top_div"></DIV>
	<DIV style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 200px; text-align: center;">

		<DIV style="width: 165px; height: 96px; position: absolute;">
			<DIV class="tou"></DIV>
			<DIV class="initial_left_hand" id="left_hand"></DIV>
			<DIV class="initial_right_hand" id="right_hand"></DIV>
		</DIV>
		<form action="power/loginAction_login.action" method="post" id="Loginform">
		<P style="padding: 30px 0px 10px; position: relative;">
			<SPAN class="u_logo"></SPAN> 
			<INPUT class="ipt" type="text" placeholder="请输入用户名或邮箱" value="" id="userName" name="userName">
		</P>
		<P style="position: relative;">
			<SPAN class="p_logo"></SPAN>
			<INPUT class="ipt" id="password" type="password" placeholder="请输入六位数密码" value="" id="password" name="password">
		</P>
		<input type="submit" value="登陆测试">
		</form>
		<DIV style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
			<P style="margin: 0px 35px 20px 45px;">
				<SPAN style="float: right;">
				<span style="color: red; margin-right: 10px;" id="msgField">${fieldErrors['msg'][0]==null?'':fieldErrors['msg'][0]}</span>
				<span style="color: red; margin-right: 10px;" id="msgName"></span>
				<span style="color: red; margin-right: 10px;" id="msgPwd"></span>
				 <A style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); 
				border-image: none; color: rgb(255, 255, 255); font-weight: bold;"href="javascript:void(0)" onClick="valiSub()">登陆</A>
				</SPAN>
			</P>
		</DIV>

	</DIV>
	
	<div style="text-align:center;">
		<p style="color: blue">XX有限责任公司CRM系统</p>
	</div>
	
	<script type="text/javascript">
	var regName=/^[a-zA-Z]{1}[A-Za-z0-9]{4,8}$/;
	var regPWD=/^[A-Za-z0-9]{6}$/
	var msgName=$("#msgName");
	var msgPwd=$("#msgPwd");
	//验证用户名
	function valiUserName(){
			$("#userName").change(function(){
			var userName=this.value;
				if(!userName){
					msgName.text("用户名不能为空");
				}else if(!regName.test(userName)){
					msgName.text("用户名格式不正确");
				}else{
				msgName.text("");
				}
			})
	};
	//验证password
	function valiPassword(){
		$("#password").change(function(){
			var password=this.value;
				if(!password){
					msgPwd.text("密码不能为空");
				}else if(!regPWD.test(password)){
					msgPwd.text("密码格式不正确");
				}else{
				msgPwd.text("");
				}
			})
	};
	//登陆验证
	function valiSub(){
		var userName=document.getElementById("userName");
		var userNameValue=userName.value;
		var password=document.getElementById("password");
		var passwordValue=password.value;
		if(!userNameValue){
			msgName.text("用户名不能为空");
		}else if(!regName.test(userNameValue)){
			msgName.text("用户名格式不正确");
		}else{
		if(!passwordValue){
			msgPwd.text("密码不能为空");
				return;
		}else if(!regPWD.test(passwordValue)){
					msgPwd.text("密码格式不正确");
				return;
		}else{
		document.getElementById("Loginform").submit();
		}
		}
	}
		$(function(){
			valiUserName();
			valiPassword();
			$("#userName").focus(function(){
				$("#msgField").text("");
			});
			$("#password").focus(function(){
				$("#msgField").text("");
			});
		})
	
	</script>
</BODY>
</html>
