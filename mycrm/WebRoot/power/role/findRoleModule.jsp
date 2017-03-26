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

<!-- document.getElementById('subform').submit(); -->
<script type="text/javascript">
	function submitForm(){
	var moduleJsons=[];
	$("input[type='hidden']").each(function(){
	var moduleId=this.value;
	var powerCode=0;
	var moduleJson={};
	$("input[name="+moduleId+"]:checked").each(function(){
		var temp=parseInt(this.value);
		powerCode+=temp;
	})
	moduleJson={
			"moduleId":moduleId,
			"powerCode":powerCode.toString()
	}
	moduleJsons.push(moduleJson);
	});
	var roleId=$("#roleId").attr("roleId");
	$.ajax({
		url:'power/roleAction_updateModule.action',
		data: {"moduleJsons":JSON.stringify(moduleJsons),"roleId":roleId},
		dataType:"text",
		type: "post",
		success:function(data){
			alert(data);
			history.go(-1);
		}
	})
	return false;
	}
	
</script>

</head>
<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>
<!-- onsubmit="return submitForm()" -->
<form action="power/roleAction_updateModule.action" method="get" id="subform">
<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="images/tleft.gif"/></td>
    <td width="39%" align="left" roleId="${role.roleId }" id="roleId">[${role.roleName }-权限分配]</td>
   
    <td width="57%"align="right">
    	<%--添加职务 --%>
       <a href="javascript:submitForm()">
       	<img src="images/button/qr.gif" />
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
    <td width="6%" align="center">菜单名称</td>
     <td width="7%" align="center">增加</td>
    <td width="6%" align="center">删除</td>
    <td width="7%" align="center">修改</td>
    <td width="7%" align="center">查看</td>
  </tr>
  
  <c:forEach items="${moduleVos }" var="mv">
   <tr class="tabtd1">
    <td width="6%" align="center" > ${mv.moduleName }</td>
 	<input type="hidden" name="moduleId" value="${mv.moduleId }">
     <td width="7%" align="center">
     <c:choose>
     	<c:when test="${mv.add==1 }">
     		 <input type="checkbox" checked="checked" name="${mv.moduleId }" value="1">
     	</c:when>
     	<c:otherwise>
     		<input type="checkbox" name="${mv.moduleId }" value="1">
     	</c:otherwise>
     </c:choose>
     </td>
     
    <td width="6%" align="center">
    	<c:choose>
    		<c:when test="${mv.delete==1 }">
    			<input type="checkbox" checked="checked" name="${mv.moduleId }" value="2"> 
    		</c:when>
    		<c:otherwise>
    			<input type="checkbox" name="${mv.moduleId }" value="2">
    		</c:otherwise>
    	</c:choose>
    </td>
    
    <td width="7%" align="center">
    	<c:choose>
    		<c:when test="${mv.update==1 }">
    			<input type="checkbox" checked="checked" name="${mv.moduleId }" value="4">
    		</c:when>
    		<c:otherwise>
    			<input type="checkbox" name="${mv.moduleId }" value="4"> 
    		</c:otherwise>
    	</c:choose>
    </td>
    
    <td width="7%" align="center">
    	<c:choose>
    		<c:when test="${mv.find==1 }">
    			<input type="checkbox" checked="checked" name="${mv.moduleId }" value="8">
    		</c:when>
    		<c:otherwise>
    			<input type="checkbox" name="${mv.moduleId }" value="8">
    		</c:otherwise>
    	</c:choose>
    </td>
  </tr>
  </c:forEach>
</table>
</form>

</body>
</html>
