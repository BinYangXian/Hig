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
    <td width="39%" align="left">[员工管理]</td>
   
    <td width="57%"align="right">
    	<%--高级查询 --%>
		<a href="javascript:void(0)" onclick="condition()"><img src="images/button/gaojichaxun.gif" /></a>
    	<%--员工注入 --%>
	  	<a href="pages/staff/addStaff.jsp">
	  		<img src="images/button/tianjia.gif" />
	  	</a>
      
    </td>
    <td width="3%" align="right"><img src="images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：马上查询 -->
<form id="conditionFormId" action="staff/staffAction_findAll" method="post">
	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">部门：</td>
	    <td width="200px">
	    	
	    	<select name="crmPost.crmDepartment.depId" onchange="changePost(this)">
			    <option value="">--请选择部门--</option>
			    <option value="2c9091c14c78e58b014c78e67de10001">java学院</option>
			    <option value="2c9091c14c78e58b014c78e68ded0002">咨询部</option>
			</select>

	    </td>
	    <td width="80px" >职务：</td>
	    <td width="200px" >
	    	
	    	<select name="crmPost.postId" id="postSelectId">
			    <option value="">--请选择职务--</option>
			    <option value="2c9091c14c78e58b014c78e6b34a0003">总监</option>
			    <option value="2c9091c14c78e58b014c78e6d4510004">讲师</option>
			    <option value="2c9091c14c78e58b014c78e6f2340005">主管</option>
			</select>

	    </td>
	    <td width="80px">姓名：</td>
	    <td width="200px" ><input type="text" name="staffName" size="12" /></td>
	    <td ></td>
	  </tr>
	</table>
</form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="images/result.gif"/></td>
  </tr>
</table>

<table width="100%" border="1" >
  <tr class="henglan" style="font-weight:bold;">
    <td width="10%" align="center">员工姓名</td>
    <td width="6%" align="center">性别</td>
    <td width="12%" align="center">入职时间</td>
    <td width="10%" align="center">电话</td>
    <td width="10%" align="center">email</td>
    <td width="10%" align="center">职务</td>
    <td width="10%" align="center">账号</td>
    <td width="10%" align="center">编辑</td>
  </tr>
  <c:forEach items="${staffVos }" var="s">
    <tr name="showTable"> 
	    <td align="center">${s.name }</td>
	    <td align="center">${s.gender==''?'未填写':s.gender }</td>
	    <td align="center">${s.entryDate==''?'未填写':s.entryDate }</td>
	    <td align="center">${s.phone==''?'未填写':s.phone }</td>
	    <td align="center">${s.email==''?'未填写':s.email }</td>
	    <td align="center">${(s.roleName==''||s.roleName==null)?'未填写':s.roleName }</td>
	    <td align="center">${s.userName==null?'未分配账号':s.userName }</td>
	  	<td width="7%" align="center">
	  		<a href="javascript:void(0)" onclick="updateStaff(this)" staffId=${s.id }><img src="images/button/modify.gif" class="img" /></a>	
	  	</td>
	  </tr>
  </c:forEach>
  
</table>


<%-- 
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第1/3页</span>
        <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
    </td>
  </tr>
</table>
--%>
<script type="text/javascript">
function updateStaff(obj){
	var staffId=$(obj).attr('staffId');
	var staffName;
	var gender;
	var entry_date;
	var phone;
	var email;
	var roleName;
	var userName;
	var arry=[];
	$(obj).parent().parent().find("td").each(function(i,o){
		arry.push($(o).text())
	});
	console.log(staffJson);
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
</body>
</html>
