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
  
    <title>Home :: Bookmymovie.com</title>
</head>
<body>

	<div class="head-all">	
		<%@ include file ="header.jsp" %>
	</div>
	<br><br>
	<div class="container combo-contain">
	<form action="bookingDetails/${price}" method="POST">
			<h4 style="text-align:center;">Grabe a bite!</h4>
			<br><br>
			<input type="submit" value="continue" class="btn cust-btn right">
			<br><br>
		<div class="row">
	
					<c:forEach var="cmb" items="${list}">
					<div class="col-md-4">
						<div class="combo-box">
							<h4>${cmb.title}</h4>
							<img src="<%=request.getContextPath()%>/resources/img/combos/combo.jpg" width="100%">
							<h3>&#8377 ${cmb.amount}</h3>
							<p>${cmb.description}</p>
							<div>
						   		<input class="combocheck" type="radio" name="combo" value="${cmb.id}">    
							</div>
						</div>
					</div>
					</c:forEach>
		</div>
		</form>
	</div>
	<br><br><br><br>	
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