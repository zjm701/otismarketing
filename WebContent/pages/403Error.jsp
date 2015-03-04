<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Error403</title>
<script type="text/javascript">
    //强制跳转到新窗口
	if (self.location != top.location) {
		top.location.href = location.href;
	}
</script>
</head>

<body>   
    <center><h1>您没有权限！</h1></center>
</body>
</html>