<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  
   uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Order</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="colorlib.com">

<!-- MATERIAL DESIGN ICONIC FONT -->
<link rel="stylesheet"
	href="fonts/material-design-iconic-font/css/material-design-iconic-font.css">

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
 
 .form{
width:200px; margin:0 auto
}

body{
background-color: #FFF8DC;

}

</style>
<body>
	<!-- SECTION 1 -->
	<section>

	<div class="form">
	<h1>Driver Details</h1>
	<a href="DriverController?action=list" class="button">List Drivers</a>
		<h3>Driver Info</h3>
		Driver Id: <c:out value="${d.driver_id}" /><br>
	
		Staff Id: <c:out value="${d.staff_id}" /><br>
	
		Name: <c:out value="${d.driver_name}" /><br>
	
		Email: <c:out value="${d.driver_email}" /><br>
	
		ICNO: <c:out value="${d.driver_icno}" /><br>
	
		Phone No: <c:out value="${d.driver_phoneno}" /><br>
	
		Address: <c:out value="${d.driver_address}" /><br>
	
		License No: <c:out value="${d.driver_licenseno}" />
	</div>		
	</section>
	<!-- Template created and distributed by Colorlib -->
</body>
</html>