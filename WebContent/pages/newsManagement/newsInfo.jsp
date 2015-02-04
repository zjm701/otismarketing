<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Oits后台管理</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/common.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css" />
<script type="text/javascript" src="<%=path%>/js/modernizr.min.js"></script>
<script type="text/javascript" src="<%=path%>/thirdparty/dataTables/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/thirdparty/dataTables/js/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/thirdparty/dataTables/css/jquery.dataTables.css" />

<script type="text/javascript">
$(document).ready(function () {
    $('#userList').dataTable({
        "oLanguage": {
            "sUrl": "<%=path%>/thirdparty/dataTables/jquery.dataTable.cn.txt"
        },
        "sPaginationType": "full_numbers",
        'bPaginate': true,
        "bProcessing": true,
        "ajax": "<%=basePath%>userManagement/getAllUsers",
        "columns": [
                    { "data": "id" },
                    { "data": "name" },
                    { "data": "createDate" },
                    { "data": "updateDate" }
                   ]
    });
});
</script>
	
</head>
<body>
	<!-- header -->
	<s:include value="header.jsp" />
	<div class="container clearfix">
		<!--sidebar-->
		<s:include value="leftMenu.jsp"></s:include>
		<div class="main-wrap">
			<div class="crumb-wrap">
				<div class="crumb-list">
					<a href="<%=path%>/pages/index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">用户管理</span>
				</div>
			</div>
			<div class="result-wrap">
				<div class="result-title">
					<div class="result-list">
						<a href="<%=path%>/pages/addUser.jsp"><i class="icon-font">&#xe026;</i>新增用户</a><br><br>
						<!-- table start -->
						<table id="userList" class="display" cellspacing="0" width="100%">
						    <thead>
						        <tr>
						            <th>ID</th>
						            <th>姓名</th>
						            <th>创建时间</th>
						            <th>更新时间</th>
						           	<!-- <th>操作</th> -->
						        </tr>
						    </thead>
						</table>
					
					<!-- table end -->
				</div>
			</div>
			</div>
		</div>
	</div>
</body>
</html>