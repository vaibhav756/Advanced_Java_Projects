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
   if(msg!=null)
   {
	   out.println("Employee Record Inserted.");
   }
%>
<form action="empservlet" method="POST">
	<table>
		<tr><td>Employee Name : </td><td><input type="text" name="empname"></input></td></tr>
		<tr><td>Employee Email : </td><td><input type="text" name="empemail"></input></td></tr>
		<tr><td>Employee Gender : </td><td><input type="radio" name="empgender" value="Male">Male</input><input type="radio" name="empgender" value="Female">Female</input></td></tr>
		<tr><td>Employee Department : </td>
		<td><select name="empdept">
			<option value="">-select-</option>
			<option value="Development">Development</option>
			<option value="Testing">Testing</option>
			<option value="Database">Database</option>
			<option value="Operations">Operations</option>
		</select></td></tr>
		<tr><td>Employee Experience : </td><td>
		<select name="empexp">
		<option value="0">-select-</option>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		</select>
		</td></tr>					
		<tr><td><button type="submit">Submit</button></td></tr>
	</table>
</form>
<a href="empservlet">View Employees</a>
</body>
</html>