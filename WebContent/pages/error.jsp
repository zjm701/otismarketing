<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>Error</title></head>
<body>
    <h3>Exception:</h3>
    <s:property value="exception"/>

    <h3>错误信息:</h3>
    <pre>
        <s:property value="exceptionStack"/>
    </pre>
</body>
</html>