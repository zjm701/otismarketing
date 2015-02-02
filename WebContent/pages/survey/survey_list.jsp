<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Survey List</title>
<script type="text/javascript" src="../js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" >
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
<a href="../main" >To Welcome</a>
<a href="toAdd" >Add Survey</a>
<hr>
Survey List
<hr>
<table width="600px" align="left">
	<tr>
		<td>标题</td>
		<td>创建时间</td>
		<td>状态</td>
		<td>操作</td>
	</tr>
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
			<input type="button" value="预览">
			<s:if test="status==0"><input type="button" value="修改"><input type="button" value="发布" onclick="publishSurvey(this)"></s:if>
			<s:if test="status==0 || status==2"><input type="button" value="删除" onclick="deleteSurvey(this)"></s:if>
		</td>
	</tr>
    </s:iterator>
</table>

</body>
</html>