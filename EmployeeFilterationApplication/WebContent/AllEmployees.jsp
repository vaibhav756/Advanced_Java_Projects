<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Employees</title>
<style>

table, th, td {
  border:1px solid black;
}
td
{
  text-align:center;
}


</style>
</head>
<body>
<form action="empservlet">
<table>
	<tr>
    <td>Employee Department : </td>
	<td><select name="empdept">
		<option value="">-select-</option>
		<option value="Development">Development</option>
		<option value="Testing">Testing</option>
		<option value="Database">Database</option>
		<option value="Operations">Operations</option>
	</select></td>
	</tr>
	<tr>
		<td>Employee Gender : </td>
		<td><input type="radio" name="empgender" value="Male">Male</input><input type="radio" name="empgender" value="Female">Female</input></td>
	</tr>
	<tr>
		<td>Employee Experience : </td>
		<td>
		<select name="empexp">
			<option value="0">-select-</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>		
		</select>
		</td>
	</tr>
    <tr><td><button type="submit">Search</button></td></tr>
</table>
</form>
<table style="width:100%">
	<tr>
		<th>EmployeId</th>
		<th>EmployeeName</th>
		<th>EmployeeEmail</th>
		<th>EmployeeGender</th>	
		<th>EmployeeDepartment</th>
		<th>EmployeeExperience</th>
	</tr>
	<c:forEach items="${emps}" var="emps">			
	<tr>
		    <td>${emps.empId}</td>
	  		<td>${emps.empName}</td>
	  		<td>${emps.empEmail}</td>
	  		<td>${emps.empGender}</td>
	  		<td>${emps.empDept}</td>
	  		<td>${emps.empExp}</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>