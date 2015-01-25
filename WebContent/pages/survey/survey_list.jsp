<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Survey List</title>
</head>
<body>
<a href="../main" >To Welcome</a>
<a href="toAdd" >Add Survey</a>
<hr>
Survey List
<hr>
<table width="400px" align="left">
	<tr>
		<td>标题</td>
		<td>创建时间</td>
		<td>状态</td>
	</tr>
	<s:iterator value="#session.AllSurvey" >
	<tr>
		<td><s:property value="title" /></td>
		<td><s:property value="createTime" /></td>
		<td>
			<s:if test="status==0">未发布</s:if>
			<s:elseif test="status==1">已发布</s:elseif>
			<s:elseif test="status==2">已结束</s:elseif>
		</td>
	</tr>
    </s:iterator>
</table>

</body>
</html>