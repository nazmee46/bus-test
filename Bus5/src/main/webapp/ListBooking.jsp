<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  
   uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="Staff.css" rel="stylesheet" type="text/css">
<title>List Booking</title>
</head>
<body>
<div class="backBut">
		<button type="button" onclick="goBack()">&laquo;</button>
		<script>
	    function goBack() 
			{
				 window.history.back();
	        }
	    </script>	
	</div>
<br>
<h1>Booking Bus List</h1>
	
	<table style="width:100%;text-align:left; border:2px solid black;">
		<tr>
			<th>Customer Name<br><br></th>
			<th>Customer Phone Number<br><br></th>
			<th>Booking Date<br><br></th>
			<th>Route<br><br></th>
			<th>Number of Seat<br><br></th>
		</tr>
		<tr>
		<c:forEach items="${bookings}" var="booking">
			<tr>
				<th><c:out value="${booking.book_name}" /></th>
				<th><c:out value="${booking.book_phoneno}" /></th>
				<th><c:out value="${booking.book_date}" /></th>
				<td><c:out value="${booking.book_route}" /></td>
				<td><c:out value="${booking.book_seat}" /></td>
			</tr>
		</c:forEach>
		</tr>
	</table>

</body>
</html>