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
<link rel="stylesheet" href="../thirdparty/jquery-ui-1.10.2/lightness/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/common.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css"/>
<script type="text/javascript" src="<%=path%>/js/modernizr.min.js"></script>

<style type="text/css">
	#top {float: left; width: 100%; height: auto; margin: 10px 10px 10px 0; }
	#left { float: left; width: 120px; height: 200px; margin: 10px 10px 10px 0; }
	#right { float: left; width: 600px; height: 500px; margin: 10px 10px 10px 0; }
	
	#divSingle { width: 120px; height: 35px; float: top; margin: 10px 10px 10px 0; }
	#divMultiple { width: 120px; height: 35px; float: top; margin: 10px 10px 10px 0; }
	#divQuestion { width: 120px; height: 35px; float: top; margin: 10px 10px 10px 0; }
</style>

<script type="text/javascript" src="../js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="../thirdparty/jquery-ui-1.10.2/jquery-ui.min.js"></script>
<script type="text/javascript" >
var left1,left2,left2;
var top1,top2,top3;
var cntQuestion = 0;
var questionType = 0;
var questionTypeName;
$(document).ready( function () {
	left1 =  $("#divSingle").position().left;
	top1 =  $("#divSingle").position().top;
	
	left2 =  $("#divMultiple").position().left;
	top2 =  $("#divMultiple").position().top;
	
	left3 =  $("#divQuestion").position().left;
	top3 =  $("#divQuestion").position().top;
});

