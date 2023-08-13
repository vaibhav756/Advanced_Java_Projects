<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border:1px solid black;
}
td
{
  text-align:center;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="register">Register Now</a>
<table style="width:100%">
<tr>
	<th>User Id</th>
	<th>User Name</th>
	<th>User Email</th>
	<th>Phoneno</th>
	<th>Edit</th>
	<th>Delete</th>
</tr>
<c:forEach items="${users}" var="user">
<tr>
    <td>${user.userId}</td>
    <td>${user.userName}</td>
    <td>${user.userEmail}</td>
    <td>${user.userPhno}</td>
    <td><a href="edituser?userid=${user.userId}">Edit</a></td>
    <td><a href="deleteuser?userid=${user.userId}">Delete</a></td>
</tr>
</c:forEach>
</table>


</body>
</html>