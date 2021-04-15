<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie Ticketing</title>
</head>
<body>
<h1>Welcome to our theater!</h1>
<p><a href="viewMovies?">View Current Movies</a></p>
<p><a href="addCustomer.html">Create an account</a></p>
<br><br><p><a href="">Employee sign in</a></p>
<form action="signIn">
	<label for="name">Name:</label>
	<input type="text" id="name" placeholder="name"><br>
	<label for="password">Password:</label>
	<input type="password" id="password" placeholder="password" >
	<input type="submit" value="Sign In">
</form>
</body>
</html>