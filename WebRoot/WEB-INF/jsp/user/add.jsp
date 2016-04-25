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
<script src="${ctx}/resource/js/commons/commonAdd.js"></script>
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
	<form id="myForm" method="post" action="${ctx}/user/add">
		<table>
			<tr>
				<td style="background-color:#F0F0F0">用户名：</td>
				<td><input type="text" id="name" name="name"
					style="width:200px;" class="easyui-validatebox" data-options="required:true,validType:['length[0,6]']"/></td>
				<td style="background-color:#F0F0F0">密码：</td>
				<td><input type="password" id="password" name="password"
					class="easyui-validatebox" data-options="required:true,validType:['length[0,12]']" style="width:200px;" /></td>
			</tr>
			<tr>

				<td style="background-color:#F0F0F0">电话：</td>
				<td><input type="text" id="tellphone" name="tellphone"
					style="width:200px;" /></td>
				<td style="background-color:#F0F0F0">邮箱：</td>
				<td><input type="text" id="email" name="email"
					style="width:200px;" /></td>
			</tr>
			<tr>
				<td colspan="4" align="right"><a href="#"
					class="easyui-linkbutton" iconCls="icon-save" onclick="ev_validateAndSave('用户管理','${ctx}/user/add')">提交</a> <a href="#"
					id="btn" class="easyui-linkbutton" iconCls="icon-cancel" onclick="ev_cancel()">取消</a></td>
			</tr>

		</table>
	</form>
</body>


</html>
