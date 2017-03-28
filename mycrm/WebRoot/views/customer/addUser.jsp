<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="#" method="post">
		<table class="table table-bordered table-hover"  width="80%" border="1px">
			<tr>
				<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">名称</th>
				<th>
					<input type="text" name="crmCustomer.cusName"><span>&nbsp*</span>
				</th>
				<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">客户等级</th>
				<th>
					<select name="crmCustomer.cusLevel.levelName">
		                <option >请选择</option>
		                <c:forEach items="${areaNames }" var="a" >
		                	<option>${a }</option>
		                </c:forEach>
					</select><span>&nbsp*</span>
				</th>
			</tr>
			<tr>
				<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">地区</th>
				<th>
					<select name="crmCustomer.crmCusArea.areaName">
		                <option >请选择</option>
		                <c:forEach items="${crmCusAreaNames }" var="c" >
		                	<option >${c }</option>
		                </c:forEach>
					</select><span>&nbsp*</span>
				</th>
				<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">客户经理</th>
				<th>
					<select name="crmCustomer.cusLinkman.cusLinkmanName">
		                <option >请选择</option>
		                  <c:forEach items="${linkmanNames }" var="l" >
		                	<option >${l }</option>
		                </c:forEach>
					</select><span>&nbsp*</span>
				</th>
			</tr>
			<tr>
				<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">客户满意度</th>
				<th>
					<select name="crmCustomer.cusSatisfaction">
		                <option >请选择</option>
		                <option >*****</option>
		                <option >****</option>
		                <option >***</option>
		                <option >**</option>
		                <option >*</option>
					</select><span>&nbsp*</span>
				</th>
				<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">客户信用度</th>
				<th>
					<select name="crmCustomer.cusSatisfaction">
		                  <option >请选择</option>
		                <option >*****</option>
		                <option >****</option>
		                <option >***</option>
		                <option >**</option>
		                <option >*</option>
					</select><span>&nbsp*</span>
				</th>
			</tr>
			<tr>
				<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">地址</th>
				<th><input type="text" name="crmCustomer.cusAddr"><span>&nbsp*</span></th>
				<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">邮政编码</th>
				<th>
					<input type="text" name="crmCustomer.cusZipcode"><span>&nbsp*</span>
				</th>
			</tr>
			<tr>
				<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">传真</th>
				<th>
					<input type="text" name="crmCustomer.cus_buslicNum"><span>&nbsp*</span>
				</th>
				<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">网址</th>
				<th><input type="text" name="crmCustomer.url"><span>&nbsp*</span></th>
			</tr>
			<tr>
				<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">营业执照注册号</th>
				<th><input type="text" name="crmCustomer.cus_buslicNum"></th><span>&nbsp&nbsp&nbsp</span>
				<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">法人</th>
				<th>
					<input type="text" name="crmCustomer.cusLegalperson"><span>&nbsp*</span>
				</th>
			</tr>
			<tr>
				<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">注册资金(万元)</th>
				<th><input type="text" name="crmCustomer.cusRegiscapital"></th><span>&nbsp&nbsp&nbsp</span>
				<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">年营业额</th>
				<th>
					<input type="text" name="crmCustomer.cusTurnover"><span>&nbsp&nbsp&nbsp</span>
				</th>
			</tr>
			<tr>
				<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">开户银行</th>
				<th><input type="text" name="crmCustomer.cusBank"><span>&nbsp*</span></th>
				<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">银行账号</th>
				<th>
					<input type="text" name="crmCustomer.cusBankaccount"><span>&nbsp*</span>
				</th>
			</tr>
			<tr>
				<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">地税登记号</th>
				<th><input type="text" name="crmCustomer.cusLandtax"></th><span>&nbsp&nbsp&nbsp</span>
				<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">国税登记号</th>
				<th>
					<input type="text" name="crmCustomer.cusTax"><span>&nbsp&nbsp&nbsp</span>
				</th>
			</tr>
			<tr>
				<th colspan="4" align="right"><input type="submit" value="提交"></th>
			</tr>
		</table>
	</form>
</body>
</html>