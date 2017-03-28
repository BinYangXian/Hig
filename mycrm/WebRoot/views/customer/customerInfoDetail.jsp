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
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<%-- 		<ol class="breadcrumb">
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
				</ol> --%>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">帮助</a></li>
						<li><a href="#">联系人</a></li>
						<li><a href="#">交往记录</a></li>
						<li><a href="#">历史订单</a></li>
						<li><a href="#">返回</a></li>
						<li><a href="#">保存</a></li>
					</ul>
				</div><!-- /.navbar-collapse -->
			</div><!-- /.container-fluid -->
		</div>
		
		<div class="container">
			<div class="row">
				<div class="panel panel-default">
					<table class="table table-bordered table-hover">
						<tr>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">客户编号</th>
							<th><input type="text" disabled="disabled"></th>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">名称</th>
							<th>
								<input type="text"><span>&nbsp&nbsp*</span>
							</th>
						</tr>
						<tr>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">地区</th>
							<th>
								<select>
					                <option value="0">地区</option>
								</select><span>&nbsp&nbsp*</span>
							</th>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">客户经理</th>
							<th>
								<select>
					                <option value="0">客户经理</option>
								</select><span>&nbsp&nbsp*</span>
							</th>
						</tr>
						<tr>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">客户等级</th>
							<th>
								<select>
					                <option value="0">客户等级</option>
								</select><span>&nbsp&nbsp*</span>
							</th>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle"></th>
							<th>
							</th>
						</tr>
						<tr>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">客户满意度</th>
							<th>
								<select>
					                <option value="0">*****</option>
								</select><span>&nbsp&nbsp*</span>
							</th>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">客户信用度</th>
							<th>
								<select>
					                <option value="0">*****</option>
								</select><span>&nbsp&nbsp*</span>
							</th>
						</tr>
						<tr>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">地址</th>
							<th><input type="text"><span>&nbsp&nbsp*</span></th>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">邮政编码</th>
							<th>
								<input type="text"><span>&nbsp&nbsp*</span>
							</th>
						</tr>
						<tr>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">电话</th>
							<th><input type="text"><span>&nbsp&nbsp*</span></th>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">传真</th>
							<th>
								<input type="text"><span>&nbsp&nbsp*</span>
							</th>
						</tr>
						<tr>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">网址</th>
							<th><input type="text"><span>&nbsp&nbsp*</span></th>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle"></th>
							<th>
							</th>
						</tr>
						<tr>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">营业执照注册号</th>
							<th><input type="text"></th>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">法人</th>
							<th>
								<input type="text"><span>&nbsp&nbsp*</span>
							</th>
						</tr>
						<tr>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">注册资金(万元)</th>
							<th><input type="text"></th>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">年营业额</th>
							<th>
								<input type="text">
							</th>
						</tr>
						<tr>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">开户银行</th>
							<th><input type="text"><span>&nbsp&nbsp*</span></th>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">银行账号</th>
							<th>
								<input type="text"><span>&nbsp&nbsp*</span>
							</th>
						</tr>
						<tr>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">地税登记号</th>
							<th><input type="text"></th>
							<th style="background-color:#AFD5ED;text-align:center;vertical-align:middle">国税登记号</th>
							<th>
								<input type="text">
							</th>
						</tr>
					</table>
					<div class="panel-footer">分页</div>
				</div>
			</div>
		</div>
		
		
		<script type="text/javascript">
			$(function(){
				$('table.table [data-toggle="modal"]').bind('click',function(){
					var empno = $(this).data('emps-empno');
					var target = $($(this).data('target'));
					$.ajax({
						url:'usersAction!findById',
						data:{'emp.empno':empno},
						dataType:'json',
						success:function(json){
							target.find('.modal-body :input').each(function(i,o){
								var colName=o.name;
								var index=colName.indexOf(".");
								//alert(colName.substr(index+1,colName.length-index));
								$(o).val(json[colName.substr(index+1,colName.length-index)]);
							});
						}
					})
				})
				
			})
		</script>
	</body>
</html>