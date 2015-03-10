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
<title>问卷统计</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/thirdparty/dataTables/css/jquery.dataTables.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/thirdparty/jquery-ui-1.10.2/lightness/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/common.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css" />
<script type="text/javascript" src="<%=path%>/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/modernizr.min.js"></script>
<script type="text/javascript" src="<%=path%>/thirdparty/dataTables/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/thirdparty/dataTables/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="<%=path%>/thirdparty/jquery-ui-1.10.2/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/survey.js"></script>

<script type="text/javascript" >
$(function () {
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
					<a href="<%=path%>/pages/index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">问卷统计</span>
				</div>
			</div>
			<div class="result-wrap">
				<div class="result-title">
					<div class="result-list">
						<!-- table start -->
						<table id="surveyList" class="display" cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>问卷标题</th>
									<th>状态</th>
									<th>截止时间</th>
									<th>创建者</th>
									<th>创建时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="#session.AllSurvey" >
								<tr>
									<td><input type='hidden' name='surveyId' value='<s:property value="surveyId"/>' /><s:property value="title" /></td>
									<td>
										<s:if test="status==0">未发布</s:if>
										<s:elseif test="status==1">收集中</s:elseif>
										<s:elseif test="status==2">已结束</s:elseif>
									</td>
									<td><s:date name="endTime" format="yyyy-MM-dd HH:mm"/></td>
									<td><s:property value="author.username" /></td>
									<td><s:date name="createTime" format="yyyy-MM-dd HH:mm"/></td>
									<td>
										<s:if test="status==1 || status==2"><a href="<%=path%>/statistic/getSurveyStatistic?surveyId=<s:property value="surveyId"/>" target='_blank'>查看统计结果</a></s:if>
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
	
    <div id="alertMsg" >
  		<p></p>
	</div>
    <div id="confirmMsg" >
  		<p></p>
	</div>
</body>
</html>