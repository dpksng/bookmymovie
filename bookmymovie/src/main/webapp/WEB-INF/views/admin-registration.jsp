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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/admin.css" type="text/css">
	<link href='https://fonts.googleapis.com/css?family=Baloo' rel='stylesheet'>
	
	<title>Dashboard :: Admin | BOOKMYMOVIE.COM</title>

</head>
 <body onload="startTime()">
	
		<div class="admin-dashboard">
		<div class="container-fluid">
			<div class="admin-reg">
				<div class="row">
					<div class="col-md-3">
						<%@ include file ="admin-profile.jsp" %>
					</div>
					<div class="col-md-9">
						<div class="border-box">
								<h4>ADD NEW ADMIN</h4>
							</div>	
							<form:form method="post" modelAttribute="admin" action="registerAdmin">
								<div class="form-group">
									<label>ADMIN EMAIL</label>
									<form:input path="id" cssClass="form-control label" placeholder="email@login.com"/>
								</div>
								<div class="form-group">
									<label>Name</label>
									<form:input path="name" cssClass="form-control label" placeholder="Name"/>
								</div>
								<div class="form-group">
									<label>Gender</label>
									<form:input path="gender" cssClass="form-control label" placeholder="Gender"/>
								</div>
								<div class="form-group">
									<label>Create password</label>
									<form:password path="pwd" cssClass="form-control label" placeholder="Password"/>
								</div>
								<button type="submit" class="btn btn-primary">Register</button>
							</form:form>
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