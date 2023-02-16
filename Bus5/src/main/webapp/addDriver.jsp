<%@ page language="java" contentType="text/html;charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  
   uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Driver</title>
</head>
<style>
.form{
width:150px; margin:0 auto
}
input[type=submit], input[type=reset]{
  background-color: #E3BC9A; /* Green */
  border: none;
  color: black;
  padding: 10px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 13px;
 }
 body{
background-color: #FFF8DC;
}
input[type=text], select, textarea {
  width: 80%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 10px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}
</style>
<body>
<!-- <a href="DriverController" class="button">List Drivers</a><br><br> -->

	<form action="DriverController" method="post">
	<h1>Add Driver Form</h1>
		Name: <br>
		<input type="text" name="driver_name"/><br>
		Email: <br>
		<input type="text" name="driver_email"/><br>
		IC No: <br>
		<input type="text" name="driver_icno"/><br>
		Phone No: <br>
		<input type="text" name="driver_phoneno"/><br>
		Address: <br>
		<input type="text" name="driver_address"/><br>
		License No: <br>
		<input type="text" name="driver_licenseno"/><br><br>
		<!-- Staff Id: <br>
		<input type="hidden" name="staff_id"/><br><br> -->
		<input type="submit" value="ADD DRIVER">
		<input type="reset" value="RESET">
	</form>

</body>
</html>

</html>