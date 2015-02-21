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
    $('#newsList').dataTable({
        "oLanguage": {
            "sUrl": "<%=path%>/thirdparty/dataTables/jquery.dataTable.cn.txt"
        },
        "sPaginationType": "full_numbers",
        'bPaginate': true,
        "bProcessing": true,
        "bServerSide": false,
        "aoColumnDefs": [{"bSortable": false, "aTargets": [4]}] 
    });
//     $('#newsList tbody').on( 'click', 'a', function () {
//         var data = $('#newsList').dataTable.row( $(this).parents('tr') ).data();
//         alert( data[0] +"'s status is: "+ data[ 3 ] );
//     } );
    
});

function deleteNews(newsId) {
	if(confirm('确定要删除?')){
		window.location = "<%=path%>/newsManagement/deleteNews?newsId=" + newsId;
	}
}

</script>
	
</head>
<body>
	<!-- header -->
	<s:include value="../header.jsp" />
	<div class="container clearfix">
		<!--sidebar-->
		<s:include value="../leftMenu.jsp"></s:include>
		<div class="main-wrap">
			<div class="crumb-wrap">
				<div class="crumb-list">
					<a href="<%=path%>/pages/index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">新闻管理</span>
				</div>
			</div>
			<div class="result-wrap">
				<div class="result-title">
					<div class="result-list">
						<a href="<%=path%>/pages/newsManagement/addNews.jsp"><i class="icon-font">&#xe026;</i>新增新闻</a><br><br>
						<!-- table start -->
						<table id="newsList" class="display" cellspacing="0" width="100%">
						    <thead>
						        <tr>
						            <th>ID</th>
						            <th>标题</th>
						            <th>状态</th>
						            <th>创建时间</th>
						           	<th>操作</th>
						        </tr>
						    </thead>
						    <tbody>
								<s:iterator value="data" id="data">
								<tr>
									<td><s:property value="#data.id"/></td>
									<td>
										<s:property value="#data.title"/>
									</td>
									<td>
										<s:if test="status==0">未发布</s:if>
										<s:elseif test="status==1">已发布</s:elseif>
									</td>
									<td><s:property value="#data.createTime" /></td>
									<td>
										<a href="previewNews?newsId=<s:property value="#data.id"/>" >查看</a>
										<s:if test="#data.status==0"><a href="initUpdateNews?newsId=<s:property value="#data.id"/>" >修改</a><a href="#" onclick="deleteNews(<s:property value="#data.id"/>)" >删除</a><a href="#" >发布</a></s:if>
									</td>
								</tr>
							    </s:iterator>
							</tbody>
						</table>
					
					<!-- table end -->
				</div>
			</div>
			</div>
		</div>
	</div>
</body>
</html>