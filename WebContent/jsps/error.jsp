<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

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