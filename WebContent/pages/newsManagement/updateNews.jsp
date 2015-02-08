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


<script type="text/javascript" src="<%=path%>/thirdparty/umeditor1_2_2/third-party/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/thirdparty/ueditor1_4_3/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/thirdparty/ueditor1_4_3/ueditor.all.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/thirdparty/ueditor1_4_3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
	function setValues(){
		document.getElementById("content").value = getContent();
		return true;
	}
	
</script>
</head>
<body>
<!-- header -->
<s:include value="../header.jsp"/>
<div class="container clearfix">
	<!--sidebar-->
    <s:include value="../leftMenu.jsp"/>
    <div class="main-wrap">
         <div class="crumb-wrap">
            <div class="crumb-list"><a href="<%=path%>/pages/index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="<%=path%>/pages/newsManagement/newsInfo.jsp">新闻管理</a><span class="crumb-step">&gt;</span><span>修改新闻</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>修改新闻</h1>
            </div>
            <s:form action="updateNews" namespace="/userManagement" method="post" onsubmit="return setValues()">
	        <table>
	           	<tr>
	            	<td><s:textfield name="title" /></td>
	            </tr>
	        </table>
	        <br>
            <div class="result-content">
            	<s:hidden name="content" id="content" value=""/>
            	<s:hidden name="newsId" id="newsId" />
	            <div>
	            	<script type="text/plain" id="newsEditor" style="width:1000px;height:240px;">${requestScope.content}</script>
	            </div>
	            <br>
            	<input class="btn btn-primary btn6 mr10" value="确定" type="submit" >
            	<input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
            </div>
            </s:form>
            <div>
			    <h3 id="focush2"></h3>
			</div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var ue = UE.getEditor('newsEditor');
//     ue.ready(function() {
//         ue.setContent('<s:property value="content" />');
//     });
    function getContent() {
    	return ue.getContent();
    }
</script>
</body>
</html>