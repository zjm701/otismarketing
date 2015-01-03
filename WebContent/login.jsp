<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="login" method="post">
		<TABLE style="FONT-SIZE: 12px">
			<TBODY>
				<TR>
					<TD>用户登录</TD>
				</TR>
				<TR>
					<TD>用户名:</TD>
					<TD><INPUT style="WIDTH: 150px" name="userName"></TD>
				</TR>
				<TR>
					<TD>密码:</TD>
					<TD><INPUT style="WIDTH: 150px" type="password"
						name="password"></TD>
				</TR>
				<TR>
					<TD></TD>
					<TD><input type="submit" value="确认"></TD>
				</TR>
			</TBODY>
	</s:form>

</body>
</html>