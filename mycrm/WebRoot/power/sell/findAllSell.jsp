<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<base href="<%=basePath%>">
<title>销售机会</title>

<link href="css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
	function selectRefer() {
	}
</script>
</head>

<body>
	<table border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="topg"></td>
		</tr>
	</table>

	<table border="0" cellspacing="0" cellpadding="0" class="wukuang">
		<tr>
			<td width="1%"><img src="images/tleft.gif" /></td>
			<td width="33%" align="left">[销售机会管理]</td>

			<td width="63%" align="right">
				<%--添加咨询 --%> <a class="butbg" href="pages/refer/addRefer.jsp">
					<img src="images/button/tianjia.gif" />
			</a>
			</td>
			<td width="3%" align="right"><img src="images/tright.gif" /></td>
		</tr>
	</table>

	<!-- 查询条件：添加或选择马上查询 -->
	<form action="pages/student/listStudent.jsp" method="post">
		<table width="88%" border="0" style="margin: 20px;">
			<tr>
				<td width="10%">（姓名|电话）查询：</td>
				<td width="20%"><input type="text" name="condition" size="20"
					value="" /></td>
				<td width="30%px">客户状态： <select
					name="crmClass.crmCourseType.courseTypeId" onchange="">
						<option value="">--请选择--</option>
						<option value="2c9091c14c78e58b014c78e829b70008">开发中</option>
						<option value="2c9091c14c78e58b014c78e867b80009">已开发</option>
						<option value="2c9091c14c78e58b014c78e867b80009">开发失败</option>
				</select>
				</td>
				<td width="6%">概要查询：</td>
				<td width="18%"><input type="text" name="condition" size="20"
					value="" /></td>
			</tr>
		</table>
	</form>

	<table border="0" cellspacing="0" cellpadding="0"
		style="margin-top:5px;">
		<tr>
			<td><img src="images/result.gif" /></td>
		</tr>
	</table>

	<table width="100%" border="1">

		<tr class="henglan" style="font-weight:bold;">
			<td width="10%" align="center">姓名</td>
			<td width="10%" align="center">电话</td>
			<td width="10%" align="center">来源</td>
			<td width="10%" align="center">状态</td>
			<td width="10%" align="center">营销人员</td>
			<td width="22%" align="center">概要</td>
			<%-- 操作栏 --%>
			<td width="8%" align="center">查看详情</td>
			<td width="8%" align="center">编辑</td>
			<td width="8%" align="center">删除</td>
		</tr>
		<c:forEach items="${devCustoms }" var="d">
			<tr class="tabtd1">
				<td align="center">${d.name }</td>
				<td align="center">${d.phone }</td>
				<td align="center">${d.source }</td>
				<c:choose>
					<c:when test="${d.stateCode=='1'}">
						<td align="center">已开发</td>
					</c:when>
					<c:when test="${d.stateCode=='0'}">
						<td align="center">开发失败</td>
					</c:when>
					<c:otherwise>
						<td align="center">未开发</td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${d.salesOpp.desigStaff==null}">
						<td align="center"><a href="pages/refer/showRefer.jsp">指派销售员</a></td>
					</c:when>
					<c:otherwise>
						<td align="center">${d.salesOpp.desigStaff.name}</td>
					</c:otherwise>
				</c:choose>

				<td align="center">${d.describe}</td>

				<!-- 查看 -->
				<td width="8%" align="center"><a
					href="pages/refer/showRefer.jsp"><img
						src="images/button/view.gif" class="img" /></a></td>


				<!-- 编辑 -->
				<td width="8%" align="center"><a
					href="pages/refer/editRefer.jsp"><img
						src="images/button/modify.gif" class="img" /></a></td>

				<!-- 删除 -->
				<td width="8%" align="center"><a
					href="pages/follow/addOrEditFollow.jsp"><img
						src="images/button/del.gif" class="img" /></a></td>

			</tr>
		</c:forEach>
		<!-- 
  <tr class="tabtd2">
	    <td align="center">张三</td>
	    <td align="center">13812341234</td>
	    <td align="center">2342424</td>
	    <td align="center">
	    	java基础/
	    	1期
	    </td>
	    <td align="center">
	    	资讯中
	    </td>
	    <td align="center">管理员</td>
	    
		<td width="8%" align="center">
			<a href="refer/referAction_findById.action?referId=2c9091c14c79506c014c7981cf370000"><img src="images/button/view.gif" class="img"/></a>
		</td>
		
		<td width="8%" align="center">
			<a href="refer/referAction_preEdit.action?referId=2c9091c14c79506c014c7981cf370000"><img src="images/button/modify.gif" class="img"/></a>
		</td>
		
		
		<td width="8%" align="center">
			<a href="follow/followAction_preAddOrEdit.action?crmRefer.referId=2c9091c14c79506c014c7981cf370000"><img src="images/button/new.gif" class="img"/></a>
		</td>
		
		
		<td width="8%" align="center">
			<a href="refer/referAction_preAddStudent.action?referId=2c9091c14c79506c014c7981cf370000"><img src="images/button/modify.gif" class="img"/></a>
		</td>
		
	</tr>
 -->

	</table>
	<table border="0" cellspacing="0" cellpadding="0" align="center">
		<tr>
			<td align="right"><span>第1/3页</span> <span> <a href="#">[首页]</a>&nbsp;&nbsp;
					<a href="#">[上一页]</a>&nbsp;&nbsp; <a href="#">[下一页]</a>&nbsp;&nbsp;
					<a href="#">[尾页]</a>
			</span></td>
		</tr>
	</table>
<script type="text/javascript">
	$(function(){
		$(".tabtd1").mouseenter(function(){
			console.log("测试")
		})
	})
</script>
</body>
</html>
