<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="WEB-INF/jsp/common/taglibs.jsp"%>

<!doctype html>
<html>
<head>
<title>后台管理</title>
<link href="${ctx}/resource/css/lib/easyui/themes/gray/easyui.css"
	rel="stylesheet"></link>
<link href="${ctx}/resource/css/lib/easyui/themes/icon.css"
	rel="stylesheet"></link>
<script src="${ctx}/resource/js/lib/jquery/jquery-1.11.1.min.js"></script>
<script src="${ctx}/resource/js/lib/easyui/jquery.easyui.min.js"></script>
<script src="${ctx}/resource/js/lib/easyui/easyui-ch.js"></script>

<style type="text/css">
.menuStyle {
	height: 25px;
	padding-top: 10px;
	padding-left: 10px;
}

#exit:hover {
	color: red;
}
</style>
</head>
<body class="easyui-layout">

	<div data-options="region:'north'" style="height:50px"></div>
	<!-- 底部部位 -->
	<div data-options="region:'south'"
		style="margin: 0 auto; width: 100%; height: 5%; text-align: center; padding-top: 10px;">
		版权所有：后台开发</div>
	<!-- end底部部位 -->
	<!-- <div data-options="region:'east',split:true" title="East"
		style="width:100px;"></div> -->
	<div data-options="region:'west',split:false" title="导航菜单"
		style="width:200px;">
		<div id="aa" class="easyui-accordion">
			<div title="系统管理" style="padding: 0px">
				<div class="menuStyle"
					onclick="showTab('${ctx}/menu/listView','菜单管理')">菜单管理</div>
				<div class="menuStyle"
					onclick="showTab('${ctx}/user/listView','用户管理')">用户管理</div>
				<div class="menuStyle"
					onclick="showTab('${ctx}/role/listView','角色管理')">角色管理</div>
			</div>
		</div>
	</div>
	<!-- 中间部位 -->
	<div data-options="region:'center'" style="background:#eee;">
		<div class="easyui-tabs" style="overflow:hidden;" scroll=auto
			border="false" fit="true" id="mainTab">
			<!-- 如何去滚动条：在引进的easyui中的.panel-body中添加 overflow: hidden;  -->
		</div>
	</div>
	<!-- end中间部位 -->

	<!-- 弹窗部分  -->
	<div id="dialog1" class="easyui-dialog" closed="true"
		data-options="iconCls:'dialog_icon_default',style:{borderWidth:0},resizable:true,modal:true"
		style="overflow-x: hidden; overflow-y: hidden;">
		<iframe id="win1" style="height: 100%; width: 100%;" name="win1"></iframe>
	</div>
	<div id="dialog2" class="easyui-dialog" closed="true"
		data-options="iconCls:'dialog_icon_default',style:{borderWidth:0},resizable:true,modal:true"
		style="overflow-x: hidden; overflow-y: hidden;">
		<iframe id="win2" style="height: 100%; width: 100%;" name="win2"></iframe>
	</div>
	<div id="dialog3" class="easyui-dialog" closed="true"
		data-options="iconCls:'dialog_icon_default',style:{borderWidth:0},resizable:true,modal:true"
		style="overflow-x: hidden; overflow-y: hidden;">
		<iframe id="win3" style="height: 100%; width: 100%;" name="win3"></iframe>
	</div>
</body>

<script>
	$(function() {
		menuStyle();
		//tab鼠标移动到某个tab时跳转到该tab（仅限于一次加载完，后面加载的不会生效）
		//setListener();
	});

	function setListener() {
		var tabs = $('#mainTab').tabs().tabs('tabs');
		for (var i = 0; i < tabs.length; i++) {
			tabs[i].panel('options').tab.unbind().bind('mouseenter', {
				index : i
			}, function(e) {
				$('#mainTab').tabs('select', e.data.index);
			});
		}
	}

	//菜单栏的效果
	function menuStyle() {
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

	//对话框调用判断
	function showWin(url, title, height, width) {

		var divId = "#dialog1";
		if ($(divId).panel('options').closed) {
			$("#win1").attr("src", url);
			openWin(divId, url, title, height, width);
			return;
		}
		divId = "#dialog2";
		if ($(divId).panel('options').closed) {
			$("#win2").attr("src", url);
			openWin(divId, url, title, height, width);
			return;
		}
		divId = "#dialog3";
		if ($(divId).panel('options').closed) {
			$("#win3").attr("src", url);
			openWin(divId, url, title, height, width);
			return;
		}
	}
	//对话框显示
	function openWin(divId, url, title, height, width) {

		var top = (screen.height - height - 100) / 2;
		var left = (screen.width - width) / 2;
		$(divId).dialog({
			title : title,
			width : width,
			top : top,
			left : left,
			height : height,
			modal : true,
			onClose : function() {
				if (divId == "#dialog1") {
					$("#win1").attr("src", "blank.html");
				} else if (divId == "#dialog2") {
					$("#win2").attr("src", "blank.html");
				} else if (divId == "#dialog3") {
					$("#win3").attr("src", "blank.html");
				}
			}
		});
		$(divId).dialog("open");
	}

	//关掉窗口
	function closeDialog(evalStr) {
		eval("$('#" + evalStr + "').dialog('close')");
	}

	//在又部添加选项卡 url:路径名称 name:iframe的名称（以便刷新列表的时候判断） mtitle:iframe的名称（用于判断tab是否存在）
	function showTab(url, mtitle) {
		if (!$('#mainTab').tabs('exists', mtitle)) {
			var content = "<iframe scrolling=\"auto\" frameborder=\"0\"  src='"
					+ url + "' style=\"width:100%;height:100%;\" name="
					+ mtitle + "></iframe>";
			$('#mainTab').tabs('add', {
				title : mtitle,
				content : content,
				closable : true
			});
		} else {
			$('#mainTab').tabs('select', mtitle);
		}
		//setListener();
	}

	//右下角提示框
	function showMessager(msg) {
		$.messager.show({
			title : '提示',
			msg : '您有新提示:' + msg,
			timeout : 3000,
			showType : 'slide'
		});
	}

	function showProgress(title, msg) {
		$.messager.progress({
			title : title,
			msg : msg
		});
	}

	function hideProgress() {
		$.messager.progress('close');
	}

	//确定对话框
	function showComfirm(title, msg, fun) {
		$.messager.confirm(title, msg, fun);
	}

	//交互框

	function showPrompt(title, msg, fun) {
		$.messager.prompt(title, msg, fun);
	}

	//中间部位提示框
	function alertMessager(msg) {
		$.messager.alert("提示!", msg);
	}
	
	//调用执行
	function shuaxin(hanshu) {
		eval(hanshu);
	}
</script>
</html>

