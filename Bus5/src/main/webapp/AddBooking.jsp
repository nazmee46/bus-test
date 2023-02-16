<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  
   uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="Customer.css" rel="stylesheet" type="text/css">
<title>Add Booking</title>
</head>
<body>

	 <!-- <div class="header">
        <div class="header-right">
            <a href="CustomerDashboard.html">Dashboard</a>
            <a class="active" href="CustomerBooking.html">Booking</a>
        </div>
    </div> -->
	
	<div class="backBut">
		<button type="button" onclick="goBack()">&laquo;</button>
		<script>
	    function goBack() 
			{
				 window.history.back();
	        }
	    </script>	
	</div>
	
	<div class="container" style=text-align:center>
	  	<form action="BookingController" method="post" id="wizard">
	  	<h2>BUS BOOKING FORM:</h2>
	  	
		<br><br>
	    
	    <label for="book_name">ENTER YOUR NAME:</label><br>
	  	<input type="text" name="book_name" id="book_name"><br>
	  	
	  	<label for="book_phoneno">ENTER YOUR PHONE NUMBER:</label><br>
	  	<input type="text" name="book_phoneno" id="book_phoneno"><br>
	  	
	    <label for="book_date">SELECT BOOKING DATE:</label><br>
	  	<input type="date" name="book_date" id="book_date"><br>
	    
	    <label for="book_route">CHOOSE ROUTE: </label><br>
	    <select id="book_route" name = "book_route" class = "custom-select" required>
			<option value=""></option>	
			<option value="Merlimau-BandarayaMelaka">Merlimau - Bandaraya Melaka</option>
			<option value="Merlimau-AlorGajah">Merlimau - Alor Gajah</option>
			<option value="BandarayaMelaka-Merlimau">Bandaraya Melaka - Merlimau</option>
			<option value="BandarayaMelaka-AlorGajah">Bandaraya Melaka - Alor Gajah</option>
			<option value="AlorGajah-Merlimau">Alor Gajah - Merlimau</option>
			<option value="AlorGajah-BandarayaMelaka">Alor Gajah - Bandaraya Melaka</option>
		</select><br>
		
		<label for="book_seat">ENTER NUMBER OF SEAT</label><br>
		<input type="number" name="book_seat" id="book_seat"><br>
		
		<c:if test="${book_route=='Merlimau-BandarayaMelaka'}">
			<c:set var = "book_price" scope = "session" value = "${book_seat*5}"/>
		</c:if>
		<c:if test="${book_route=='Merlimau-AlorGajah'}">
			<c:set var = "book_price" scope = "session" value = "${book_seat*5}"/>
		</c:if>
		<c:if test="${book_route=='BandarayaMelaka-Merlimau'}" >
			<c:set var = "book_price" scope = "session" value = "${book_seat*4.5}"/>
		</c:if>
		<c:if test="${book_route=='BandarayaMelaka-AlorGajah'}" >
			<c:set var = "book_price" scope = "session" value = "${book_seat*4.5}"/>
		</c:if>
		<c:if test="${book_route=='AlorGajah-Merlimau'}">
			<c:set var = "book_price" scope = "session" value = "${book_seat*5.5}"/>
		</c:if>
		<c:if test="${book_route=='AlorGajah-BandarayaMelaka'}" >
			<c:set var = "book_price" scope = "session" value = "${book_seat*5.5}"/>
		</c:if>
		
	    <br>
	    <br>
	    <br>
		
	    <input type="submit" value="BOOK BUS">
	  </form>
	</div>

</body>
</html>