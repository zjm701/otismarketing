<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<title>This page is for interface testing</title>
</head>
<body>
	<a href="<%=path%>/webservice/otisService/getSurvey?surveyId=31" target='_blank'>getSurvey</a>
	<form name="form1" action="<%=path%>/webservice/otisService/submitReply" method="post" target='_blank'>
		<input type="button" value="submitReply" onClick="form1.submit()"></intput>
	</form>
</body>
</html>