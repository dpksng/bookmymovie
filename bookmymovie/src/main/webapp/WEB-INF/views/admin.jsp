<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/admin.css" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Lato:400,900" rel="stylesheet">
	
	
<title>Dashboard :: Admin | BOOKMYMOVIE.COM</title>
</head>
 <body onload="startTime()">
	
	<div class="admin-dashboard">
		<div class="container-fluid">
			<div class="admin-rg">
			<div class="row">
				<div class="col-md-4">
					<sec:authentication var="user" property="principal" />
					<%@ include file ="admin-profile.jsp" %>
				</div>
				<div class="col-md-8 admin-box">
					<div class="row">
						<div class="col-md-6">
							<a href="/bookmymovie/admin/manage-users">
							<div class="option-box">
								<div class="option-box-img">
									<img src="<%=request.getContextPath()%>/resources/img/admin/manage-user.png" width="100%">
								</div>
								<h5>MANAGE USERS</h5>
							</div>
							</a>
						</div>
						<div class="col-md-6">
							<a href="/bookmymovie/admin/manage-movies">
							<div class="option-box">
								<div class="option-box-img">
									<img src="<%=request.getContextPath()%>/resources/img/admin/manage-movies.png" width="100%">
								</div>
								<h5>MANAGE MOVIES</h5>
							</div>
							</a>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<a href="/bookmymovie/admin/manage-combos">
							<div class="option-box">
								<div class="option-box-img">
									<img src="<%=request.getContextPath()%>/resources/img/admin/manage-combos.png" width="100%">
								</div>
								<h5>MANAGE COMBOS</h5>
							</div>
							</a>
						</div>
						<div class="col-md-6">
							<a href="/bookmymovie/admin/manage-cinemas">
							<div class="option-box">
								<div class="option-box-img">
									<img src="<%=request.getContextPath()%>/resources/img/admin/manage-cinemas.png" width="100%">
								</div>
								<h5>MANAGE CINEMAS</h5>
							</div>
							</a>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<a href="/bookmymovie/admin/manage-bookings">
							<div class="option-box">
								<div class="option-box-img">
									<img src="<%=request.getContextPath()%>/resources/img/admin/manage-report.png" width="100%">
								</div>
								<h5>MANAGE BOOKINGS</h5>
							</div>
							</a>
						</div>
						<div class="col-md-6">
							<a href="/bookmymovie/admin/manage-feedbacks">
							<div class="option-box">
								<div class="option-box-img">
									<img src="<%=request.getContextPath()%>/resources/img/admin/manage-feedback.png" width="100%">
								</div>
								<h5>FEEDBACKS</h5>
							</div>
							</a>
						</div>
					</div>
				</div>
			</div>
			</div>
		</div>
	</div>
	
	<!-- My JavaScript -->
	<script src="<%=request.getContextPath()%>/resources/js/admin.js"></script>
	<!-- /My JavaScript -->
	
	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>