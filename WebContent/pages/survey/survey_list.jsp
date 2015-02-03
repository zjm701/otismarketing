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
<title>Survey List</title>
<script type="text/javascript" src="../js/jquery-1.10.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/common.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css" />
<script type="text/javascript" src="<%=path%>/js/modernizr.min.js"></script>
<script type="text/javascript" src="<%=path%>/thirdparty/dataTables/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/thirdparty/dataTables/js/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/thirdparty/dataTables/css/jquery.dataTables.css" />

<script type="text/javascript" >
$(document).ready(function () {
    $('#surveyList').dataTable({
        "oLanguage": {
            "sUrl": "<%=path%>/thirdparty/dataTables/jquery.dataTable.cn.txt"
        },
        "sPaginationType": "full_numbers",
        'bPaginate': true,
        "bProcessing": true,
        "bServerSide": false
        //"sAjaxSource": "Home/GetJsonCitys",
    });
});

function publishSurvey(btn){
	var td = $(btn).parent().siblings().first();
	var id = td.find("input:hidden").first().val();
	var title = td.text();
	if( confirm('您确定要发布调查"'+title+'"么?')){
		$.ajax({
			url: "publish.action",//要访问的后台地址
			data: "surveyId=" + id,//要发送的数据
			type: "get", //使用get方法访问后台
			dataType: "json", //返回json格式的数据
			async: true,
			success: function(msg){//msg为返回的数据，在这里做数据绑定
				alert(msg.message);
				location.href = "findAllSurvey.action";
			}
		});
	}
}

function deleteSurvey(btn){
	var td = $(btn).parent().siblings().first();
	var id = td.find("input:hidden").first().val();
	var title = td.text();
	if( confirm('您确定要删除调查"'+title+'"么?')){
		$.ajax({
			url: "delete.action",//要访问的后台地址
			data: "surveyId=" + id,//要发送的数据
			type: "get", //使用get方法访问后台
			dataType: "json", //返回json格式的数据
			async: true,
			success: function(msg){//msg为返回的数据，在这里做数据绑定
				alert(msg.message);
				location.href = "findAllSurvey.action";
			}
		});
	}
}
</script>
</head>
<body>
	<!-- header -->
	<s:include value="../header.jsp" />
	<div class="container clearfix">
		<!--sidebar-->
		<s:include value="../leftMenu.jsp" />
		<div class="main-wrap">
			<div class="crumb-wrap">
				<div class="crumb-list">
					<a href="<%=path%>/pages/index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">问卷管理</span>
				</div>
			</div>
			<div class="result-wrap">
				<div class="result-title">
					<div class="result-list">
						<a href="toAdd"><i class="icon-font">&#xe026;</i>新增问卷</a><br><br>
						<!-- table start -->
						<table id="surveyList" class="display" cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>标题</th>
									<th>创建时间</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="#session.AllSurvey" >
								<tr>
									<td><input type='hidden' name='surveyId' value='<s:property value="surveyId"/>' /><s:property value="title" /></td>
									<td><s:property value="createTime" /></td>
									<td>
										<s:if test="status==0">未发布</s:if>
										<s:elseif test="status==1">已发布</s:elseif>
										<s:elseif test="status==2">已结束</s:elseif>
									</td>
									<td>
										<a href="#">预览</a>
										<s:if test="status==0"><a href="#">修改</a><a href="#" onclick="publishSurvey(this)">发布</a></s:if>
										<s:if test="status==0 || status==2"><a href="#" onclick="deleteSurvey(this)">删除</a></s:if>
									</td>
								</tr>
							    </s:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>