$(function() {
	$("#startTime").datepicker({
		option: {dateFormat : "yy-mm-dd"},
		showOtherMonths: true,
		selectOtherMonths: true,
	    changeMonth: true,
	    changeYear: true,
	    onClose: function( selectedDate ) {
	    	$("#endTime").datepicker( "option", "minDate", selectedDate );
	    }
	});
	$("#endTime").datepicker({
		option: $.datepicker.regional[ "zh-CN" ],
		showOtherMonths: true,
		selectOtherMonths: true,
	    changeMonth: true,
	    changeYear: true,
	    onClose: function( selectedDate ) {
	    	$("#startTime").datepicker( "option", "maxDate", selectedDate );
	    }
	});
	$("#startTime").datepicker( "option", "dateFormat", "yy-mm-dd" );
	$("#endTime").datepicker( "option", "dateFormat", "yy-mm-dd" );
	
	$("#divSingle").draggable({
		start: function (event, ui) {
			questionType = 0; //single
			questionTypeName = "单选题";
		}
	}).button({icons: {primary: "ui-icon-radio-on"}});
	
	$("#divMultiple").draggable({
		start: function (event, ui) {
			questionType = 1; //multiple
			questionTypeName = "多选题";
		}
	}).button({icons: {primary: "ui-icon-check"}});
	
	$("#divQuestion").draggable({
		start: function (event, ui) {
			questionType = 2; //question
			questionTypeName = "问答题";
		}
	}).button({icons: {primary: "ui-icon-document"}});

	$("#main").droppable({
		drop: function( event, ui ) {
			$("#divSingle").css({position: "absolute", left:left1, top:top1});
			$("#divMultiple").css({position: "absolute", left:left2, top:top2});
			$("#divQuestion").css({position: "absolute", left:left3, top:top3});
		}
	});
	
	$("#right").droppable({
		drop: function( event, ui ) {
			addQuesion($(this));
			
			$("#divSingle").css({position: "absolute", left:left1, top:top1});
			$("#divMultiple").css({position: "absolute", left:left2, top:top2});
			$("#divQuestion").css({position: "absolute", left:left3, top:top3});
		}
	});
	
	$("input[name='save']").click(function() {
		var title = $("input[name='title']");
		if($.trim(title.val())==""){
			alert("请输入问卷的标题!");
			title.focus();
			return;
		}
		if(cntQuestion==0){
			alert("请至少添加一个问题!");
			return;
		}else{
			var questions = [];

			var isRequired = 0;
			var question_title = null;
			var type = 0;

			for(var index = 1; index <= cntQuestion ;index++){	//后续tr依次前移
				table = $("#question_"+index);
				if(table.length == 0){
					break;
				}else{
					question_title = table.find("input[name='question_title']").first();
					if($.trim(question_title.val())==""){
						alert("Q"+index+":请输入问题!");
						question_title.focus();
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
									alert("Q"+index+":请输入选项"+(cntOption+1)+"!");
									option.focus();
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
									alert("Q"+index+":请输入选项"+(cntOption+1)+"的选中跳至的下一题！");
									link.focus();
									return;
								}else{
									if(isNaN(val) || parseInt(val) <= 0 || parseInt(val) > cntQuestion){
										needSubmit = false;
										alert("Q"+index+":选项"+(cntOption+1)+"的选中跳至的下一题必须是1~"+cntQuestion+"整数！");
										link.focus();
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
						optionsString = "-";
						for(var j = 0; j < options.length; j++){
							optionsString = optionsString + options[j] + "-";
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

			alert(":"+JSON.stringify(survey));
			
			$.ajax({
				url: "add.action",//要访问的后台地址
				data: "surveyJson=" + JSON.stringify(survey),//要发送的数据
				type: "post", //使用get方法访问后台
				dataType: "json", //返回json格式的数据
				async: true,
				success: function(msg){//msg为返回的数据，在这里做数据绑定
					alert(msg.message);
					location.href = "findAllSurvey.action";
				}
			});
		}
	});
});

var addQuesion = function(parent){
	var i = ++cntQuestion;
    var question = null;
    
    if(questionType == 0 ){
    	question = $("<table id='question_"+ i + "'>"+
    			"<tr><td>Q"+i+"</td><td><font color='red'>"+questionTypeName+"</font></td><td>&nbsp;<input type='checkbox' name='isRequired' checked='true' value='1' />该题可跳过不回答</td><td>&nbsp;<input type='button' onclick='deleteQusetion("+i+")' value='删除此题'></td><td><input type='hidden' name='type' value='"+questionType+"'></td></tr>"+
    			"<tr><td></td><td>问题:</td><td colspan='2'><input type='text' name='question_title' size='30'/></td><td></td></tr>"+
    			"<tr id='tr_1'><td></td><td>选项1:</td><td><input type='text' name='option' size='10'/></td><td>选中跳至<input type='text' name='link' value='"+i+"' size='1'/>题</td><td></td></tr>"+
    			"<tr id='tr_2'><td></td><td>选项2：</td><td><input type='text' name='option' size='10'/></td><td>选中跳至<input type='text' name='link' value='"+i+"' size='1'/>题</td><td></td></tr>"+
    			"<tr><td></td><td colspan='2'><input type='button' onclick=\"addTr("+i+",0)\" value='新增选项'></td><td></td><td></td></tr>"+
    			"</table>");
    }else if(questionType == 1){
    	question = $("<table id='question_"+ i + "'>"+
				"<tr><td>Q"+i+"</td><td><font color='red'>"+questionTypeName+"</font></td><td>&nbsp;<input type='checkbox' name='isRequired' checked='true' value='1' />该题可跳过不回答</td><td>&nbsp;<input type='button' onclick='deleteQusetion("+i+")' value='删除此题'></td><td><input type='hidden' name='type' value='"+questionType+"'></td></tr>"+
				"<tr><td></td><td>问题:</td><td colspan='2'><input type='text' name='question_title' size='30'/></td><td></td></tr>"+
				"<tr id='tr_1'><td></td><td>选项1:</td><td><input type='text' name='option' size='10'/></td><td></td><td></td></tr>"+
				"<tr id='tr_2'><td></td><td>选项2：</td><td><input type='text' name='option' size='10'/></td><td></td><td></td></tr>"+
				"<tr><td></td><td colspan='2'><input type='button' onclick=\"addTr("+i+",1)\" value='新增选项'></td><td></td><td></td></tr>"+
				"</table>");
	}else if(questionType == 2){
		question = $("<table id='question_"+ i + "'>"+
				"<tr><td>Q"+i+"</td><td><font color='red'>"+questionTypeName+"</font></td><td>&nbsp;<input type='checkbox' name='isRequired' checked='true' value='1' />该题可跳过不回答</td><td>&nbsp;<input type='button' onclick='deleteQusetion("+i+")' value='删除此题'></td><td><input type='hidden' name='type' value='"+questionType+"'></td></tr>"+
				"<tr><td></td><td>问题:</td><td colspan='2'><input type='text' name='question_title' size='30'/></td></tr>"+
				"</table>");
	}
    if(question != null){
        parent.append(question);        //将子table添加到父div中
    }
};

function deleteQusetion(questionIndex){
	cntQuestion--;
	$("#question_"+questionIndex).remove();
	
	var table = null;
	for(var index = questionIndex; ;index++){	//后续tr依次前移
		table = $("#question_"+(index+1));
		if(table.length == 0){
			break;
		}else{
			table.attr("id", "question_"+index);
			table.find("tr").each(function(i){
				if(i==0){//第一行
					$(this).find("td").first().text("Q"+index);
					$(this).find("input:button").first().attr("onclick", function(i,origValue){ return origValue.replace("deleteQusetion("+(index+1)+")", "deleteQusetion("+index+")");});
				}else if(i>=4){
					$(this).find("input:button").first().attr("onclick", function(i,origValue){ return origValue.replace("deleteTr("+(index+1)+",", "deleteTr("+index+",");});
					$(this).find("input:button").first().attr("onclick", function(i,origValue){ return origValue.replace("addTr("+(index+1)+",", "addTr("+index+",");});
				}
			});
		}
	}
}

function addTr(questionIndex, questionType){
   var tr=$("#question_"+questionIndex+" tr").eq(-2);
   var idString = tr.attr("id");
   var optionIndex = parseInt(idString.substring(idString.indexOf("_")+1)) + 1;
   
   var trHtml = null;
   if(questionType == 0){
	   trHtml = $("<tr id='tr_"+(optionIndex)+"'><td></td><td>选项"+optionIndex+"：</td><td><input type='text' name='option' size='10'/></td><td>选中跳至<input type='text' name='link' value='"+cntQuestion+"' size='1'/>题</td><td><input type='button' onclick=\"deleteTr("+questionIndex+","+optionIndex+")\" value='删除此项'></td></tr>");
   }else if(questionType == 1){
	   trHtml = $("<tr id='tr_"+(optionIndex)+"'><td></td><td>选项"+optionIndex+"：</td><td><input type='text' name='option' size='10'/></td><td></td><td><input type='button' onclick=\"deleteTr("+questionIndex+","+optionIndex+")\" value='删除此项'></td></tr>");
   }
   tr.after(trHtml);
};

function deleteTr(questionIndex, optionIndex){
	$("#question_"+questionIndex+" #tr_"+optionIndex).remove(); //删除当前tr
	
	var tr = null;
	for(var index = optionIndex; ;index++){	//后续tr依次前移
		tr = $("#question_"+questionIndex+" #tr_"+(index+1));
		if(tr.length == 0){
			break;
		}else{
			tr.attr("id", "tr_"+index);
			tr.find("td").each(function(i){
				if(i==1){//第二格
					$(this).text("选项"+index+":");
				}else if(i==4){//第五格
					$(this).find("input").attr("onclick", function(i,origValue){ return origValue.replace(","+(index+1)+")", ","+index+")");});
				}
			});
		}
	}
}

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
								<td><input type="text" name="title" style="width: 430px" ></td>
							</tr>
							<tr>
								<th>详细描述:</th>
								<td><textarea id="description" cols="50" rows="3"></textarea></td>
							</tr>
							<tr>
								<th>时&nbsp;&nbsp;间:</th>
								<td>从&nbsp;<input type="text" id="startTime" name="startTime" size="15">&nbsp;到&nbsp;<input type="text" id="endTime" name="endTime" size="15"></td>
							</tr>
							<tr>
								<th></th>
								<td><input type="button" name="save" value="保存" class="btn btn-primary btn6 mr10" ></td>
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
						<div id="right">
						</div>
					</div>
				</div>            
	        </div>
        </div>
    </div>
</body>
</html>
