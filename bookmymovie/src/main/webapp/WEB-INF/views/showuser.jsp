<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	${user.name}<br>
	${user.id}<br>
	${user.email}<br>
	${user.pwd}<br>
	${user.gender}<br>
	${user.dob}<br>
	${user.question1}<br>
	${user.answer1}<br>
	${user.question2}<br>
	${user.answer2}<br>
	${user.date}<br>
	${user.time}

	<a href="${pageContext.request.contextPath}/">Home</a>
</body>
</html>