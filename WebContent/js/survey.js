var cntQuestion = 0;
var questionType = 0;
var questionTypeName;
var callbackAlert = null;

$(function() {	
	$("#alertMsg").dialog({
		autoOpen: false,
		modal: true,
		resizable: false,
		closeOnEscape: false,
		height: 180,
		width: 300,
		buttons: {
			"确  定": function() {
				$(this).dialog("close"); 
				if(callbackAlert != null){
					callbackAlert();
				}
				callbackAlert = null;
			}
		}
	});

    $('#confirmMsg').dialog({
		autoOpen: false,
		modal: true,
		resizable: false,
		closeOnEscape: false,
		height: 180,
		width: 300,
        buttons: {
            "取 消": function() {
                $(this).dialog('close');
            },
            "确  定": function() {
				$(this).dialog("close"); 
				if(callbackAlert != null){
					callbackAlert();
				}
				callbackAlert = null;
			}
        }
    });

	$("#startTime").datepicker({
		showOtherMonths: true,
		selectOtherMonths: true,
	    changeMonth: true,
	    changeYear: true,
	    onClose: function( selectedDate ) {
	    	$("#endTime").datepicker( "option", "minDate", selectedDate );
	    }
	});
	$("#endTime").datepicker({
		showOtherMonths: true,
		selectOtherMonths: true,
	    changeMonth: true,
	    changeYear: true,
	    onClose: function( selectedDate ) {
	    	$("#startTime").datepicker( "option", "maxDate", selectedDate );
	    }
	});
	
	$("#divSingle").draggable({
		revert: "valid",
		start: function (event, ui) {
			questionType = 0; //single
			questionTypeName = "单选题";
		}
	}).button({icons: {primary: "ui-icon-radio-on"}});
	
	$("#divMultiple").draggable({
		revert: "valid",
		start: function (event, ui) {
			questionType = 1; //multiple
			questionTypeName = "多选题";
		}
	}).button({icons: {primary: "ui-icon-check"}});
	
	$("#divQuestion").draggable({
		revert: "valid",
		start: function (event, ui) {
			questionType = 2; //question
			questionTypeName = "问答题";
		}
	}).button({icons: {primary: "ui-icon-document"}});

	$("#main").droppable();
	
	$("#right").droppable({
		activeClass: "ui-state-default",
		hoverClass: "ui-state-hover",
		accept: ":not(.ui-sortable-helper)",
		drop: function( event, ui ) {
	        $(this).find(".placeholder").remove();
	        addQuesion($(this).children().last());
		}
	});

	$("#sortable").sortable({
		items: "li:not(.placeholder)",
		sort: function( event, ui){
			$(this).removeClass("ui-state-default");
		},
		stop: function( event, ui){
			sortQusetions();
		}
	});
});

function checkRequired(obj, name){
	var val = $.trim(obj.val());
	if( val == ""){
		openAlert("填写错误", '请输入"'+name+'"', function(){obj.focus();});
		return false; // not pass
	}else{
		return true; //pass
	}
}

function checkMaxLength(obj, name, max){
	var val = $.trim(obj.val());
	if( val.length > max) {
		openAlert("填写错误", '"'+name+'"的长度不能超过'+max, function(){obj.focus();});
		return false; // not pass
	}else{
		return true; //pass
	}
}

function openAlert(title, msg, callback){
	callbackAlert = callback;
	$("#alertMsg").children('p').first(0).text(msg);
	$("#alertMsg").dialog("option","title", title).dialog("open");
}

function openConfirm(title, msg, callback){
	callbackAlert = callback;
	$("#confirmMsg").children('p').first(0).text(msg);
	$("#confirmMsg").dialog("option","title", title).dialog("open");
}

function toSurveyList(){
	location.href = "findAllSurvey.action";
}

