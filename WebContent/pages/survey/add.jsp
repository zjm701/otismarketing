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
<title>新增问卷</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/thirdparty/jquery-ui-1.10.2/lightness/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/common.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css"/>
<style type="text/css">
	#top {float: left; width: 100%; height: auto; margin: 10px 10px 10px 0; }
	#left { float: left; width: 140px; height: 200px; margin: 10px 10px 10px 0; }
	#right { float: left; width: 600px; height: 500px; margin: 10px 10px 10px 0; }
	
	#divSingle { width: 120px; height: 35px; float: top; margin: 10px 10px 10px 0; }
	#divMultiple { width: 120px; height: 35px; float: top; margin: 10px 10px 10px 0; }
	#divQuestion { width: 120px; height: 35px; float: top; margin: 10px 10px 10px 0; }
</style>

<script type="text/javascript" src="<%=path%>/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/modernizr.min.js"></script>
<script type="text/javascript" src="<%=path%>/thirdparty/jquery-ui-1.10.2/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=path%>/thirdparty/jquery-ui-1.10.2/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="<%=path%>/js/survey.js"></script>
<script type="text/javascript" >
$(function() {
	$("input[name='save']").click(function() {
		var title = $("input[name='title']");
		if($.trim(title.val())==""){
			openAlert("填写错误", "请输入问卷的标题!", function(){title.focus();});
			return;
		}
		if(cntQuestion==0){
			openAlert("填写错误", "请至少添加一个问题!");
			return;
		}else{
			var table = null;
			var questions = [];

			var question_title = null;
			var isRequired = 0;
			var type = 0;
			
			for(var index = 1; index <= cntQuestion ;index++){
				table = $("#right table").eq(index-1);
				if(table.length == 0){
					break;
				}else{
					question_title = table.find("input[name='question_title']").first();
					if($.trim(question_title.val())==""){
						openAlert("填写错误", "Q"+index+":请输入题干!", function(){question_title.focus();});
						return;
					}
					if(table.find("input:checkbox").first().is(":checked")){
						isRequired = 0;
					}else{
						isRequired = 1;
					}
					
					type = table.find("input:hidden").first().val();
					
					var option = null;
					var options = new Array();
					var optionsString = "";

					var link = null;
					var links = new Array();
					var linksString = "";
					
					var cntOption = 0;
					var needSubmit = true;
					
					table.find("tr").each(function(i){
						cntOption = i - 2;
						if(i>=2){
							if(!needSubmit){
								return;
							}
							
							option = $(this).find("input[name='option']").first();
							if(option.length >= 1){
								if($.trim(option.val())==""){
									needSubmit = false;
									openAlert("填写错误", "Q"+index+":请输入选项"+(cntOption+1)+"!", function(){option.focus();});
									return;
								}else{
									options[cntOption] = $.trim(option.val());
								}
							}

							link = $(this).find("input[name='link']").first();
							if(link.length >= 1){
								var val = $.trim(link.val());
								if(val==""){
									needSubmit = false;
									openAlert("填写错误", "Q"+index+":请输入选项"+(cntOption+1)+"的选中跳至的下一题！", function(){link.focus();});
									return;
								}else{
									if(isNaN(val) || parseInt(val) <= 0 || parseInt(val) > cntQuestion){
										needSubmit = false;
										openAlert("填写错误", "Q"+index+":选项"+(cntOption+1)+"的选中跳至的下一题必须是 1~"+cntQuestion+" 整数！", function(){link.focus();});
										return;
									}else{
										links[cntOption] = parseInt(val);
									}
								}
							}
						}
					});
					
					if(!needSubmit){
						return;
					}
					if(options.length > 0){
						optionsString = "ʃʃ";
						for(var j = 0; j < options.length; j++){
							optionsString = optionsString + options[j] + "ʃʃ";
						}
					}

					if(links.length > 0){
						linksString = "-";
						for(var k = 0; k < options.length; k++){
							linksString = linksString + links[k] + "-";
						}
					}
					
					var question = {
							title: $.trim(question_title.val()),
							type: parseInt(type),
							isRequired: isRequired,
							orderNO: index,
							optionsString: optionsString,
							linksString: linksString
						};
					questions[index-1] = question;
				}
			}

			var survey = {
				title: $.trim(title.val()),
				description: $.trim($("#description").val()),
				startTime: $.trim($("#startTime").val()),
				endTime: $.trim($("#endTime").val()),
				questions: questions
			};
			
			$.ajax({
				url: "add.action",//要访问的后台地址
				data: "surveyJson=" + JSON.stringify(survey),//要发送的数据
				type: "post", //使用get方法访问后台
				dataType: "json", //返回json格式的数据
				async: true,
				success: function(msg){//msg为返回的数据，在这里做数据绑定
					openAlert("提示", msg.message, toSurveyList);
				}
			});
		}
	});
});
</script>

</head>
<body id="main">
	<!-- header -->
	<s:include value="../header.jsp" />
	<div class="container clearfix">
		<!--sidebar-->
		<s:include value="../leftMenu.jsp" />
		<div class="main-wrap">
			<div class="crumb-wrap">
				<div class="crumb-list">
					<a href="<%=path%>/pages/index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="<%=path%>/survey/findAllSurvey">问卷管理</a><span class="crumb-step">&gt;</span><span>新增问卷</span>
				</div>
			</div>
	        <div class="result-wrap">
            	<div class="result-title">
               		<h1>问卷信息</h1>
            	</div>
	            <div class="result-content">
					<div id="top">
						<table class="insert-tab" width="100%">
							<tr>
								<th width="120"><i class="require-red">*</i>问卷标题:</th>
								<td><input type="text" name="title" style="width: 440px" ></td>
							</tr>
							<tr>
								<th>详细描述:</th>
								<td><textarea id="description" cols="50" rows="3"></textarea></td>
							</tr>
							<tr>
								<th>时&nbsp;&nbsp;&nbsp;&nbsp;间:</th>
								<td>从&nbsp;<input type="text" id="startTime" name="startTime" size="15">&nbsp;到&nbsp;<input type="text" id="endTime" name="endTime" size="15"></td>
							</tr>
							<tr>
								<th></th>
								<td><input type="button" name="save" value="提  交" class="btn btn-primary btn6 mr10" ></td>
							</tr>
						</table>
					</div>
					<div id="content">
						<div id="left">
							<div>题型选择</div>
							<div id="divSingle" class="ui-widget-content">单选题</div>
							<div id="divMultiple" class="ui-widget-content">多选题</div>
							<div id="divQuestion" class="ui-widget-content">问答题</div>
						</div>
						<div id="right" class="ui-widget-content">
							<ul id="sortable">
								<li class="placeholder">拖拽题型到这里，即添加新问题</li>
						    </ul>
						</div>
					</div>
				</div>            
	        </div>
        </div>
    </div>
    
    <div id="alertMsg" >
  		<p></p>
	</div>
</body>
</html>
