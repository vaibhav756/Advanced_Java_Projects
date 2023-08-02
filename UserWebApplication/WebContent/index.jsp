<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	}%>
<form action="user" name="userform" method="POST">
  <table>
      <tr>
          <td>UserName : </td>
          <td><input type="text" name="username"></index></td>
      </tr>
      <tr>
	      <td>UserEmail : </td>
	      <td><input type="text" name="useremail"></input></td>
      </tr>
      <tr>
          <td>UserPhno : </td>
          <td><input type="text" name="userphno"></input></td>
      </tr>
      <tr><td><button type="submit">Submit</button></td></tr>
      <tr><td><a href="user">View All Users</a></td></tr>
  </table>
</form>


</body>
</html>