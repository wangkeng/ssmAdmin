//保存操作
function ev_save(name, url) {
	var postData = $('#myForm').serialize();
	$.ajax({
		type : "POST",
		url : url,
		data : postData,
		dataType : 'json',
		success : function(result) {
			parent.showMessager(result);
			parent.closeDialog('dialog1');
			parent.shuaxin(name + '.window.refreshDG()');
		},
		error : function(result) {
			parent.showMessager('添加失败');
		}
	});
}

// 关闭窗口
function ev_cancel() {
	parent.closeDialog('dialog1');
}

function ev_validateAndSave(name, url) {
	if (!$("#myForm").form('validate')) {
		return false;
	} else {
		ev_save(name, url);
	}
}