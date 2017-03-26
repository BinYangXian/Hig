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
		<link rel="stylesheet" href="assets/css/zTreeStyle/zTreeStyle.css">
		<script type="text/javascript" src="assets/js/jquery.min.js"></script>
		<script type="text/javascript" src="assets/js/jquery.ztree.all-3.5.min.js"></script>
		<script type="text/javascript">
		
			var setting = {
				data:{
					simpleData:{
						enable:true,
						idKey:'id',
						pIdKey:'parent',
						rootPId:0
					}
				}
					
			};
			var zTreeObj;
			
			$(function(){
				$.ajax({
					url:'companyAction!findAllToJson.action',
					dataType:'json',
					success:function(json){
						//渲染
						zTreeObj = $.fn.zTree.init($('#ztree'),setting,json);
						zTreeObj.expandAll(true);
					}
				})
			})
		
		</script>
	</head>
	<body>
		<a href="companyAction.action">查看数据</a>
		<hr />
		<ul id="ztree" class="ztree"></ul>
	</body>
</html>