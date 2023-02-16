<%@ page language="java" contentType="text/html;charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  
   uri="http://java.sun.com/jsp/jstl/core" %>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Add Staff</title>
</head>
<style>
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
 .form{
width:300px; margin:0 auto
}
 body{
background-color: #FFF8DC;
}
input[type=text], input[type=password], select, textarea {
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
<!-- <a href="StaffController">List Staff</a><br><br> -->
	<div class="form">
	<h1>Add Staff Form</h1>
	<form action="StaffController" method="post">
		Name: <br>
		<input type="text" name="staff_name"/><br>
		Email: <br>
		<input type="text" name="staff_email"/><br>
		Password: <br>
		<input type="password" name="staff_password"/><br>
		Address: <br>
		<input type="text" name="staff_address"/><br>
		Phone No: <br>
		<input type="text" name="staff_phoneno"/><br>
		IC No: <br>
		<input type="text" name="staff_icno"/><br>
		<br>
		<input type="submit" value="ADD STAFF">
		<input type="reset" value="RESET">
	</form>
	</div>
</body>

</html>