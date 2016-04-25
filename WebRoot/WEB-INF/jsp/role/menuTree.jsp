<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../common/taglibs.jsp"%>

<!DOCTYPE>
<html>
<head>

<link href="${ctx}/resource/css/lib/easyui/themes/gray/easyui.css"
	rel="stylesheet"></link>
<link href="${ctx}/resource/css/lib/easyui/themes/icon.css"
	rel="stylesheet"></link>
<script src="${ctx}/resource/js/lib/jquery/jquery-1.11.1.min.js"></script>
<script src="${ctx}/resource/js/lib/easyui/jquery.easyui.min.js"></script>
<script src="${ctx}/resource/js/lib/easyui/easyui-ch.js"></script>
<script src="${ctx}/resource/js/commons/commonList.js"></script>
<script>
	$(function() {
		$('#tt').tree({
			url : '${ctx}/role/getMenuTree?id=${roleId}',
			checkbox : true
		});
	});

	// 关闭窗口
	function ev_cancel() {
		parent.closeDialog('dialog1');
	}

	function getChecked() {
		var nodes = $('#tt').tree('getChecked');
		var s = '';
		for (var i = 0; i < nodes.length; i++) {
			if (s != '')
				s += ',';
			s += nodes[i].id;
		}
		alert(s);
	}

	function getSelected() {
		var node = $('#tt').tree('getSelected');
		alert(node.text);
	}

	function save() {
		getChecked();
	}
</script>
<body>
	<div class="easyui-layout" fit="true" border="false">
		<div data-options="region:'center',split:false">
			<div id="tt"></div>
		</div>
		<div data-options="region:'south',split:false">
			<div style="padding:5px;float:right">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-search'"
					href="javascript:void(0);" onclick="save();"
					style="margin-left: 30px">确定</a> <a href="#" id="btn"
					class="easyui-linkbutton" iconCls="icon-cancel"
					onclick="ev_cancel()">取消</a>
			</div>
		</div>
	</div>
</body>
</html>
