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
		function selectRefer(){
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
    <td width="1%"><img src="images/tleft.gif"/></td>
    <td width="33%" align="left">[咨询学生管理]</td>
   
    <td width="63%"align="right">
    	<%--添加咨询 --%>
    	<a class="butbg" href="pages/refer/addRefer.jsp">
	        <img src="images/button/tianjia.gif" />
    	</a>
    </td>
    <td width="3%" align="right"><img src="images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：失去焦点马上查询 -->
<form action="" method="post">
	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">查询条件：</td>
	    <td width="300px">
	    	<input type="text" name="condition" size="20" onblur="" />
	    	（姓名|电话|QQ）
	    </td>
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
	<td width="80px" align="center">姓名</td>
	<td width="9%" align="center">电话</td>
	<td width="11%" align="center">QQ </td>
	<td width="15%" align="center">意向类别/班级</td>
	<td width="17%" align="center">状态</td>
	<td width="10%" align="center">营销人员</td>
	<td width="8%" align="center">查看</td>
	<%-- 根据状态不同显示操作项 --%>
	<td width="8%" align="center">编辑</td>
	<td width="8%" align="center">跟踪</td>
	<td width="8%" align="center">录入学籍</td>
  </tr>
  <tr class="tabtd1">
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
	    
	    <!-- 查看 -->
		<td width="8%" align="center">
			<a href="pages/refer/showRefer.jsp"><img src="images/button/view.gif" class="img"/></a>
		</td>
		
		
		<!-- 编辑 -->
		<td width="8%" align="center">
			<a href="pages/refer/editRefer.jsp"><img src="images/button/modify.gif" class="img"/></a>
		</td>
		
		<!-- 添加跟踪 -->
		<td width="8%" align="center">
			<a href="pages/follow/addOrEditFollow.jsp"><img src="images/button/new.gif" class="img"/></a>
		</td>
		
		<!-- 入学 -->
		<td width="8%" align="center">
			<a href="pages/refer/addStudent.jsp"><img src="images/button/modify.gif" class="img"/></a>
		</td>
		
	</tr>
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
		
		
		<!-- 编辑 -->
		<td width="8%" align="center">
			<a href="refer/referAction_preEdit.action?referId=2c9091c14c79506c014c7981cf370000"><img src="images/button/modify.gif" class="img"/></a>
		</td>
		
		<!-- 添加跟踪 -->
		<td width="8%" align="center">
			<a href="follow/followAction_preAddOrEdit.action?crmRefer.referId=2c9091c14c79506c014c7981cf370000"><img src="images/button/new.gif" class="img"/></a>
		</td>
		
		<!-- 入学 -->
		<td width="8%" align="center">
			<a href="refer/referAction_preAddStudent.action?referId=2c9091c14c79506c014c7981cf370000"><img src="images/button/modify.gif" class="img"/></a>
		</td>
		
	</tr>

</table>
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

</body>
</html>
