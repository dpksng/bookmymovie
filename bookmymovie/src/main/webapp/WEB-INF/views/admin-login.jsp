<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
	<link href='https://fonts.googleapis.com/css?family=Baloo' rel='stylesheet'>
	
    <title>Login :: Bookmymovie.com</title>
</head>
<body>
		
		<br><br><br>
		<div class="container">
				<div class="row justify-content-center">
					<div class="col-sm-4">
						<div class="login-panel">
						<h1>Admin</h1>
						<br>
							<form action="performLogin" method="post">
								<div class="form-group">
									<label>Your email</label>
									<input type="email" name="email" id="email" class="form-control">
								</div>
								<div class="form-group">
									<label>Your password</label>
									<input type="password" name="password" id="password" class="form-control">
								</div>
								<input type="submit" value="Login" class="btn cust-btn form-control">
							</form>
						</div>
					</div>
				</div>
			</div>	
			<br><br><br>
	
</body>
</html>