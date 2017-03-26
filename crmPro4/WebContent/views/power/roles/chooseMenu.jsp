<%@page contentType="text/html; charset=utf-8" %>
<%@taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title></title>
	<base href="<%=basePath%>">
	<link rel="stylesheet" href="assets/css/tabCss.css">
	<link rel="stylesheet" href="assets/css/zTreeStyle/zTreeStyle.css">
	<script src="assets/js/tabjs.js"></script>
	<script src="assets/js/jquery-1.4.4.js"></script>
	<script src="assets/js/jquery.ztree.all-3.5.min.js"></script>
	<script type="text/javascript">
		/* 
			渲染tree
		*/
		
		var setting = {
			
			check:{
				enable:true,
				chkStyle: "checkbox",
				chkboxType: { "Y": "p", "N": "s" }
			},
			data:{
				key:{
					name:'menuName'
				},
				simpleData:{
					enable:true,
					pIdKey:'parentId',
					idKey:'menuId',
					rootPId:0
				}
			}
		};
		var zTreeObj;
		$(function(){
			//ajax加载树的数据
			$.ajax({
				url:'power/roleAction!updateChooseMenuJson.action',
				data:{"roleId":"${param.roleId}"},
				dataType:'json',
				success:function(nodes){
					zTreeObj = $.fn.zTree.init($('#tree'),setting,nodes);
					zTreeObj.expandAll(true);
				}
			})
		})
		
		function getNodes(_form){
			//第一步 得到所有的选中节点
			var nodes = zTreeObj.getCheckedNodes(true);
			//循环遍历  动态生成input
			$.each(nodes,function(i,o){
				var input = $('<input type="hidden" name="menuIds" />');
				input.val(o.menuId);
				$(_form).append(input);
			})
			//第三步 将生成的input 添加到_form
			
			return true;
		}
	
	</script>	
	</head>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="assets/images/tab_03.gif" width="15" height="30" /></td>
        <td width="1101" background="assets/images/tab_05.gif"><img src="assets/images/311.gif" width="16" height="16" /> <span class="STYLE4">分配菜单</span></td>
        <td width="281" background="assets/images/tab_05.gif"></td>
        <td width="14"><img src="assets/images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" height="100%">
			<img alt="" src="assets/images/tab_12.gif"  width="9px" height="100%">
		</td>
        <td bgcolor="#f3ffe3">
        	<!-- 渲染tree -->
        	<div>
	        	<ul id="tree" class="ztree"></ul>
	        	<form action="power/roleAction!updateChooseMenu.action" method="post" onsubmit="return getNodes(this);">
	        		<input type="hidden" name="roleId" value="${param.roleId }">
	        		<input type="submit" value="提交"/>
	        		<input type="button" value="取消" onclick="history.go(-1);"/>
	        	</form>
        	</div>
        </td>
        <td width="9" height="100%">
  			<img alt="" src="assets/images/tab_16.gif"  width="9px" height="100%">
  		</td>
      </tr>
    </table></td>
  </tr>
   <tr>
    <td height="29"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="assets/images/tab_20.gif" width="15" height="29" /></td>
        <td background="assets/images/tab_21.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
           <!-- 导出Excel表 -->
            <td align="center" width="100%" height="29" nowrap="nowrap"><span class="STYLE1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
          </tr>
        </table></td>
        <td width="14"><img src="assets/images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
