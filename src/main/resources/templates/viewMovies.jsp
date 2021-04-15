<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Current Movies</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<h1>Current Showings</h1>
	<table>
	<!--  filter options -->
	</table>
	<table>
	<tr>
		<td>Movie</td><td>Date</td><td>Time</td><td>Rating</td><td>Run Time</td>
	</tr>
	<c:forEach items="${movies}">
		<tr>
			<td>${movies.movieName}</td><td>${movies.movieShowDate}</td><td>${movies.movieShowTime}</td><td>${movies.movieRating}</td><td>${movies.movieTimeMinutes}</td>
			<td><a href="reserve?">Reserve seats</a></td>
		</tr>
	</c:forEach>
	</table>
	<a href="index.jsp">Home</a>
	<a href="addCustomer.html">Create Account</a>
</body>
</html>