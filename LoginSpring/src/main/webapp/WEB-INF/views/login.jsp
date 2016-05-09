<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/include/head-include.jsp" />
<title>Login</title>
</head>
<body>
<div class="container" style = "max-width:500px">
${loginError}
<div class="form-group form">
	<form action='login' method="post" >
		<div >
			<label>User name:</label>
			<input type="text" id="userId" name="userId" placeholder="Client id" class="form-control"/>
		</div>
		
		<div>
			<label>Password:</label>
			<input type="password" id="password" name="password" placeholder="last 6 digist of your SSN/CUI" class="form-control"/>
		</div>
		<button id="loginButton" class="form-control">Login</button>
	</form>
</div>
</div>
</body>
</html>