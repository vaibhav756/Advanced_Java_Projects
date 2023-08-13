<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String msg=(String)request.getAttribute("msg");
   if(null!=msg)
   {
	   out.println(msg);
   }
%>
<form action="login" name="loginform" method="POST">
<table>
	<tr>
		<td>Enter Email</td>
		<td><input type="text" name="email"></input></td>
	</tr>
	<tr>
		<td>Enter Password</td>
		<td><input type="text" name="password"></input></td>
	</tr>
	<tr>
		<td><button type="submit">Submit</button></td>
	</tr>
	<tr>
		<td><a href="forgotpwd">Forgot Password</a></td>
		<td><a href="register">Sign Up</a></td>
	</tr>
</table>
</form>

</body>
</html>