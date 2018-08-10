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
	<link href="https://fonts.googleapis.com/css?family=Lato:400,900" rel="stylesheet">
	
	<title>Manage Users :: Admin | BOOKMYMOVIE.COM</title>

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
						<div class="row">
							<div class="col-md-12">
								<nav class="navbar navbar-light navbar-toggleable">							
									<a class="navbar-brand" href="#">Users</a>
									<div class="collapse navbar-collapse menu" id="navbarSupportedContent">
										<ul class="navbar-nav ml-auto menu-nav">
											<li>
												<a href="/bookmymovie/admin" class="nav-link menu-link">GO BACK</a>
											</li>
											<%@ include file ="menu.jsp" %>		
										</ul>
									</div>
								</nav>
							</div>
							<div class="col-md-12">
								<table class="table">
									<thead>
									  <tr>
										<th>ID</th>
										<th>EMAIL</th>
										<th>NAME</th>
										<th>DOB</th>
										<th>GENDER</th>
										<th>REG DATE</th>
										<th>REG TIME</th>
										<th>UPDATE</th>
										<th>DELETE</th>
									  </tr>
									</thead>
									<tbody>
									  <c:forEach var="u" items="${list}">      
										  <tr>
												<form:form method="post" modelAttribute="user" action="updateUser">
												  	<td><form:input path="id" cssClass="form-control" value="${u.id}"/></td>
												  	<td><form:input path="email" cssClass="form-control" value="${u.email}"/></td>
												  	<td><form:input path="name" cssClass="form-control" value="${u.name}"/></td>
												  	<td><form:input path="dob" cssClass="form-control" value="${u.dob}"/></td>
												  	<td><form:input path="gender" cssClass="form-control" value="${u.gender}"/></td>
												  	<td><form:input path="date" cssClass="form-control" value="${u.date}"/></td>
												  	<td><form:input path="time" cssClass="form-control" value="${u.time}"/></td>
												  	<td><input type="submit" class="btn btn-success" value="UPDATE"></td>
													<td><a href="/bookmymovie/admin/deleteUser/${u.id}" class="btn btn-danger">DELETE</a></td>
												</form:form>
											</tr>
										 </c:forEach>
									</tbody>
								  </table>
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
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>