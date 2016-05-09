<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>welcome</title>
	<jsp:include page="/WEB-INF/views/include/head-include.jsp" />
</head>
<body>
	<div class = "container">
		<div style = "float:right ; margin-tip : -30px">
			<c:choose>
				<c:when test="${empty loggedInUser.numeC }">
					Hello Guest:  <a href="login">Login</a>
				</c:when>
				
				<c:otherwise>
					<b>Hello : </b> ${loggedInUser.numeC}   <b>cui:</b> ${loggedInUser.cui}! &nbsp;
					<a href="logout">Logout</a>
					<br/><br/><br/><br/>
					<canvas></canvas>
					<div >
						<c:if test="${empty loggedInUser.listaFacturi}">
							You don't have any orders
						</c:if>
						<c:if test="${ not empty loggedInUser.listaFacturi}">
							<h4>Order list</h4>
							<ul>
								<c:forEach var="fact" items="${loggedInUser.listaFacturi}">
	
									<li>${fact}</li>
	
								</c:forEach>
							</ul>
						</c:if>
					</div>
				</c:otherwise>
			</c:choose>
		
		</div>
	</div>
	<img alt="c" src="http://ladys.ro/images/curier%20rapid%20600x800.jpg"  style = "width: 100px;height: 100px;">
</body>
</html>
