<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<HTML>
<HEAD>
<link rel="stylesheet"href="${pageContext.request.contextPath}/css/zTreeStyle/zTreeStyle.css" />
<script type="text/javascript"src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"src="${pageContext.request.contextPath}/js/jquery.ztree.all-3.5.min.js"></script>

	<script type="text/javascript">
  		$(function(){
  			var zTreeObj;
  			var setting = {
  				view: {
  					selectedMulti: false
  				},
  				check:{
				enable:false
			},
  				data: {
  					key:{
  						name:"menuVoName",
  						title:"menuVoName",
  						url:"menuVoUrl"
  					},
  					simpleData: {
  						enable: true,
  						idKey: "menuVoId",
  						pIdKey: "menuVoParentId",
  						rootPId: 0
  					}
  				}
  			};
  			$(function(){
  				$.ajax({
  					url:'power/loginAction_findUserMenu.action',
  					dataType:'json',
  					success:function(data){
  						for(var i in data){
  							if(data[i]['menuVoUrl']){
  								data[i]['target']='rightweb';
  							};
  						}
  						zTreeObj = $.fn.zTree.init($("#tree"), setting, data);
  						zTreeObj.expandAll(true);
  					}
  				});
  				
  			});
  		});
  	</script>

</HEAD>
<BODY bgColor=#DDF0FB leftMargin=0 topMargin=0 marginwidth="0"
	marginheight="0">
	<table width="90%" border="0" cellspacing="1" cellpadding="2"
		align="center">
		<tr>
			<div style="height:100%;">
				<ul class="ztree" id="tree"></ul>
			</div>
		</tr>
	</table>
</BODY>
</HTML>