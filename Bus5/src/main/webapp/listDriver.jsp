<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  
   uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<title>Driver</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="author" content="colorlib.com">

		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.css">

		<!-- STYLE CSS -->
		<link rel="stylesheet" href="css/style.css">
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

</style>
<body>
<!-- SECTION 1 -->
<h1>List of Drivers</h1>
<a href="addDriver.jsp" class="button">Add Driver</a>
	<br>
	<br>
<table style = "width:100%; text-align:center;">
	
<tr>
<th>Driver ID </th>
<th>Driver Name</th>
<th>Driver ICNO </th>
<th>Action</th>
</tr>
<c:forEach items="${drivers}" var="d">
	<tr>
		<td><c:out value="${d.driver_id}" /></td>
		<td><c:out value="${d.driver_name}" /></td>
		<td><c:out value="${d.driver_icno}" /></td>
		
		<td><a class="button"  href="DriverController?action=view&driver_id=<c:out value="${d.driver_id}"/>">View</a>
		<a class="button"  href="UpdateDriverController?action=update&driver_id=<c:out value="${d.driver_id}"/>">Update</a>
		<a class="button" href="DriverController?action=delete&driver_id=<c:out value="${d.driver_id}"/>" onclick="confirmation(this.id)">Delete</a></td>
	</tr>
</c:forEach>
</table>
<script>
   function confirmation(id){					  		 
   console.log(id);
   var r = confirm("Are you sure you want to delete?");
   if (r == true) {				 		  
	location.href = 'DriverController?driver_id=' + driver_id;
	alert("Driver successfully deleted");			
  	} else {				  
  	return false;	
   }
     }
</script>
</body>
</html>