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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Oits后台管理</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/common.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css"/>
<script type="text/javascript" src="<%=path%>/js/modernizr.min.js"></script>
</head>
<body>
<!-- header -->
<s:include value="header.jsp"/>
<div class="container clearfix">
	<!--sidebar-->
    <s:include value="leftMenu.jsp"/>
    <div class="main-wrap">
         <div class="crumb-wrap">
            <div class="crumb-list"><a href="<%=path%>/pages/index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="<%=path%>/pages/userInfo.jsp">用户管理</a><span class="crumb-step">&gt;</span><span>新增用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>用户信息</h1>
            </div>
            <div class="result-content">
                <form action="<%=path%>/userManagement/addUser" method="post" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        	<tr>
                            <th width="120"><i class="require-red">*</i>用户名：</th>
                            <td>
                                <input class="common-text required" id="userName" name="userName" size="50" value="" type="text">
                            </td>
                        	</tr>
                            <tr>
                                <th><i class="require-red">*</i>密码：</th>
                                <td>
                                    <input class="common-text required" id="password" name="password" size="50" value="" type="password">
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>