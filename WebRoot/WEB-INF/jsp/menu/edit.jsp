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
<script src="${ctx}/resource/js/commons/commonUpdate.js"></script>
<script src="${ctx}/resource/js/lib/easyui/easyui-ch.js"></script>

<style type="text/css">
table {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #CFCFCF;
	border-collapse: collapse;
	margin: auto;
}

table tr td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #CFCFCF;
	background-color: #ffffff;
}
</style>
</head>


<body>
	<form id="myForm" method="post" action="${ctx}/menu/edit">
	<input type="hidden" name="id" value="${ssmMenu.id}"/>
		<table>
			<tr>
				<td style="background-color:#F0F0F0">菜单名：</td>
				<td colspan="3"><input type="text" id="name" name="name" value="${ssmMenu.name}"
					style="width:500px;" /></td>
			</tr>
			<tr>

				<td style="background-color:#F0F0F0">链接：</td>
				<td><input type="text" id="linkurl" name="linkurl" value="${ssmMenu.linkurl}"
					style="width:200px;" /></td>
				<td style="background-color:#F0F0F0">菜单类型：</td>
				<td><select class="easyui-combobox" name="menulevel"
					id="menulevel" style="width:200px;" panelHeight="80" value="${ssmMenu.menulevel}"
					editable="false">
						<option value="1">菜单</option>
						<option value="2">菜单按钮</option>
				</select></td>
			</tr>
			<tr>
				<td style="background-color:#F0F0F0">描述：</td>
				<td><input type="text" style="width:200px;" id="description" value="${ssmMenu.description}"
					name="description" /></td>

				<td style="background-color:#F0F0F0">排序</td>
				<td><input type="text" style="width:200px;" id="sort" value="${ssmMenu.sort}"
					name="sort" /></td>
			</tr>
			<tr>
				<td colspan="4" align="right"><a href="#"
					class="easyui-linkbutton" iconCls="icon-save" onclick="ev_validateAndUpdate('菜单管理','${ctx}/menu/edit')">提交</a> <a href="#"
					id="btn" class="easyui-linkbutton" iconCls="icon-cancel" onclick="ev_cancel()">取消</a></td>
			</tr>

		</table>
	</form>
</body>
<script type="text/javascript">
//更新操作
function ev_update(name, url) {
	var postData = $('#myForm').serialize();
	$.ajax({
		type : "POST",  
		url : url,  
		data : postData,  
		dataType : 'json',  

		success : function(result) {  
			parent.showMessager(result);
			parent.closeDialog('dialog1');
			parent.shuaxin(name + '.window.refreshDGByEdit()');
		},
		error : function(result) {
			parent.showMessager('更新失败');
		}
	});
}

$(function(){
	  $("body").keydown(function() {
          if (event.keyCode == "13") {//keyCode=13是回车键
        	  ev_validateAndUpdate('菜单管理','${ctx}/menu/edit');
          }
      });
});
</script>

</html>
