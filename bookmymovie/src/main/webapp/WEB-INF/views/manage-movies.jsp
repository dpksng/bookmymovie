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
	
	<title>Manage Movies :: Admin | BOOKMYMOVIE.COM</title>

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
									<a class="navbar-brand" href="#">Movies</a>
									<div class="collapse navbar-collapse menu" id="navbarSupportedContent">
										<ul class="navbar-nav ml-auto menu-nav">
																				
										
											<li>
												<a href="#" class="nav-link menu-link" data-toggle="modal" data-target="#modalImage">ADD MOVIE IMAGES</a>
												<div class="modal fade" id="modalImage" tabindex="-1" role="dialog" aria-labelledby="AddCinema" aria-hidden="true">
												  <div class="modal-dialog modal-dialog-centered" role="document">
												    <div class="modal-content">
												      <div class="modal-header">
												        <h5 class="modal-title" id="modalLongTitle">UPDATE IMAGES</h5>
												        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
												          <span aria-hidden="true">&times;</span>
												        </button>
												      </div>
												      <div class="modal-body">
												      <h4>Box Image</h4><br>
												       	<form action="upload" method="post" enctype="multipart/form-data">
												       		<div class="form-group">
															    <label>Select Movie</label>
															    <select name="selection" class="form-control">
															    	<c:forEach var="ml" items="${list}">
															      		<option value="${ml.id}">${ml.title}</option>
															      	</c:forEach>
															    </select>
															  </div>
															  <div class="form-group">
															    <input type="file" name="file" class="form-control-file">
															    <small id="fileHelp" class="form-text text-muted">Box Image should be 24.41 CM X 35.28 CM in jpg format</small>
															  </div>
												       		<input type="submit" value="UPLOAD" class="btn btn-success"> 
												       	</form>
												       	<br><br>
												       	<h4>Slide Image</h4><br>
												       	<form action="uploadSlide" method="post" enctype="multipart/form-data">
												       		<div class="form-group">
															    <label>Select Slide</label>
															    <select name="selection" class="form-control">
															   		<option value="01">1</option>
															   		<option value="02">2</option>
															   		<option value="03">3</option>
															    </select>
															  </div>
															  <div class="form-group">
															    <input type="file" name="file" class="form-control-file">
															    <small id="fileHelp" class="form-text text-muted">Slide Image should be 45.16 CM X 17.64 CM in jpg format</small>
															  </div>
												       		<input type="submit" value="UPLOAD" class="btn btn-success"> 
												       	</form>
												      </div>
												    </div>
												  </div>
												</div>
											</li>
											<li>
												<a href="#" class="nav-link menu-link" data-toggle="modal" data-target="#modalCenter">ADD MOVIE</a>
												<div class="modal fade" id="modalCenter" tabindex="-1" role="dialog" aria-labelledby="AddCinema" aria-hidden="true">
												  <div class="modal-dialog modal-dialog-centered" role="document">
												    <div class="modal-content">
												      <div class="modal-header">
												        <h5 class="modal-title" id="modalLongTitle">Add Movie</h5>
												        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
												          <span aria-hidden="true">&times;</span>
												        </button>
												      </div>
												      <div class="modal-body">
														<form:form method="post" modelAttribute="movie" action="registerMovie">
														<div class="row">
															<div class="col-sm-12">
																<div class="form-group">
																	<form:input path="title" cssClass="form-control label" placeholder="Title"/>
																</div>
															</div>
															<div class="col-sm-6">
																<div class="form-group">
																	<form:input path="length" cssClass="form-control label" placeholder="Length"/>
																</div>
															</div>
															<div class="col-sm-6">
																<div class="form-group">
																	<form:input path="date" type="date" cssClass="form-control label" placeholder="Release Date"/>
																</div>
															</div>
															<div class="col-sm-12">
																<div class="form-group">
																	<form:textarea path="description" cssClass="form-control label" rows="3" placeholder="Description"/>
																</div>
															</div>
															<div class="col-sm-12">
																<div class="form-group">
																	<form:input path="cast" cssClass="form-control label" placeholder="Cast"/>
																</div>
															</div>
															<div class="col-sm-6">
																 <div class="form-group">
																 	<form:select path = "status" cssClass="form-control">
																		<form:options items="${status}"/>
																	</form:select>
																  </div>
															</div>
															<div class="col-sm-6">
																 <div class="form-group">
																 	<form:select path = "language" cssClass="form-control">
																		<form:options items="${language}"/>
																	</form:select>
																  </div>
															</div>
															<div class="col-sm-6">
																 <div class="form-group">
																 	<form:select path = "category" cssClass="form-control">
																		<form:options items="${category}"/>
																	</form:select>
																  </div>
															</div>
															<div class="col-sm-12">
																<button type="submit" class="btn btn-primary form-control label">ADD</button>
															</div>
														</div>
														</form:form>
												      </div>
												    </div>
												  </div>
												</div>
											</li>
											<li>
												<a href="/bookmymovie/admin" class="nav-link menu-link">GO BACK</a>
											</li>
											<%@ include file ="menu.jsp" %>		
										</ul>
									</div>
								</nav>
							</div>
							<div class="col-md-12">
								<table class="table table-sm">
									<thead>
									  <tr>
										<th>ID</th>
										<th>TITLE</th>
										<th>RELEASE DATE</th>
										<th>LENGTH</th>
										<th>CATEGORY</th>
										<th>LANGUAGE</th>
										<th>DESCRIPTION</th>
										<th>CAST</th>
										<th>STATUS</th>
										<th>UPDATE</th>
										<th>DELETE</th>
									  </tr>
									</thead>
									<tbody>
										<c:forEach var="mov" items="${list}">      
										  	<tr>
												<form:form method="post" modelAttribute="movie" action="updateMovie">
												  	<td><form:input path="id" cssClass="form-control" value="${mov.id}"/></td>
												  	<td><form:input path="title" cssClass="form-control" value="${mov.title}"/></td>
												  	<td><form:input path="date" cssClass="form-control" value="${mov.date}"/></td>
												  	<td><form:input path="length" cssClass="form-control" value="${mov.length}"/></td>
												  	<td><form:input path="category" cssClass="form-control" value="${mov.category}"/></td>
												  	<td><form:input path="language" cssClass="form-control" value="${mov.language}"/></td>
												  	<td><form:input path="description" cssClass="form-control" value="${mov.description}"/></td>
												  	<td><form:input path="cast" cssClass="form-control" value="${mov.cast}"/></td>
												  	<td><form:input path="status" cssClass="form-control" value="${mov.status}"/></td>
													<td><input type="submit" class="btn btn-success" value="UPDATE"></td>
													<td><a href="/bookmymovie/admin/deleteMovie/${mov.id}" class="btn btn-danger">DELETE</a></td>
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