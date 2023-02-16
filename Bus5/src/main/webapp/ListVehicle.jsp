<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  
   uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>List of Vehicle </title>
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

.button {
  background-color: #E3BC9A; /* Green */
  border: none;
  color: black;
  padding: 10px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
 }
 .button1 {
  
  background-color: #E3BC9A; /* Green */
  border: none;
  color: black;
  padding: 10px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
 }
 
 h1{
    text-align:center;
 }
}

</style>
<body>

<h1>Vehicle</h1>
<br>

<br>
<br>
<div>
<table style = "width:100%;text-align:center;">
  <tr>
   	<th>Bus ID </th>
    <th>Bus Name </th>
    <th>Bus Plate Number</th>
    <th>Bus Road Tax Date</th>
    <th> Action</th>
  </tr>
  <tr>
 	<c:forEach items="${vehicles}" var="vehicle">
	<tr>
		<td><c:out value="${vehicle.vec_id}" /></td>
		<td><c:out value="${vehicle.vec_name}" /></td>
		<td><c:out value="${vehicle.vec_plateno}" /></td>
		<td><c:out value="${vehicle.vec_rtdate}" /></td>
		<td><a href="UpdateVehicleController?vec_id=<c:out value="${vehicle.vec_id}"/> "class="button">Update</a>
			<a href="VehicleController?action=delete&vec_id=<c:out value="${vehicle.vec_id}"/>" class="button" onclick="confirmation(this.id)">Delete</a>
		</td>
	</tr>
	</c:forEach>
  </tr>
  
</table>
<br>
<br>
<a href="AddVehicle.jsp" class="button"  >Add Vehicle</a>
<script>
      function confirmation(id){					  		 
   		console.log(id);
   		var r = confirm("Are you sure you want to delete?");
   		if (r == true) {				 		  
			location.href = 'VehicleController?vec_id=' + vec_id;
			alert("Vehicle successfully deleted");			
  		} else {				  
  			return false;	
   			}
     }
</script>
</div>




</body>
</html>