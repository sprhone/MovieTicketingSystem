<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Add customer</title>
</head>
<body>
<form th:object="${newProgramUser}" onsubmit="return formValidate(this);" method='POST'>
User Name: <input name="userName" size="20" th:field="*{userName}"> <br />
Password: <input name="userPass" size="10" th:field="*{userPass}"><br />

<input name="submit" type="submit" value="submit"/>
</form>

<script>
//Noah Hobbs -ndhobbs
function formValidate(form) {
	let passCheck = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$/;
	if (form.userName.value == "") {
		   
		   window.alert("Warning! The username field is empty!");
		   form.userName.focus();
		   return false;
		   
		  }
	if (form.userPass.value == "") {
		   
		   window.alert("Warning! The Password field is empty!");
		   form.userPass.focus();
		   return false;
		   
		  }
}
</script>
</body>
</html>