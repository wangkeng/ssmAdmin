//添加loding
function ajaxLoading() {
	$("<div class=\"datagrid-mask\"></div>").css({
		backgroundColor : "white",
		border : "0px",
		display : "block",
		width : "100%",
		height : $(window).height()
	}).appendTo("body");
	$("<div class=\"datagrid-mask-msg\"></div>").html("loading。。。").appendTo(
			"body").css({
		display : "block",
		left : ($(document.body).outerWidth(true) - 190) / 2,
		top : ($(window).height() - 45) / 2
	});
}
//去掉loding
function ajaxLoadEnd() {
	$(".datagrid-mask").remove();
	$(".datagrid-mask-msg").remove();
}
// 在又部添加选项卡 url:路径名称 name:iframe的名称（以便刷新列表的时候判断） mtitle:iframe的名称（用于判断tab是否存在）
function showTab(url, mtitle) {
	if (!$('#mainTab').tabs('exists', mtitle)) {
		var content = "<iframe scrolling=\"auto\" frameborder=\"0\"  src='"
				+ url + "' style=\"width:100%;height:100%;\" name=" + mtitle
				+ "></iframe>";
		$('#mainTab').tabs('add', {
			title : mtitle,
			content : content,
			closable : true
		});
	} else {
		$('#mainTab').tabs('select', mtitle);
	}
}

//菜单栏的效果
function dddStyle() {
	$(".menuStyle").css('color', 'gray');
	$(".menuStyle").hover(function() {// 对div的处理
		$(this).css('backgroundColor', '#D4D4D4');
		$(this).css('cursor', 'pointer');
	}, function() {
		$(this).css('backgroundColor', 'white');
	});
	$(".menuStyle").click(function() {
		$(".menuStyle").css('color', 'gray');
		$(this).css('color', 'black');
	});
}

// 对话框的显示和设置 url:路径 t:标题 l:左边距离 top:顶部距离 w:对话框宽度 h:对话框高度
function showWin(url, title, height, width, left, top) {

	var divId = "#dd1";
	if ($(divId).panel('options').closed) {
		$("#win1").attr("src", url);
		openWin(divId, url, title, height, width, left, top);
		return;
	}

	divId = "#dd2";
	if ($(divId).panel('options').closed) {
		$("#win2").attr("src", url);
		openWin(divId, url, title, height, width, left, top);
		return;
	}

	divId = "#dd3";
	if ($(divId).panel('options').closed) {
		$("#win3").attr("src", url);
		openWin(divId, url, title, height, width, left, top);
		return;
	}
}

function openWin(divId, url, title, height, width, left, top) {

	$(divId).dialog({
		width : width,
		height : height,
		title : title,
		modal : true,
		left : left,
		top : top,
		onClose : function() {
			if (divId == "#dd1") {
				$("#win1").attr("src", "blank.html");
			} else if (divId == "#dd2") {
				$("#win2").attr("src", "blank.html");
			} else if (divId == "#dd3") {
				$("#win3").attr("src", "blank.html");
			}

		}
	});
	$(divId).dialog("open");
}

//关掉窗口
function closeDialog(hanshu) {
	eval("$('#" + hanshu + "').dialog('close')");
}

//打开文件上传窗口
function openFileUpLoadWin(url, title) {
	$("#fileUpLoadFrame").attr("src", url);
	$("#fileUpLoad").dialog({
		width : 950,
		height : 550,
		title : title,
		modal : true,
		left : 200,
		top : 50,
		onClose : function() {
			$("#fileUpLoadFrame").attr("src", "blank.html");
		}
	});
	$("#fileUpLoad").dialog("open");
}

//右下角提示框
function showMessager(msg) {
	$.messager.show({
		title : '提示',
		msg : '客官，您有新提示:' + msg,
		timeout : 3000,
		showType : 'slide'
	});
}

//确定对话框
function showComfirm(title, msg, fun) {
	$.messager.confirm(title, msg, fun);
}

//中间部位提示框
function alertMessager(msg) {
	$.messager.alert("提示!", "客官:" + msg);
}

//调用执行
function shuaxin(hanshu) {
	eval(hanshu);
}
$(function() {
	dddStyle();
});