var addQuesion = function(parent){
	var i = ++cntQuestion;
    var question = null;
    
    if(questionType == 0 ){
    	question = $("<li><table><tbody>"+
    			"<tr><td width='40'>Q"+i+"</td><td width='60'><font color='red'>"+questionTypeName+"</font></td><td width='160'><input type='checkbox' name='isRequired' checked />该题可跳过不回答</td><td width='140'><input type='button' onclick='deleteQusetion(this)' value='删除此题'/></td><td><input type='hidden' name='type' value='"+questionType+"'/></td></tr>"+
    			"<tr><td></td><td>问&nbsp;&nbsp;题:</td><td colspan='2'><input type='text' name='question_title' size='35'/></td><td></td></tr>"+
    			"<tr><td></td><td>选项1:</td><td><input type='text' name='option' size='15'/></td><td>选中跳至第<input type='text' name='link' value='"+i+"' size='1'/>题</td><td></td></tr>"+
    			"<tr><td></td><td>选项2:</td><td><input type='text' name='option' size='15'/></td><td>选中跳至第<input type='text' name='link' value='"+i+"' size='1'/>题</td><td></td></tr>"+
    			"<tr><td></td><td colspan='2'><input type='button' onclick='addTr(this,0)' value='新增选项'></td><td></td><td></td></tr>"+
    			"</tbody></table></li>");
    }else if(questionType == 1){
    	question = $("<li><table><tbody>"+
				"<tr><td width='40'>Q"+i+"</td><td width='60'><font color='red'>"+questionTypeName+"</font></td><td width='160'><input type='checkbox' name='isRequired' checked />该题可跳过不回答</td><td width='140'><input type='button' onclick='deleteQusetion(this)' value='删除此题'/></td><td><input type='hidden' name='type' value='"+questionType+"'/></td></tr>"+
				"<tr><td></td><td>问&nbsp;&nbsp;题:</td><td colspan='2'><input type='text' name='question_title' size='35'/></td><td></td></tr>"+
				"<tr><td></td><td>选项1:</td><td><input type='text' name='option' size='15'/></td><td></td><td></td></tr>"+
				"<tr><td></td><td>选项2:</td><td><input type='text' name='option' size='15'/></td><td></td><td></td></tr>"+
				"<tr><td></td><td colspan='2'><input type='button' onclick='addTr(this,1)' value='新增选项'></td><td></td><td></td></tr>"+
				"</tbody></table></li>");
	}else if(questionType == 2){
		question = $("<li><table><tbody>"+
				"<tr><td width='40'>Q"+i+"</td><td width='60'><font color='red'>"+questionTypeName+"</font></td><td width='160'><input type='checkbox' name='isRequired' checked />该题可跳过不回答</td><td width='140'><input type='button' onclick='deleteQusetion(this)' value='删除此题'/></td><td><input type='hidden' name='type' value='"+questionType+"'/></td></tr>"+
				"<tr><td></td><td>问&nbsp;&nbsp;题:</td><td colspan='2'><input type='text' name='question_title' size='35'/></td><td></td></tr>"+
				"</tbody></table></li>");
	}
    if(question != null){
        parent.append(question);        //将子table添加到父div中
    }
};

function deleteQusetion(button){
	cntQuestion--;
	var current_tr = $(button).parent().parent();
	var quesionStr = current_tr.children('td').eq(0).text();
	var questionIndex =  parseInt(quesionStr.substring(1));
	
	var current_li = current_tr.parent().parent().parent();
	
	current_li.nextAll().each(function(i){
		var td = $(this).find("td").eq(0);
		if(td.text().indexOf("Q")==0){
			td.text("Q" + (questionIndex + i));
		}
	});
	
	current_li.remove();
}

function sortQusetions(){
	$("#right li").each(function(i){
		var td = $(this).find("td").eq(0);
		if(td.text().indexOf("Q")==0){
			td.text("Q" + (i + 1));
		}
	});
}

function addTr(button, questionType){
   var current_tr = $(button).parent().parent();
   var optionIndex = current_tr.siblings().size() - 1;
   
   var tr = null;
   if(questionType == 0){
	   tr = $("<tr><td></td><td>选项"+optionIndex+":</td><td><input type='text' name='option' size='15'/></td><td>选中跳至第<input type='text' name='link' value='"+cntQuestion+"' size='1'/>题</td><td><input type='button' onclick='deleteTr(this)' value='删除此项'></td></tr>");
   }else if(questionType == 1){
	   tr = $("<tr><td></td><td>选项"+optionIndex+":</td><td><input type='text' name='option' size='15'/></td><td></td><td><input type='button' onclick='deleteTr(this)' value='删除此项'></td></tr>");
   }
   current_tr.before(tr);
};

function deleteTr(button){
	var current_tr = $(button).parent().parent();
	var optionStr = current_tr.children('td').eq(1).text();
	var optionIndex =  parseInt(optionStr.substring(2, optionStr.length - 1));
	
	current_tr.nextAll().each(function(i){
		var td = $(this).children("td").eq(1);
		if(td.text().indexOf("选项")==0){
			td.text("选项" + (optionIndex + i) +":");
		}
	});
	
	current_tr.remove(); //删除当前tr
}
