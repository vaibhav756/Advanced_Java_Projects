<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="forgotpwdsuccess" method="POST">
     <table>
       <% 
       String email=(String)request.getAttribute("email");
       String msg=(String)request.getAttribute("msg");
       if(msg!=null)
       {
    	   out.println(msg);
       }
       %>
        <input type="hidden" value=<%= email %> name="email"></input>
     	<tr>
     		<td>New Password</td>
     		<td><input type="text" name="newpassword"></input></td>
     	</tr>
     	<tr>
     		<td>Confirm Password</td>
     		<td><input type="text" name="confirmpassword"></input></td>     	
 		</tr>
 		<tr><td><button type="submit">Submit</button></td>&nbsp;&nbsp;&nbsp;<td><a href="login">Cancel</a></td></tr>
     </table>
</form>
</body>
</html>