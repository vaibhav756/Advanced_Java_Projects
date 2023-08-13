<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password Page</title>
</head>
<body>
<% String email=(String)request.getAttribute("email");
   if(email!=null)
   {
	   out.println(email);
   }
%>
<form action="forgotpwd" method="POST">
	<table>
	  	<tr>
		  	<td>Enter Email : </td>
		  	<td><input type="text" name="email"></input></td>
	  	</tr>
	  	<tr>
	  	<td><button type="submit">Submit</button></td>
	  	</tr>
	  	  	<tr><a href="login"></a></tr>
	</table>
</form>
</body>
</html>