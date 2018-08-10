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
	<div class="head">
				
				<%@ include file ="header.jsp" %>
				
				<br><br>
		
				<div class="container-fluid">
					<div class="row justify-content-center">
						<div class="col-sm-10">
							<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
								  <ol class="carousel-indicators">
									<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
									<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
									<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
								  </ol>
								  <div class="carousel-inner" role="listbox">
									<div class="carousel-item active">
									  <img class="d-block slider img-fluid" src="<%=request.getContextPath()%>/resources/img/slider/01.jpg" alt="First slide">
									</div>
									<div class="carousel-item">
									  <img class="d-block slider img-fluid" src="<%=request.getContextPath()%>/resources/img/slider/02.jpg" alt="Second slide">
									</div>
									<div class="carousel-item">
									  <img class="d-block slider img-fluid" src="<%=request.getContextPath()%>/resources/img/slider/03.jpg" alt="Third slide">
									</div>
								  </div>
								  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
									<span class="carousel-control-prev-icon" aria-hidden="true"></span>
									<span class="sr-only">Previous</span>
								  </a>
								  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
									<span class="carousel-control-next-icon" aria-hidden="true"></span>
									<span class="sr-only">Next</span>
								  </a>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="body">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-sm-5">
							<div id="accordion-btn">
								<div id="btn-l" class="btn-b">
									<a href="#accordion-btn" class="btn-l" onClick="nowShowing()">NOW SHOWING</a>
								</div>
								<div id="btn-r" class="btn-e">
									<a href="#accordion-btn" class="btn-r" onClick="upComing()">UPCOMING</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="container-fluid">
					<div id="nowshowing">
						<h1 style="text-align:center;">NOW SHOWING<h1>	
						<div class="row justify-content-center top-mar">
							<c:forEach var="mov" items="${list1}">
							<div class="col-sm-3 movie-box">
								<div>
								<img src="<%=request.getContextPath()%>/resources/img/movies/${mov.image}.jpg" width="100%">
								</div>
								<h4>${mov.title}</h4>
								<div class="lang"><span>${mov.language}</span></div>
								<div class="cat"><span>${mov.category}</div>
								<a href="/bookmymovie/selectCinema/${mov.id}" class="btn booking-btn">BOOK NOW</a>
							</div>
							 </c:forEach>
						</div>
					</div>
					
					<div id="upcoming">
						<h1 style="text-align:center;">UPCOMING<h1>	
						<div class="row justify-content-center top-mar">
							<c:forEach var="list2" items="${list2}"> 
							<div class="col-sm-3 movie-box">
								<div>
								<img src="<%=request.getContextPath()%>/resources/img/movies/${list2.image}.jpg" width="100%">
								</div>
								<h4>${list2.title}</h4>
								<div class="lang"><span>${list2.language}</span></div>
								<div class="cat"><span>${list2.category}</div>
								<!--<a href="/bookmymovie/getDetails/${list2.id}" class="btn booking-btn">GET DETAILS</a> -->
								<button type="button" class="btn booking-btn" data-toggle="modal" data-target="#movieDetailsModalCenter${list2.id}">
								  Get Details
								</button>
								
								<!-- Modal -->
								<div class="modal fade" id="movieDetailsModalCenter${list2.id}" tabindex="-1" role="dialog" aria-hidden="true">
								  <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
								    <div class="modal-content">
								      <div class="modal-header">
								        <h5 class="modal-title" id="movieDetailsModal">Movie Details</h5>
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
								          <span aria-hidden="true">&times;</span>
								        </button>
								      </div>
								      <div class="modal-body">
								        <div class="row">
								        	<div class="col-sm-4">
								        	<img src="<%=request.getContextPath()%>/resources/img/movies/${list2.image}.jpg" width="100%">
								        	</div>
								        	<div class="col-sm-8">
								        		<h1>${list2.title}</h1>
								        		<div class="lang"><span>${list2.language}</span></div>
												<div class="cat"><span>${list2.category}</span></div>
												<div class="lang"><span>Length :</span><span>${list2.length}</span></div>
												<div class="lang"><span>Release Date :</span><span>${list2.date}</span></div>
												<div class="lang"><span>Cast :</span><span>${list2.cast}</span></div>
								        		<p style="font-size:16px; text-transform: capitalize;"><span style="font-size:18px; text-transform: uppercase;">Info:</span><br>${list2.description}</p>
								        	</div>
								        </div>
								      </div>
								      <div class="modal-footer">
								        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								      </div>
								    </div>
								  </div>
								</div>
							</div>
							 </c:forEach>
						</div>
					</div>

				</div>				
			</div>
			
			<br><br>			
				
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