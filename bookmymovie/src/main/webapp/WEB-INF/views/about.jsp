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
	<link href="https://fonts.googleapis.com/css?family=Baloo|Roboto" rel="stylesheet">
  
    <title>About Us :: Bookmymovie.com</title>
</head>
<body>

	<div class="head-all">	
		<%@ include file ="header.jsp" %>
	</div>
		<br><br><br><br>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<h1 style="text-align:center;">About Us</h1><br><br>
				<p>Bookmymovie.com is a one-stop portal for Your tickets Your way to Movies. The website offers the audience a facility of buying tickets online along with combos that would keep them entertained. We encourage you to visit the site and have fun while you explore. Buy all your tickets and satisfy your appetite for entertainment only with Ticketplease!!!</p>
				<p>Bookmymovie.com has tied up with leading multiplexes along with several single screen theatres across India to provide customers the convenience of ticketing almost anywhere. The website not only caters to film fans but also intends to mobilize the passion of music and sports fans to buy tickets to concert and events across India.</p>
			</div>
		</div>
	</div>	
	<br><br><br><br><br><br>			
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