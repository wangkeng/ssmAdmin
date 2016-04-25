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
		$('#dg').datagrid({
			url : 'getList',
			queryParams : {},
			iconCls : 'icon-save',
			pagination : true,
			pageSize : 15,
			pageList : [ 15, 20, 30, 40, 50 ],
			fit : true,
			fitColumns : true,
			nowrap : false,
			columns : [ [ {
				field : 'id',
				checkbox : 'true',
				width : 200
			}, {
				field : 'name',
				title : '角色名',
				width : 100,
				align : 'center'
			}, {
				field : 'description',
				title : '角色描述',
				width : 70,
				align : 'center'
			}, {
				field : 'creator',
				title : '创建人',
				width : 70,
				align : 'center'
			}, {
				field : 'createtime',
				title : '创建时间',
				width : 100,
				align : 'center'
			}, {
				field : 'sort',
				title : '排序',
				width : 100,
				align : 'center'
			} ] ],
			toolbar : [ {

				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					parent.showWin("${ctx}/role/addView", "添加角色", 200, 600);
				}
			}, {

				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					updateObj("${ctx}/role/updateView", "修改角色", 200, 600);
				}
			}, {

				text : '权限设置 ',
				iconCls : 'icon-edit',
				handler : function() {
					roleMenu("${ctx}/role/menuTreeView", "权限设置 ", 600, 400);
				}
			}, {

				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					deleteObjs("${ctx}/role/delete");
				}
			} ]
		});

	});

	function searchFun() {
		var queryParams = $('#dg').datagrid('options').queryParams;
		var beginTime = $("#beginTime").datetimebox('getValue');
		var endTime = $("#endTime").datetimebox('getValue');
		if(!isEmpty(beginTime)&&isEmpty(endTime)){
			alert("请选择结束时间");
			return false ;
		}
		if(!isEmpty(endTime)&&isEmpty(beginTime)){
			alert("请选择开始时间");
			return false ;
		}
		queryParams = {
			'name' : $("#name").val(),
			'beginTime' : beginTime,
			'endTime' : endTime
		};
		$('#dg').datagrid('options').queryParams = queryParams;
		refreshDG();
	}

	function clearSearch() {
		window.location.href = "${ctx}/role/listView";
	}
	
	function isEmpty(str){
		if(str==null||str==""||str.length<1)
			return true ;
		else
			return false ;
				
	}

	function refreshDG() {
		$('#dg').datagrid("reload");
	}
	
	//弹窗：更新窗口
	function roleMenu(url, title, height, width) {
		var rows = $('#dg').datagrid('getSelections');
		if (rows.length > 1) {
			parent.alertMessager('只能选择一个角色进行操作!');
		} else {
			var row = $('#dg').datagrid('getSelected');
			if (row) {
				var id = row.id;
				var URL = url + '?id=' + id;
				parent.showWin(URL, title, height, width);
			} else {
				parent.alertMessager('请选择所要操作的角色');
			}
		}
	}
</script>
<body>

	<div class="easyui-layout" fit="true" border="false">
		<div data-options="region:'north'"
			style="background: #F4F4F4;height:35px">
			<form id="searchForm">
				<table style="margin-left: 7px">
					<tr>
						<td>
							<div>
								<span style="font-size: 13px">用户名：</span> <input
									class="easyui-validatebox" id="name" value="${name}" 
									type="text" />
							</div>
						</td>
						<td>&nbsp;<span style="font-size: 13px">开始时间：</span></td>
						<td><input class="easyui-datetimebox" id="beginTime" name="beginTime" editable="false" style="width:150px"></td>
						<td>&nbsp;<span style="font-size: 13px">结束时间：</span></td>
						<td><input class="easyui-datetimebox" id="endTime" name="endTime" editable="false" style="width:150px"></td>
						<td><a class="easyui-linkbutton"
							data-options="iconCls:'icon-search'" href="javascript:void(0);"
							onclick="searchFun();" style="margin-left: 30px">查找</a></td>
						<td><a class="easyui-linkbutton"
							data-options="iconCls:'icon-reload'" href="javascript:void(0);"
							onclick="clearSearch();">清空</a></td>
						<!--<td><a class="easyui-linkbutton"
							data-options="iconCls:'icon-print'" href="javascript:void(0);"
							onclick="ex_exportAll();">导出全部信息</a></td>
						 <td><a class="easyui-linkbutton"
							data-options="iconCls:'icon-reload'" href="javascript:void(0);"
							onclick="ex_fileUpLoad();">图片上传</a></td> -->
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',split:false">
			<table id="dg">
			</table>
		</div>
	</div>
</body>
</html>
