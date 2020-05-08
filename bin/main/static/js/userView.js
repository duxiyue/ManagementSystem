/**
 * ユーザ編集
 * @param userCode
 * @returns
 */
function selectUser(userCode) {

	openFancybox(false, 'userView/editUser?userCode=' + userCode, 500, 300, null, null, function() {
		redirect('userView');
	});
}

/**
 * ユーザ登録
 * @returns
 */
function insertUser() {

	openFancybox(false, 'userView/insertUser', 500, 300, null, null, function() {alert(11);
		redirect('userView');
	});
}
