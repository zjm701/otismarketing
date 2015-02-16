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


<script type="text/javascript" charset="utf-8" src="<%=path%>/thirdparty/ueditor1_4_3/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/thirdparty/ueditor1_4_3/ueditor.all.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/thirdparty/ueditor1_4_3/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript">
	function submitForm(){
		document.getElementById("content").value = getContent();
		document.addForm.submit();
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
            <div class="crumb-list"><a href="<%=path%>/pages/index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="<%=path%>/pages/newsManagement/newsInfo.jsp">新闻管理</a><span class="crumb-step">&gt;</span><span>新增新闻</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>添加新闻</h1>
            </div>
            <div class="result-content">
            <form action="<%=path%>/newsManagement/addNews" method="post" id="addForm" name="addForm">
            	标题：<input type="text" name="title"><br><br>
            	<s:hidden name="content" id="content" value=""/>
            
            	<script type="text/plain" id="newsEditor" style="width:1000px;height:240px;"></script><br>
            	<input class="btn btn-primary btn6 mr10" value="提交" type="button" onclick="submitForm()">
			</form>
            </div>
            <div>
			    <h3 id="focush2"></h3>
			</div>
        </div>
    </div>
</div>
<script type="text/javascript">
    //var ue = UE.getEditor('newsEditor');
    var ue = UE.getEditor('newsEditor', {
    	toolbars:[[
					'source', '|', 'undo', 'redo', '|', 'bold', 'italic', 'underline', 'strikethrough', '|',
					'superscript', 'subscript', '|', 'forecolor', 'backcolor', '|', 'removeformat', '|',
					'insertorderedlist', 'insertunorderedlist', '|', 'selectall', 'cleardoc', 'paragraph', '|', 'fontfamily', 'fontsize','|',
					'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|',
					'link', 'unlink', '|', 'simpleupload',  'attachment',
					'horizontal', 'preview', 'fullscreen'  
    	]]
    });
    function getContent() {
    	return UE.getEditor('newsEditor').getContent();
    }
</script>
</body>
</html>