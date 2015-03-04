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
<title>${sessionScope.currentSurvey.title}</title>
<link rel="stylesheet" href="../../thirdparty/jquery-ui-1.10.2/lightness/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/common.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css"/>
<script type="text/javascript" src="<%=path%>/js/modernizr.min.js"></script>

</head>
<body>
	<div class="result-wrap">
		<div class="result-title">
			<h1>${sessionScope.currentSurvey.title}</h1>
		</div>
		<div class="result-content">
			<div id="top">
				<table width="100%">
					<tr>
						<td><s:property value="#session.currentSurvey.description"/></td>
					</tr>
				</table>
			</div>
			<div id="content">
				<hr>
				<table>
					<s:iterator value="#session.currentSurvey.questions" status='st'>
						<tr height="10"></tr>
						<tr>
							<td width="40">Q<s:property value="#st.count"/>:&nbsp;</td>
							<td><s:property value="title" /></td>
						</tr>
						<s:if test="type==0 || type==1">
							<s:generator val="optionsString" separator="ʃʃ" id="options">
							<s:iterator value="#options" id="option">
								<tr>
									<td></td>
									<td>
										<s:if test="type==0">
											<input type="radio" name="Q<s:property value='#st.count'/>" />
										</s:if>
										<s:elseif test="type==1">
											<input type="checkbox" name="Q<s:property value='#st.count'/>" />
										</s:elseif>
										<s:property value="option"/></td>
								</tr>
	                  		</s:iterator>
							</s:generator>
						</s:if>
						<s:elseif test="type==2">
							<tr>
								<td></td>
								<td><textarea id="description" cols="30" rows="2"></textarea></td>
							</tr>
						</s:elseif>
					</s:iterator>
				</table>
				<hr>
			</div>
			<div id="bottom">
				<table width="100%">
					<tr>
						<td>收集时间:&nbsp;从&nbsp;<s:date name="#session.currentSurvey.startTime" format="yyyy-MM-dd"/>&nbsp;到&nbsp;<s:date name="#session.currentSurvey.endTime" format="yyyy-MM-dd"/></td>
					</tr>
					<tr>
						<td>(<s:property value="#session.currentSurvey.author.username"/>)</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
