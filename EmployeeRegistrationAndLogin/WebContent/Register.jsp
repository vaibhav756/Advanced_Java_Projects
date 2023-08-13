<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Insert title here</title>
</head>
<body>
<% String msg=(String)request.getAttribute("msg");
    if(null!=msg)
    {
    	out.print(msg);
    }
%>

<form action="register" method="POST">
	<table>
		<tr>
			<td>Enter FirstName</td>
			<td><input type="text" name="fname"></input></td>
		</tr>	
		<tr>
			<td>Enter LastName</td>
			<td><input type="text" name="lname"></input></td>
		</tr>
		<tr>
			<td>Enter Email</td>
			<td><input type="text" name="email"></input></td>
		</tr>
		<tr>
			<td>Enter Password</td>
			<td><input type="text" name="password"></input></td>
		</tr>
		<tr>
			<td>Select Gender</td>
			<td><input type="radio" name="gender" value="Male">Male</input>&nbsp;<input type="radio" name="gender" value="Female">Female</input></td>
		</tr>
		<tr>
			<td><button type="submit">Submit</button></td>&nbsp;&nbsp;&nbsp;
			<td><a href="login"></a></td>
		</tr>
	</table>
</form>
</body>
</html>