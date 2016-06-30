function formCheck() {

	var mail = document.input.elements['mail'];
	var editMail = removeSpace(mail.value);
	if (editMail.length != 0 && !editMail.match(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/)) {
		alert("※メールアドレスは必須ではありません。入力する場合は一つの@を含んだ半角英数字のアドレスであるか確認してください。");
		mail.focus();
		return false;
	}
	var title = document.input.elements['title'];
	var editTitle = removeSpace(title.value);
	if (editTitle.length == 0) {
		alert("※タイトルは必須です。スペースのみの入力も不可です。");
		title.focus();
		return false;
	}
	var message = document.input.elements['message'];
	var editMessage = removeSpace(message.value);
	if (editMessage.length == 0) {
		alert("本文は必須です。スペースのみの入力も不可です。");
		message.focus();
		return false;
	}
	if (editMessage.length > 200) {
		alert("本文が長すぎます。200文字以内で入力してください。" + editMessage.length);
		message.value = message.value.substring(0, 200);
		message.focus();
		return false;
	}
	var password = document.input.elements['password'];
	var editPassword = removeSpace(password.value);
	if (!editPassword.match(/^[0-9a-zA-Z]+$/)) {
		alert("パスワードは必須です。半角英数字で入力してください。");
		password.focus();
		return false;
	}
	return true;
}

function passwordCheck() {
	var password = document.checkPass.elements['inputPassword'];
	var editPassword = removeSpace(password.value);
	if (!editPassword.match(/^[0-9a-zA-Z]+$/)) {
		alert("パスワードは必須です。半角英数字で入力してください。");
		password.focus();
		return false;
	}
	return true;
}

function removeSpace(word) {
	var editWord = word.replace(/(^\s+)|(\s+$)/g, "");
	return editWord;
}

function clearInputForm() {
    for (var i = 0; i < document.input.elements.length; ++i) {
        clearElement(input.elements[i]);
    }
    document.input.elements['name'].focus();
}

function clearElement(element) {
    switch(element.type) {
        case "text":
        	element.value = "";
        	return;
        case "password":
        	element.value = "";
        	return;
        case "textarea":
            element.value = "";
            return;
        default:
    }
}  