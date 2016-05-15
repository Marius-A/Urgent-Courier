<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>welcome</title>
<jsp:include page="/WEB-INF/views/include/head-include.jsp" />
<style type="text/css">
h1 {
    font-size: 250%;
}

h2 {
    font-size: 200%;
}

p {
    font-size: 120%;
    color: white;
    font-weight: bold;
}
div.scroll {
    width: 900px;
    height: 350px;
    overflow: auto
}

</style>
</head>
<body>
	<div id="narrow" style="width: 100px; height: 100px; float: left;">
		<img alt="c" src="http://ladys.ro/images/curier%20rapid%20600x800.jpg"
		style="width: 100px; height: 100px;">
	</div>
	<div class="container" style="float: right; margin-tip: 10px">
		<div >
			<c:choose>
				<c:when test="${empty loggedInUser.numeC }">
					Hello Guest:  <a href="login">Login</a>
				</c:when>

				<c:otherwise>
					<h1 style="float: left; margin-tip: 10px"><b>Hello : </b> ${loggedInUser.numeC}   <b>CUI:</b> ${loggedInUser.cui}! &nbsp;</h1>
					<a style="float: left; margin-tip: 10px" href="logout">Logout</a>
					<br />
					<br />
					<br />
					<br />
					<canvas></canvas>
					<div class="scroll" style="float: left; margin-tip: 10px">
						<c:if test="${empty loggedInUser.listaFacturi}">
							You don't have any orders
						</c:if>
						<c:if test="${ not empty loggedInUser.listaFacturi}">
							<h4>Order list</h4>
							<ul class="menu">
								<c:forEach var="fact" items="${loggedInUser.listaFacturi}">
									<li >
										<p><b>Valoare Totala : </b>${fact.valoareTotala} ;</p>
										<p><b>Cod factura : </b>${fact.codFactura} ; </p>
										<p><b>Intemeietor: </b>${fact.intemeietor.nume} ;</p>
										<p><b>Comanda : </b>${fact.comanda}</p>
										<p><b>Lista de pachete</b></p>
										<c:forEach var="pac" items="${fact.comanda.listaPachete}">
											<p>${pac}</p>
										</c:forEach>

									</li>

								</c:forEach>
							</ul>
						</c:if>
					</div>
				</c:otherwise>
			</c:choose>

		</div>
	</div>
</body>
</html>
