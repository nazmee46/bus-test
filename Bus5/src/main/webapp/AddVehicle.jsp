 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  
   uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<title>Add Vehicle</title>
</head>

<style>

.form{
width:150px; margin:0 auto
}

.form1{
width:-100px; margin:0 auto
}
h2{
text-align:center;

}

body{
background-color: #FFF8DC;
}
input[type=text], input[type=number], select, textarea {
  width: 80%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 10px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=date]{
	width: 80%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 10px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=submit]{
	
	width: 80%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

</style>

<body>
	<h2> Add New Vehicle Detail</h2>
	<div class="form">
	<form action="VehicleController" method="post">
	  <label for="vec_name">Vehicle Name:</label><br>
	  <input type="text" id="vec_name" name="vec_name" value=""><br>
	  <label for="vec_plateno"> Vehicle Plate Number:</label><br>
	  <input type="text" id="vec_plateno" name="vec_plateno" value=""><br>
	  <label for="vec_rtdate"> Vehicle Road tax date:</label><br>
	  <input type="date" id="vec_rtdate" name="vec_rtdate" value=""><br>
	  <br>
	  <br>
	  
	  <input type="submit" value="ADD">
	  
	  
	</form> 
	  </div>
</body>