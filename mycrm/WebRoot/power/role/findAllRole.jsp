<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>无标题文档</title>
<link href="css/sys.css" type="text/css" rel="stylesheet" />

<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>

<!--  -->
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<!--  -->
<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" />
<script type="text/javascript" src="js/jquery.ztree.all-3.5.min.js"></script>

<script type="text/javascript">
var zTreeObj;
  		function getZtree(roleId){
  			var setting = {
  				view: {
  					selectedMulti: false
  				},
  				check:{
				enable:true,
				chkStyle: "checkbox",
			},
  				data: {
  					key:{
  						name:"menuVoName",
  						title:"menuVoName",
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
  					url:'power/menuAction_findAll.action',
  					data:{'roleId':roleId},
  					dataType:'json',
  					async:false,
  					type:'post',
  					success:function(data){
  						zTreeObj = $.fn.zTree.init($("#tree"), setting, data);
  						zTreeObj.expandAll(true);
  					}
  				});
  			});
  		}
  	function getNodes(){
  		var nodes = zTreeObj.getCheckedNodes(true);
  		var formHidden=document.getElementById("formHidden");
  		for(var i=0;i<nodes.length;i++){
  			var input = document.createElement("input");
  			input.type="hidden";
  			input.name="menuIds";
  			input.value=nodes[i]['menuVoId'];
  			formHidden.appendChild(input);
  		}
  		return true;
  	}
$(function(){
	$("tr[name='showTable']").each(function(i){
		if(i%2!=0){
			$(this).addClass("tabtd2");
		}else{
			$(this).addClass("tabtd1");
			}
	})
})
</script>

</head>

<body >

 <table border="0" cellspacing="0" cellpadding="0" width="100%">

  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="images/tleft.gif"/></td>
    <td width="39%" align="left">[角色管理]</td>
 
    <td width="57%"align="right">
    	<%--添加 --%>
       <a href="javascript:addRole()">
       	<img src="images/button/tianjia.gif" />
       </a>
       <!-- 删除 -->
       <a href="javascript:deleteRole()">
       	<img src="images/button/shanchu.gif" />
       </a>
    </td>
    <td width="3%" align="right"><img src="images/tright.gif"/></td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="images/result.gif"/></td>
  </tr>
</table>

<table width="100%" border="1" >
  
  <tr class="henglan" style="font-weight:bold;">
    <td width="6%" align="center"><input type="checkbox"  onclick="selectAll(this)"> </td>
    <td width="6%" align="center">职务</td>
    <td width="7%" align="center">菜单分配</td>
    <td width="7%" align="center">权限分配</td>
  </tr>

  <c:forEach items="${roles }" var="r">
  	<tr name="showTable">
	    <td align="center"><input type="checkbox" name="checkTest" value="${r.roleId }"> </td>
	    <td align="center">
	    <a href="javascript:void(0)" onclick="edRole(this)" tid="${r.roleId }">
	    ${r.roleName}
	    </a>
	    <input type="text" name="roleName"  style="display:none" onblur="edText(this)">
	    </td>
	    <td width="7%" align="center">
	  		<a href="javascript:void(0)"  roleId="${r.roleId }" onclick="getRoleMenu(this)" ><img src="images/button/modify.gif" class="img" /></a>
	  	</td>
	  	<td width="7%" align="center">
	  		<a href="power/roleAction_findRoleModule.action?roleId=${r.roleId }" ><img src="images/button/modify.gif" class="img" /></a>
	  	</td>
	  </tr>
  </c:forEach>
</table>

<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr align="center">
    		<td colspan="5">
 				<jsp:include page="/pageUtil.jsp">
 					<jsp:param value="power/roleAction_findAllToPage.action" name="url"/>
 				</jsp:include>
    		</td>
    	</tr>
</table>

<!-- 模态框（Modal） -->
<form action="" method="post" onsubmit="return getNodes(this)">
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"   >
	<div class="modal-dialog" style="height:60%;width:33%;">
		<div class="modal-content"  >
			<div class="modal-header">
			</div>
			<div class="modal-body" style="overflow:auto">
				<div style="height:60%;">
				<ul class="ztree" id="tree"></ul>
				</div>
			</div>
			<div class="modal-footer">
			
				<div id="formHidden"></div>
				<input type="hidden" name="roleId" value="" id="roleId">
				<input type="submit" value="提交">
				<input type="button" value="关闭" data-dismiss="modal">
			
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
	</div>
</form>
<!-- 模态框（结束）-->

<script type="text/javascript">

function getRoleMenu(obj){
	$("form[method='post']").attr('action','power/roleAction_updateMenu.action');
	$("div[class='modal-header']").empty();
	var id=obj.getAttribute("roleId");
	var roleId=document.getElementById("roleId");
	roleId.value=id;
	getZtree(id);
	$("#myModal").modal('show');
}

//编辑角色名
function edRole(obj){
	var roleName=obj.innerText;
	var objNext=$(obj).next();
	objNext.val(roleName);
	objNext.show();
	$(obj).hide();
}
function edText(obj){
	newObj=$(obj);
	var prev=newObj.prev();
	var newName=obj.value;
	var roleName=$.trim(prev.text());
	var roleId=prev.attr("tid");
	if(!newName||newName==roleName){
		newObj.hide();
		prev.show();
	}else{
	$.ajax({
		url:"power/roleAction_updateName.action",
				data:{"newName":newName,"roleId":roleId},
				dataType: "json",
				type: "post",
				success: function(data){
				if(data){
					alert(data);
					newObj.val(roleName);
				}else{
				prev.text(newName);
					newObj.hide();
				prev.show();
				}
				}
	})
}
}

//添加角色
function addRole(){
	$("form[method='post']").attr('action','power/roleAction_addRole.action');
	var text=document.createElement("input");
	var texthead=$("div[class='modal-header']");
	texthead.empty();
	var tempText=$("input[name='newName']");
	var tempName=tempText.val();
	$("input[name='newName']").remove();
	text.type="text";
	text.name="newName";
	text.value=(tempName==null?"":tempName);
	texthead.append("职务名:");
	texthead.append(text);
	getZtree();
	$("#myModal").modal('show');
}
//删除角色 name="check"
function deleteRole(){
	var roleIds=[];
	$("input:checkbox[name=checkTest]:checked").each(
		function(){
			roleIds.push($(this).val());
		});
	if(!roleIds.length){
		alert("请选择要删除的职务");
		return;
	}
	$.ajax({
		url:"power/roleAction_deleteRole.action",
		traditional: true,
		data: {"roleIds":roleIds},
		dataType: "json",
		type: "post",
		success:function(data){
			alert(data);
			history.go(0);
		}
	})
	}

//全选 name="check"
function selectAll(obj){
	if(obj.checked==true){
	$("input[name=checkTest]").each(
		function(){
			$(this).prop('checked',true);
		}
	);
	}else{
	$("input[name=checkTest").each(
		function(){
			$(this).prop('checked',false);
		}
	)
	}
}


</script>
</body>
</html>
