<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<HTML>
<HEAD>
<base href="<%=basePath%>">
<TITLE></TITLE>



<LINK href="css/style.css" type=text/css rel=stylesheet>

<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<base target="_self">


</HEAD>
<BODY bgColor=#CEEBFF leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">

<table border="0" width="100%" cellspacing="0" cellpadding="0" id="table1" height="27">
	<tr>
		<td>
		<table border="0" width="100%" cellspacing="0" cellpadding="0" id="table2">
			<tr>
				<td width="420">
				<img border="0" src="images/topbg.jpg" width="436" height="80"></td>
				<td background="images/topbg.jpg" valign="bottom">
				<div align="right">
				<table border="0" width="145" id="table7" cellspacing="0" cellpadding="0">
					<tr>
						<td width="150" height="24"></td>
					</tr>
					<tr>
						<td width="150" height="35"><p align="right">
							<font color="#FFFFFF">欢迎您：
								<b>${loginUser.userName==null?"未登陆":loginUser.userName }</b>
							</font>
						</td>
					</tr>
				</table>
				</div>
				</td>
				<td width="374" background="images/topright.jpg" valign="top">
				<table border="0" width="100%" cellspacing="0" cellpadding="0" id="table4">
					<tr>
						<td>
						<div align="right">
							<table border="0" width="100%" cellspacing="0" cellpadding="0" id="table5">
								<tr>
									<td height="19">
									<p align="center">
									<img border="0" src="images/calendar.gif" align="right">&nbsp;</td>
									<td width="189">
										<font color="#ffffff">今天是：
										<script language="JavaScript">
												<!--
													tmpDate = new Date();
													date = tmpDate.getDate();
													month = tmpDate.getMonth() + 1;
													year = tmpDate.getFullYear();
													//document.write(1900 + year);
													document.write(year);
													document.write("年");
													document.write(month);
													document.write("月");
													document.write(date);
													document.write("日 ");
				
													myArray = new Array(6);
													myArray[0] = "星期日";
													myArray[1] = "星期一";
													myArray[2] = "星期二";
													myArray[3] = "星期三";
													myArray[4] = "星期四";
													myArray[5] = "星期五";
													myArray[6] = "星期六";
													weekday = tmpDate.getDay();
													document.write(myArray[weekday]);
												// -->
												</script>
										</font>
									</td>
								</tr>
							</table>
						</div>
						</td>
					</tr>
					<tr>
						<td height="20">　</td>
					</tr>
					<tr>
						<td>
						<div align="right">
							<table border="0" width="215" cellspacing="0" cellpadding="0" id="table6" height="23">
								<tr>
									<td width="26"><img border="0" src="images/pwd.gif"></td>
									<td width="51" valign="middle">
										
										<a href="power/user/updPwd.jsp" target="rightweb">
										<font color="ffffff">更改口令</font></a>
										
									</td>
									<td width="31"><p align="center"><img border="0" src="images/login.gif"></td>
									<td width="55" valign="middle"><a href="power/loginAction_exit.action" target="_top"><font color="ffffff">重新登录</font></a></td>
								</tr>
							</table>
						</div>
						</td>
					</tr>
				</table>			  </td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<table border="0" width="100%" cellspacing="0" cellpadding="0" height="10" id="table3">
	<tr>
		<td style="border-bottom: 1px solid #ffffff; filter: progid:dximagetransform.microsoft.gradient(startcolorstr='#0075C4', endcolorstr='#ffffff', gradienttype='1'">　</td>
	</tr>
</table>


</BODY></HTML>