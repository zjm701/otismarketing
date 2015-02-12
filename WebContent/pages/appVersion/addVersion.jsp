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
<s:include value="../header.jsp"/>
<div class="container clearfix">
	<!--sidebar-->
    <s:include value="../leftMenu.jsp"/>
    <div class="main-wrap">
         <div class="crumb-wrap">
            <div class="crumb-list"><a href="<%=path%>/pages/index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="#">App版本管理</a><span class="crumb-step">&gt;</span><span>新增App版本</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>版本信息</h1>
            </div>
            <div class="result-content">
                <form action="<%=path%>/appVersion/addVersion" method="post" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        	<tr>
                            <th width="120"><i class="require-red">*</i>版本：</th>
                            <td>
                                <input class="common-text required" id="versionName" name="versionName" size="30" value="" type="text">
                            </td>
                        	</tr>
                            <tr>
                                <th><i class="require-red">*</i>下载地址：</th>
                                <td>
                                    <input class="common-text required" id="downLoadLink" name="downLoadLink" size="100" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="确定" type="submit">
                                    <input class="btn btn6" onclick="window.location.href='<%=path%>/appVersion/goAppVersion'" value="返回" type="button">
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