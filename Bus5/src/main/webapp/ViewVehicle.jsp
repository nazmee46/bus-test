<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  
   uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Vehicle</title>
</head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 50%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}


</style>
<body>
	<h2>Vehicle Detail</h2>
	
	<form action="/action_page.php">
		<table>
			<tr>
			    <th>Bus Name </th>
			    <th>Bus Plate Number</th>
			    <th>Bus Road Tax Date</th>
			    <th>Action</th>
		  	</tr>
		  	<tr>
			 	<c:forEach items="${vehicles}" var="vehicle">
					<td><c:out value="${vehicle.vec_name}" /></td>
					<td><c:out value="${vehicle.vec_plateno}" /></td>
					<td><input type="date" name="vec_rtdate" /></td> 
					<td><input type="submit" value="UPDATE"></td>
				</c:forEach>
		 	</tr>
		</table>
	</form>
</body>
</html>