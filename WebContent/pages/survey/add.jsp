<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Survey List</title>
</head>
<body>
	<s:form action="add" method="post">
		<TABLE style="FONT-SIZE: 12px">
			<TBODY>
				<TR>
					<TD>新增调查</TD>
				</TR>
				<TR>
					<TD>调查标题:</TD>
					<TD><INPUT style="WIDTH: 150px" name="title"></TD>
				</TR>
				<TR>
					<TD></TD>
					<TD><input type="submit" value="确认"></TD>
				</TR>
			</TBODY>
		</TABLE>
	</s:form>
</body>
</html>