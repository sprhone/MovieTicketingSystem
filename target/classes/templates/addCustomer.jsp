<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Add customer</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
<form th:object="${newProgramUser}" onsubmit="return formValidate(this);" method='POST'>
User Name: <input name="userName" size="20" th:field="*{userName}"> <br />
Password: <input name="passwords.userPass" size="10" th:field="*{passwords.userPass}"><br />

<input name="submit" type="submit" value="submit"/>
</form>

<script>
//Noah Hobbs -ndhobbs
//This javascript checks that the user is entering valid input
//Note to teammates I'm not 100% sure if I need to say form.passwords.userPass or if it should be form.userPass
function formValidate(form) {
	var passCheck = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$/;
	var userCheck = /^[a-z0-9_-]{3,15}$/;
	if (form.userName.value == "") {
		   
		   window.alert("Warning! The username field is empty!");
		   form.userName.focus();
		   return false;
		   
		  } else if (!userCheck.test(form.userName.value)){
			  window.alert("Warning! The invalid username!");
			   form.userName.focus();
			   return false;
		  }
	if (form.passwords.userPass.value == "") {
		   
		   window.alert("Warning! The Password field is empty!");
		   form.userPass.focus();
		   return false;
		   
		  } else if(!passCheck.test(form.passwords.userPass.value)) {
			  window.alert("Warning! The Password contains invalid characters!");
			  form.userPass.focus();
			  return false;
		  }
}
</script>
<a href="index.html"> Return to Home Page</a>
<a href="viewMovies.html"> View Movies</a>
</body>
</html>