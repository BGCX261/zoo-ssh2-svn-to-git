function regUserChked() {
	//var username=$("username").value;
	var username = document.getElementsByName("user.loginName")[0].value;
	DWRUser.isExist(username, showData);//showData回调函数   
}
function showData(data) {
	if (typeof window['DWRUtil'] == 'undefined')
		window.DWRUtil = dwr.util;
	if (data) {
		DWRUtil.setValue("userMsg", "该用户名已经被注册，请更换您的用户名！");
	} else {
		DWRUtil.setValue("userMsg", "恭喜您，该用户名尚未被注册！");
	}
}
