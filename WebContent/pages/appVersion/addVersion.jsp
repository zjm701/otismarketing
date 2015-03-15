<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Oits后台管理</title>

<link rel="stylesheet" type="text/css" href="<%=path%>/css/stream-v1.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/common.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css"/>
<script type="text/javascript" src="<%=path%>/js/modernizr.min.js"></script>
<script type="text/javascript">
function checkInput() {
	var isSubmit = false;
	if (document.getElementById("versionNameInput").value == null || document.getElementById("versionNameInput").value == '') {
		alert("请输入版本！");
	}else if (document.getElementById("downLoadLink").value == null || document.getElementById("downLoadLink").value == '') {
		alert("请上传最新版本！");
	}else {
		document.getElementById("versionName").value = document.getElementById("versionNameInput").value;
		isSubmit = true;
	}
	return isSubmit;
}
</script>
</head>
<body>
<s:include value="../header.jsp"/>
<div class="container clearfix">
	<!--sidebar-->
    <s:include value="../leftMenu.jsp"/>
    <div class="main-wrap">
         <div class="crumb-wrap">
            <div class="crumb-list"><a href="<%=path%>/pages/index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="<%=path%>/appVersion/getVersionsInfoList">App版本管理</a><span class="crumb-step">&gt;</span><span>新增App版本</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>版本信息</h1>
            </div>
            <div class="result-content">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        	<tr>
                            <th width="120"><i class="require-red">*</i>版本：</th>
                            <td>
                                <input class="common-text required" id="versionNameInput" name="versionName" size="30" value="" type="text">
                            </td>
                        	</tr>
                            <tr>
                                <th><i class="require-red">*</i>文件上传：</th>
                                <td>
                                    <div id="i_select_files" style="width:600px;height:70px"></div>
									<div id="i_stream_files_queue"></div>
									<button onclick="javascript:_t.upload();">开始上传</button>
<!-- 									</br>上传信息: -->
<!-- 	<div id="i_stream_message_container" class="stream-main-upload-box" style="overflow: auto;height:200px;"> -->
<!-- 	</div> -->
                                </td>
                            </tr>
                            <tr>
                                <th>上传地址:</th>
                                <td id="downLoadLinkTd">
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                <s:form action="addVersion" namespace="/appVersion" method="post" onsubmit="return checkInput();">
				                	<input type="hidden" id="versionName" name="versionName" value="" />
				                	<input type="hidden" id="downLoadLink" name="downLoadLink" value="" />
				                	<input type="hidden" id="uploadFileName" name="uploadFileName" value="" />
                                    <input class="btn btn-primary btn6 mr10" value="确定" type="submit">
                                    <input class="btn btn6" onclick="window.location.href='<%=path%>/appVersion/getVersionsInfoList'" value="返回" type="button">
                                </s:form>
                                </td>
                            </tr>
                        </tbody></table>
            </div>
        </div>
    </div>
</div>
   
<!--                                     <input class="common-text required" id="downLoadLink" name="downLoadLink" size="100" value="" type="text"> -->
									
<script type="text/javascript" src="<%=path%>/js/stream-v1.js"></script>
<script type="text/javascript">
/**
 * 配置文件（如果没有默认字样，说明默认值就是注释下的值）
 * 但是，on*（onSelect， onMaxSizeExceed...）等函数的默认行为
 * 是在ID为i_stream_message_container的页面元素中写日志
 */
	var config = {
		uploadPath: "http://localhost:8080" + "/install/file/",
		browseFileId : "i_select_files", /** 选择文件的ID, 默认: i_select_files */
		browseFileBtn : "<div>请选择文件</div>", /** 显示选择文件的样式, 默认: `<div>请选择文件</div>` */
		dragAndDropArea: "i_select_files", /** 拖拽上传区域，Id（字符类型"i_select_files"）或者DOM对象, 默认: `i_select_files` */
		dragAndDropTips: "<span>或把文件拖拽到这里</span>", /** 拖拽提示, 默认: `<span>把文件(文件夹)拖拽到这里</span>` */
		filesQueueId : "i_stream_files_queue", /** 文件上传容器的ID, 默认: i_stream_files_queue */
		filesQueueHeight : 100, /** 文件上传容器的高度（px）, 默认: 450 */
		messagerId : "i_stream_message_container", /** 消息显示容器的ID, 默认: i_stream_message_container */
		multipleFiles: false, /** 多个文件一起上传, 默认: false */
		autoUploading: false, /** 选择文件后是否自动上传, 默认: true */
//		autoRemoveCompleted : true, /** 是否自动删除容器中已上传完毕的文件, 默认: false */
		maxSize: 60814233600,
//		maxSize: 104857600//, /** 单个文件的最大大小，默认:2G */
//		retryCount : 5, /** HTML5上传失败的重试次数 */
//		postVarsPerFile : { /** 上传文件时传入的参数，默认: {} */
//			param1: "val1",
//			param2: "val2"
//		},
//		swfURL : "/swf/FlashUploader.swf", /** SWF文件的位置 */
		tokenURL : "/otismarketing/tk", /** 根据文件名、大小等信息获取Token的URI（用于生成断点续传、跨域的令牌） */
		frmUploadURL : "/otismarketing/fd;", /** Flash上传的URI */
		uploadURL : "/otismarketing/upload", /** HTML5上传的URI */
		simLimit: 1, /** 单次最大上传文件个数 */
		extFilters: [".txt", ".rpm", ".rmvb", ".gz", ".rar", ".zip", ".avi", ".mkv", ".mp3", ".xlsx", ".xls", ".vmdk",".zip",".deb",".ipa",".pxl"], /** 允许的文件扩展名, 默认: [] */
//		onSelect: function(list) {alert('onSelect')}, /** 选择文件后的响应事件 */
//		onMaxSizeExceed: function(size, limited, name) {alert('onMaxSizeExceed')}, /** 文件大小超出的响应事件 */
//		onFileCountExceed: function(selected, limit) {alert('onFileCountExceed')}, /** 文件数量超出的响应事件 */
//		onExtNameMismatch: function(name, filters) {alert('onExtNameMismatch')}, /** 文件的扩展名不匹配的响应事件 */
//		onCancel : function(file) {alert('Canceled:  ' + file.name)}, /** 取消上传文件的响应事件 */
//		onComplete: function(file) {alert('onComplete')}, /** 单个文件上传完毕的响应事件 */
//		onQueueComplete: function() {alert('onQueueComplete')}, /** 所以文件上传完毕的响应事件 */
//		onUploadError: function(status, msg) {alert('onUploadError')} /** 文件上传出错的响应事件 */
//		onDestroy: function() {alert('onDestroy')} /** 文件上传出错的响应事件 */
	};
	var _t = new Stream(config);
	
</script>
                          
</body>
</html>