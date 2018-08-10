<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/font-awesome.css" type="text/css"> 
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/animate.css" type="text/css">
	<link href='https://fonts.googleapis.com/css?family=Baloo' rel='stylesheet'>
  
    <title>Your Ticket :: Bookmymovie.com</title>
</head>
<body>

	<div class="head-all">	
		<%@ include file ="header.jsp" %>
	</div>
	
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-8 ticket">
				<h1 style="text-align:center;">Your Ticket Details</h1>
				<br>
				<div class="row">
					<div class="col-md-6">
						<img src="<%=request.getContextPath()%>/resources/img/movies/${ms.image}.jpg" width="100%">
					</div>
					<div class="col-md-6">
						<img src="<%=request.getContextPath()%>/resources/img/movies/qr.png" class="img-thumbnail" width="50%">
						<br><br>
						<h3>${ms.title}</h3>
						<h5>${book.cinema}</h5>
						<h5>Seats : ${seats}</h5>
						<h5>Show Time : ${ss.time}</h5>
						<br>
						<h5>Amount : &#8377 ${total}</h5>
						<h5>Movie Date : ${book.showDate}</h5>
						<h5>Booking Date : ${book.date}</h5>
						<h5>Booking Time : ${book.time}</h5>
						<h5>Tickets Count : ${count}</h5>
					</div>
				</div>
				<div class="col-md-1 print">
				<button onclick="window.print()">Print</button>
				</div>
			</div>
		</div>
	</div>
	
	<%@ include file ="footer.jsp" %>
		
	<!--my javascript-->
	<script src="<%=request.getContextPath()%>/resources/js/accordion.js"></script>
	<!--/my javascript-->
		
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>