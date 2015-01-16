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
					<TD>第一题（单选题）:</TD>
				</TR>
				<TR>
					<TD>问题:</TD>
					<TD><INPUT style="WIDTH: 150px" name="qusetion1"></TD>
				</TR>
				<TR>
					<TD>第一项:</TD>
					<TD><INPUT style="WIDTH: 150px" name="qusetion1_option1"></TD>
				</TR>
				<TR>
					<TD>跳转至:</TD>
					<TD><INPUT style="WIDTH: 150px" name="qusetion1_link1"></TD>
				</TR>
				<TR>
					<TD>第二项:</TD>
					<TD><INPUT style="WIDTH: 150px" name="qusetion1_option2"></TD>
				</TR>
				<TR>
					<TD>跳转至:</TD>
					<TD><INPUT style="WIDTH: 150px" name="qusetion1_link2"></TD>
				</TR>
				<TR>
					<TD>第二题（问答题）:</TD>
				</TR>
				<TR>
					<TD>问题:</TD>
					<TD><INPUT style="WIDTH: 150px" name="qusetion2"></TD>
				</TR>
				<TR>
					<TD>第三题（问答题）:</TD>
				</TR>
				<TR>
					<TD>问题:</TD>
					<TD><INPUT style="WIDTH: 150px" name="qusetion3"></TD>
				</TR>
				<TR>
					<TD>第四题（多选题）:</TD>
				</TR>
				<TR>
					<TD>问题:</TD>
					<TD><INPUT style="WIDTH: 150px" name="qusetion4"></TD>
				</TR>
				<TR>
					<TD>第一项:</TD>
					<TD><INPUT style="WIDTH: 150px" name="qusetion4_option1"></TD>
				</TR>
				<TR>
					<TD>第二项:</TD>
					<TD><INPUT style="WIDTH: 150px" name="qusetion4_option2"></TD>
				</TR>
				<TR>
					<TD>第三项:</TD>
					<TD><INPUT style="WIDTH: 150px" name="qusetion4_option3"></TD>
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