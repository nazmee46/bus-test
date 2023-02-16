<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  
   uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update vehicle Detail</title>
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
h2{
text-align:center;

}
.form{

width:350px; margin:0 auto
}

body{
background-color: #FFF8DC;

}
input[type=text], input[type=number], select, textarea {
  width: 50%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=date]{
	width: 50%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}
input[type=submit]{
	width: 50%;
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
<h2>Update Vehicle</h2>
<div class="form">
 <form action="UpdateVehicleController" method="POST"> 
        
       	Vehicle Name:
       	<input type="text" id="vec_name" name="vec_name" value="<c:out value="${vehicle.vec_name}"/> " readonly><br><br>
       	Vehicle Plate Number:
       	<input type="text" id="vec_plateno" name="vec_plateno" value="<c:out value="${vehicle.vec_plateno}"/> " readonly><br><br>
       	Vehicle Road Tax Date:
       	<input type="date" id="vec_rtdate" name="vec_rtdate" value="<c:out value="${vehicle.vec_rtdate}"/> "><br><br>
     	<input type="hidden" id="vec_id" name="vec_id" value="<c:out value="${vehicle.vec_id}"/>"><br>
       
        <input type="submit" value="Submit">
        
  </form>
  </div>
</body>
</html>