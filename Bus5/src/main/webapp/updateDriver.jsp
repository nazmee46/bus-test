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
<link rel="stylesheet"
	href="fonts/material-design-iconic-font/css/material-design-iconic-font.css">

<!-- STYLE CSS -->
<link rel="stylesheet" href="css/style.css">
</head>
<style>
.form{
width:150px; margin:0 auto
}
input[type=submit]{
  background-color: #E3BC9A; /* Green */
  border: none;
  color: black;
  padding: 10px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
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
		<form action="UpdateDriverController" method="POST">
					Name: 
					<input type="text" id="driver_name" name="driver_name" value="<c:out value="${d.driver_name}"/> " disabled><br>

					ICNO: 
					<input type="text" id="driver_icno" name="driver_icno" value="<c:out value="${d.driver_icno}"/> "disabled><br>

					License No: 
					<input type="text" id="driver_licenseno" name="driver_licenseno" value="<c:out value="${d.driver_licenseno}"/>"disabled><br>

					Email: 
					<input type="email" id="driver_email" name="driver_email" value="<c:out value="${d.driver_email}"/>"><br>

					Phone No: 
					<input type="text" id="driver_phoneno" name="driver_phoneno" value="<c:out value="${d.driver_phoneno}"/>"><br>

					Address: 
					<input type="text" id="driver_address" name="driver_address" value="<c:out value="${d.driver_address}"/>"><br><br>

					<input type="hidden" id="driver_id" name="driver_id" value="<c:out value="${d.driver_id}"/>">

		    <input type="submit" value="Update">
		</form>
	</div>
	</section>
	<!-- Template created and distributed by Colorlib -->
</body>
</html>