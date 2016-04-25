//删除操作
function deleteObjs(url) {
	var rows = $('#dg').datagrid('getSelections');
	if (rows.length > 0) {
		parent.showComfirm('来自铿哥哥的温馨提示:', '是否删除选中项?', function(r) {
			if (r) {
				var ids = "";
				for (var i = 0; i < rows.length; i++) {
					ids += rows[i].id + ",";
				}
				$.ajax({
					type : "POST",
					url : url,
					data : "ids=" + ids,
					success : function(msg) {
						parent.showMessager(msg);
						refreshDG();
					}
				});
			}
		});
	} else {
		parent.alertMessager('请选择删除项');
	}
}
//弹窗：更新窗口
function updateObj(url, title, height, width) {
	var rows = $('#dg').datagrid('getSelections');
	if (rows.length > 1) {
		parent.alertMessager('只能选择一条数据进行修改');
	} else {
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			var id = row.id;
			var URL = url + '?id=' + id;
			parent.showWin(URL, title, height, width);
		} else {
			parent.alertMessager('请选择修改项');
		}
	}
}
//清除搜索框内容并刷新页面
function clearSearch() {
	var queryParams = $('#dg').datagrid('options').queryParams;
	queryParams.state = {};
	$('#dg').datagrid('options').queryParams = queryParams;
	$("#searchForm").find("input").val("");// 找到form表单下的所有input标签并清空
	refreshDG();
}
