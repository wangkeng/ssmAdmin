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
</head>

<body>
	<div id="tb" style="padding-left:10px;padding-top:6px;height:auto">
		
	<!-- 	<table>
			<tr>
				<td> &nbsp;开始时间:</td>
				<td><input class="easyui-datebox" style="width:80px"></td>
				<td> &nbsp;结束时间:</td>
				<td> <input class="easyui-datebox"
				style="width:80px"></td>
				
				<td> &nbsp;菜单名:</td>
				<td>  <input class="easyui-combobox"
				style="width:100px" url="data/combobox_data.json" valueField="id"
				textField="text"></td>
				<td><a href="#" class="easyui-linkbutton"
				iconCls="icon-search">Search</a></td>
			</tr>
		</table> -->
		
	</div>
	<table id="menuTree" fit="true" checkbox="true"></table>
</body>

<script type="text/javascript">
	$(function() {
		$("#menuTree")
				.treegrid(
						{
							url : "${ctx}/menu/getFirstData",//首次查询路径  
							idField : 'id',
							treeField : 'name',
							parentField : 'menuid',
							rownumbers : true,
							queryParams : {
								"id" : "-1"
							},//首次查询参数         
							columns : [ [ {
								field : "name",
								title : "名称",
								width : 200
							}, {
								field : "description",
								title : "描述",
								width : 300
							}, {
								field : "createtime",
								title : "创建时间",
								width : 200
							}, {
								field : "menulevel",
								title : "菜单级别",
								width : 200
							}, {
								field : "linkurl",
								title : "链接",
								width : 200
							}, {
								field : "sort",
								title : "排序",
								width : 200
							} ] ],
							onBeforeExpand : function(row) {
								// 此处就是异步加载地所在
								if (row) {
									$(this).treegrid('options').url = '${ctx}/menu/getSecondData?id='
											+ row.id;
								}
								return true;
							},
							toolbar : [ {
								id : 'addLeafBtn',
								text : '添加菜单',
								iconCls : 'icon-add',
								handler : function() {
									addMenu();
								}
							},'-', {
								id : 'editBtn',
								text : '修改',
								iconCls : 'icon-edit',
								handler : function() {
									editMenu();
								}
							}, '-', {
								id : 'deleteBtn',
								text : '删除',
								disabled : true,
								iconCls : 'icon-save',
								handler : function() {
									$('#btnsave').linkbutton('disable');
									alert('save');
								}
							} ]
						});
	});
	
	function onclick(){
		 var pnode = $("#menuTree").treegrid("getSelected");
		 alert(pnode.id);
		console.info(pnode);
	}
	
	function addMenu(){
		 var pnode = $("#menuTree").treegrid("getSelected");
		 if(pnode){
			 parent.showWin('${ctx}/menu/addView?id='+pnode.id, "新增菜单", 240, 650);
		 }else{
			 parent.alertMessager('请选择上级菜单');
		 }
	}
	
	function editMenu(){
		 var pnode = $("#menuTree").treegrid("getSelected");
		 if(pnode){
			 parent.showWin('${ctx}/menu/editView?id='+pnode.id, "编辑菜单", 240, 650);
		 }else{
			 parent.alertMessager('请选择菜单');
		 }
	}
	
	function refreshDG(){
		var pnode = $("#menuTree").treegrid("getSelected");
		var id = pnode.id ;
		if(id==-1){
			$("#menuTree").treegrid('options').url = "${ctx}/menu/getFirstData?id=-1" ;
			$('#menuTree').treegrid('reload'); 
			return ;
		}
		if(pnode.state=="open"&&typeof(pnode.children) == "undefined"){
			id = pnode.menuid;
		}
		$('#menuTree').treegrid('reload',id); 
	}
	
	function refreshDGByEdit(){
		var pnode = $("#menuTree").treegrid("getSelected");
		var id = pnode.id ;
		if(id==-1){
			$("#menuTree").treegrid('options').url = "${ctx}/menu/getFirstData?id=-1" ;
			$('#menuTree').treegrid('reload'); 
			return ;
		}
		id = pnode.menuid;
		$('#menuTree').treegrid('reload',id); 
	}
	
</script>
</html>
