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
			parent.shuaxin(name + '.window.refreshDG()');
		},
		error : function(result) {
			parent.showMessager('更新失败');
		}
	});
}
// 关闭窗口
function ev_cancel() {
	parent.closeDialog('dialog1');
}

function ev_validateAndUpdate(name, url) {
	var postData = $('#myForm').serialize();
	console.info(postData);
	if (!$("#myForm").form('validate')) {
		return false;
	} else {
		ev_update(name, url);
	}
}